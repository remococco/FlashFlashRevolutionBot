package flashflashrevolutionbot.gameareadetection;

import java.awt.event.AWTEventListener;

import java.awt.Rectangle;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.LinkedList;
import java.util.List;

/**
 * This class will get the coordinates on the screen
 * and alert of its listeners when the information 
 * is retreived.
 *
 * @author Remo Cocco
 *
 * @version 2011.03.05
 */
public class GameAreaDetectionController extends MouseAdapter implements Runnable {

    /** The {@link GameAreaDetectionController} used to detect the game area */
    private final GameAreaDetectionFrame gameAreaDetectionFrame;

    /** The {@link Thread} that will control the frame and retreives the game area */
    private final Thread controlThread;

    /** Keep track of when the thread is running */
    private volatile boolean isRunning;

    /** List of {@link GameAreaDetectionListeners} that are interested in infromation obtained by this class */
    private final List<GameAreaDetectionListener> gameAreaDetectionListeners;

    /**
     * Create a new GameAreaDetectionController 
     */
    public GameAreaDetectionController() {
        this.gameAreaDetectionFrame = 
            new GameAreaDetectionFrame();
        this.gameAreaDetectionListeners = new LinkedList<GameAreaDetectionListener>();
        this.gameAreaDetectionFrame.addMouseListener(this);
        this.gameAreaDetectionFrame.setVisible(true); 
        this.controlThread = new Thread(this);
    }

    /*(*
     * Create a new GameAreaDetectionController and add all of the given listeners
     *
     * @param gameAreaDetectionListeners The game area detection listeners interested in this
     */
     public GameAreaDetectionController(GameAreaDetectionListener... gameAreaDetectionListeners) {
         this();
         this.addGameAreaDetectionListeners(gameAreaDetectionListeners);
     }

    /**
     * Register the {@link GameAreaDetectionListener}s
     *
     * @param gameAreaDetectionListeners The GameAreaDetectionListeners that are interested in the information retreived by this.
     */
    public void addGameAreaDetectionListeners(GameAreaDetectionListener... gameAreaDetectionListeners) {
        for (GameAreaDetectionListener gameAreaDetectionListener : gameAreaDetectionListeners) {
            this.gameAreaDetectionListeners.add(gameAreaDetectionListener);
        }
    }

    /**
     * Run loop which will continue to appropritly re-draw the {@link GameAreaDetectionController}
     * and get the area of the game when it is over.
     */
    @Override
    public void run() {
        Point currentMouseLocation;
        Rectangle currentFrameLocation;
        while (isRunning) {
            currentMouseLocation = 
                MouseInfo.getPointerInfo().getLocation();
            currentFrameLocation = gameAreaDetectionFrame.getBounds();
            gameAreaDetectionFrame.setBounds(currentFrameLocation.x, currentFrameLocation.y,
                currentMouseLocation.x - currentFrameLocation.x,
                currentMouseLocation.y - currentFrameLocation.y);
        }   
        this.cleanUpGameAreaDetectionController();
        this.alertGameAreaDetectionListeners(gameAreaDetectionFrame.getBounds());
    }  

    /**
     * Alert all of the {@link GameAreaDetectionListener}s that the game area was determined
     *
     * @param gameArea The area of the game to alert the listeners with
     */
    private void alertGameAreaDetectionListeners(Rectangle gameArea) {
        for (GameAreaDetectionListener gameAreaDetectionListener : this.gameAreaDetectionListeners) {
            gameAreaDetectionListener.didFinishRetreivingGameArea(gameArea);
        }
    }

    /**
     * Clean up the {@link GameAreaDetectionController used by this.
     * Make s the {@link GameAreaDetectionController} inviisble and
     * disposed of it
     */
    private void cleanUpGameAreaDetectionController() {
        this.gameAreaDetectionFrame.setVisible(false);
        this.gameAreaDetectionFrame.dispose();
    }


    /* Mouse Listener Methods */

    /**
     * When the mouse is clicked, start the detection thread.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        this.isRunning = true;
        this.controlThread.start();
        this.gameAreaDetectionFrame.setBounds(e.getX(), e.getY(), 0, 0);
    }

    /**
     * When the mouse is released end the detection thrad.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        isRunning = false;
    }
}

