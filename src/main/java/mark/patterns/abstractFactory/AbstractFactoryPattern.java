package mark.patterns.abstractFactory;

import mark.patterns.factoryMethod.Notification;
import mark.patterns.factoryMethod.PushNotificationFactory;

class CallPhoneNotification implements Notification{
    String message;

    public CallPhoneNotification(String message) {
        this.message = message;
    }

    @Override
    public void notification() {
        System.out.println("Calling: " + message);
    }
}
class SMSPhoneNotification implements Notification{
    String message;

    public SMSPhoneNotification(String message) {
        this.message = message;
    }

    @Override
    public void notification() {
        System.out.println("SMS: "+ message);
    }
}
class DefaultPhoneNotification implements Notification{
    String message;

    public DefaultPhoneNotification(String message) {
        this.message = message;
    }
    @Override
    public void notification() {
        System.out.println("Another phone notification: "+ message);
    }
}



public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory notificationFactory = new PushNotificationFactory("ANDROID","Checking system!");
        Notification pushNotification = notificationFactory.getInstance();
        pushNotification.notification();

        notificationFactory = new PhoneNotificationFactory("SMS","to right number");
        pushNotification = notificationFactory.getInstance();
        pushNotification.notification();
    }
}
