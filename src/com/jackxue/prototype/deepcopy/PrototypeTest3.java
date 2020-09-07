package com.jackxue.prototype.deepcopy;

import java.io.*;

public class PrototypeTest3 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep1 tom = new Sheep1("Tom", 2);

        Sheep1 tom1 = new Sheep1("Tom1", 1);
        tom1.setFriend(tom);

        Sheep1 tom2 = (Sheep1) tom1.clone();

        System.out.println("tom1: "+ tom1 + " tom1.name:" + tom1.getName());
        System.out.println("tom2: "+ tom2 + " tom2.name:" + tom2.getName());

        System.out.println("tom1 friend: "+ tom1.getFriend() + " tom1 friend.name:" + tom1.getFriend().getName());
        System.out.println("tom2 friend: "+ tom2.getFriend() + " tom2 friend.name:" + tom2.getFriend().getName());
    }
}

class Sheep1 implements Serializable, Cloneable{
    static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private Sheep1 friend;

    public Sheep1() {
    }

    public Sheep1(String name, int age) {
        this.name = name;
        this.age = age;
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

    public Sheep1 getFriend() {
        return friend;
    }

    public void setFriend(Sheep1 friend) {
        this.friend = friend;
    }

    @Override
    protected Object clone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream  bis = null;
        ObjectInputStream ois = null;
        Sheep1 o = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            o = (Sheep1) ois.readObject();
            System.out.println("sheep1:"+ o.getName());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
                bos.close();
                ois.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                return o;
            }
        }
    }
}
