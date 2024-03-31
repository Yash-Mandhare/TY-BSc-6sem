// Write an OS program to implement SSTF algorithm Disk Scheduling algorithm

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

// Function to find the index of the shortest seek time
int findSSTF(int request[], int visited[], int head, int n) {
    int min_distance = INT_MAX;
    int index = -1;
    
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            int distance = abs(head - request[i]);
            if (distance < min_distance) {
                min_distance = distance;
                index = i;
            }
        }
    }
    
    return index;
}

// Function to implement SSTF algorithm
int sstf(int request[], int n, int head) {
    int seek_count = 0;
    int visited[n];
    for (int i = 0; i < n; i++)
        visited[i] = 0;

    printf("Seek Sequence\n%d ", head);

    for (int i = 0; i < n; i++) {
        int index = findSSTF(request, visited, head, n);
        printf("%d ", request[index]);
        seek_count += abs(head - request[index]);
        head = request[index];
        visited[index] = 1;
    }

    printf("\nTotal Number of head movement : %d\n", seek_count);

    return seek_count;
}

int main() {
    int n, head, seek_count;

    printf("Enter number of disk blocks: ");
    scanf("%d", &n);

    int request[n];
    printf("Enter disk request string: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &request[i]);

    printf("Enter current head position: ");
    scanf("%d", &head);

    seek_count = sstf(request, n, head);

    return 0;
}


// Enter number of disk blocks: 5
// Enter disk request string: 98 183 37 122 14
// Enter current head position: 53
// Seek Sequence
// 53 37 14 98 122 183 
// Total Number of head movement : 236
