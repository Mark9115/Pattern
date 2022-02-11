package mark.patterns.singleton;

public class SingletonPattern {
    private static volatile SingletonPattern instance;
    private final String message;
    private SingletonPattern(String message){
        this.message = message;
    }

    public static SingletonPattern getInstance(String message){
        if(instance == null){
            synchronized (SingletonPattern.class){
                if (instance == null) {
                    instance = new SingletonPattern(message);
                }
                return instance;
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "message='" + message + '\'' +
                '}';
    }
}

class SingletonTest{
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(()->System.out.println(SingletonPattern.getInstance("Singleton" + finalI))).start();
        }
    }
}

