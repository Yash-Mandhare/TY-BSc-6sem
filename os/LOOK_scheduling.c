// Write a simulation program for disk scheduling using LOOK algorithm. Accept total number of disk blocks, disk request string, and current head position from the user. Display the list of request in the order in which it is served. Also display the total number of head
// moments. [15]
// 176, 79, 34, 60, 92, 11, 41, 114
// Starting Head Position: 65
// Direction: Left

#include <stdio.h>
#include <stdlib.h>

void look(int request[], int n, int head) {
    int seek_count = 0;
    int i, j;
    int min = 0, max = 199; // Assuming disk range
    int visited[n];

    for (i = 0; i < n; i++)
        visited[i] = 0;

    printf("Seek Sequence\n%d ", head);

    // Serve requests in ascending order
    for (i = head; i <= max; i++) {
        for (j = 0; j < n; j++) {
            if (request[j] == i && !visited[j]) {
                printf("%d ", request[j]);
                visited[j] = 1;
                seek_count += abs(head - request[j]);
                head = request[j];
            }
        }
    }

    // Serve requests in descending order
    for (i = head; i >= min; i--) {
        for (j = 0; j < n; j++) {
            if (request[j] == i && !visited[j]) {
                printf("%d ", request[j]);
                visited[j] = 1;
                seek_count += abs(head - request[j]);
                head = request[j];
            }
        }
    }

    printf("\nTotal Number of head movement : %d\n", seek_count);
}

int main() {
    int n, head;

    printf("Enter total number of disk blocks: ");
    scanf("%d", &n);

    int request[n];
    printf("Enter disk request string: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &request[i]);

    printf("Enter current head position: ");
    scanf("%d", &head);

    look(request, n, head);

    return 0;
}


// Order of serving requests:
// 60 41 34 11 
// Total number of head movements: 118
