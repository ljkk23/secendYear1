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
void Preorder(Bitree T){//�������
    if (T)
    {
        /* code */
        //printf("heelo\n");
        printf("%c",T->data);
        Preorder(T->lchild);
        Preorder(T->rchild);
    }
}
void InOrder(Bitree T)//��������������
{
   if(T){
   InOrder(T->lchild);
   printf("%c ",T->data);
   InOrder(T->rchild);
 }
}
 void postOrder(Bitree T)  //�������  
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
    //���eΪ��null�����Ը�e��ֵ��
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
    Bitree p = T;//����������ָ��    
    SqStack S;   //ջ 
    InitStack(S);//��ջ   
    int i=0; 
    //printf("  %d\n",p->lchild->rchild->lchild);
    while (p || !StackEmpty(S)) //ָ�벻Ϊ�� ���� ջΪ�գ�����ѭ��
    {    
        
        
        if (p)    
        {//���ָ�벻Ϊ�� 
            i++;
            printf("ddd\n%d",i);  

            //printf("%d",p);
            Push(S,p);      //�˽ڵ���ջ    ����Ӧ�� 1 ����
            printf(" %d   ",p);
            p = p->lchild;  //�������ʴ˽ڵ����ڵ�  ����Ӧ�� 2 ����
            printf(" aaa ");
        }    
        else   
        {//��ָ��Ϊ�գ���û������ �� 
             
            //printf("aaa\n");
            Pop(S,&p);    //ջ��Ԫ�� ��ջ ����ֵ������ָ�� ����Ӧ�� 3 ����
            printf("  weikong  ");
            printf("%c ",p->data);   //���ֵ 
            printf(" dizhi  %d ",p);
            
            
            p = p->rchild;             //���������ҽڵ�    ����Ӧ�� 4 ����
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

