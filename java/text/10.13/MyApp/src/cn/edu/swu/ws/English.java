package cn.edu.swu.ws;

public class English extends Human {

    public English(String name) {
        super(name);
    }

    @Override
    public void greeting(Human human) {
        System.out.println(
            "Hello " + human.getName() + ", I'm " + this.getName());

    }

}
