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
	int i, min;//min������ʱ�洢��Сֵ�ڵ���±�
 
	//��min����ֵ
	for (i = 1; i <= n; ++i)
	{
		if (HT[i].parent == 0)
		{
			min = i;
			break;
		}
	}
 
	//Ѱ�ҵ�һ����Сֵ���
	for (i = 1; i <= n; ++i)
	{
		if (HT[i].parent == 0)
			if (HT[i].weight < HT[min].weight)
				min = i;
	}
 
	*s1 = min;
 
	//��min����ֵ������s1��ͬ
	for (i = 1; i <= n; ++i)
	{
		if (HT[i].parent == 0 && i != *s1)
		{
			min = i;
			break;
		}
	}
 
	//Ѱ�ҵڶ�����Сֵ���
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
	int i, m = 2 * n - 1;//Ҷ�ӽ��Ϊn�Ĺ���������m�����
	HuffmanTree HT = (HTNode*)malloc((m + 1) * sizeof(HTNode));//0�ŵ�Ԫδ��
	//Ҷ�ӽ���ʼ��
	for (i = 1; i <= n; ++i, ++w)
	{
		HT[i].weight = *w;
		HT[i].lchild = 0;
		HT[i].rchild = 0;
		HT[i].parent = 0;
	}
 
	//��Ҷ�ӽ���ʼ��
	for (i = n + 1; i <= m; ++i)
	{
		HT[i].weight = 0;
		HT[i].lchild = 0;
		HT[i].rchild = 0;
		HT[i].parent = 0;
	}
 
	//����������
	for (i = n + 1; i <= m; ++i)
	{
		int s1, s2;
 
		//ѡ�����ø����Ȩֵ��С������Ϊ�½�����������
		Select(HT, i - 1, &s1, &s2);
 
		//���½ڵ���и�ֵ
		HT[i].lchild = s1;
		HT[i].rchild = s2;
		HT[i].weight = HT[s1].weight + HT[s2].weight;
 
 
		//ɾ���ղ�ѡ���������ڵ�
		HT[s1].parent = i;
		HT[s2].parent = i;
	}
	return HT;
}
 
//���������벢����wpl
HuffmanCode HuffmanCoding(HTNode HT[], int n, int* wpl)
{
	HuffmanCode HC = (char**)malloc((n + 1) * sizeof(char*));//����n��ָ����������봮��ָ�룬0�ŵ�Ԫδ��
	char* cd = (char*)malloc(n * sizeof(char));//����һ����ʱ�ַ������飬�洢����Ҷ���Ĺ��������봮����������������߶���n
	cd[n - 1] = '\0';//�ַ��������һ��λ�����ý�����
	*wpl = 0;//����ֵ
 
	int i, start;
	int current;//��ǵ�ǰ���
	int father;//��ǵ�ǰ���ĸ����
	int level;//�����洢·������
 
	//���ַ������������
	for (i = 1; i <= n; i++)
	{
		start = n - 1;//���������λ�ã�start������ѭ����
		current = i;
		father = HT[current].parent;
		level = 0;
 
		//��Ҷ�ӽڵ㵽�����������
		while (father != 0)
		{
			if (HT[father].lchild == current)//ע������д�����д����i
				cd[--start] = '0';
			else
				cd[--start] = '1';
			current = father;
			father = HT[current].parent;
			++level;
		}
 
		HC[i] = (char*)malloc((n - start) * sizeof(char));/*��ǣ����������±�Ϊn-1���ӽ��������±�Ϊstart���ַ�����Ϊn-1 - start + 1����n-start*/
		strcpy(HC[i], &cd[start]);
		*wpl += level * HT[i].weight;
	}
 
	free(cd);//�����Ժ�Ҫ�����ͷŹ����ռ�
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
 
	//������Ĵ�Ȩ·������
	printf("WPL=%d\n", wpl);
 
	//�������
	for (i = 1; i <= n; ++i)
	{
		printf("%dth:%s\n", i, HC[i]);
	}
	system("pause");
}