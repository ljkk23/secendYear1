#include <stdio.h>
#include <stdlib.h>
typedef struct node
{
    /* data */
    char data;
    struct node *lchild,*rchild;
}Treenode,*Bitree;
Bitree CreateTree(){
    Bitree T;
    char ch;
    scanf("%c",&ch);
    if (ch==' ')
    {
        /* code */
        T=NULL;
        return T;
    }
    else{
        T=(Bitree)malloc(sizeof(Bitree));
        T->data=ch;
        printf("%c",T->data);
    }
    return T;
}
int main()
{
    Bitree T=(Bitree)malloc(sizeof(Bitree));
    T=CreateTree();
    
    printf("%cnihao",T->data);
    return 0;
}

