

DATA  SEGMENT               ;DATA段定义开始
             BUF1 DB 34H 
             BUF2 DB 27H
             SUM  DB ?
DATA  ENDS                         ;DATA段定义结束
CODE  SEGMENT                ;CODE段定义开始
            ASSUME CS:CODE
            ASSUME DS:DATA ;段性质规定
START: MOV AX,DATA              
               MOV DS,AX          ;给DS赋值
               MOV AL, BUF1     ;取第一个加数
              ADD AL, BUF2       ;两数加
              MOV SUM, AL       ;和放入SUM单元
              MOV AH,4CH                  
              INT 21H                    ;返回DOS
CODE  ENDS                         ;CODE段定义结束
             END START              ;源程序结束