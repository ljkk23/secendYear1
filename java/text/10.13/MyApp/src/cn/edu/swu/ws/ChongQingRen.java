package cn.edu.swu.ws;

public class ChongQingRen extends Chinese {

    public ChongQingRen(String name) {
        super(name);
    }

    // 重载，覆盖
    @Override
    public void greeting(Human human) {
        System.out.println(
            "你好" + human.getName() + ", 吃了没的？ 我是" + this.getName());
    }

}
