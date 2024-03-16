#include<stdio.h>
#include<stdlib.h>

#define MAX 10
void input(int,int);
void display();
int safestate(int,int);
void checkrequest();

int allocate[MAX][MAX];
int maximum[MAX][MAX];
int need[MAX][MAX];

int available[MAX];
int work[MAX];
int finish[MAX];
int sequence[MAX];
int request[MAX];

int i,j,n,r;
int main()
{
	int ch,ans;
	do{
		printf("\n1 Accept Data \n2 Display Data \n3 Safety algorithm \n4 check request\n5 Request Exit\n");
		printf("Enter Choice: ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: printf("\n Enter the no. of processor: ");
				scanf("%d",&n);
				printf("\n Enter the no. of resources: ");
				scanf("%d",&r);

				if(r>n)
					printf("\nResources can't be greater than no. of processes");
				else
					input(n,r);
				break;

			case 2: display();
				break;

			case 3: ans=safestate(n,r);
				if(ans==1)
				{
					printf("\nSystem is in a safe state\n");
					printf("Safe sequence is: \n");
					for(i=0;i<n;i++)
						printf("P%d",sequence[i]);
				}
				else
					printf("\nSystem is not in a safe state\n");
					break;
			
			case 4: checkrequest();
				break;

			case 5: exit(0);
				break;
		}
	}while(ch!=5);
}


void input(int n,int r)
{
	printf("\nEnter initial allocate - ");
	for(i=0;i<n;i++)
	{
	  printf("\nEnter %d allocate for P%d: ",r,i);
	  for(j=0;j<r;j++)
	    scanf("%d",&allocate[i][j]);
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
	      need[i][j]=maximum[i][j]-allocate[i][j];
}

void display()
{
	printf("\nAllocate Matrix: \n");
	for(i=0;i<n;i++)
	{
	  for(j=0;j<r;j++)
	    printf("\t%d",allocate[i][j]);
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
	for(i=0;i<n;i++)
	    printf("\t%d",available[i]);
	    printf("\n");
}

int safestate(int n,int r)
{
	int index=0,flag=1,cnt;
	for(i=0;i<n;i++)
		finish[i]=0;

	for(i=0;i<r;i++)
		work[i]=available[i];

	while(flag)
	{
		flag=0;
		for(i=0;i<n;i++)
		{
			if(finish[i]=0)
			{
				cnt=0;
				for(j=0;j<r;j++)
				{
					if(need[i][j]<=work[j])
						cnt++;


					else
					break;
				}
					if(cnt==r)
					{
						finish[i]=1;
						for(j=0;j<r;j++)
							work[j]+=allocate[i][j];
							flag=1;
							sequence[index]=i;
							index++;


					}
					
			}
		}
	}
	for(i=0;i<n;i++)
		if(finish[i]==0)
			return 0;
	return 1;

}

void checkrequest()
{
	int c1=1,c2=1,p;
	printf("\nAvailable resources are : [");
	for(i=0;i<r;i++){
	printf("%d ",available[i]);
}
	printf("]");
	printf("\nEnter the requesting proceseses :P");
	scanf("%d",&p);
	printf("\nEnter the requests for P%d:",p);
	for(i=0;i<r;i++)
		scanf("%d",&request[i]);
	for(i=0;i<r;i++)
		if(request[i]>available[i])
		{
			c1=0;
			printf("\nRequest by P%d exceeds the available resources \nIt cannot be immediately granted\n",p);
			break;

		}
	if(c1 && c2)
		{
			for(i=0;i<r;i++)
			{
				available[i]-=request[i];
				allocate[p][i]+=request[i];
				need[p][i]-=request[i];
			
			}
			if(!safestate(n,r))
			{
				printf("\nSystem is in an unsafe state.\n");
				printf("\nRequest by P%d cannot be immediately granted\n",p);
				for(i=0;i<r;i++)
				{
					available[i]+=request[i];
				allocate[p][i]-=request[i];
				need[p][i]+=request[i];	
				}
			}
			else
			{
				printf("\nSystem is in a safe state.");
				printf("\nRequest by P%d can be immediately granted\n",p);
				
			}
		}
		else
		{
			printf("\nSystem is in a unsafe state.");
		}
}


// 1 Accept Data 
// 2 Display Data 
// 3 Safety algorithm 
// 4 check request
// 5 Request Exit
// Enter Choice: 1

//  Enter the no. of processor: 3
//  Enter the no. of resources: 4

//  Enter initial allocate - 
// Enter 4 allocate for P0: 1 2 3 4
// Enter 4 allocate for P1: 5 6 7 8
// Enter 4 allocate for P2: 9 10 11 12

// Enter max requirement -
// Enter 4 Max requirement for P0: 10 9 8 7
// Enter 4 Max requirement for P1: 6 5 4 3
// Enter 4 Max requirement for P2: 2 1 0 9

// Enter available resources: 3 2 1 4

// 1 Accept Data 
// 2 Display Data 
// 3 Safety algorithm 
// 4 check request
// 5 Request Exit
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
//     3 2 1 4

// 1 Accept Data 
// 2 Display Data 
// 3 Safety algorithm 
// 4 check request
// 5 Request Exit
// Enter Choice: 3

// System is in a safe state
// Safe sequence is: 
// P0P2P1
// 1 Accept Data 
// 2 Display Data 
// 3 Safety algorithm 
// 4 check request
// 5 Request Exit
// Enter Choice: 4

// Available resources are : [3 2 1 4 ]
// Enter the requesting proceseses :P0

// Enter the requests for P0:0 1 0 2

// System is in a safe state.
// Request by P0 can be immediately granted

// 1 Accept Data 
// 2 Display Data 
// 3 Safety algorithm 
// 4 check request
// 5 Request Exit
// Enter Choice: 5
