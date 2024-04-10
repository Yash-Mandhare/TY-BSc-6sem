// Write an OS program to implement C-SCAN Disk Scheduling algorithm.


#include <stdio.h>
#include <stdlib.h>

#define MAX_REQUESTS 100

// Function to sort the request array in ascending order
void sortRequests(int request[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (request[j] > request[j + 1]) {
                int temp = request[j];
                request[j] = request[j + 1];
                request[j + 1] = temp;
            }
        }
    }
}

// Function to implement C-SCAN algorithm
int cscan(int request[], int n, int head, char direction) {
    int seek_count = 0;
    int current_track = head;
    int index;

    // Sort the requests and find the index where the head is located
    sortRequests(request, n);
    for (int i = 0; i < n; i++) {
        if (request[i] >= head) {
            index = i;
            break;
        }
    }

    // C-SCAN towards higher tracks
    if (direction == 'r') {
        printf("Seek Sequence\n%d ", current_track);
        for (int i = index; i < n; i++) {
            printf("%d ", request[i]);
            seek_count += abs(current_track - request[i]);
            current_track = request[i];
        }
        printf("199 "); // Move to the highest track
        seek_count += 199 - current_track; 

        // Move to the lowest track
        printf("0 ");
        seek_count += 199; 

        // C-SCAN towards lower tracks
        for (int i = 0; i < index; i++) {
            printf("%d ", request[i]);
            seek_count += abs(current_track - request[i]);
            current_track = request[i];
        }
    } else { // C-SCAN towards lower tracks
        printf("Seek Sequence\n%d ", current_track);
        seek_count += current_track;
        for (int i = index-1; i >= 0; i--) {
            printf("%d ", request[i]);
            seek_count += abs(current_track - request[i]);
            current_track = request[i];
        }
        printf("0 "); // Move to the lowest track
        seek_count += current_track; 

        // Move to the highest track
        printf("199 ");
        seek_count += 199 - current_track; 

        // C-SCAN towards higher tracks
        for (int i = n-1; i >= index; i--) {
            printf("%d ", request[i]);
            seek_count += abs(current_track - request[i]);
            current_track = request[i];
        }
    }

    printf("\nTotal Number of head movement : %d\n", seek_count);

    return seek_count;
}

int main() {
    int n, head, seek_count;
    char direction;

    printf("Enter number of disk requests (up to %d): ", MAX_REQUESTS);
    scanf("%d", &n);

    int request[MAX_REQUESTS];
    printf("Enter disk request string: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &request[i]);

    printf("Enter current head position: ");
    scanf("%d", &head);

    printf("Enter direction of movement (l for left, r for right): ");
    scanf(" %c", &direction);

    seek_count = cscan(request, n, head, direction);

    return 0;
}


// Enter number of disk requests (up to 100): 8
// Enter disk request string: 40 60 20 10 100 90 80 30
// Enter current head position: 50
// Enter direction of movement (l for left, r for right): r
// Seek Sequence
// 50 60 80 90 100 199 0 10 20 30 40 
// Total Number of head movement : 468

// Enter number of disk requests (up to 100): 8
// Enter disk request string: 40 60 20 10 100 90 80 30
// Enter current head position: 50
// Enter direction of movement (l for left, r for right): l
// Seek Sequence
// 50 40 30 20 10 0 199 100 90 80 60
// Total Number of head movement : 419
