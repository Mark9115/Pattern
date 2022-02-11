package mark.patterns.templateMethod;

abstract class Worker {
    final String getUp() {
        return "Everyone should get up at 7 o'clock";
    }
    String relaxTime(){
        return "1 hour";
    }
    abstract String workingHours();
    abstract String nameOfWorker();
}

class Manager extends Worker {
    @Override
    String workingHours() {
        return "9:00 - 18:00";
    }
    @Override
    String nameOfWorker(){
        return "Manager";
    }

    @Override
    String relaxTime() {
        return "1 hour";
    }
}
class Engineer extends Worker {
    @Override
    String workingHours() {
        return "10:00 - 19:00";
    }
    @Override
    String nameOfWorker(){
        return "Engineer";
    }
}
public class TemplateMethodPattern {
    public static void main(String[] args) {
        Worker worker = new Engineer();
        System.out.println(worker.getUp());
        System.out.println(worker.nameOfWorker());
        System.out.println(worker.workingHours());
        System.out.println(worker.relaxTime());
        System.out.println();
        worker = new Manager();
        System.out.println(worker.getUp());
        System.out.println(worker.nameOfWorker());
        System.out.println(worker.workingHours());
        System.out.println(worker.relaxTime());
    }
}
