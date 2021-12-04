#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct 
{
    /* data */
    int parent;
    int lchild;
    int rchild;
    int weight;
}HTNODE,*HuffmanTree;
typedef char** HuffmanCode;
int Select(HuffmanTree HT,int n,int* s1,int* s2){
    int min;//存储当前最小权值的结点的下标
     
    //给min赋初值
	for (int i = 1; i <= n; ++i)
	{
		if (HT[i].parent == 0)
		{
			min = i;
			break;
		}
	}


    //寻找最小的权值结点
    for (int i = 1; i <=n; i++)
    {
        /* code */
        if (HT[i].parent==0&&HT[i].weight<HT[min].weight)
        {
            /* code */
            min=i;
        }
    }
    *s1=min;

    //寻找次小的权值结点,赋初值
     for (int i = 1; i <= n; ++i)
	{
		if (HT[i].parent == 0 && i != *s1)
		{
			min = i;
			break;
		}
	}
    
    for (int i = 1; i <=n; i++)
    {
        /* code */
        if (HT[i].parent==0 && i!=*s1)
        {
            /* code */
            if (HT[i].weight<HT[min].weight)
            {
                /* code */
                min=i;
            }
        }
        
    }

    *s2=min;
    return 0;
}
HuffmanTree CreateHuff(int n,int* w){
    int i,m=2*n-1;//m表示结点数
    HuffmanTree HT=(HTNODE*)malloc((m+1)*sizeof(HTNODE));//??
    //叶子结点初始化
    for ( i = 1; i <= n; i++)
    {
        /* code */
        HT[i].weight=*w;
        HT[i].lchild=0;
        HT[i].rchild=0;
        HT[i].parent=0;
        w++;
    }
    //非叶子结点的初始化
    for ( i = n+1; i <=m; i++)
    {
        /* code */
        HT[i].weight=0;
        HT[i].lchild=0;
        HT[i].rchild=0;
        HT[i].parent=0;
    }

    //建立哈夫曼树
    for ( i = n+1; i <=m; i++)
    {
        /* code */
        int s1,s2;

        //选择两个权值最小的树作为左右结点
        Select(HT,i-1,&s1,&s2);
        //printf("s1=%d s2=%d\n",s1,s2);

        //对新结点赋值
        HT[i].lchild=s1;
        HT[i].rchild=s2;
        HT[i].weight=HT[s1].weight+HT[s2].weight;

        //删除选出的结点
        HT[s1].parent=i;
        HT[s2].parent=i;
    }
    return HT;
}

HuffmanCode HuffmanCoding(HTNODE HT[],int n,int* wpl){
    
    HuffmanCode HC=(char**)malloc((n+1)*sizeof(char*));
    char* cd=(char*)malloc(n*sizeof(char));
    cd[n-1]='\0';
    *wpl=0;
    int i, start;
	int current;//标记当前结点
	int father;//标记当前结点的父结点
	int level;//用来存储路径长度
     
     //逐一字符求哈夫曼编码
    for (int i = 1; i <=n; i++)
    {
        /* code */
        start=n-1;
        current=i;
        father=HT[current].parent;
        
        level=0;

        //从叶子结点到根求编码

        while (father!=0)
        {
            /* code */
            if (HT[father].lchild==current)
            {
                /* code */
                cd[--start]='0';
            }
            else{
                cd[--start]='1';
            }
            current=father;
            father=HT[current].parent;
            level++;
        }

        HC[i]=(char*)malloc((n-start)*sizeof(char));
        strcpy(HC[i],&cd[start]);
        *wpl+=level*HT[i].weight;
        
    }
    free(cd);//释放空间
    return HC;
    

}
int main(){
    int i,n,wpl;
    printf("请输入结点数：");
    scanf("%d",&n);
    int* w=(int*)malloc(n*sizeof(int));
    for (int i = 0; i < n; i++)
    {
        /* code */
        printf("输入第%d个结点的权值：",i+1);
        scanf("%d",&w[i]);
    }

    HuffmanTree HT=CreateHuff(n,w);

    HuffmanCode HC = HuffmanCoding(HT, n, &wpl);

    printf("wpl=%d\n",wpl);

    for (int i = 1; i <=n; i++)
    {
        /* code */
        printf("%dth:%s\n",i,HC[i]);
    }
    
    return 0;
}
