package mark.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

class Cake{
    double price;
    String name;
    Cake(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return name +" "+ price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return Double.compare(cake.price, price) == 0 && Objects.equals(name, cake.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}

public class IteratorPattern {

    public static void main(String[] args) {
        ArrayList<Cake> cakes = new ArrayList<>();
        cakes.add(new Cake("Birthday cake", 20_000));
        cakes.add(new Cake("Weeding cake", 40_000));
        cakes.add(new Cake("Cheesecake", 1_000));
        cakes.add(new Cake("Vanilla slice", 5_000));

        CakeIterator iterator = new CakeIterator(cakes);

        iterator.addCake(new Cake("Fruitcake ", 3_000));

        while (iterator.hasNext()){
            Cake current = iterator.next();
            if(current.equals(new Cake("Birthday cake", 20_000))){
                iterator.remove();
            }else {
                System.out.println(current);
            }
        }
    }
}

class CakeIterator implements Iterator<Cake> {
    ArrayList<Cake> cakes;
    int currentIndex = 0;

    CakeIterator(ArrayList<Cake> cakes){
        this.cakes = cakes;
    }
    @Override
    public boolean hasNext() {
        return currentIndex < cakes.size();
    }

    @Override
    public Cake next() {
        return cakes.get(currentIndex++);
    }

    @Override
    public void remove() {
        cakes.remove(--currentIndex);
    }

    public void addCake(Cake cake) {
        cakes.add(cake);
    }

}
