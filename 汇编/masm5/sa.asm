

DATA  SEGMENT               ;DATA�ζ��忪ʼ
             BUF1 DB 34H 
             BUF2 DB 27H
             SUM  DB ?
DATA  ENDS                         ;DATA�ζ������
CODE  SEGMENT                ;CODE�ζ��忪ʼ
            ASSUME CS:CODE
            ASSUME DS:DATA ;�����ʹ涨
START: MOV AX,DATA              
               MOV DS,AX          ;��DS��ֵ
               MOV AL, BUF1     ;ȡ��һ������
              ADD AL, BUF2       ;������
              MOV SUM, AL       ;�ͷ���SUM��Ԫ
              MOV AH,4CH                  
              INT 21H                    ;����DOS
CODE  ENDS                         ;CODE�ζ������
             END START              ;Դ�������