#include <stdio.h>
#include <stdlib.h>
typedef struct node//�ļ������е�����Ϊ����������11.14��û�е����Զ�����nihao.exe
{
    /* data */
    char data;
    struct node *lchild,*rchild;
}Treenode,*Bitree;
Bitree CreateTree(){
    //vs�Դ�һ������cmd���նˣ�Ĭ�����Դ��ģ������Դ������벻��
    Bitree T;
    char ch;//������Ӧ����exe�ļ�������Ĳ��Գɶ������ˣ����Լ��±������롣
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
    Bitree T;
    T=CreateTree();
    printf("%c",T->data);
    return 0;
}

