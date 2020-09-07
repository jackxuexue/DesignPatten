package com.jackxue.prototype;

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep tom = new Sheep("Tom", 2);
        Sheep tom1 = (Sheep) tom.clone();
        System.out.println(tom);
        System.out.println(tom1);
    }
}

class Sheep implements Cloneable{
    private String name;
    private int age;

    public Sheep() {
    }

    public Sheep(String name, int age) {
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
