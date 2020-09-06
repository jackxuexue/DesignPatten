package com.jackxue.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Drink order = new LongBlack();
        order = new Milk(order);

        order = new Milk(order);
        order = new Milk(order);

        order = new Perl(order);
        System.out.println(order.cost());
        System.out.println(order.getDecription());
    }
}

abstract class Drink{
    private float price;
    private String decription;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

   public abstract float cost();
}

class Decorator extends Drink{
    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDecription() {
        return super.getDecription() + " price:" + super.getPrice() +
                " && " + obj.getDecription();
    }
}

class LongBlack extends Drink{

    public LongBlack() {
        super.setPrice(15.0f);
        super.setDecription("美式咖啡 price:" + super.getPrice());
    }

    @Override
    public float cost() {
        return super.getPrice();
    }
}

class Milk extends Decorator{

    public Milk(Drink obj) {
        super(obj);
        super.setPrice(2.0f);
        super.setDecription("牛奶");
    }
}

class Perl extends Decorator{

    public Perl(Drink obj) {
        super(obj);
        super.setPrice(1.0f);
        super.setDecription("珍珠");
    }
}
