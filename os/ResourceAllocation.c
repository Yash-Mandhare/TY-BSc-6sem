// Consider a system with ‘m’ processes and ‘n’ resource types. Accept number of instances for every resource type. For each process accept the allocation and maximum requirement matrices. Write a program to display the contents of need matrix and to check if the given request of a process can be granted immediately or not

#include<stdio.h>
#include<stdlib.h>
#define MAX 10

void input(int,int);
void display(int,int); // Updated function prototype
int allocation[MAX][MAX];
int maximum[MAX][MAX];
int need[MAX][MAX];
int available[MAX];
int i,j,n,r;

int main()
{
	int ch;
	do
	{
		printf("\n1.Accept Data \n2.Display Data \n0.Exit\n");
		printf("\nEnter Choice: ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:printf("Enter the no of processes: ");
			       scanf("%d",&n);
			       printf("Enter the no of resources: ");
			       scanf("%d",&r);

			       if(r>n)
			         printf("\nResources are more than processes");
			       else
  				 input(n,r);
			       break;
			case 2:display(n,r); // Updated function call
			       break;
 			case 0:exit(0);
			       break;
			default:printf("Invalid choice!");
		}
	}while(ch!=0);
}

void input(int n,int r)
{
	printf("\nEnter initial allocation - ");
	for(i=0;i<n;i++)
	{
	  printf("\nEnter %d Allocation for P%d: ",r,i);
	  for(j=0;j<r;j++)
	    scanf("%d",&allocation[i][j]);
	}

	printf("\nEnter max requirement -");
	for(i=0;i<n;i++)
	{
	  printf("\nEnter %d Max requirement for P%d: ",r,i);
	  for(j=0;j<r;j++)
	    scanf("%d",&maximum[i][j]);
	}

	printf("\nEnter available resources: ");
	for(i=0;i<r;i++)
	  scanf("%d",&available[i]);
	  for(i=0;i<n;i++)
	    for(j=0;j<r;j++)
	      need[i][j]=maximum[i][j]-allocation[i][j];
}

void display(int n,int r)
{
	printf("\nAllocate Matrix: \n");
	for(i=0;i<n;i++)
	{
	  for(j=0;j<r;j++)
	    printf("\t%d",allocation[i][j]);
	    printf("\n");
	}

	printf("\nMax Matrix: \n");
	for(i=0;i<n;i++)
	{
	  for(j=0;j<r;j++)
	    printf("\t%d",maximum[i][j]);
	    printf("\n");
	}

	printf("\nNeed Matrix: \n");
	for(i=0;i<n;i++)
	{
	  for(j=0;j<r;j++)
	    printf("\t%d",need[i][j]);
	    printf("\n");
	}

	printf("\nAvailable Resources are: \n");
	for(i=0;i<n;i++){
	    printf("\t%d ",available[i]);
	    printf("\n");
	}
}



// 1.Accept Data 
// 2.Display Data 
// 0.Exit

// Enter Choice: 1
// Enter the no of processes: 3
// Enter the no of resources: 2
// Enter initial allocation - 
// Enter 2 Allocation for P0: 1 0
// Enter 2 Allocation for P1: 0 1
// Enter 2 Allocation for P2: 1 1
// Enter max requirement -
// Enter 2 Max requirement for P0: 3 2
// Enter 2 Max requirement for P1: 1 3
// Enter 2 Max requirement for P2: 2 3
// Enter available resources: 2 2

// 1.Accept Data 
// 2.Display Data 
// 0.Exit

// Enter Choice: 2

// Allocate Matrix: 
//     1   0
//     0   1
//     1   1

// Max Matrix: 
//     3   2
//     1   3
//     2   3

// Need Matrix: 
//     2   2
//     1   2
//     1   2

// Available Resources are: 
//     2 
//     2 

// 1.Accept Data 
// 2.Display Data 
// 0.Exit

// Enter Choice: 0

