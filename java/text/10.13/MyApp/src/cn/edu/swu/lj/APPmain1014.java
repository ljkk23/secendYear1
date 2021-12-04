package cn.edu.swu.lj;

public class APPmain1014 {
    public static void main(String[] args) {
        System.out.println("nihao");

        English jack = new English("jack");
        English rose = new English("rose");
        Chinese cc = new Chinese("曹操");
        painter painter=new painter("刘剑");

        jack.greeting(rose);
        cc.greeting(rose);
        rose.greeting(cc);
        jacks lj= new jacks() {
            @Override
            public void fly() {
                System.out.println(" I can fly");
            }

            @Override
            public void draw() {
                System.out.println(" I can draw");

            }

            @Override
            public void swim() {
                System.out.println(" I can swim");

            }
        };
        lj.draw();
        lj.fly();
        lj.swim();
        painter.greeting(cc);
        painter.draw("apple");
    }
}
