package cn.edu.swu.ws;

public class Chinese extends Human {

    public Chinese(String name) {
        super(name);//构造方法中，若surper，则自动调用父类的无参数构造方法，
    }

    @Override
    public void greeting(Human human) {
        System.out.println(
            "你好" + human.getName() + ", 我是" + this.getName());
    }

}
