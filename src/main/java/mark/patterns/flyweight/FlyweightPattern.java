package mark.patterns.flyweight;

import java.util.HashMap;
import java.util.Random;


interface Insect
{
    void assignPosition(Position pos);
    void myRepresentation();
}

class Position{
    private final int x;
    private final int y;
    private final int z;
    Position(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}

class Housefly implements Insect
{
    // Intrinsic Attribute
    private final String occupation;

    // Extrinsic Attribute
    Position pos;


    public Housefly()
    {
        occupation = "Flying";
    }
    public void assignPosition(Position pos)
    {
        this.pos = pos;
    }
    public void myRepresentation()
    {
        System.out.println(
                "I am " + occupation + ". My position is" +
                        "\nx: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + "."
        );
    }
}

class Beetle implements Insect
{
    // Intrinsic Attribute
    private final String occupation;

    // Extrinsic Attribute
    Position pos;

    public Beetle()
    {
        occupation = "Hanging out";
    }
    public void assignPosition(Position pos)
    {
        this.pos = pos;
    }
    public void myRepresentation()
    {
        System.out.println(
                "I am " + occupation + ". My position is" +
                        "\nx: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + "."
        );
    }
}

class Cockroach implements Insect
{
    // Intrinsic Attribute
    private final String occupation;

    // Extrinsic Attribute
    Position pos;

    public Cockroach()
    {
        occupation = "Shitting";
    }
    public void assignPosition(Position pos)
    {
        this.pos = pos;
    }
    public void myRepresentation()
    {
        System.out.println(
                "I am " + occupation + ". My position is" +
                        "\nx: " + pos.getX() + ", y: " + pos.getY() + ", z: " + pos.getZ() + "."
        );
    }
}

class InsectFactory
{
    private static final HashMap <String, Insect> map = new HashMap<>();

    // Method to get an Insect
    public static Insect getInsect(String type)
    {
        Insect insectInstance = null;

        if (map.containsKey(type))
            insectInstance = map.get(type);
        else
        {
            switch(type)
            {
                case "Cockroach":
                    System.out.println("Cockroach Created");
                    insectInstance = new Cockroach();
                    break;
                case "Beetle":
                    System.out.println("Beetle Created");
                    insectInstance = new Beetle();
                    break;
                case "Housefly":
                    System.out.println("Housefly Created");
                    insectInstance = new Housefly();
                    break;
                default :
                    System.out.println("Unreachable code!");
            }
            map.put(type, insectInstance);
        }
        return insectInstance;
    }
}

public class FlyweightPattern
{
    private static final String[] insectType = {"Housefly", "Beetle", "Cockroach"};

    public static void main(String[] args)
    {

        for (int i = 1; i <= 15; i++)
        {

            Insect insectInstance = InsectFactory.getInsect(getRandInsectType());

            insectInstance.assignPosition(getRandPosition());

            insectInstance.myRepresentation();
        }
    }

    public static String getRandInsectType()
    {
        Random rand = new Random();
        int randInt = rand.nextInt(insectType.length);

        return insectType[randInt];
    }
    public static Position getRandPosition()
    {
        Random rand = new Random();
        return new Position(rand.nextInt(100),rand.nextInt(100),rand.nextInt(100));
    }
}

