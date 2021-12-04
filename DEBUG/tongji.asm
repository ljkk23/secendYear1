DATAS SEGMENT
STRING1 DB 'As39b8*#1fh!HbQ$'
CAPITAL DB  0
LOWER   DB  0
NUMBER DB 0
OTHER DB 0;各种字符变量计数清零
NUM DB 'NUMBER:$'
LO DB 'LOWER:$'
CAP DB 'CAPITAL:$'
OT DB 'OTHER:$';提示语句
DATAS ENDS
CODES SEGMENT
   ASSUME CS:CODES,DS:DATAS
START:
   MOV AX,DATAS
   MOV DS,AX
   LEA BX,STRING1
LP:
   MOV AL,[BX];取一个字符
    CMP AL,'$'
    JZ  DOWN;判断是不是终止符
    CMP AL,'0'
    JB NOTNUM;不是数字，跳转到非数字
    CMP AL,'9'
    JA NOTNUM;不是数字，跳转到非数字
    INC NUMBER
    INC BX;bx后移
    JMP LP
NOTNUM:
    CMP AL,'a'
    JB NOTLOW;不是小写字母，跳转到非小写字母
    CMP AL,'z'
    JA NOTLOW;不是小写字母，跳转到非小写字母
    INC LOWER
    INC BX;bx后移
    JMP LP
NOTLOW:
    CMP AL,'A'
    JB   OTH;不是大写字母，跳转到其他字符
    CMP AL,'Z'
    JA   OTH;不是大写字母，跳转到其他字符
    INC CAPITAL 
    INC BX  
    JMP LP 
OTH:
    INC OTHER
    INC BX
    JMP LP
DOWN:
    MOV DX,OFFSET NUM
    MOV AH,09H
    INT 21H;输出提示语句
    MOV DL,NUMBER
    ADD DL,30H
    MOV AH,02H
    INT 21H;输出统计的数量
    MOV DL,0DH
    INT 21H
    MOV DL,0AH
     INT 21H;输出换行以及回车
    
    MOV DX,OFFSET LO
    MOV AH,09H
    INT 21H;输出提示语句
    MOV DL, LOWER
    ADD DL,30H
    MOV AH,02H;输出统计的数量
    INT 21H
    MOV DL,0DH
    INT 21H
    MOV DL,0AH
    INT 21H;输出换行以及回车
    
    MOV DX,OFFSET CAP
    MOV AH,09H
    INT 21H;输出提示语句
    MOV DL, CAPITAL
    ADD DL,30H
    MOV AH,02H;输出统计的数量
    INT 21H
    MOV DL,0DH
    INT 21H
    MOV DL,0AH
    INT 21H;输出换行以及回车
    
    MOV DX,OFFSET OT
    MOV AH,09H
    INT 21H;输出提示语句
    MOV DL, OTHER
    ADD DL,30H
    MOV AH,02H;输出统计的数量
    INT 21H
    MOV DL,0DH
    INT 21H
    MOV DL,0AH
    INT 21H;输出换行以及回车

    MOV AH,4CH
    INT 21H
CODES ENDS
   END START