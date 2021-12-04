#include <stdio.h>
#include <stdlib.h>
typedef struct Lnode
{
    int data;
    struct Lnode *next;
}Stacknode;
int INIT_STACK(Stacknode *S)
{
    S=(Stacknode *)malloc(sizeof(Lnode));
    if (S)
    {
        printf("成功分配\n");
    }
    S->next=NULL;
    

}
int StackLenth(Stacknode *S)
{
    int i=0;
    Stacknode *p;
    p=S->next;
    while (p)
    {
        i++;
        p=p->next;
    }
    printf("the length is %d",i);
    
}
int Push(Stacknode *S,int e)
{
    Stacknode *p;
    p=(Stacknode *)malloc(sizeof(Lnode));
    
    if (!p)
    {
        printf("wrong");
        return 0;
    }
    p->data=e;
    p->next=S;
    S=p;
    

}
int display(Stacknode *S)
{
    Stacknode *p;
    p=(Stacknode *)malloc(sizeof(Lnode));
    p=S;
    while (p)
    {
        /* code */
        printf("%d  ddd ",p->data);
        p=p->next;
    }
    return 0;
    
}
int main()
{
    Stacknode S;
    INIT_STACK(&S);
    int x=0;
    //StackLenth(&S);
    while (x!=-1)
    {
        scanf("%d",&x);
        Push(&S,x);
        printf("压栈成功\n");
    }
    display(&S);
    
}
