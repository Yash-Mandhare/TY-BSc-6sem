// Write an MPI program to find the min and max number from randomly generated 1000 numbers (stored in array) on a cluster (Hint: Use MPI_Reduce)

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char** argv) {
    int rank, size;
    int local_min = INT_MAX, local_max = INT_MIN;
    int local_array[ARRAY_SIZE];

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Seed random number generator
    srand(time(NULL) + rank);

    // Generate random numbers for the local array
    for (int i = 0; i < ARRAY_SIZE; i++) {
        local_array[i] = rand() % 1000; // Generate numbers between 0 and 999
    }

    // Find local min and max
    for (int i = 0; i < ARRAY_SIZE; i++) {
        if (local_array[i] < local_min) {
            local_min = local_array[i];
        }
        if (local_array[i] > local_max) {
            local_max = local_array[i];
        }
    }

    // Reduce local min and max across all processes
    int global_min, global_max;
    MPI_Reduce(&local_min, &global_min, 1, MPI_INT, MPI_MIN, 0, MPI_COMM_WORLD);
    MPI_Reduce(&local_max, &global_max, 1, MPI_INT, MPI_MAX, 0, MPI_COMM_WORLD);

    if (rank == 0) {
        printf("Minimum number: %d\n", global_min);
        printf("Maximum number: %d\n", global_max);
    }

    MPI_Finalize();
    return 0;
}


// mpicc mpi_min_max.c -o mpi_min_max
// mpirun -np <number_of_processes> ./mpi_min_max


// Minimum number: <min_number>
// Maximum number: <max_number>