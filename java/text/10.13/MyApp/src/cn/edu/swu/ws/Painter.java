package cn.edu.swu.ws;

public class Painter extends Human implements DrawPicture {

    public Painter(String name) {
        this.setName(name);
    }

    @Override
    public void greeting(Human human) {
        System.out.println(
            "你好" + human.getName() + ". 我是画家" + this.getName());
    }

    @Override
    public void draw(String theme) {
        System.out.println(".................");
        System.out.println(".................");
        System.out.println("...." + theme + "....");
        System.out.println(".................");
        System.out.println(".................");
        System.out.println(".................");
    }
}
