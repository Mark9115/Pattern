package mark.patterns.bridge;

abstract class Vehicle {
    protected StateVehicle state;

    protected Vehicle(StateVehicle state)
    {
        this.state = state;
    }

    abstract public void manufacture();
}

class Bus extends Vehicle {
    public Bus(StateVehicle state)
    {
        super(state);
    }

    @Override
    public void manufacture()
    {
        System.out.print("Bus");
        state.work();
    }
}

class Truck extends Vehicle {
    public Truck(StateVehicle state)
    {
        super(state);
    }

    @Override
    public void manufacture()
    {
        System.out.print("Truck");
        state.work();
    }
}

interface StateVehicle
{
    void work();
}

class Registration implements StateVehicle {
    @Override
    public void work()
    {
        System.out.print(" is on registration");
    }
}

class Working implements StateVehicle {
    @Override
    public void work()
    {
        System.out.print(" is working");
    }
}

class BridgePattern {
    public static void main(String[] args)
    {
        Vehicle vehicle1 = new Bus(new Registration());
        vehicle1.manufacture();
        System.out.println();
        Vehicle vehicle2 = new Truck(new Working());
        vehicle2.manufacture();
    }
}
