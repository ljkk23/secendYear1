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
    SqStack L,Q,S;
    char x;
    int len;
    char s[255],j=0;
    InitStack(L);
    InitStack(Q);
    InitStack(S);
    while (x!='@')
    {
        /* code */
        scanf("%c",&x);
        Push(S,x);
        s[j]=x;
        j++;
        
    }
    len=S.top-S.base-1;
    for (int i = 0; i < len; i++)
    {
        /* code */
        if(s[i]!='@')
        {
            /* code */
            
            if (s[i]=='['){
                Push(L,1); 
                
                
            }
            if (s[i]=='{'){
                Push(L,2); 
            }
            if (s[i]=='('){
                Push(L,3); 
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
                if (Gettop(Q)==Gettop(L))
                {
                    /* code */  
                    Pop(Q);
                    Pop(L);   
                } 
            }
        }
    }
    if (L.base==L.top && Q.base==Q.top)
        {
            /* code */
            printf("YES!");
        }
        else
        printf("NO£¡");
    return 0;
}