#include <stdio.h>
#include <stdlib.h>
#define INIT_SIZE 20
#define INCREMENT_SIZE 5
typedef struct 
{
    int *base;
    int *top;
    int size;
}Sqstack;
int Initstack(Sqstack *S)
{
    S->base=(int *)malloc(INIT_SIZE*sizeof(int));
    if (!S->base)
    {
        exit(-1);
    }
    S->top=S->base;
    S->size=INIT_SIZE;
    printf("成功生成栈\n");
    return 0;
}
int Isempty(Sqstack *S)//是否为空
{
    if (S->top==S->base)
    {
        printf("empty stack\n");
        return true;
    }else
    {
        printf("not empty stack\n");
        return false;
    }
    
}
int Getlenth(Sqstack *S)
{
    return S->top-S->base;
}
int Push(Sqstack *S,int e)
{
    if ((S->top-S->base)/sizeof(int)>=S->size)
    {
        S->base =(int *)realloc(S->base, (S->size+INCREMENT_SIZE)*sizeof(int));
        S->top = S->base + S->size;
        S->size += INCREMENT_SIZE;
    }
    *S->top=e;
    S->top++;
    return 0;
}
int Gettop(Sqstack *S)
{
    if (S->top>S->base)
    {
        printf("the top element is %d\n",*(--S->top));//top指针是没有元素的，相当于头节点，所以要减一
        S->top++;   
    }
    else
    {
        printf("no top elemrnt\n");
        return 0;
    }
    
}
int Pop(Sqstack *S)
{
    int e;
    if (S->top>S->base)
    {
        e=*(--S->top);
        printf("%d 元素退出栈\n",e);
    }
    else
    return 0;  
}
int display(Sqstack *S)
{
    for (int i = 0; i < *S->top; i++)
    {
        printf("%d  ",*(S->base++));
    }
    
}
int main()
{
    Sqstack S;
    Initstack(&S);
    Isempty(&S);
    for (int i = 0; i < 6; i++)
    {
        Push(&S,i);
        
    }
    printf("push 过后\n");
    Isempty(&S);
    Gettop(&S);
    Pop(&S);
    display(&S);
    
    

}
