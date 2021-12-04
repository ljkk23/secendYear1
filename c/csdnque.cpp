#include <stdio.h>
#include <stdlib.h>
//�����еĽڵ�ṹ
typedef struct QNode{
    int data;
    struct QNode * next;
}QNode;
//������ʽ���еĺ���
QNode * initQueue(){
    //����һ��ͷ�ڵ�
    QNode * queue=(QNode*)malloc(sizeof(QNode));
    //��ͷ�ڵ���г�ʼ��
    queue->next=NULL;
    return queue;
}
QNode* enQueue(QNode * rear,int data){
    QNode * enElem=(QNode*)malloc(sizeof(QNode));
    enElem->data=data;
    enElem->next=NULL;
    //ʹ��β�巨�����������������Ԫ��
    rear->next=enElem;
    rear=enElem;
    return rear;
}
QNode* DeQueue(QNode * top,QNode * rear){
    if (top->next==NULL) {
        printf("\n����Ϊ��");
        return rear;
    }
    QNode * p=top->next;
    printf("���ӵ�Ԫ���ǣ�%d \n",p->data);
    top->next=p->next;
    if (rear==p) {
        rear=top;
    }
    free(p);
    return rear;
}
//���еĳ���
int QueueLength(QNode * top)
{
    int length=0;
    QNode * pMove = top;
    if(pMove->next==NULL){//ͷָ��ָ��գ�����Ϊ0
        return length;
    }
    while (pMove->next !=NULL) {//ͷָ�벻Ϊ�գ��ƶ�ָ����㳤��
        pMove = pMove->next;
        length++;
    }
    return length;
}
void printQueue(QNode * top)
{
    QNode * pMove = top->next;
    if(pMove->next==NULL){
        printf("�ö���Ϊ�գ�\n");
    }
    while (pMove!=NULL) {
        printf("%d ",pMove->data);
        pMove = pMove->next;
    }
    printf("\n");
}
int main() {
    QNode * queue,*top,*rear;
    queue=top=rear=initQueue();//����ͷ���
    //������������ӽ�㣬ʹ��β�巨��ӵ�ͬʱ����βָ����Ҫָ����������һ��Ԫ��
    for(int i=0;i<10;i++)
    {
        
        rear = enQueue(rear, i+1);
    }
    printQueue(top);
    printf("���еĳ���Ϊ��%d\n",QueueLength(top));
    //�����ɣ���������Ԫ�ؿ�ʼ������
    rear=DeQueue(top, rear);
    rear=DeQueue(top, rear);
    return 0;
}