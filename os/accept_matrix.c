// write in c program Add the following functionalities in your program 
// a) Accept Available
// b) Display Allocation, Max
// c) Display the contents of need matrix
// d) Display Available

#include <stdio.h>

#define MAX_PROCESSES 10
#define MAX_RESOURCES 10

int allocation[MAX_PROCESSES][MAX_RESOURCES];
int max[MAX_PROCESSES][MAX_RESOURCES];
int need[MAX_PROCESSES][MAX_RESOURCES];
int available[MAX_RESOURCES];

int num_processes, num_resources;

void acceptAvailable() {
    printf("Enter the number of resources: ");
    scanf("%d", &num_resources);

    printf("Enter the available resources:\n");
    for (int i = 0; i < num_resources; i++) {
        scanf("%d", &available[i]);
    }
}

void displayAllocationMax() {
    printf("Allocation Matrix:\n");
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            printf("%d ", allocation[i][j]);
        }
        printf("\n");
    }

    printf("Max Matrix:\n");
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            printf("%d ", max[i][j]);
        }
        printf("\n");
    }
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

void displayAvailable() {
    printf("Available Resources:\n");
    for (int i = 0; i < num_resources; i++) {
        printf("%d ", available[i]);
    }
    printf("\n");
}

int main() {
    printf("Enter the number of processes: ");
    scanf("%d", &num_processes);

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
            need[i][j] = max[i][j] - allocation[i][j];
        }
    }

    acceptAvailable();

    printf("\n");

    displayAllocationMax();
    printf("\n");
    displayNeed();
    printf("\n");
    displayAvailable();

    return 0;
}


// Enter the number of processes: 3
// Enter the Allocation Matrix:
// 1 2 3
// 4 5 6
// 7 8 9
// Enter the Max Matrix:
// 10 11 12
// 13 14 15
// 16 17 18
// Enter the available resources:
// 3 2 1

// Allocation Matrix:
// 1 2 3 
// 4 5 6 
// 7 8 9 
// Max Matrix:
// 10 11 12 
// 13 14 15 
// 16 17 18 
// Need Matrix:
// 9 9 9 
// 9 9 9 
// 9 9 9 
// Available Resources:
// 3 2 1
