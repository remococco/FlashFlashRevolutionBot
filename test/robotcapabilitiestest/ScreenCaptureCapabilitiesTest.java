package robotcapabilitiestest;

/* JUnit test imports */
import org.junit.*;
import static org.junit.Assert.*;

/* All other imports for the tests */
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Robot;

public class ScreenCaptureCapabilitiesTest {

    private Robot robot;
    private static int SCREEN_WIDTH;
    private static int SCREEN_HEIGHT;
    private static int PIXEL_INCREMENT;

    @BeforeClass
    public static void initScreenCoordinates() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_WIDTH = (int) screenSize.getWidth();
        SCREEN_HEIGHT = (int) screenSize.getHeight();
    }   

    @BeforeClass
    public static void initConstants() {
        PIXEL_INCREMENT = 100;
    }

    @Before
    public void initRobot() {
        try {
            this.robot = new Robot();
        } catch (AWTException awtException) {
            fail("Could not instantiate robot");
        }
    }

    /**
     * This test was used to determine how
     * junit outputs stdout while running the test.
     * The main goal was to determine if 
     * running the tests using "ant test"
     * would result stdout being output to the
     * terminal "live" or if everything in the
     * buffer would be output at once.
     */
    @Ignore
    @Test
    public void testTest() {
        System.out.println("Before loop");
        for (int i = 0; i < 10; i++) {
            System.out.println("Iteration: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                continue; // OM
            }
        }
    }

    @Test(timeout=15)
    public void getAllScreenCoordsTest() {
        Color color;
        System.out.printf("Testing all coordinates in height: (0, %d) width: (0. %d)\n", SCREEN_HEIGHT, SCREEN_WIDTH);
        for (int width = 0; width < SCREEN_WIDTH; width+= PIXEL_INCREMENT) {
            for (int height = 0; height < SCREEN_HEIGHT; height+= PIXEL_INCREMENT) {
                color = this.robot.getPixelColor(height, width);
                System.out.printf("The color at (%d, %d) is %s\n",
                    height, width, color);
            }
        }
    }
}

