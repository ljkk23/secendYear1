#include <stdio.h>
#include <stdlib.h>
typedef struct node//文件名中有点则认为是完整名字11.14，没有点则自动加上nihao.exe
{
    /* data */
    char data;
    struct node *lchild,*rchild;
}Treenode,*Bitree;
Bitree CreateTree(){
    //vs自带一个类似cmd的终端，默认是自带的，但是自带的输入不好
    Bitree T;
    char ch;//编译玩应该是exe文件，编译的不对成二进制了，所以记事本打开乱码。
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

