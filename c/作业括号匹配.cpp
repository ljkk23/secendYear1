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
    int x,y;
    char s[9];
    InitStack(S);
    InitStack(Q);


    for (int i = 0; i < 9; i++)
    {
        /* code */
        scanf("%c",&s[i]);
    }
    for (int i = 0; i < 9; i++)
    {
        /* code */
        
        if(s[i]!='#')
        {
            /* code */
            if (s[i]=='['){
                Push(S,1); 
                
            }
            if (s[i]=='{'){
                Push(S,2); 
                
            }
            if (s[i]=='('){
                Push(S,3); 
                
            }
            
            if (s[i]==']' || s[i]=='}'||s[i]==')')
            {
                /* code */
                if (s[i]==']')
                {
                    /* code */
                    Push(Q,1);
                   
                    
                }
                if (s[i]=='}')
                {
                    /* code */
                    Push(Q,2);
                    
                }
                if (s[i]==')')
                {
                    /* code */
                    Push(Q,3);
                    
                }
                if (Gettop(Q)==Gettop(S))
                {
                    /* code */
                    
                    Pop(Q);
                    Pop(S);
                    
                } 
            }
        }
    }
    
    if (S.base==S.top && Q.base==Q.top)
        {
            /* code */
            printf("合法！");
        }
        else
        printf("不合法！");
    
    return 0;
}