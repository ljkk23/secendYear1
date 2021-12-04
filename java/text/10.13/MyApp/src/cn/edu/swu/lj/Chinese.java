package cn.edu.swu.lj;

public class Chinese extends Human{
    public Chinese(String name) {super(name);
    }

    @Override
    public void greeting(Human human) {
        System.out.println("你好啊！"+ human.getName()+"我是"+this.getName());
    }
}
