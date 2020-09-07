package com.jackxue.strategy.v1;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactoryTest {
    public static void main(String[] args) {
        Kitchen.setStrategy("steam", new SteamedCrab());
        Kitchen.setStrategy("braise", new BraisedCrab());

        Kitchen.cookMethod("steam");
    }
}

interface CrabCooking{
    public abstract void cookingMethod();
}

class Kitchen{
    private final static Map<String, CrabCooking> strategy = new HashMap<>();

    private Kitchen(){}

    public static void setStrategy(String str, CrabCooking st){
        strategy.put(str, st);
    }

    public static void cookMethod(String st){
        CrabCooking crabCooking = strategy.get(st);
        if(crabCooking == null){
            System.out.println("not suport this cook method");
            return;
        }
        crabCooking.cookingMethod();
    }
}

//具体抽象类
class SteamedCrab implements CrabCooking {

    @Override
    public void cookingMethod() {
        System.out.println("清蒸大闸蟹");
    }
}

class BraisedCrab implements CrabCooking {

    @Override
    public void cookingMethod() {
        System.out.println("红烧大闸蟹");
    }
}