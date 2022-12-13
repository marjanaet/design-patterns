package Command;

public class CommandTest {
    public static void main(String args[]) {
        Light officeRoomLight = new Light();

        LightOnCommand lightOnCommand = new LightOnCommand(officeRoomLight);
        lightOnCommand.execute();

    }
}
