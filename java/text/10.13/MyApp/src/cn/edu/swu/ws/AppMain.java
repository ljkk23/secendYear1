package cn.edu.swu.ws;

public class AppMain {

    public static void main(String[] args) {
        English jack = new English("Jack");
        English rose = new English("Rose");
        Chinese cc = new Chinese("曹操");
        ChongQingRen ws = new ChongQingRen("伍胜");
        Painter painter = new Painter("毕加索");

        jack.greeting(rose);
        jack.greeting(cc);
        cc.greeting(jack);
        ws.greeting(cc);
        painter.greeting(ws);

        painter.draw("tree");

        // 匿名类
        Jack actor = new Jack(){
            @Override
            public void draw() {
                System.out.println("I can draw");
            }

            @Override
            public void fly() {
                System.out.println("I can fly");
            }

            @Override
            public void swim() {
                System.out.println("I can swim");
            }
        };//匿名类，类只使用一次时

        actor.fly();
        actor.swim();
        actor.draw();

        Human french = new Human() {
            @Override
            public void greeting(Human human) {
                System.out.println("Bon jou");
            }
        };
        french.greeting(jack);

    }

}
