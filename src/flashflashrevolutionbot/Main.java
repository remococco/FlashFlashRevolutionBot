package flashflashrevolutionbot;

import flashflashrevolutionbot.gameareadetection.GameAreaDetectionController;
import flashflashrevolutionbot.gameareadetection.GameAreaDetectionLogger;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Main class for Flash Flash Revolution Robot
 *
 * @author Remo Cocco
 *
 * @version 2011.03.05
 */
public class Main {

    /**
     * This class should never be instantiated.
     */
    private Main() {}

    /**
     * Main Methods
     * This will set up the application and run it
     */
    public static void main (String... args) {
        new GameAreaDetectionController(new GameAreaDetectionLogger());
    }
}

