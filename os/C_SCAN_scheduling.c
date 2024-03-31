// Write an OS program to implement C-SCAN Disk Scheduling algorithm.


#include <stdio.h>
#include <stdlib.h>

void cscan(int request[], int n, int head, char direction) {
    int seek_count = 0;
    int i, j;
    int min = 0, max = 199;
    int range = 200;
    int visited[n];

    for (i = 0; i < n; i++)
        visited[i] = 0;

    if (direction == 'r') {
        printf("Seek Sequence\n%d ", head);

        // Move towards the right until reaching the end
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

        // Move from the beginning to the minimum
        for (i = min; i < head; i++) {
            for (j = 0; j < n; j++) {
                if (request[j] == i && !visited[j]) {
                    printf("%d ", request[j]);
                    visited[j] = 1;
                    seek_count += abs(head - request[j]);
                    head = request[j];
                }
            }
        }
    } else if (direction == 'l') {
        printf("Seek Sequence\n%d ", head);

        // Move towards the left until reaching the beginning
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

        // Move from the end to the maximum
        for (i = max; i > head; i--) {
            for (j = 0; j < n; j++) {
                if (request[j] == i && !visited[j]) {
                    printf("%d ", request[j]);
                    visited[j] = 1;
                    seek_count += abs(head - request[j]);
                    head = request[j];
                }
            }
        }
    }

    printf("\nTotal Number of head movement : %d\n", seek_count);
}

int main() {
    int n, head;
    char direction;

    printf("Enter number of disk requests (up to 100): ");
    scanf("%d", &n);

    int request[n];
    printf("Enter disk request string: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &request[i]);

    printf("Enter current head position: ");
    scanf("%d", &head);

    printf("Enter direction of movement (l for left, r for right): ");
    scanf(" %c", &direction);

    cscan(request, n, head, direction);

    return 0;
}
