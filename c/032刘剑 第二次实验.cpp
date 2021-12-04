#include <stdio.h>
#include <stdlib.h>
typedef struct Lnode{
    int data;
    struct Lnode *Next;
}Lnode,*Linklist;
Lnode *create()
{
    int x;
    Lnode *p,*h;
    h=0;
    printf("input -1 to end");
    scanf("%d",&x);
    while (x!=-1)
    {
        p=(Lnode *)malloc(sizeof(Lnode));
        p->data=x;
        p->Next=h;
        h=p;
        scanf("%d",&x);
    }
    return h;
    
}
int show(Lnode *h)
{
    Lnode *p=h;
    while(p)
    {
        printf("%d->",p->data);
        p=p->Next;
    }
    printf("\n");
    return 0;
}
int search(Lnode *h,int x)
{
    Lnode *p=h;
    
    int i=0;
    while (p)
    {
        if (p->data!=x)
        {
            p=p->Next;
            i++;
        }else if (p->data==x)
        {
            printf("find! the %d position\n",i+1);
            return 0;
        }   
    }
    if (!p)
    {
        printf("no such element\n");
    }
}
int Insert(Lnode *h,int x,int y)
{
    Lnode *p=h,*q;
    q=0;
    q=(Lnode *)malloc(sizeof(Lnode));
    while (p)
    {
        //printf("ddd  ");
        if (p->data==x)
        {
            break;
        }else 
        p=p->Next;
        
    }//鎵惧埌闇�瑕佹彃鍏ョ殑鍓嶇户鑺傜偣
    q->data=y;
    q->Next=p->Next;
    p->Next=q;
    return 0;
}
int Delet(Lnode *h,int x)
{
    Lnode *p=h,*q;
    q=h->Next;
    //q=(Lnode *)malloc(sizeof(Lnode));
    while (p)
    {
        
        if (q->data==x)
        {
            
            p->Next=q->Next;
            free(q);
            return 0;

        }else{
            
            p=q;
            q=q->Next;
        }
        //printf("dd  %d",q->data);
        
    }
    
}
int Merger(Lnode *m,Lnode *n,Lnode *k)
{
    Lnode *p,*h;
    
    h=k;
    while (m && n)
    {
        //printf("m=%d  ",m->data);
        //printf("n=%d  ",n->data);
        if (m->data>n->data)
        {
            //printf("dd %d",k->data);
            p=(Lnode *)malloc(sizeof(Lnode));
            p->data=m->data;
            //printf("  %d  ",p->Next);
            p->Next=0;
            m=m->Next;
            k->Next=p;
            k=p;
        }else if (m->data<n->data)
        {
            p=(Lnode *)malloc(sizeof(Lnode));
            p->data=n->data;
            p->Next=0;
            n=n->Next;
            k->Next=p;
            k=p;
        }else if (m->data==n->data)
        {
            p=(Lnode *)malloc(sizeof(Lnode));
            p->data=n->data;
            p->Next=0;
            n=n->Next;
            m=m->Next;
            k->Next=p;
            k=p;
        }  
    }
    while (m)
    {
        p=(Lnode *)malloc(sizeof(Lnode));
        p->data=m->data;
        p->Next=0;
            m=m->Next;
            k->Next=p;
            k=p;
    }
    while (n)
    {
        p=(Lnode *)malloc(sizeof(Lnode));
        p->data=n->data;
        p->Next=0;
            n=n->Next;
            k->Next=p;
            k=p;
    }
    k=h;
    return 0;
    
    
}
int bin(Lnode *m,Lnode *n,Lnode *r)
{
    Lnode *h,*hn;
    h=r;
    hn=n;
    int same=0;
    while (m)
    {
        while(n)
        {
            //printf("m=%d  ",m->data);
            //printf("n=%d  ",n->data);
            same=0;
            if (m->data==n->data)
            {
                same=1;
                break;
            }else
            {
                n=n->Next;
            }
        }
        n=hn;
        //printf("same=%d ",same);
        if (same==1)
        {
            m=m->Next;
        }else
        {
            r->Next=m;
            r=m;
            m=m->Next;
            //printf("r->  %d  ",r->data);
        }
        //printf("  %d  ",m->Next);

    }
    n=hn;
    while (n)
    {
        //printf("  ddd ");
        r->Next=n;
        r=n;
        n=n->Next;
    }
    r->Next=0;
    r=h->Next;
    //printf("  ddd %d",r->data);
    return 0;
}
int jiao(Lnode *m,Lnode *n,Lnode *r)
{
    Lnode *h,*hn;
    h=r;
    hn=n;
    int same=0;
    while (m)
    {
        while(n)
        {
            //printf("m=%d  ",m->data);
            //printf("n=%d  ",n->data);
            same=0;
            if (m->data==n->data)
            {
                same=1;
                break;
            }else
            {
                n=n->Next;
            }
        }
        n=hn;
        //printf("same=%d ",same);
        if (same==1)
        {
            
            r->Next=m;
            r=m;
            m=m->Next;
        }else
        {
            
            m=m->Next;
            //printf("r->  %d  ",r->data);
        }
        //printf("  %d  ",m->Next);

    }
    r=h->Next;
    return 0;
}
int main()
{
   Lnode *h,*m,*n,*k,*r,*b,*z,*x;
   k=(Lnode *)malloc(sizeof(Lnode));
   r=(Lnode *)malloc(sizeof(Lnode));
   b=(Lnode *)malloc(sizeof(Lnode));
   h=create();
   show(h);
   search(h,5);
   Insert(h,3,5);
   show(h);
   Delet(h,5);
   show(h);
   /*m=create();
   show(m);
   n=create();
   show(n);
   printf("\n有序表归并后的链表：\n");
   Merger(m,n,k);
   show(k);
   printf("\集合的归并后的链表：");
   bin(m,n,r);
   show(r);
   z=create();
   show(z);
   x=create();
   show(x);
   printf("\n集合的交集：\n");
   jiao(z,x,b);
   show(b);*/


   
}
