#include<stdio.h>
#include<stdlib.h>
#define MAX 10

void input(int,int);
void display();
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
			case 2:display();
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

void display()
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
// Enter the no of resources: 4

// Enter initial allocation - 
// Enter 4 Allocation for P0: 1 2 3 4
// Enter 4 Allocation for P1: 5 6 7 8
// Enter 4 Allocation for P2: 9 10 11 12

// Enter max requirement -
// Enter 4 Max requirement for P0: 10 9 8 7
// Enter 4 Max requirement for P1: 6 5 4 3
// Enter 4 Max requirement for P2: 2 1 0 9

// Enter available resources: 3 2 1 4

// 1.Accept Data 
// 2.Display Data 
// 0.Exit

// Enter Choice: 2

// Allocate Matrix: 
//     1   2   3   4
//     5   6   7   8
//     9   10   11   12

// Max Matrix: 
//     10   9   8   7
//     6   5   4   3
//     2   1   0   9

// Need Matrix: 
//     9   7   5   3
//     1   -1   -3   -5
//     -7   -9   -11   -3

// Available Resources are: 
//     3 
//     2 
//     1 
//     4 

// 1.Accept Data 
// 2.Display Data 
// 0.Exit

// Enter Choice: 0
