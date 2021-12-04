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
void Display(SqStack &S){
    while (S.top!=S.base)
    {
        /* code */
        printf("%d  ",*--S.top);
        
    }
    
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
    SqStack S,Q;
    char x;
    InitStack(S);
    InitStack(Q);
    while (x!='@')
    {
        /* code */
        scanf("%c",&x);
        Push(S,x);
    }
    printf("length:%d",S.top-S.base-1);
}
    