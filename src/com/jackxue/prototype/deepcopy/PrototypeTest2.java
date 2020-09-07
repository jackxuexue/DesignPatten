package com.jackxue.prototype.deepcopy;

import java.io.Serializable;

public class PrototypeTest2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep tom = new Sheep("Tom", 2, null);
        Sheep tom1 = (Sheep) tom.clone();
        tom1.setFriend(tom);
        System.out.println("tom " + tom);
        System.out.println("tom1 " + tom1);
        System.out.println("tom1.friend "+tom1.getFriend());

        Sheep tom2 = (Sheep) tom1.clone();
        System.out.println("tom2 "+tom2);
        System.out.println("tom2.friend "+tom2.getFriend());
    }
}

class Sheep implements Cloneable{
    private String name;
    private int age;
    private Sheep friend;

    public Sheep() {
    }

    public Sheep(String name, int age, Sheep friend) {
        this.name = name;
        this.age = age;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sheep getFriend() {
        return friend;
    }

    public void setFriend(Sheep friend) {
        this.friend = friend;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj =  super.clone();
        if(this.friend != null) {
            ((Sheep) obj).setFriend((Sheep) this.friend.clone());
        }
        return obj;
    }
}

