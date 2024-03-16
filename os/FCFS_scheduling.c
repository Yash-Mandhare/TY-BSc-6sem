// Write an OS program to implement FCFS Disk Scheduling algorithm.

#include<stdio.h>
#include<math.h>

int fcfs(int request[],int n, int head)
{
    int i,d,cnt=0;

    for(i=0;i<n;i++)
        {
            d = abs(head - request[i]);

            cnt += d;

            head = request[i];
        }
    return cnt;
}


int main()
{
    int i,n,request[100],head,seek_cnt;

    printf("\nEnter number of disk blocks:");
    scanf("%d",&n);

    printf("\nEnter disk request string:");
    for(i=0;i<n;i++)
        scanf("%d",&request[i]);

    printf("\nEnter current head position:");
    scanf("%d",&head);

    printf("\nSeek Sequence in FCFS would be the same as requested array");
    printf("%d ",head);
    for(i=0;i<n;i++)
        printf("%d ",request[i]);

    seek_cnt = fcfs(request,n,head);
    
    printf("\nTotal number of head movement : %d",seek_cnt);

    return 0;
} 

// Enter number of disk blocks: 5
// Enter disk request string: 98 183 37 122 14
// Enter current head position: 53

// Seek Sequence in FCFS would be the same as requested array
// 53 98 183 37 122 14 
// Total number of head movement: 236
