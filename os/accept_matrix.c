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
    printf("Enter the available resources:\n");
    int i;
    for (i = 0; i < num_resources; i++) {
        scanf("%d", &available[i]);
    }
}

void displayAllocationMax() {
    printf("Allocation Matrix:\n");
    int i, j;
    for (i = 0; i < num_processes; i++) {
        for (j = 0; j < num_resources; j++) {
            printf("%d ", allocation[i][j]);
        }
        printf("\n");
    }

    printf("Max Matrix:\n");
    for (i = 0; i < num_processes; i++) {
        for (j = 0; j < num_resources; j++) {
            printf("%d ", max[i][j]);
        }
        printf("\n");
    }
}

void displayNeed() {
    printf("Need Matrix:\n");
    int i, j;
    for (i = 0; i < num_processes; i++) {
        for (j = 0; j < num_resources; j++) {
            printf("%d ", need[i][j]);
        }
        printf("\n");
    }
}

void displayAvailable() {
    printf("Available Resources:\n");
    int i;
    for (i = 0; i < num_resources; i++) {
        printf("%d ", available[i]);
    }
    printf("\n");
}

int main() {
    int choice;
    
    printf("Enter the number of processes: ");
    scanf("%d", &num_processes);
    
    printf("Enter the number of resources: ");
    scanf("%d", &num_resources);

    printf("Enter the Allocation Matrix:\n");
    int i, j;
    for (i = 0; i < num_processes; i++) {
        printf("For Process %d: ", i);
        for (j = 0; j < num_resources; j++) {
            scanf("%d", &allocation[i][j]);
        }
    }

    printf("Enter the Max Matrix:\n");
    for (i = 0; i < num_processes; i++) {
        printf("For Process %d: ", i);
        for (j = 0; j < num_resources; j++) {
            scanf("%d", &max[i][j]);
            need[i][j] = max[i][j] - allocation[i][j];
        }
    }

    acceptAvailable();

    do {
        printf("\nMenu:\n");
        printf("1. Display Allocation and Max\n");
        printf("2. Display Need Matrix\n");
        printf("3. Display Available Resources\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("\n");
                displayAllocationMax();
                break;
            case 2:
                printf("\n");
                displayNeed();
                break;
            case 3:
                printf("\n");
                displayAvailable();
                break;
            case 4:
                printf("\nExiting program...\n");
                break;
            default:
                printf("\nInvalid choice! Please enter a valid option.\n");
        }
    } while (choice != 4);

    return 0;
}






// [smile@localhost slip os 6sem]$ gcc accept_matrix.c 
// [smile@localhost slip os 6sem]$ ./a.out
// Enter the number of processes: 3
// Enter the number of resources: 3
// Enter the Allocation Matrix:
// For Process 0: 0 1 0
// For Process 1: 2 0 0
// For Process 2: 3 0 2
// Enter the Max Matrix:
// For Process 0: 7 5 3
// For Process 1: 3 2 2
// For Process 2: 9 0 2
// Enter the available resources:
// 3 3 2

// Menu:
// 1. Display Allocation and Max
// 2. Display Need Matrix
// 3. Display Available Resources
// 4. Exit
// Enter your choice: 3

// Available Resources:
// 3 3 2 

// Menu:
// 1. Display Allocation and Max
// 2. Display Need Matrix
// 3. Display Available Resources
// 4. Exit
// Enter your choice: 2

// Need Matrix:
// 7 4 3 
// 1 2 2 
// 6 0 0 

// Menu:
// 1. Display Allocation and Max
// 2. Display Need Matrix
// 3. Display Available Resources
// 4. Exit
// Enter your choice: 1

// Allocation Matrix:
// 0 1 0 
// 2 0 0 
// 3 0 2 
// Max Matrix:
// 7 5 3 
// 3 2 2 
// 9 0 2 

// Menu:
// 1. Display Allocation and Max
// 2. Display Need Matrix
// 3. Display Available Resources
// 4. Exit
// Enter your choice: 
