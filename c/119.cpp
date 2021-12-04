#include <stdio.h>
#include <stdlib.h>
#define STACK_INIT_SIZE 100
#define STACKCREAMENT 10
typedef struct node
{
    /* data */
    char data;
    struct node *lchild,*rchild;
}Treenode,*Bitree;
typedef struct {
    Treenode *base;
    Treenode *top;
    int stacksize;
}SqStack;
Bitree CreateTree(){
    Bitree T;
    char ch;
    scanf("%c",&ch);
    //T->data=ch;
    T=(Bitree)malloc(sizeof(Bitree));
    if (ch=='#')
    {
        /* code */
        T=NULL;
        return T;
    }
    else{
        //T=(Bitree)malloc(sizeof(Bitree));
        T->data=ch;
        T->lchild=CreateTree();
        T->rchild=CreateTree();
    }
    return T;
}
void Preorder(Bitree T){//先序遍历
    if (T)
    {
        /* code */
        //printf("heelo\n");
        printf("%c",T->data);
        Preorder(T->lchild);
        Preorder(T->rchild);
    }
}
void InOrder(Bitree T)//中序遍历，左根右
{
   if(T){
   InOrder(T->lchild);
   printf("%c ",T->data);
   InOrder(T->rchild);
 }
}
 void postOrder(Bitree T)  //后序遍历  
 {  
     if(T)  
     {     
         postOrder(T->lchild);  
         postOrder(T->rchild); 
	     printf("%c",T->data);  
     }  
 }
void InitStack(SqStack &S){
    S.base=(Treenode*)malloc(STACK_INIT_SIZE*sizeof(SqStack));
    if(!S.base)
    exit(0);
    S.top=S.base;
    S.stacksize=STACK_INIT_SIZE;
}
void Push(SqStack &S,Bitree e){
    if (S.top-S.base>=S.stacksize)
    {
        /* code */
        S.base=(Treenode *)realloc(S.base,(S.stacksize+STACKCREAMENT)*sizeof(char));
        if (!S.base)
        {
            exit(0);
        }
    }
        printf("jinzhan");
        S.top=e;
        S.top++;
        //printf("%c",e->data);
    
}
void Pop(SqStack &S,Bitree *e){
    if(S.top==S.base) 
    exit(0);
    *e=--S.top;
    printf("  chuzhan  ");
    
    //printf("chuzhan");
    //printf("%c",e->data);
    //如果e为空null，可以给e赋值吗
}
int StackEmpty(SqStack &S)         
{    
    if (S.top == S.base)    
        return 1;    
    else   
        return 0;    
} 
void InOrderTraverse(Bitree T)                         
{    
    Bitree p = T;//二叉树遍历指针    
    SqStack S;   //栈 
    InitStack(S);//建栈   
    int i=0; 
    //printf("  %d\n",p->lchild->rchild->lchild);
    while (p || !StackEmpty(S)) //指针不为空 或者 栈为空，进入循环
    {    
        
        
        if (p)    
        {//如果指针不为空 
            i++;
            printf("ddd\n%d",i);  

            //printf("%d",p);
            Push(S,p);      //此节点入栈    （对应第 1 步）
            printf(" %d   ",p);
            p = p->lchild;  //继续访问此节点的左节点  （对应第 2 步）
            printf(" aaa ");
        }    
        else   
        {//若指针为空（即没有左孩子 ） 
             
            //printf("aaa\n");
            Pop(S,&p);    //栈顶元素 出栈 并赋值给遍历指针 （对应第 3 步）
            printf("  weikong  ");
            printf("%c ",p->data);   //输出值 
            printf(" dizhi  %d ",p);
            
            
            p = p->rchild;             //继续遍历右节点    （对应第 4 步）
        }    
    }   

    return;
}
int main()
{
    Bitree T;

    T=CreateTree();
    InOrderTraverse(T);
    //Preorder(T);
    //InOrder(T);
    //postOrder(T);

    return 0;
}

