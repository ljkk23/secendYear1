#include <stdio.h>
#include <stdlib.h>
typedef struct Lnode{
    int data;
    struct Lnode *Next;
}Lnode,*Linklist;
void Display(Lnode *p){
    while (p)
    {
        /* code */
        printf("%d->",p->data);
        p=p->Next;
    }
}
int main(){
    Lnode *p,*h,*q,*q_front,*q_back;//pΪ�����ɵĽ�㣬hΪͷ��㣬qΪ�ƶ��Ľ�㣬q_front��q_back�ֱ��ʾq��ǰ���ͺ��
    int x,y,z,m=0;//xΪ���ó�ʼ�ڵ�Ϊ1��yΪ�����������yͬѧ����߻����ұ�,zΪ�ж��������1����0,m�����������ж��ٸ��ڵ�
    int n=1,r=1;//��¼ͷ����Ƿ��ƶ��ļǺ�,��ʼͷ�ڵ�ֵΪ1,��¼β����Ƿ��ƶ��ļǺ�,��ʼͷ�ڵ�ֵΪ1
    scanf("%d",&x);
    h=(Lnode*)malloc(sizeof(Lnode));
    q_front=(Lnode*)malloc(sizeof(Lnode));
    q_back=(Lnode*)malloc(sizeof(Lnode));
    h->data=1;
    h->Next=NULL;
    q=h;
    q_front->Next=q;
    q_back=q->Next;
    m++;
    for (int i = 2; i < x+1; i++)
    {
        /* code */
        p=(Lnode*)malloc(sizeof(Lnode));
        p->data=i;
        p->Next=NULL;
        scanf("%d %d",&y,&z);
        for (int i = 0; i < m; i++)
        {
            /* code */
            if (q->data!=y)
            {
                /* code */
                q=q->Next;
                q_back->Next=q_back->Next;
                q_front->Next=q_front->Next;

            }
            if (q->data==y)
            {
                /* code */
                if (z==0)
                {
                    /* code */
                    
                    q_front->Next=p;
                    p->Next=q;
                    if (q->data==n)//�ж�ͷ����Ƿ��ƶ�
                    {
                        /* code */
                        h=q;
                        n=h->data;
                        
                    }
                    q_front=p;   
                }
                if (z==1)
                {
                    /* code */
                    q->Next=p;
                    p->Next=q_back;
                    if (q->data==r)//�ж��Ƿ���β���
                    {
                        /* code */
                        r=q->data;
                        p->Next=NULL;
                    }
                    q_back=p;
                }     
            }
            q=h;
            q_front->Next=q;
            q_back=q->Next;
            q_back=NULL;
        }
    }
    
    Display(h);
}