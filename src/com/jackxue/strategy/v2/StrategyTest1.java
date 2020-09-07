package com.jackxue.strategy.v2;

public class StrategyTest1 {

    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        kitchen.setStrategy(new SteamedCrab());

        kitchen.CookCrab();
    }
}

//抽象策略类
interface CrabCooking{
    public abstract void cookingMethod();
}

//环境类
class Kitchen {
    private CrabCooking strategy;

    public CrabCooking getStrategy() {
        return strategy;
    }

    public void setStrategy(CrabCooking strategy) {
        this.strategy = strategy;
    }

    public void CookCrab(){
        strategy.cookingMethod();
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

