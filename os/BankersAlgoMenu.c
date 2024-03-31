#include <stdio.h>
#include <stdlib.h>

#define MAX_PROCESSES 5
#define MAX_RESOURCES 3

int allocation[MAX_PROCESSES][MAX_RESOURCES];
int max[MAX_PROCESSES][MAX_RESOURCES];
int available[MAX_RESOURCES];

// Function to calculate and display need matrix
void calculateAndDisplayNeed() {
    int need[MAX_PROCESSES][MAX_RESOURCES];
    printf("Need Matrix:\n");
    for (int i = 0; i < MAX_PROCESSES; i++) {
        printf("P%d: ", i);
        for (int j = 0; j < MAX_RESOURCES; j++) {
            need[i][j] = max[i][j] - allocation[i][j];
            printf("%d ", need[i][j]);
        }
        printf("\n");
    }
}

// Function to display allocation matrix
void displayAllocation() {
    printf("Allocation Matrix:\n");
    for (int i = 0; i < MAX_PROCESSES; i++) {
        printf("P%d: ", i);
        for (int j = 0; j < MAX_RESOURCES; j++) {
            printf("%d ", allocation[i][j]);
        }
        printf("\n");
    }
}

// Function to display maximum matrix
void displayMax() {
    printf("Max Matrix:\n");
    for (int i = 0; i < MAX_PROCESSES; i++) {
        printf("P%d: ", i);
        for (int j = 0; j < MAX_RESOURCES; j++) {
            printf("%d ", max[i][j]);
        }
        printf("\n");
    }
}

// Function to display available resources
void displayAvailable() {
    printf("Available Resources:\n");
    for (int i = 0; i < MAX_RESOURCES; i++) {
        printf("%c: %d ", 'A' + i, available[i]);
    }
    printf("\n");
}

int main() {
    char choice;
    // Accept allocation matrix
    printf("Enter Allocation Matrix:\n");
    for (int i = 0; i < MAX_PROCESSES; i++) {
        printf("For Process P%d: ", i);
        for (int j = 0; j < MAX_RESOURCES; j++) {
            scanf("%d", &allocation[i][j]);
        }
    }

    // Accept maximum matrix
    printf("Enter Maximum Matrix:\n");
    for (int i = 0; i < MAX_PROCESSES; i++) {
        printf("For Process P%d: ", i);
        for (int j = 0; j < MAX_RESOURCES; j++) {
            scanf("%d", &max[i][j]);
        }
    }

    // Accept available resources
    printf("Enter Available Resources: ");
    for (int i = 0; i < MAX_RESOURCES; i++) {
        scanf("%d", &available[i]);
    }

    do {
        printf("\nMenu:\n");
        printf("a) Display Allocation, Max\n");
        printf("b) Find Need and Display It\n");
        printf("c) Display Available\n");
        printf("d) Exit\n");
        printf("Enter choice: ");
        scanf(" %c", &choice);

        switch (choice) {
            case 'a':
                displayAllocation();
                displayMax();
                break;
            case 'b':
                calculateAndDisplayNeed();
                break;
            case 'c':
                displayAvailable();
                break;
            case 'd':
                printf("Exiting...\n");
                exit(0);
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (1);

    return 0;
}



// Enter Allocation Matrix:
// For Process P0: 0 1 0
// For Process P1: 4 0 0
// For Process P2: 5 0 4
// For Process P3: 4 3 3
// For Process P4: 2 2 4
// Enter Maximum Matrix:
// For Process P0: 0 0 0
// For Process P1: 5 2 2
// For Process P2: 1 0 4
// For Process P3: 4 4 4
// For Process P4: 6 5 5
// Enter Available Resources: 7 2 6

// Menu:
// a) Display Allocation, Max
// b) Find Need and Display It
// c) Display Available
// d) Exit
// Enter choice: a
// Allocation Matrix:
// P0: 0 1 0
// P1: 4 0 0
// P2: 5 0 4
// P3: 4 3 3
// P4: 2 2 4
// Max Matrix:
// P0: 0 0 0
// P1: 5 2 2
// P2: 1 0 4
// P3: 4 4 4
// P4: 6 5 5

// Menu:
// a) Display Allocation, Max
// b) Find Need and Display It
// c) Display Available
// d) Exit
// Enter choice: b
// Need Matrix:
// P0: 0 0 0
// P1: 1 2 2
// P2: 1 0 0
// P3: 0 1 1
// P4: 4 3 1

// Menu:
// a) Display Allocation, Max
// b) Find Need and Display It
// c) Display Available
// d) Exit
// Enter choice: c
// Available Resources:
// A: 7 B: 2 C: 6 

// Menu:
// a) Display Allocation, Max
// b) Find Need and Display It
// c) Display Available
// d) Exit
// Enter choice: d
// Exiting...
