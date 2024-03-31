// Write a simulation program for disk scheduling using LOOK algorithm. Accept total number of disk blocks, disk request string, and current head position from the user. Display the list of request in the order in which it is served. Also display the total number of head
// moments. [15]
// 176, 79, 34, 60, 92, 11, 41, 114
// Starting Head Position: 65
// Direction: Left

#include <stdio.h>
#include <stdlib.h>

// Function to sort the request array in ascending order
void sortRequests(int *requests, int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (requests[j] > requests[j + 1]) {
                // Swap requests[j] and requests[j + 1]
                int temp = requests[j];
                requests[j] = requests[j + 1];
                requests[j + 1] = temp;
            }
        }
    }
}

// Function to find the index of the request closest to the head position
int findClosestRequest(int *requests, int n, int head, int direction) {
    int index = -1;
    if (direction == -1) {
        // Moving left
        for (int i = 0; i < n; i++) {
            if (requests[i] < head) {
                index = i;
            } else {
                break;
            }
        }
    } else {
        // Moving right
        for (int i = n - 1; i >= 0; i--) {
            if (requests[i] > head) {
                index = i;
            } else {
                break;
            }
        }
    }
    return index;
}

int main() {
    int totalBlocks, head, direction;
    
    printf("Enter the total number of disk blocks: ");
    scanf("%d", &totalBlocks);

    printf("Enter the disk request string (comma-separated): ");
    int requests[totalBlocks];
    for (int i = 0; i < totalBlocks; i++) {
        scanf("%d", &requests[i]);
    }

    printf("Enter the starting head position: ");
    scanf("%d", &head);

    printf("Enter the direction (1 for right, -1 for left): ");
    scanf("%d", &direction);

    sortRequests(requests, totalBlocks);

    printf("\nOrder of serving requests:\n");

    int totalHeadMovements = 0;
    int currentIndex = findClosestRequest(requests, totalBlocks, head, direction);
    while (currentIndex != -1) {
        printf("%d ", requests[currentIndex]);
        totalHeadMovements += abs(requests[currentIndex] - head);
        head = requests[currentIndex];
        requests[currentIndex] = -1; // Mark as served
        currentIndex = findClosestRequest(requests, totalBlocks, head, direction);
    }

    printf("\nTotal number of head movements: %d\n", totalHeadMovements);

    return 0;
}


// Order of serving requests:
// 60 41 34 11 
// Total number of head movements: 118
