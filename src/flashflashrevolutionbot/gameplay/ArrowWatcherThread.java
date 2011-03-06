package flashflashrevolutionbot.gameplay;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Robot;

/**
 * This class will handle watching on arrow
 */
public class ArrowWatcherThread extends Thread {

    /* Static block to init the robot */
    static {
        Robot tmpRobot = null;
        try {
            tmpRobot = new Robot();
        } catch (AWTException awtException) {
            awtException.printStackTrace();
            System.err.println("Fatal Error: can not init robot... now exiting");
            System.exit(1);
        } finally {
            robot = tmpRobot;
        }
    }

    /** The robot */
    private final static Robot robot;

    /** The point to watch for change */
    private final Point watchPoint;

    /**
     * Create a new ArrowWatcherThread
     *
     * @param watchPoint The point on the screen to watch
     */
    public ArrowWatcherThread(Point watchPoint) {
        this.watchPoint = watchPoint;
    }

    /**
     * The run loop will constantly watch the given point
     * for a change in color generate an event
     */
    public void run() {
        final Color initialColor = 
            ArrowWatcherThread.robot.getPixelColor(watchPoint.x, watchPoint.y);

        while (true) {
            if (!ArrowWatcherThread.robot.getPixelColor(watchPoint.x, watchPoint.y).equals(initialColor)) {
                System.out.println("Color change detected at point" + watchPoint);
            }
        }
    }

}
    
