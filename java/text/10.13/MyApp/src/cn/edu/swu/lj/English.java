package cn.edu.swu.lj;

public class English extends Human{

    public English(String name) {super(name);
    }

    @Override
    public void greeting(Human human) {
        System.out.println("hello !"+human.getName()+",I am "+this.getName());
    }
}
