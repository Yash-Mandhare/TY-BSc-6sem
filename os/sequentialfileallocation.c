// Write a program to simulate Sequential (Contiguous) file allocation method.
// Assume disk with n number of blocks. Give value of n as input. Randomly mark some
// block as allocated and accordingly maintain the list of free blocks Write menu driver
// program with menu options as mentioned below and implement each option
// • Show Bit Vector
// • Create New File
// • Show Directory
// • Exit

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#define MAX_BLOCKS 100
#define MAX_FILE_NAME_LENGTH 50

struct FileEntry {
    int allocated;
    char name[MAX_FILE_NAME_LENGTH];
};

void showBitVector(int allocated[], int n) {
    printf("Bit Vector (1 for allocated, 0 for free):\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", allocated[i]);
    }
    printf("\n");
}

void createNewFile(int allocated[], int n, struct FileEntry directory[], int size) {
    int start;
    printf("Enter starting block index for the new file: ");
    scanf("%d", &start);

    if (start < 0 || start >= n) {
        printf("Invalid starting block index.\n");
        return;
    }

    int end = start + size - 1;

    if (end >= n) {
        printf("File size exceeds available blocks.\n");
        return;
    }

    for (int i = start; i <= end; i++) {
        if (allocated[i] == 1) {
            printf("Block %d is already allocated. Cannot create file.\n", i);
            return;
        }
    }

    char name[MAX_FILE_NAME_LENGTH];
    printf("Enter name of the new file: ");
    scanf("%s", name);

    printf("Creating new file '%s' starting from block %d to %d\n", name, start, end);
    for (int i = start; i <= end; i++) {
        directory[i].allocated = 1;
        strcpy(directory[i].name, name);
        allocated[i] = 1;
    }
}

void showDirectory(struct FileEntry directory[], int n) {
    printf("Directory:\n");
    for (int i = 0; i < n; i++) {
        if (directory[i].allocated == 1) {
            printf("Block %d: %s\n", i, directory[i].name);
        } else {
            printf("Block %d: Empty\n", i);
        }
    }
}

int main() {
    int allocated[MAX_BLOCKS] = {0}; // Initially all blocks are free
    struct FileEntry directory[MAX_BLOCKS]; // Initially no files exist
    int n;

    printf("Enter number of disk blocks: ");
    scanf("%d", &n);

    if (n > MAX_BLOCKS) {
        printf("Error: Number of blocks exceeds maximum.\n");
        return 1;
    }

    srand(time(NULL)); // Seed for random number generation

    int choice, size;
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
                printf("Enter size of the new file (number of blocks): ");
                scanf("%d", &size);
                createNewFile(allocated, n, directory, size);
                break;
            case 3:
                showDirectory(directory, n);
                break;
            case 4:
                printf("Exiting program.\n");
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
// Enter size of the new file (number of blocks): 3
// Enter starting block index for the new file: 2
// Enter name of the new file: file1
// Creating new file 'file1' starting from block 2 to 4

// Menu:
// 1. Show Bit Vector
// 2. Create New File
// 3. Show Directory
// 4. Exit
// Enter your choice: 1
// Bit Vector (1 for allocated, 0 for free):
// 0 0 1 1 1 0 0 0 0 0 

// Menu:
// 1. Show Bit Vector
// 2. Create New File
// 3. Show Directory
// 4. Exit
// Enter your choice: 3
// Directory:
// Block 0: Empty
// Block 1: Empty
// Block 2: file1
// Block 3: file1
// Block 4: file1
// Block 5: Empty
// Block 6: Empty
// Block 7: Empty
// Block 8: Empty
// Block 9: Empty

// Menu:
// 1. Show Bit Vector
// 2. Create New File
// 3. Show Directory
// 4. Exit
// Enter your choice: 2
// Enter size of the new file (number of blocks): 2
// Enter starting block index for the new file: 6
// Enter name of the new file: file2
// Creating new file 'file2' starting from block 6 to 7

// Menu:
// 1. Show Bit Vector
// 2. Create New File
// 3. Show Directory
// 4. Exit
// Enter your choice: 3
// Directory:
// Block 0: Empty
// Block 1: Empty
// Block 2: file1
// Block 3: file1
// Block 4: file1
// Block 5: Empty
// Block 6: file2
// Block 7: file2
// Block 8: Empty
// Block 9: Empty

// Menu:
// 1. Show Bit Vector
// 2. Create New File
// 3. Show Directory
// 4. Exit
// Enter your choice: 4
// Exiting program.
