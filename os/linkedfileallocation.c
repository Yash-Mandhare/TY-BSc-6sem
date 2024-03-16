// Write a program to simulate Linked file allocation method. Assume disk with n number of blocks. Give value of n as input. Write menu driver program with menu options as mentioned above and implement each option.

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_BLOCKS 100

typedef struct Node {
    int block_num;
    struct Node* next;
} Node;

Node* allocated[MAX_BLOCKS] = {NULL}; // File Allocation Table (FAT)

void displayFAT(int n) {
    printf("File Allocation Table (FAT):\n");
    printf("Block No.\tAllocated Blocks\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t\t", i);
        Node* current = allocated[i];
        while (current != NULL) {
            printf("%d -> ", current->block_num);
            current = current->next;
        }
        printf("NULL\n");
    }
}

void allocateFile(int n) {
    int start_block;
    printf("Enter starting block number: ");
    scanf("%d", &start_block);

    if (start_block < 0 || start_block >= n) {
        printf("Invalid starting block number.\n");
        return;
    }

    Node* new_node = (Node*)malloc(sizeof(Node));
    if (new_node == NULL) {
        printf("Memory allocation failed.\n");
        return;
    }

    new_node->block_num = start_block;
    new_node->next = NULL;

    if (allocated[start_block] != NULL) {
        printf("Block already allocated.\n");
        free(new_node);
        return;
    }

    allocated[start_block] = new_node;
    printf("File allocated successfully.\n");
}

void deallocateFile(int n) {
    int start_block;
    printf("Enter starting block number of the file to deallocate: ");
    scanf("%d", &start_block);

    if (start_block < 0 || start_block >= n) {
        printf("Invalid starting block number.\n");
        return;
    }

    if (allocated[start_block] == NULL) {
        printf("No file is allocated at this block.\n");
        return;
    }

    Node* current = allocated[start_block];
    while (current != NULL) {
        Node* temp = current;
        current = current->next;
        free(temp);
    }

    allocated[start_block] = NULL;
    printf("File deallocated successfully.\n");
}

int main() {
    int n;
    printf("Enter the number of blocks in the disk: ");
    scanf("%d", &n);

    int choice;
    do {
        printf("\nMenu:\n");
        printf("1. Allocate File\n");
        printf("2. Deallocate File\n");
        printf("3. Display File Allocation Table (FAT)\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                allocateFile(n);
                break;
            case 2:
                deallocateFile(n);
                break;
            case 3:
                displayFAT(n);
                break;
            case 4:
                printf("Exiting program.\n");
                break;
            default:
                printf("Invalid choice. Please enter a valid option.\n");
                break;
        }
    } while (choice != 4);

    // Free allocated memory
    for (int i = 0; i < n; i++) {
        Node* current = allocated[i];
        while (current != NULL) {
            Node* temp = current;
            current = current->next;
            free(temp);
        }
    }

    return 0;
}

/*
Enter the number of blocks in the disk: 20

Menu:
1. Allocate File
2. Deallocate File
3. Display File Allocation Table (FAT)
4. Exit
Enter your choice: 1
Enter starting block number: 3
File allocated successfully.

Menu:
1. Allocate File
2. Deallocate File
3. Display File Allocation Table (FAT)
4. Exit
Enter your choice: 1
Enter starting block number: 5
File allocated successfully.

Menu:
1. Allocate File
2. Deallocate File
3. Display File Allocation Table (FAT)
4. Exit
Enter your choice: 3
File Allocation Table (FAT):
Block No.       Allocated Blocks
0               NULL
1               NULL
2               NULL
3               3 -> NULL
4               NULL
5               5 -> NULL
6               NULL
7               NULL
8               NULL
9               NULL
10              NULL
11              NULL
12              NULL
13              NULL
14              NULL
15              NULL
16              NULL
17              NULL
18              NULL
19              NULL

Menu:
1. Allocate File
2. Deallocate File
3. Display File Allocation Table (FAT)
4. Exit
Enter your choice: 2
Enter starting block number of the file to deallocate: 3
File deallocated successfully.

Menu:
1. Allocate File
2. Deallocate File
3. Display File Allocation Table (FAT)
4. Exit
Enter your choice: 3
File Allocation Table (FAT):
Block No.       Allocated Blocks
0               NULL
1               NULL
2               NULL
3               NULL
4               NULL
5               5 -> NULL
6               NULL
7               NULL
8               NULL
9               NULL
10              NULL
11              NULL
12              NULL
13              NULL
14              NULL
15              NULL
16              NULL
17              NULL
18              NULL
19              NULL

Menu:
1. Allocate File
2. Deallocate File
3. Display File Allocation Table (FAT)
4. Exit
Enter your choice: 4
Exiting program.
*/
