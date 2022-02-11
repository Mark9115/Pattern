package mark.patterns.abstractFactory;

import mark.patterns.factoryMethod.Notification;

public class PhoneNotificationFactory extends AbstractFactory{
    String method;
    String message;

    public PhoneNotificationFactory(String method, String message) {
        this.method = method.toLowerCase();
        this.message = message;
    }

    public Notification getInstance() {
        if(method.equals("call")){
            return new CallPhoneNotification(message);
        }else if (method.equals("sms")){
            return new SMSPhoneNotification(message);
        }else{
            return new DefaultPhoneNotification(message);
        }
    }
}
