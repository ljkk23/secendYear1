DATAS SEGMENT
STRING1 DB 'PERSONA$'
DATAS ENDS
EXT SEGMENT
STRING2 DB 'PERSINB$'
EXT ENDS
CODES SEGMENT
   ASSUME CS:CODES,DS:DATAS,ES:EXT
START:
   MOV AX,DATAS
   MOV DS,AX
   MOV AX,EXT
   MOV ES,AX
   LEA DI,STRING1
   LEA SI,STRING2
   MOV CX,7
   CLD
LOP:
    ADD CX,0
    JZ  DOWN
    DEC CX 
    CMPSB
    JZ LOP 
    MOV DL,ES:[DI-01H]
    MOV AH,02H
    INT 21H
    MOV DL,0DH
    INT 21H
    MOV DL,0AH
     INT 21H;输出换行以及回车
     JMP LOP
 
DOWN:
     MOV DL,'D'
    INT 21H
     MOV DL,'O'
    INT 21H
    MOV DL,'N'
    INT 21H
    MOV DL,'E'
    INT 21H
   MOV AH,4CH
   INT 21H
CODES ENDS
   END START
