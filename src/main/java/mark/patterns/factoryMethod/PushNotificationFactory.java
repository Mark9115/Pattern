package mark.patterns.factoryMethod;

import mark.patterns.abstractFactory.AbstractFactory;

public class PushNotificationFactory extends AbstractFactory{
    String platform;
    String message;

    public PushNotificationFactory(String platform, String message) {
        this.platform = platform.toLowerCase();
        this.message = message;
    }

    public Notification getInstance() {
        if(platform.equals("android")){
            return new AndroidPushNotification(message);
        }else if (platform.equals("ios")){
            return new IOSPushNotification(message);
        }else{
            return new DefaultPushNotification(message);
        }
    }
}
