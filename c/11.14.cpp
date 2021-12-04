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
    scanf("&c",&ch);
    if (ch==' ')
    {
        /* code */
        T=NULL;
        return T;
    }
    else{
        T=(Bitree)malloc(sizeof(Bitree));
        T->data=ch;
    }
    return T;
}
int main()
{
    Bitree T;//Ó¦¸ÃÊÇ11.14.exe
    T=CreateTree();
    printf("%c",T->data);
    return 0;
}

