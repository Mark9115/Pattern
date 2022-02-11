package mark.patterns.decorator;

abstract class Food {

    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

class Chicken extends Food {

    public Chicken() {
        this.description = "Chicken";
    }

    @Override
    public double cost() {
        return 10;
    }
}
class Fish extends Food {

    public Fish() {
        this.description = "Fish";
    }

    @Override
    public double cost() {
        return 5;
    }
}

abstract class FoodDecorator extends Food {
}

class KetchUP extends FoodDecorator {

    private final Food food;

    public KetchUP(Food food) {
        this.food = food;
    }

    @Override
    public double cost() {
        return 0.5 + food.cost();
    }

    @Override
    public String getDescription() {
        return food.getDescription() + " + KetchUP";
    }
}

class Greenery extends FoodDecorator {

    private final Food food;

    public Greenery(Food food) {
        this.food = food;
    }

    @Override
    public double cost() {
        return 1 + food.cost();
    }

    @Override
    public String getDescription() {
        return food.getDescription() + " + Greenery";
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Food fish = new Greenery(new KetchUP(new Fish()));
        System.out.println(fish.getDescription() + " : " + fish.cost());
        Food chicken = new Greenery(new Chicken());
        System.out.println(chicken.getDescription() + " : " + chicken.cost());
    }
}
