#include <stdio.h>
#include <stdlib.h>
#define STACK_INIT_SIZE 100
#define STACKCREAMENT 10
typedef struct {
    int *base;
    int *top;
    int stacksize;
}SqStack;
void InitStack(SqStack &S){
    S.base=(int*)malloc(STACK_INIT_SIZE*sizeof(SqStack));
    if(!S.base)
    exit(0);
    S.top=S.base;
    S.stacksize=STACK_INIT_SIZE;
}
void Push(SqStack &S,int e){
    if (S.top-S.base>=S.stacksize)
    {
        /* code */
        S.base=(int *)realloc(S.base,(S.stacksize+STACKCREAMENT)*sizeof(char));
        if (!S.base)
        {
            exit(0);
        }
    }
        *S.top++=e;
    
}
void Pop(SqStack &S){
    if(S.top==S.base) 
    exit(0);
    S.top--;
}
int Gettop(SqStack &S){
    int x;
    if (S.top==S.base)
    {
        return 0;
    }
    x=*(S.top-1);
    return x;
}

int main(){
    SqStack S;
    int M,N,K,x=0,log=1;
    int po=0,top=0;
    int out[1000];
    InitStack(S);
    scanf("%d%d%d",&M,&N,&K);
    
    while (K--)
    {
        /* code */
        for (int i = 0; i < N; i++)
        {
            /* code */
            scanf("%d",&out[i]);

        }
        for (int i = 0; i < N; i++)
        {
            /* code */
            for (int j =po+1; j <= out[i]; j++)
            {
                /* code */
                po=j;
                Push(S,j);
                x++;
            }
            if (Gettop(S)!=out[i])
            {
                /* code */
                log=0;
                break;
                
            }
            Pop(S); 
            x--;
            if (x>5)
            {
                /* code */
                printf("no!");
            }
            
        }
        if (log==0)
        {
            /* code */
            printf("no!");
        }else
        printf("yes!");   
    }
    
    

}