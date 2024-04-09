//  Write a program to simulate Indexed file allocation method. Assume disk with n
// number of blocks. Give value of n as input. Randomly mark some block as allocated and
// accordingly maintain the list of free blocks Write menu driver program with menu
// options as mentioned above and implement each option.
// • Show Bit Vector
// • Create New File
// • Show Directory
// • Delete File
// • Exit

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_BLOCKS 100

void showBitVector(int allocated[], int n) {
    printf("Bit Vector (1 for allocated, 0 for free):\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", allocated[i]);
    }
    printf("\n");
}

void createNewFile(int allocated[], int n, int directory[], int index) {
    if (allocated[index] == 0) {
        printf("Creating new file with index %d\n", index);
        directory[index] = 1;
        allocated[index] = 1;
    } else {
        printf("Block is already allocated. Choose another block.\n");
    }
}

void showDirectory(int directory[], int n) {
    printf("Directory (1 for file, 0 for empty):\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", directory[i]);
    }
    printf("\n");
}

void deleteFile(int allocated[], int n, int directory[], int index) {
    if (allocated[index] == 1 && directory[index] == 1) {
        printf("Deleting file with index %d\n", index);
        directory[index] = 0;
        allocated[index] = 0;
    } else {
        printf("No file exists in this block.\n");
    }
}

int main() {
    int allocated[MAX_BLOCKS] = {0}; // Initially all blocks are free
    int directory[MAX_BLOCKS] = {0}; // Initially no files exist
    int n;

    printf("Enter number of disk blocks: ");
    scanf("%d", &n);

    if (n > MAX_BLOCKS) {
        printf("Error: Number of blocks exceeds maximum.\n");
        return 1;
    }

    srand(time(NULL)); // Seed for random number generation

    int choice, index;
    do {
        printf("\nMenu:\n");
        printf("1. Show Bit Vector\n");
        printf("2. Create New File\n");
        printf("3. Show Directory\n");
        printf("4. Delete File\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                showBitVector(allocated, n);
                break;
            case 2:
                printf("Enter index for the new file: ");
                scanf("%d", &index);
                if (index >= 0 && index < n) {
                    createNewFile(allocated, n, directory, index);
                } else {
                    printf("Invalid index.\n");
                }
                break;
            case 3:
                showDirectory(directory, n);
                break;
            case 4:
                printf("Enter index of the file to delete: ");
                scanf("%d", &index);
                if (index >= 0 && index < n) {
                    deleteFile(allocated, n, directory, index);
                } else {
                    printf("Invalid index.\n");
                }
                break;
            case 5:
                printf("Exiting program.\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 5);

    return 0;
}

/*
Enter number of disk blocks: 10

Menu:
1. Show Bit Vector
2. Create New File
3. Show Directory
4. Delete File
5. Exit
Enter your choice: 2
Enter index for the new file: 3
Creating new file with index 3

Menu:
1. Show Bit Vector
2. Create New File
3. Show Directory
4. Delete File
5. Exit
Enter your choice: 3
Directory (1 for file, 0 for empty):
0 0 0 1 0 0 0 0 0 0 

Menu:
1. Show Bit Vector
2. Create New File
3. Show Directory
4. Delete File
5. Exit
Enter your choice: 4
Enter index of the file to delete: 3
Deleting file with index 3

Menu:
1. Show Bit Vector
2. Create New File
3. Show Directory
4. Delete File
5. Exit
Enter your choice: 1
Bit Vector (1 for allocated, 0 for free):
0 0 0 0 0 0 0 0 0 0 

Menu:
1. Show Bit Vector
2. Create New File
3. Show Directory
4. Delete File
5. Exit
Enter your choice: 5
Exiting program.

*/
