// Write an MPI program to calculates sum of randomly generated 1000 numbers (stored in array) on a cluster

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char** argv) {
    int rank, size;
    int local_sum = 0, total_sum = 0;
    int local_array[ARRAY_SIZE];
    int i;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Seed random number generator
    srand(time(NULL) + rank);

    // Generate random numbers for the local array
    for (i = 0; i < ARRAY_SIZE; i++) {
        local_array[i] = rand() % 100; // Generate numbers between 0 and 99
    }

    // Calculate local sum
    for ( i = 0; i < ARRAY_SIZE; i++) {
        local_sum += local_array[i];
    }

    // Reduce local sums to calculate total sum
    MPI_Reduce(&local_sum, &total_sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    if (rank == 0) {
        printf("Total sum across all processes: %d\n", total_sum);
    }

    MPI_Finalize();
    return 0;
}


// [smile@localhost slip os 6sem]$ mpicc MPIsum.c -o MPIsum
// [smile@localhost slip os 6sem]$ mpirun -np 10 ./MPIsum
// Total sum across all processes: 497005