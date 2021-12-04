#include <stdio.h>
#include <stdlib.h>
typedef struct Lnode{
    int data;
    struct Lnode *Next;
}Lnode,*Linklist;
void Display(Lnode *p){
    while (p)
    {
        /* code */
        printf("%d->",p->data);
        p=p->Next;
    }
}
int main(){
    Lnode *p,*h,*q,*q_front,*q_back;//p为新生成的结点，h为头结点，q为移动的结点，q_front和q_back分别表示q的前驱和后继
    int x,y,z,m=0;//x为设置初始节点为1，y为接收输入的在y同学的左边或者右边,z为判断输入的是1还是0,m用来计数已有多少个节点
    int n=1,r=1;//记录头结点是否移动的记号,初始头节点值为1,记录尾结点是否移动的记号,初始头节点值为1
    scanf("%d",&x);
    h=(Lnode*)malloc(sizeof(Lnode));
    q_front=(Lnode*)malloc(sizeof(Lnode));
    q_back=(Lnode*)malloc(sizeof(Lnode));
    h->data=1;
    h->Next=NULL;
    q=h;
    q_front->Next=q;
    q_back=q->Next;
    m++;
    for (int i = 2; i < x+1; i++)
    {
        /* code */
        p=(Lnode*)malloc(sizeof(Lnode));
        p->data=i;
        p->Next=NULL;
        scanf("%d %d",&y,&z);
        for (int i = 0; i < m; i++)
        {
            /* code */
            if (q->data!=y)
            {
                /* code */
                q=q->Next;
                q_back->Next=q_back->Next;
                q_front->Next=q_front->Next;

            }
            if (q->data==y)
            {
                /* code */
                if (z==0)
                {
                    /* code */
                    
                    q_front->Next=p;
                    p->Next=q;
                    if (q->data==n)//判断头结点是否移动
                    {
                        /* code */
                        h=q;
                        n=h->data;
                        
                    }
                    q_front=p;   
                }
                if (z==1)
                {
                    /* code */
                    q->Next=p;
                    p->Next=q_back;
                    if (q->data==r)//判断是否是尾结点
                    {
                        /* code */
                        r=q->data;
                        p->Next=NULL;
                    }
                    q_back=p;
                }     
            }
            q=h;
            q_front->Next=q;
            q_back=q->Next;
            q_back=NULL;
        }
    }
    
    Display(h);
}