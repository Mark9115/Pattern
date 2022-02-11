package mark.patterns.prototype;

interface Prototype {
    Prototype getClone();
}
class Computer implements Prototype{
    private final String CPU;
    private final String GPU;
    private final String RAM;
    private final String HDD;

    Computer(String CPU,String GPU,String RAM,String HDD){
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        this.HDD = HDD;
    }
    @Override
    public Prototype getClone() {
        return new Computer(CPU,GPU,RAM,HDD);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", HDD='" + HDD + '\'' +
                '}';
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        Computer i5 = new Computer("i5","rtx 2070","ddr4","500gb");
        Computer i3 = new Computer("i3","rtx 1060","ddr3","1000gb");
        Computer i7 = new Computer("i7","rtx 3080","ddr4","1000gb");
        System.out.println(i5);
        System.out.println(i3);
        System.out.println(i7);
        Computer i5Clone = (Computer) i5.getClone();
        System.out.println("clone:" + i5Clone);
    }
}
