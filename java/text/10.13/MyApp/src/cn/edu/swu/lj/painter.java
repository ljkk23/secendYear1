package cn.edu.swu.lj;

public class painter extends Chinese implements Draw{
    public painter(String name) {
        super(name);
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
