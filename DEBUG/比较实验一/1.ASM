;PROGRAM TITLE GOES HERE--Compare string
;*******************************
datarea segment                ;define data segment
   string1        db         'Move the  cursor backward.'
   string2        db         'Move the  cursor backward.'
;
  mess1           db         'Match.',13,10,'$'
  mess2           db         'No Match!',13,10,'$'
datarea ends
;**********************************
prognam  segment        ;
;--------------------
main   proc   far
           assume cs:prognam,ds:datarea,es:datarea
start:
;set up  stack for return
             push        ds        ;
             sub       ax,ax       ;
             push       ax        ;
;set DS register to current  data segment
               mov     ax,datarea   ;
               mov    ds,ax           ;
               mov     es,ax          ;
;MAIN   PART OF PROGRAM GOES HERE
               lea    si,string1
               lea    di,string2
               cld
               mov   cx,25
               repz   cmpsb
               jz       match
               lea     dx,mess2
               jmp    short disp
match:
                lea   dx,mess1
disp:
                mov    ah,09
                int       21h
                 ret                ;
main    endp                   ;
;-------------------
prognam ends        ;
;*********************************
                    end          start            ;
