import java.util.Stack;

public class TestCommand {
    public static void main(String args[]) {
        System.out.println("Test Command Class");
        Light testLight = new Light();
        LightOnCommand loc = new LightOnCommand(testLight);
        LightOffCommand lfc = new LightOffCommand(testLight);
        Switch testLightSwitch = new Switch(loc, lfc);
        testLightSwitch.flipUp();
        testLightSwitch.flipDown();
        testLightSwitch.undoCommand();
        testLightSwitch.flipDown();
        testLightSwitch.flipUp();
        testLightSwitch.undoCommand();
        testLightSwitch.undoCommand();
        testLightSwitch.undoCommand();

        Fan testFan = new Fan();
        FanOnCommand foc = new FanOnCommand(testFan);
        FanOffCommand ffc = new FanOffCommand(testFan);
        Switch tsFanSwitch = new Switch(foc, ffc);
        tsFanSwitch.flipUp();
        tsFanSwitch.flipDown();
        tsFanSwitch.undoCommand();
        tsFanSwitch.undoCommand();

    }
}

class Switch {
    private Command UpCommand, DownCommand;
    Stack<Command> undoCommandsStack = new Stack<Command>();

    public Switch(
            Command Up, Command Down) {
        UpCommand = Up;
        DownCommand = Down;
    }

    void flipUp() {
        undoCommandsStack.push(UpCommand);
        UpCommand.execute();
    }

    void flipDown() {
        undoCommandsStack.push(DownCommand);
        DownCommand.execute();
    }

    void undoCommand() {
        undoCommandsStack.pop().undo();
    }
}

class Light {
    public void turnOn() {
        System.out.println("Light is On");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}

class Fan {
    public void startRotate() {
        System.out.println("Fan is rotating");
    }

    public void stopRotate() {
        System.out.println("Fan is not rotating");
    }
}

class LightOnCommand implements Command {
    private Light myLight;

    public LightOnCommand(Light L) {
        myLight = L;
    }

    public void execute() {
        myLight.turnOn();
    }

    public void undo() {
        myLight.turnOff();
    }
}

class LightOffCommand implements Command {
    private Light myLight;

    public LightOffCommand(Light L) {
        myLight = L;
    }

    public void execute() {
        myLight.turnOff();
    }

    public void undo() {
        myLight.turnOn();
    }
}

class FanOnCommand implements Command {
    private Fan myFan;

    public FanOnCommand(Fan F) {
        myFan = F;
    }

    public void execute() {
        myFan.startRotate();
    }

    public void undo() {
        myFan.stopRotate();
    }
}

class FanOffCommand implements Command {
    private Fan myFan;

    public FanOffCommand(Fan F) {
        myFan = F;
    }

    public void execute() {
        myFan.stopRotate();
    }

    public void undo() {
        myFan.startRotate();
    }
}
