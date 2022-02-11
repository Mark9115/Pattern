package mark.patterns.adapter;

interface RailsAble{
    void rideOnRails();
}

class Train implements RailsAble{

    @Override
    public void rideOnRails() {
        System.out.println("I can use rails cuz im train!");
    }
}

class Boat{
    void sailing(){
        System.out.println("I can use rails cuz im train!");
    }
}

class AdapterBoat implements RailsAble{
    Boat boat;

    public AdapterBoat(Boat boat) {
        this.boat = boat;
    }

    @Override
    public void rideOnRails() {
        System.out.println("Now i can use rails too!");
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Train train = new Train();
        Boat boat = new Boat();
        AdapterBoat boatOnRails = new AdapterBoat(boat);
        methodForTrails(train);
        System.out.println();
        methodForTrails(boatOnRails);
    }


    static void methodForTrails(RailsAble onRails){
        onRails.rideOnRails();
    }
}
