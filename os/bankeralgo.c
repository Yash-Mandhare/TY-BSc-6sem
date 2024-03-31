// Write a C program to simulate Banker’s algorithm for the purpose of deadlock
// avoidance. Consider the following snapshot of system, A, B, C and D is the
// resource type.
// Process Allocation Max Available
// A B C D A B C D A B C D
// P0 0 0 1 2 0 0 1 2 1 5 2 0
// P1 1 0 0 0 1 7 5 0
// P2 1 3 5 4 2 3 5 6
// P3 0 6 3 2 0 6 5 2
// P4 0 0 1 4 0 6 5 6
// a) Calculate and display the content of need matrix?
// b) Is the system in safe state? If display the safe sequence.

#include<stdio.h>
#include<stdbool.h>

// Number of processes
#define P 5

// Number of resources
#define R 4

// Function to calculate need matrix
void calculateNeed(int need[P][R], int max[P][R], int allot[P][R])
{int i,j;
    for (i = 0; i < P; i++)
        for (j = 0; j < R; j++)
            need[i][j] = max[i][j] - allot[i][j];
}

// Function to find whether the system is in safe state or not
bool isSafe(int processes[], int avail[], int max[][R], int allot[][R])
{int i, p, k;
    int need[P][R];
    calculateNeed(need, max, allot);

    bool finish[P] = {0};

    int safeSeq[P];
    int work[R];
    for (i = 0; i < R; i++)
        work[i] = avail[i];

    int count = 0;
    while (count < P)
    {
        bool found = false;
        for (p = 0; p < P; p++)
        {
            if (!finish[p])
            {
                int j;
                for (j = 0; j < R; j++)
                    if (need[p][j] > work[j])
                        break;

                if (j == R)
                {
                    for (k = 0; k < R; k++)
                        work[k] += allot[p][k];

                    safeSeq[count++] = p;
                    finish[p] = 1;

                    found = true;
                }
            }
        }

        if (!found)
        {
            printf("System is not in safe state\n");
            return false;
        }
    }

    printf("System is in safe state.\nSafe sequence is: ");
    for (i = 0; i < P - 1; i++)
        printf("P%d -> ", safeSeq[i]);
    printf("P%d\n", safeSeq[P - 1]);

    return true;
}

int main()
{
    int processes[P];
    int avail[R];
    int max[P][R];
    int allot[P][R];
    int i, j;
    // Taking input for allocation matrix
    printf("Enter allocation matrix:\n");
    for (i = 0; i < P; i++) {
        printf("For process P%d: ", i);
        for (j = 0; j < R; j++)
            scanf("%d", &allot[i][j]);
    }

    // Taking input for maximum matrix
    printf("Enter maximum matrix:\n");
    for (i = 0; i < P; i++) {
        printf("For process P%d: ", i);
        for (j = 0; j < R; j++)
            scanf("%d", &max[i][j]);
    }

    // Taking input for available resources
    printf("Enter available resources:\n");
    for (i = 0; i < R; i++)
        scanf("%d", &avail[i]);

    // Initialize processes array
    for (i = 0; i < P; i++)
        processes[i] = i;

    // Check if the system is in a safe state
    isSafe(processes, avail, max, allot);

    return 0;
}


// Enter allocation matrix:
// For process P0: 0 0 1 2
// For process P1: 1 0 0 0 
// For process P2: 1 3 5 4
// For process P3: 0 6 3 2
// For process P4: 0 0 1 4
// Enter maximum matrix:
// For process P0: 0 0 1 2
// For process P1: 1 7 5 0
// For process P2: 2 3 5 6
// For process P3: 0 6 5 2
// For process P4: 0 6 5 6
// Enter available resources:
// 1 5 2 0
// System is in safe state.
// Safe sequence is: P0 -> P2 -> P3 -> P4 -> P1
