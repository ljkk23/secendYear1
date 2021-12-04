package cn.edu.swu.lj;

public  abstract class Human {
    private String name;
    public Human() {};
    public Human(String name){
        this.setName(name);
    };

    public void setName(String name) {
        this.name = name;
    };

    public String getName() {
        return this.name;
    };
    public abstract void greeting(Human human);
}
