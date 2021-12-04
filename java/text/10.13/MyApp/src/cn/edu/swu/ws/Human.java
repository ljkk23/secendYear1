package cn.edu.swu.ws;

public abstract class Human {

    private String name;

    public Human() {
    }

    public Human(String name) {
        this.setName(name);
    }

    public abstract void greeting(Human human);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}



