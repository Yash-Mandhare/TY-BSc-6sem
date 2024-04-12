// Write a program to simulate Linked file allocation method. Assume disk with n
// number of blocks. Give value of n as input. Randomly mark some block as allocated and
// accordingly maintain the list of free blocks Write menu driver program with menu
// options as mentioned below and implement each option.
// • Show Bit Vector
// • Create New File
// • Show Directory
// • Exit

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_BLOCKS 100

// Node structure for linked list
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#define MAX_BLOCKS 100
#define MAX_FILE_NAME_LENGTH 50

// Node structure for linked list
struct Node {
    int blockIndex;
    char name[MAX_FILE_NAME_LENGTH];
    struct Node *next;
};

void showBitVector(int allocated[], int n) {
    printf("Bit Vector (1 for allocated, 0 for free):\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", allocated[i]);
    }
    printf("\n");
}

void createNewFile(struct Node **head, int allocated[], int n) {
    int index;
    printf("Enter index for the new file: ");
    scanf("%d", &index);

    if (index < 0 || index >= n) {
        printf("Invalid index.\n");
        return;
    }

    if (allocated[index] == 1) {
        printf("Block is already allocated. Choose another block.\n");
        return;
    }

    char name[MAX_FILE_NAME_LENGTH];
    printf("Enter name for the new file: ");
    scanf("%s", name);

    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        printf("Memory allocation failed.\n");
        return;
    }

    newNode->blockIndex = index;
    strcpy(newNode->name, name);
    newNode->next = *head;
    *head = newNode;

    allocated[index] = 1;

    printf("New file '%s' created with index %d\n", name, index);
}

void showDirectory(struct Node *head) {
    printf("Directory (File blocks and names):\n");
    struct Node *current = head;
    while (current != NULL) {
        printf("Block %d: %s\n", current->blockIndex, current->name);
        current = current->next;
    }
}

void freeList(struct Node *head) {
    struct Node *current = head;
    while (current != NULL) {
        struct Node *temp = current;
        current = current->next;
        free(temp);
    }
}

int main() {
    int allocated[MAX_BLOCKS] = {0}; // Initially all blocks are free
    struct Node *directory = NULL; // Initially no files exist
    int n;

    printf("Enter number of disk blocks: ");
    scanf("%d", &n);

    if (n > MAX_BLOCKS) {
        printf("Error: Number of blocks exceeds maximum.\n");
        return 1;
    }

    srand(time(NULL)); // Seed for random number generation

    int choice;
    do {
        printf("\nMenu:\n");
        printf("1. Show Bit Vector\n");
        printf("2. Create New File\n");
        printf("3. Show Directory\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                showBitVector(allocated, n);
                break;
            case 2:
                createNewFile(&directory, allocated, n);
                break;
            case 3:
                showDirectory(directory);
                break;
            case 4:
                printf("Exiting program.\n");
                freeList(directory);
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 4);

    return 0;
}



// Enter number of disk blocks: 10

// Menu:
// 1. Show Bit Vector
// 2. Create New File
// 3. Show Directory
// 4. Exit
// Enter your choice: 2
// Enter index for the new file: 3
// New file created with index 3

// Menu:
// 1. Show Bit Vector
// 2. Create New File
// 3. Show Directory
// 4. Exit
// Enter your choice: 2
// Enter index for the new file: 6
// New file created with index 6

// Menu:
// 1. Show Bit Vector
// 2. Create New File
// 3. Show Directory
// 4. Exit
// Enter your choice: 3
// Directory (File blocks):
// 6 3 

// Menu:
// 1. Show Bit Vector
// 2. Create New File
// 3. Show Directory
// 4. Exit
// Enter your choice: 1
// Bit Vector (1 for allocated, 0 for free):
// 0 0 0 1 0 0 1 0 0 0 

// Menu:
// 1. Show Bit Vector
// 2. Create New File
// 3. Show Directory
// 4. Exit
// Enter your choice: 4
// Exiting program.
