package flashflashrevolutionbot.gameplay;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Robot;

/**
 * This class will handle watching on arrow
 */
public class ArrowWatcherThread extends Thread {

    /** The robot */
    private final static Robot robot = initRobot();

    /** Keep track of when the thread is running */
    private volatile boolean isRunning;

    /** The point to watch for change */
    private final Point watchPoint;

    /** The keyCode for the key to press when a change is detected */
    private final int keyCode;

    /**
     * Static block to init the robot.
     * 
     * @return An initiliazed robot
     */
    private static Robot initRobot() {
        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException awtException) {
            awtException.printStackTrace();
            System.err.println("Fatal Error: can not init robot... now exiting");
            System.exit(1);
        }

        return robot;
    }

    /**
     * Create a new ArrowWatcherThread
     *
     * @param watchPoint The point on the screen to watch
     * @param keyCode Key to press (e.g. KeyEvent.VK_A) when the change is detected.
     *
     * @see java.awt.event.KeyEvent
     */
    public ArrowWatcherThread(Point watchPoint, int keyCode) {
        this.watchPoint = watchPoint;
        this.keyCode = keyCode;
        this.isRunning = true;
    }

    /**
     * The run loop will constantly watch the given point
     * for a change in color generate an event
     */
     @Override
    public void run() {
        final Color initialColor = 
            ArrowWatcherThread.robot.getPixelColor(watchPoint.x, watchPoint.y);

        while (isRunning) {
            if (!ArrowWatcherThread.robot.getPixelColor(watchPoint.x, watchPoint.y).equals(initialColor)) {
                System.out.println("Color change detected at point" + watchPoint);
                ArrowWatcherThread.robot.keyPress(this.keyCode);
                ArrowWatcherThread.robot.keyRelease(this.keyCode);
            }
        }
    }

    /**
     * Stop the thread from execution
     */
    public void stopExecution() {
        this.isRunning = false;
    }
}
    
