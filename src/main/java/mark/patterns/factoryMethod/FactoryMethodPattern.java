package mark.patterns.factoryMethod;

class AndroidPushNotification implements Notification{
    String message;

    public AndroidPushNotification(String message) {
        this.message = message;
    }

    @Override
    public void notification() {
        System.out.println("Android Says: " + message);
    }
}
class IOSPushNotification implements Notification{
    String message;

    public IOSPushNotification(String message) {
        this.message = message;
    }

    @Override
    public void notification() {
        System.out.println("IOS Says: "+ message);
    }
}
class DefaultPushNotification  implements Notification{
    String message;

    public DefaultPushNotification(String message) {
        this.message = message;
    }
    @Override
    public void notification() {
        System.out.println("Another device Says: "+ message);
    }
}


public class FactoryMethodPattern {
    public static void main(String[] args) {
        PushNotificationFactory pushNotificationFactory = new PushNotificationFactory("ANDROID","Checking system!");
        Notification pushNotification = pushNotificationFactory.getInstance();
        pushNotification.notification();
    }
}
