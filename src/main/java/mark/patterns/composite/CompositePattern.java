package mark.patterns.composite;

import java.util.ArrayList;

interface Gives {

    void giveIceCream(String IceCream);
}
class Manager implements Gives {

    @Override
    public void giveIceCream(String nameOfIceCream) {
        System.out.println("Manager has an ice cream : "+ nameOfIceCream);
    }
}
class Student implements Gives {

    @Override
    public void giveIceCream(String nameOfIceCream) {
        System.out.println("Student has an ice cream : "+ nameOfIceCream);
    }
}
class child implements Gives {

    @Override
    public void giveIceCream(String nameOfIceCream) {
        System.out.println("Child has an ice cream : "+ nameOfIceCream);
    }
}

class GeneralGives implements Gives{
    private final ArrayList<Gives> iceCreams = new ArrayList<>();

    @Override
    public void giveIceCream(String nameOfIceCream) {
        for(Gives ic : iceCreams)
        {
            ic.giveIceCream(nameOfIceCream);
        }
    }

    public void add(Gives ic){
        this.iceCreams.add(ic);
    }

    public void remove(Gives ic){
        iceCreams.remove(ic);
    }

    public void clear(){
        System.out.println("Clearing...");
        this.iceCreams.clear();
    }
}

public class CompositePattern {

    public static void main(String[] args) {
        Gives student = new Student();
        Gives manager = new Manager();
        Gives child = new child();

        GeneralGives give = new GeneralGives();
        give.add(student);
        give.add(manager);
        give.add(child);

        give.remove(manager);

        give.giveIceCream("Eskimo");

        give.clear();

        give.add(manager);
        give.add(child);
        give.giveIceCream("SUNDAE");
    }

}
