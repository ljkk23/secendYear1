#include <stdio.h>
#include <string.h>
#define MAX_SIZE 20
typedef struct 
{
    /* data */
    char str[MAX_SIZE];
    int lenth;
}String;
int Substring(String &sub,String S,int loc,int len){
    for (int i = loc; i < (loc+len); i++)
    {
        /* code */
        sub.str[i-loc]=S.str[i];
        printf("%c",sub.str[i-loc]);
    }
    return 0;
    

}
int Getlenth(String S){
    int i=0;
    while (S.str[i]!='\0')
    {
        /* code */
        i++;
    }
    return i;
    
}
int mate(char *B,char *A){
    int i=0,j=0;
    while (i<strlen(B) && j<strlen(A))
    {
        if (B[i]==A[j])
        {
            i++;
            j++;
            
        }else{
    
            i=i-j+1;
            j=0;
           
        }
        
    }
    if (j==strlen(A))
    {
        /* code */
        printf("\n匹配成功！在第%d个位置",i-j+1);
        return 0;
    }else{
    printf("\n匹配不成功！%d",j);
    return 0;
    }
    
    

}
int main(int argc, char const *argv[])
{
    /* code */
    String S;
    String SubS;
    char *A="cbd";
    char *B="abccbdhsj";
    char str[MAX_SIZE];
    printf("输入主串");
    gets(S.str);
    printf("3-7的子串为");
    Substring(SubS,S,3,7);
    printf("\n主串的长度为%d",Getlenth(S));
    mate(B,A);


}
