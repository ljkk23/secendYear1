#define LIST_INIT_SIZE 100
#define LISTCREAMENT 10
#include "stdio.h"
#include "stdlib.h"
#include "time.h"
typedef struct {
	int *elem;
	int length;
	int listsize;

}Slist;//定义顺序
Initlist_Sq(Slist &L)
	{
		L.elem=(int *)malloc(LIST_INIT_SIZE*sizeof(int));
		if(!(L.elem))
			exit(0);
		L.length=0;
		L.listsize=LIST_INIT_SIZE;
		printf("成功分配。\n");
		return 0;
	}
fuzhilist_Sq(Slist &L)
{
	int i;
	for(i=0;i<7;i++)
	{	
		
		L.elem[i]=(rand()%50);
		L.length++;
	}

}
display(Slist &L)
{
	for(int i=0;i<L.length;i++)
	{
		printf("%d  ",L.elem[i]);//*l.elem
	}
	printf("\n");
	//printf("%d",L.length);
}
Insertlist_Sq(Slist &L,int pos,int elem)
{
	if(L.length==L.listsize)
		L.elem=(int *)realloc(L.elem,(L.length+LISTCREAMENT)*sizeof(int));//重新分配空间
	if(!(L.elem))
		exit(0);
	L.listsize+=LISTCREAMENT;
	L.length++;
	int *q,*p;
	q=&(L.elem[pos-1]);
	p=&(L.elem[L.length-1]);
	for(p=&(L.elem[L.length-1]);p>=q;--p)
		*(p+1)=*p;
	L.elem[pos-1]=elem;
}
Dellist_Sq(Slist &L,int pos)
{
	if(pos<0 || pos>L.length)
		printf("wrong position!");
	int *q,*p;
	q=&(L.elem[pos-1]);
	p=&(L.elem[L.length-1]);
	//printf("%d   %d",*p,*q);
	for(q=&(L.elem[pos-1]);q<=p;q++)
	  *q=*(q+1);
	L.length--;
	
}
Select(Slist &L,int elem)
{
	int i=0;
	int j=0;
	while(i<L.length)
	{
		if(elem==L.elem[i])
		{
			printf("在%d个位置\n",i+1);
			j=1;
		    break;
		}else
		i++;
	}
	if (j==0)
	{
		printf("no such element");
	}
	

}
int MergrList(Slist La,Slist Lb,Slist &Lc)

{
	Lc.listsize=La.length+Lb.length;
	Lc.elem=(int *)malloc(Lc.listsize*sizeof(int));
	
	if(!(Lc.elem))
			exit(0);
	int m=0,n=0,k=0;		
	while (Lc.length!=Lc.listsize)
	{
		if (La.elem[m]>Lb.elem[n])
		{
		    Lc.elem[k]=Lb.elem[n];
			k++;
			n++;
			Lb.length--;
		}
		else
		{
			Lc.elem[k]=La.elem[m];
			k++;
			m++;
			La.length--;
		}
		Lc.length++;
		//printf("merger%d",Lc.length);
		

	}
	while (La.length==0)
		{
			if (Lb.length!=0)
			{
				Lc.elem[k]=Lb.elem[n];
			    Lc.length++;
			}
			//printf("merger%d",Lc.length);
			return 0;
		}
	while (Lb.length==0)
		{
			if (La.length!=0)
			{
				Lc.elem[k]=La.elem[m];
			    Lc.length++;
			}
			//printf("merger%d",Lc.length);
			return 0;
		}
		
	
}
int MergrList2(Slist Le,Slist Ld,Slist &Lf)
{
	int k=0,f=0,same=0,s_elem=0;
	
		for (int i = 0; i < Le.length; i++)
		{
			for (int j = 0; j < Ld.length; j++)
			{
				if (Le.elem[i]==Ld.elem[j])
				{
					s_elem++;
				}
				
			}
			
		}
		Lf.length=Le.length+Ld.length-s_elem;
		Lf.elem=(int *)malloc((Lf.length)*sizeof(int));
		//printf("\n lelenth :%d",Le.length);
		for (int i = 0; i < Le.length; i++)
		{
			for (int j = 0; j < Ld.length; j++)
			{
				if (Le.elem[i]==Ld.elem[j])
				{
					same=0;
					break;
				}
				else
				{same=1;}
				
			}
			//printf("\ni=%d same=%d  ",i,same);
			if (same==1)
			{
				Lf.elem[f]=Le.elem[i];
				f++;
			}
			
		}
		
		
		for (int i = 0; i < Ld.length; i++)
		{
			Lf.elem[f]=Ld.elem[i];
			f++;
		}
		//printf("\n lflenth :%d",Lf.length);
		

}
int jiao(Slist Le,Slist Ld,Slist &Lg)
{
	int g=0;
	
		for (int i = 0; i < Le.length; i++)
		{
			for (int j = 0; j < Ld.length; j++)
			{
				if (Le.elem[i]==Ld.elem[j])
				{
					Lg.length++;
				}
				
			}
			
		}
		Lg.elem=(int *)malloc((Lg.length)*sizeof(int));
		for (int i = 0; i < Le.length; i++)
		{
			for (int j = 0; j < Ld.length; j++)
			{
				if (Le.elem[i]==Ld.elem[j])
				{
					Lg.elem[g]=Le.elem[i];
					g++;
				}
				
			}
			
		}

}
int main(){
	Slist LT,La,Lb,Lc,Ld,Le,Lf,Lg;
	int j=4;
	Initlist_Sq(LT);
	fuzhilist_Sq(LT);
	display(LT);
	Insertlist_Sq(LT,4,50);
	display(LT);
	Dellist_Sq(LT,3);
	display(LT);
	Select(LT,17);
	Initlist_Sq(La);
	Initlist_Sq(Lb);
	Initlist_Sq(Lc);
	for (int i = 0; i < 5; i++)
	{
		
		La.elem[i]=j+2;
		j+=2;
		La.length++;
	}
	j=4;
	for (int i = 0; i < 6; i++)
	{
		
		Lb.elem[i]=j+1;
		j+=2;
		Lb.length++;
	}//给La,Lb赋值
	display(La);
	display(Lb);
	MergrList(La,Lb,Lc);
	display(Lc);
	Initlist_Sq(Ld);
	Initlist_Sq(Le);
	Initlist_Sq(Lf);
	j=1;
	for (int i = 0; i < 5; i++)
	{
		
		Ld.elem[i]=j+3;
		j+=2;
		Ld.length++;
	}
	j=4;
	for (int i = 0; i < 6; i++)
	{
		
		Le.elem[i]=j+1;
		j++;
		Le.length++;
	}//给Le,Ld赋值
	display(Le);
	display(Ld);
    MergrList2(Le,Ld,Lf);//并集
	display(Lf);
	Initlist_Sq(Lg);
	jiao(Le,Ld,Lg);//交集
	display(Lg);



	return 0;
}	

