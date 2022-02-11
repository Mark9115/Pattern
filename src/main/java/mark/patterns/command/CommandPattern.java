package mark.patterns.command;

@FunctionalInterface
interface ICommand {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }
    public void turnOff() {
        System.out.println("Light is off");
    }
}

class Fan {
    void start() {
        System.out.println("Fan Started..");
    }
    void stop() {
        System.out.println("Fan stopped..");
    }
}

class TurnOnLightCommand implements ICommand {
    Light light;
    public TurnOnLightCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        System.out.println("Turning on light.");
        light.turnOn();
    }
}

class TurnOffLightCommand implements ICommand {
    Light light;
    public TurnOffLightCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        System.out.println("Turning off light.");
        light.turnOff();
    }
}

class StartFanCommand implements ICommand {
    Fan fan;
    public StartFanCommand(Fan fan) {
        this.fan = fan;
    }
    public void execute() {
        System.out.println("Starting Fan.");
        fan.start();
    }
}

class StopFanCommand implements ICommand {
    Fan fan;
    public StopFanCommand(Fan fan) {
        this.fan = fan;
    }
    public void execute() {
        System.out.println("Stopping Fan.");
        fan.stop();
    }
}

class HomeAutomationRemote {

    ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }
}

public class CommandPattern {
    public static void main(String[] args)
    {
        Light roomLight = new Light();
        Fan roomFan = new Fan();

        HomeAutomationRemote remote = new HomeAutomationRemote();
        System.out.println();
        remote.setCommand(new TurnOnLightCommand(roomLight));
        remote.buttonPressed();
        System.out.println();
        remote.setCommand(new StartFanCommand(roomFan));
        remote.buttonPressed();
        System.out.println();
        remote.setCommand(new StopFanCommand(roomFan));
        remote.buttonPressed();
        System.out.println();
        remote.setCommand(new TurnOffLightCommand(roomLight));
        remote.buttonPressed();
    }
}
