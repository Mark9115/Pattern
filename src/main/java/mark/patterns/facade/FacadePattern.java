package mark.patterns.facade;


class Egg{
    private final int count;
    Egg(int count){
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
class Bacon{
    private final int count;
    Bacon(int count){
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}

class Salt{
    private final double value;
    Salt(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
class Stove{
    public String cooking(Egg egg, Salt salt, Bacon bacon){
        return "cooking! \neggs: " + egg.getCount() + ", salt: " + salt.getValue() + ", bacon: " + bacon.getCount();
    }
}

public class FacadePattern {
    private final Egg egg = new Egg(2);
    private final Salt salt = new Salt(5);
    private final Bacon bacon = new Bacon(2);
    private final Stove stove = new Stove();
    private final String cooked = stove.cooking(egg, salt, bacon);

    public String getString(){
        return cooked;
    }
}

class Cook{
    public static void main(String[] args) {
        FacadePattern facade = new FacadePattern();
        System.out.println(facade.getString());
    }
}

