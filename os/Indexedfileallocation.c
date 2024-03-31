// Write a program to simulate Indexed file allocation method. Assume disk with n number of blocks. Give value of n as input. Write menu driver program with menu options as mentioned above and implement each option



#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_BLOCKS 100

typedef struct IndexNode {
    int block_num;
    struct IndexNode* next;
} IndexNode;

IndexNode* index_table[MAX_BLOCKS] = {NULL}; // Index Table (IT)

void displayIT(int n) {
    printf("Index Table (IT):\n");
    printf("Block No.\tIndex Blocks\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t\t", i);
        IndexNode* current = index_table[i];
        while (current != NULL) {
            printf("%d -> ", current->block_num);
            current = current->next;
        }
        printf("NULL\n");
    }
}

void allocateFile(int n) {
    int index_block;
    printf("Enter the index block number: ");
    scanf("%d", &index_block);

    if (index_block < 0 || index_block >= n) {
        printf("Invalid index block number.\n");
        return;
    }

    if (index_table[index_block] != NULL) {
        printf("Index block already allocated.\n");
        return;
    }

    int num_blocks;
    printf("Enter the number of blocks to allocate: ");
    scanf("%d", &num_blocks);

    if (num_blocks <= 0 || num_blocks > n - 1) {
        printf("Invalid number of blocks.\n");
        return;
    }

    index_table[index_block] = (IndexNode*)malloc(sizeof(IndexNode));
    if (index_table[index_block] == NULL) {
        printf("Memory allocation failed.\n");
        return;
    }

    index_table[index_block]->block_num = -1; // Dummy node to indicate index block
    index_table[index_block]->next = NULL;

    for (int i = 0; i < num_blocks; i++) {
        int block_num;
        printf("Enter the block number to allocate: ");
        scanf("%d", &block_num);

        if (block_num < 0 || block_num >= n) {
            printf("Invalid block number.\n");
            free(index_table[index_block]);
            index_table[index_block] = NULL;
            return;
        }

        IndexNode* new_node = (IndexNode*)malloc(sizeof(IndexNode));
        if (new_node == NULL) {
            printf("Memory allocation failed.\n");
            return;
        }

        new_node->block_num = block_num;
        new_node->next = NULL;

        // Insert new node at the end of the linked list
        IndexNode* current = index_table[index_block];
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = new_node;
    }

    printf("File allocated successfully.\n");
}

void deallocateFile(int n) {
    int index_block;
    printf("Enter the index block number of the file to deallocate: ");
    scanf("%d", &index_block);

    if (index_block < 0 || index_block >= n) {
        printf("Invalid index block number.\n");
        return;
    }

    if (index_table[index_block] == NULL) {
        printf("No file is allocated at this index block.\n");
        return;
    }

    IndexNode* current = index_table[index_block]->next; // Skip dummy node
    while (current != NULL) {
        IndexNode* temp = current;
        current = current->next;
        free(temp);
    }

    free(index_table[index_block]);
    index_table[index_block] = NULL;
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
        printf("3. Display Index Table (IT)\n");
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
                displayIT(n);
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
        if (index_table[i] != NULL) {
            IndexNode* current = index_table[i]->next; // Skip dummy node
            while (current != NULL) {
                IndexNode* temp = current;
                current = current->next;
                free(temp);
            }
            free(index_table[i]);
        }
    }

    return 0;
}


/*
Enter the number of blocks in the disk: 10

Menu:
1. Allocate File
2. Deallocate File
3. Display Index Table (IT)
4. Exit
Enter your choice: 1
Enter the index block number: 0
Enter the number of blocks to allocate: 3
Enter the block number to allocate: 1
Enter the block number to allocate: 2
Enter the block number to allocate: 3
File allocated successfully.

Menu:
1. Allocate File
2. Deallocate File
3. Display Index Table (IT)
4. Exit
Enter your choice: 3
Index Table (IT):
Block No.    Index Blocks
0           1 -> 2 -> 3 -> NULL
1           NULL
2           NULL
3           NULL
4           NULL
5           NULL
6           NULL
7           NULL
8           NULL
9           NULL

Menu:
1. Allocate File
2. Deallocate File
3. Display Index Table (IT)
4. Exit
Enter your choice: 2
Enter the index block number of the file to deallocate: 0
File deallocated successfully.

Menu:
1. Allocate File
2. Deallocate File
3. Display Index Table (IT)
4. Exit
Enter your choice: 3
Index Table (IT):
Block No.    Index Blocks
0           NULL
1           NULL
2           NULL
3           NULL
4           NULL
5           NULL
6           NULL
7           NULL
8           NULL
9           NULL

Menu:
1. Allocate File
2. Deallocate File
3. Display Index Table (IT)
4. Exit
Enter your choice: 4
Exiting program.
*/