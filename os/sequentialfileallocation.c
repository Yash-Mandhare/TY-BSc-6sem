// Write a program to simulate Sequential (Contiguous) file allocation method. Assume disk with n number of blocks. Give value of n as input. Write menu driver program with menu options as mentioned above and implement each option.

#include <stdio.h>
#include <stdbool.h>

#define MAX_BLOCKS 100

bool allocated[MAX_BLOCKS] = {false};
int file_table[MAX_BLOCKS][2]; // File Allocation Table (FAT)

void displayFAT(int n) {
    printf("File Allocation Table (FAT):\n");
    printf("Block No.\tAllocated\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t\t%s\n", i, allocated[i] ? "Allocated" : "Free");
    }
}

void allocateFile(int n) {
    int start_block, num_blocks;
    printf("Enter starting block number: ");
    scanf("%d", &start_block);
    printf("Enter number of blocks: ");
    scanf("%d", &num_blocks);

    bool can_allocate = true;
    for (int i = start_block; i < start_block + num_blocks; i++) {
        if (allocated[i] || i >= n) {
            can_allocate = false;
            break;
        }
    }

    if (can_allocate) {
        for (int i = start_block; i < start_block + num_blocks; i++) {
            allocated[i] = true;
            file_table[i][0] = start_block;
            file_table[i][1] = num_blocks;
        }
        printf("File allocated successfully.\n");
    } else {
        printf("File allocation failed. Blocks are already allocated or out of range.\n");
    }
}

void deallocateFile(int n) {
    int start_block;
    printf("Enter starting block number of the file to deallocate: ");
    scanf("%d", &start_block);

    if (!allocated[start_block]) {
        printf("No file is allocated at this block.\n");
    } else {
        int num_blocks = file_table[start_block][1];
        for (int i = start_block; i < start_block + num_blocks; i++) {
            allocated[i] = false;
            file_table[i][0] = -1;
            file_table[i][1] = -1;
        }
        printf("File deallocated successfully.\n");
    }
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

    return 0;
}


// Enter the number of blocks in the disk: 20

// Menu:
// 1. Allocate File
// 2. Deallocate File
// 3. Display File Allocation Table (FAT)
// 4. Exit
// Enter your choice: 1
// Enter starting block number: 3
// Enter number of blocks: 4
// File allocated successfully.

// Menu:
// 1. Allocate File
// 2. Deallocate File
// 3. Display File Allocation Table (FAT)
// 4. Exit
// Enter your choice: 1
// Enter starting block number: 10
// Enter number of blocks: 5
// File allocated successfully.

// Menu:
// 1. Allocate File
// 2. Deallocate File
// 3. Display File Allocation Table (FAT)
// 4. Exit
// Enter your choice: 3
// File Allocation Table (FAT):
// Block No.       Allocated
// 0               Free
// 1               Free
// 2               Free
// 3               Allocated
// 4               Allocated
// 5               Allocated
// 6               Allocated
// 7               Free
// 8               Free
// 9               Free
// 10              Allocated
// 11              Allocated
// 12              Allocated
// 13              Allocated
// 14              Allocated
// 15              Free
// 16              Free
// 17              Free
// 18              Free
// 19              Free

// Menu:
// 1. Allocate File
// 2. Deallocate File
// 3. Display File Allocation Table (FAT)
// 4. Exit
// Enter your choice: 2
// Enter starting block number of the file to deallocate: 10
// File deallocated successfully.

// Menu:
// 1. Allocate File
// 2. Deallocate File
// 3. Display File Allocation Table (FAT)
// 4. Exit
// Enter your choice: 3
// File Allocation Table (FAT):
// Block No.       Allocated
// 0               Free
// 1               Free
// 2               Free
// 3               Allocated
// 4               Allocated
// 5               Allocated
// 6               Allocated
// 7               Free
// 8               Free
// 9               Free
// 10              Free
// 11              Free
// 12              Free
// 13              Free
// 14              Free
// 15              Free
// 16              Free
// 17              Free
// 18              Free
// 19              Free

// Menu:
// 1. Allocate File
// 2. Deallocate File
// 3. Display File Allocation Table (FAT)
// 4. Exit
// Enter your choice: 4
// Exiting program.
