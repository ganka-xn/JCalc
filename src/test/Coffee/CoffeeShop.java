package test.Coffee;

import test.Coffee.CoffeeTypes.CoffeeType;

public class CoffeeShop {

//    public Coffee orderCoffee(CoffeeType type) {
//        Coffee coffee = null;
//
//        switch (type) {
//            case AMERICANO:
//                coffee = new Americano();
//                break;
//            case ESPRESSO:
//                coffee = new Espresso();
//                break;
//            case CAPPUCCINO:
//                coffee = new Cappuccino();
//                break;
//            case CAFFE_LATTE:
//                coffee = new CaffeLatte();
//                break;
//        }
//
//        coffee.grindCoffee();
//        coffee.makeCoffee();
//        coffee.pourIntoCup();
//
//        System.out.println("Вот ваш кофе! Спасибо, приходите еще!");
//        return coffee;
//    }

    private final SimpleCoffeeFactory coffeeFactory;

    public CoffeeShop(SimpleCoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee(CoffeeType type) {
        Coffee coffee = coffeeFactory.createCoffee(type);
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();

        System.out.println("Вот ваш кофе! Спасибо, приходите еще!");
        return coffee;
    }
}
