#include <stdlib.h>
#include <stdio.h>
#include <string.h>
 
typedef struct
{
	int parent;
	int lchild;
	int rchild;
	int weight;
}HTNode, *HuffmanTree;
typedef char** HuffmanCode;
 
 
void Select(HuffmanTree HT, int n, int* s1, int* s2)
{
	int i, min;//min用来临时存储最小值节点的下标
 
	//给min赋初值
	for (i = 1; i <= n; ++i)
	{
		if (HT[i].parent == 0)
		{
			min = i;
			break;
		}
	}
 
	//寻找第一个最小值结点
	for (i = 1; i <= n; ++i)
	{
		if (HT[i].parent == 0)
			if (HT[i].weight < HT[min].weight)
				min = i;
	}
 
	*s1 = min;
 
	//给min赋初值，且与s1不同
	for (i = 1; i <= n; ++i)
	{
		if (HT[i].parent == 0 && i != *s1)
		{
			min = i;
			break;
		}
	}
 
	//寻找第二个最小值结点
	for (i = 1; i <= n; ++i)
	{
		if (HT[i].parent == 0 && i != *s1)
			if (HT[i].weight < HT[min].weight)
				min = i;
	}
	*s2 = min;
 
}
 
HuffmanTree CreateHuff(int n, int* w)
{
	int i, m = 2 * n - 1;//叶子结点为n的哈夫曼树有m个结点
	HuffmanTree HT = (HTNode*)malloc((m + 1) * sizeof(HTNode));//0号单元未用
	//叶子结点初始化
	for (i = 1; i <= n; ++i, ++w)
	{
		HT[i].weight = *w;
		HT[i].lchild = 0;
		HT[i].rchild = 0;
		HT[i].parent = 0;
	}
 
	//非叶子结点初始化
	for (i = n + 1; i <= m; ++i)
	{
		HT[i].weight = 0;
		HT[i].lchild = 0;
		HT[i].rchild = 0;
		HT[i].parent = 0;
	}
 
	//建哈夫曼树
	for (i = n + 1; i <= m; ++i)
	{
		int s1, s2;
 
		//选择两棵根结点权值最小的树作为新结点的左右子树
		Select(HT, i - 1, &s1, &s2);
 
		//对新节点进行赋值
		HT[i].lchild = s1;
		HT[i].rchild = s2;
		HT[i].weight = HT[s1].weight + HT[s2].weight;
 
 
		//删除刚才选出的两个节点
		HT[s1].parent = i;
		HT[s2].parent = i;
	}
	return HT;
}
 
//哈夫曼编码并计算wpl
HuffmanCode HuffmanCoding(HTNode HT[], int n, int* wpl)
{
	HuffmanCode HC = (char**)malloc((n + 1) * sizeof(char*));//分配n个指向哈夫曼编码串的指针，0号单元未用
	char* cd = (char*)malloc(n * sizeof(char));//创建一个临时字符串数组，存储单个叶结点的哈夫曼编码串，正则二叉树的最大高度是n
	cd[n - 1] = '\0';//字符数组最后一个位置设置结束符
	*wpl = 0;//赋初值
 
	int i, start;
	int current;//标记当前结点
	int father;//标记当前结点的父结点
	int level;//用来存储路径长度
 
	//逐字符求哈夫曼编码
	for (i = 1; i <= n; i++)
	{
		start = n - 1;//编码结束符位置，start必须在循环内
		current = i;
		father = HT[current].parent;
		level = 0;
 
		//从叶子节点到根逆向求编码
		while (father != 0)
		{
			if (HT[father].lchild == current)//注意这里写错过，写成了i
				cd[--start] = '0';
			else
				cd[--start] = '1';
			current = father;
			father = HT[current].parent;
			++level;
		}
 
		HC[i] = (char*)malloc((n - start) * sizeof(char));/*简记：结束符的下标为n-1，从结束符到下标为start的字符个数为n-1 - start + 1，即n-start*/
		strcpy(HC[i], &cd[start]);
		*wpl += level * HT[i].weight;
	}
 
	free(cd);//用完以后不要忘记释放工作空间
	return HC;
}
 
int main()
{
	int i, n, wpl;
	printf("Please input n:");
	scanf("%d", &n);
	int* w = (int*)malloc(n * sizeof(int));
	for (i = 0; i < n; i++)
	{
		printf("Please input %dth weight:", i+1);
		scanf("%d", &w[i]);
	}
	HuffmanTree HT = CreateHuff(n, w);
 
	HuffmanCode HC = HuffmanCoding(HT, n, &wpl);
 
	//输出树的带权路径长度
	printf("WPL=%d\n", wpl);
 
	//输出编码
	for (i = 1; i <= n; ++i)
	{
		printf("%dth:%s\n", i, HC[i]);
	}
	system("pause");
}