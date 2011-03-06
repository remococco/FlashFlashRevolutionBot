package flashflashrevolutionbotests.gameplaytests;

import flashflashrevolutionbot.gameplay.ArrowWatcherThread;

import java.awt.Point;

import static java.awt.event.KeyEvent.*;

import org.junit.*;
import static org.junit.Assert.*;

public class ArrowWatcherThreadTests {

    private final static int TEST_RUNTIME = 25000; // 25 seconds

    private ArrowWatcherThread leftThread;
    private ArrowWatcherThread downThread;
    private ArrowWatcherThread upThread;
    private ArrowWatcherThread rightThread;

    @Before
    public void setupArrowWatcherThreads() {
        // configure this using hte MouseTracker and hovering over the 
        // arrows. We'll write the arrow finding later.
        this.leftThread = new ArrowWatcherThread(new Point(483, 339), VK_LEFT);
        this.downThread = new ArrowWatcherThread(new Point(538, 320), VK_DOWN);
        this.upThread = new ArrowWatcherThread(new Point(610, 337), VK_UP);
        this.rightThread = new ArrowWatcherThread(new Point(676, 334), VK_RIGHT);
    }

    @Before
    public void spawnTimerThread() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(TEST_RUNTIME);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                ArrowWatcherThreadTests.this.leftThread.stopExecution();
                ArrowWatcherThreadTests.this.downThread.stopExecution();
                ArrowWatcherThreadTests.this.upThread.stopExecution();
                ArrowWatcherThreadTests.this.rightThread.stopExecution();
            }
        }).start();
    }

    @Test
    public void runTest() {
//        try {
//            System.out.println("Sleeping for 2.5 seconds, start the game now!");
//            Thread.sleep(2500);
//        } catch (InterruptedException interruptedException) {
//            interruptedException.printStackTrace();
//        }

        this.leftThread.start();
        this.downThread.start();
        this.upThread.start();
        this.rightThread.start();

        try {
            this.leftThread.join();
            this.downThread.join();
            this.upThread.join();
            this.rightThread.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        assertTrue(true);
    }
}

