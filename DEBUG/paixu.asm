data segment 
       arr  db  'aa',45h,'bb',34h,'cc',56h,'dd',67h,'ee',05h
       num db $-arr
       num2 db $-arr
       innernum db $-arr
       done  db 'done:$'
       out  db 'out:$'
data ends
stack segment stack
     db 100 dup(?)
stack ends
code segment
     assume cs:code,ds:data
start:
     mov ax,data
     mov ds,ax

     mov cx,4;内循环次数
     lea bx,arr;置偏移量
     mov si,5；置外循环次数
     mov di,0
outer:
     mov cx,4;重置循环次数
      mov di,0;重置di值
inner:
     mov dl,35h
     mov ah,02h
     int 21h
     dec cx
     mov al,[bx+di+2]
     mov ah,[bx+di+5]
     cmp al,ah
     ja change
exit:
     inc di
     inc di
     inc di
     sub cx,0
     jnz inner
     dec si;
     sub si,0;标识位
     jnz outer

     mov ah,4ch
     int 21h

change:
     xchg al,[bx+di+5]
     mov [bx+di+2],al;交换成绩

     mov al,[bx+di]
     mov ah,[bx+di+3]
     mov [bx+di],ah
     mov [bx+di+3],al;交换名字的第一个字符

     mov al,[bx+di+1]
     mov ah,[bx+di+4]
     mov [bx+di],ah
     mov [bx+di+3],al;交换名字的第二个字符
      
     mov dl,38h
     mov ah,02h
     int 21h     

      jmp exit   
code ends
end start

     
