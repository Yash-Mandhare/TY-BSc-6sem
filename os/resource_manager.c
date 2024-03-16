// Modify above program so as to include the following:

// a) Accept Request for a process 
// b) Resource request algorithm
// c) Safety algorithm

// Consider a system with 'n' processes and 'm' resource types. Accept number of instances for every resource type. For each process accept the allocation and maximum requirement matrices. Write a program to display the contents of need matrix and to check if the given request of a process can be granted immediately or not.

#include <stdio.h>
#include <stdbool.h>

#define MAX_PROCESSES 10
#define MAX_RESOURCES 10

int allocation[MAX_PROCESSES][MAX_RESOURCES];
int max[MAX_PROCESSES][MAX_RESOURCES];
int need[MAX_PROCESSES][MAX_RESOURCES];
int available[MAX_RESOURCES];

int num_processes, num_resources;

void acceptAvailable() {
    printf("Enter the available resources:\n");
    for (int i = 0; i < num_resources; i++) {
        scanf("%d", &available[i]);
    }
}

void acceptProcessRequest(int process_num) {
    printf("Enter the request for process %d:\n", process_num);
    for (int i = 0; i < num_resources; i++) {
        scanf("%d", &allocation[process_num][i]);
    }
}

void calculateNeed() {
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            need[i][j] = max[i][j] - allocation[i][j];
        }
    }
}

bool checkRequest(int process_num) {
    for (int i = 0; i < num_resources; i++) {
        if (allocation[process_num][i] > available[i] || allocation[process_num][i] > need[process_num][i]) {
            return false;
        }
    }
    return true;
}

void resourceRequestAlgorithm(int process_num) {
    if (checkRequest(process_num)) {
        for (int i = 0; i < num_resources; i++) {
            available[i] -= allocation[process_num][i];
            allocation[process_num][i] += allocation[process_num][i];
            need[process_num][i] -= allocation[process_num][i];
        }
        printf("Request granted successfully.\n");
    } else {
        printf("Request cannot be granted immediately.\n");
    }
}

bool safetyAlgorithm() {
    int work[MAX_RESOURCES];
    bool finish[MAX_PROCESSES];

    for (int i = 0; i < num_resources; i++) {
        work[i] = available[i];
    }

    for (int i = 0; i < num_processes; i++) {
        finish[i] = false;
    }

    int count = 0;
    while (count < num_processes) {
        bool found = false;
        for (int i = 0; i < num_processes; i++) {
            if (!finish[i]) {
                bool safe = true;
                for (int j = 0; j < num_resources; j++) {
                    if (need[i][j] > work[j]) {
                        safe = false;
                        break;
                    }
                }
                if (safe) {
                    for (int j = 0; j < num_resources; j++) {
                        work[j] += allocation[i][j];
                    }
                    finish[i] = true;
                    found = true;
                    count++;
                }
            }
        }
        if (!found) {
            return false; // System is not in a safe state
        }
    }
    return true; // System is in a safe state
}

void displayNeed() {
    printf("Need Matrix:\n");
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            printf("%d ", need[i][j]);
        }
        printf("\n");
    }
}

int main() {
    printf("Enter the number of processes: ");
    scanf("%d", &num_processes);

    printf("Enter the number of resources: ");
    scanf("%d", &num_resources);

    printf("Enter the available resources:\n");
    for (int i = 0; i < num_resources; i++) {
        scanf("%d", &available[i]);
    }

    printf("Enter the Allocation Matrix:\n");
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            scanf("%d", &allocation[i][j]);
        }
    }

    printf("Enter the Max Matrix:\n");
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            scanf("%d", &max[i][j]);
        }
    }

    calculateNeed();

    int process_num;
    printf("Enter the process number for resource request: ");
    scanf("%d", &process_num);
    acceptProcessRequest(process_num);

    printf("Checking request for process %d...\n", process_num);
    resourceRequestAlgorithm(process_num);

    printf("\nNeed matrix after resource allocation:\n");
    displayNeed();

    if (safetyAlgorithm()) {
        printf("\nSystem is in a safe state.\n");
    } else {
        printf("\nSystem is not in a safe state.\n");
    }

    return 0;
}


// Enter the number of processes: 3
// Enter the number of resources: 4
// Enter the available resources:
// 3 2 1 4
// Enter the Allocation Matrix:
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12
// Enter the Max Matrix:
// 10 9 8 7
// 6 5 4 3
// 2 1 0 9
// Enter the process number for resource request: 1
// Enter the request for process 1:
// 0 1 0 2
// Checking request for process 1...
// Request cannot be granted immediately.

// Need matrix after resource allocation:
// 9 8 7 5 
// 1 4 4 1 
// 2 1 0 9 

// System is not in a safe state.
