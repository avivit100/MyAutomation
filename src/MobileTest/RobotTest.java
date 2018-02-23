package MobileTest;


import java.awt.*;
import java.awt.event.InputEvent;

public class RobotTest {
    public static void main(String[] args) throws AWTException{
        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

    }
}
