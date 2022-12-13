package Command;

public class LightOnCommand implements ICommand {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

class Light {
    Light() {
    }

    public void on() {
        System.out.println("Light On");
    }

    public void off() {
        System.out.println("Light Off");
    }
}
