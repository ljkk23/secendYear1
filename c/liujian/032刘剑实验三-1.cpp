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
    printf("�ɹ�����ջ\n");
    return 0;
}
int Isempty(Sqstack *S)//�Ƿ�Ϊ��
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
        printf("the top element is %d\n",*(--S->top));//topָ����û��Ԫ�صģ��൱��ͷ�ڵ㣬����Ҫ��һ
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
        printf("%d Ԫ���˳�ջ\n",e);
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
    printf("push ����\n");
    Isempty(&S);
    Gettop(&S);
    Pop(&S);
    display(&S);
    
    

}
