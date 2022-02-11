package mark.patterns.strategy;

interface Strategy {
    void send(String message);
}

class Telegram implements Strategy{
    @Override
    public void send(String message) {
        System.out.println("This message: \"" + message +"\" were sent from Telegram.");
    }
}
class WhatsApp implements Strategy{
    @Override
    public void send(String message) {
        System.out.println("This message: \"" + message +"\" were sent from WhatsApp.");
    }
}
class Signal implements Strategy{
    @Override
    public void send(String message) {
        System.out.println("This message: \"" + message +"\" were sent from Signal.");
    }
}

class Context {
    Strategy strategy;

    Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void text(String message){
        strategy.send(message);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Context textIt = new Context(new WhatsApp());

        textIt.text("Hello");
        textIt.setStrategy(new Signal());
        textIt.text("How are you, man?");

        System.out.println();

        Context textAgain = new Context(new Telegram());
        textAgain.text("Hey!");
        textAgain.text("I'm okay.");

    }
}
