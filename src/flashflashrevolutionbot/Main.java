package flashflashrevolutionbot;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Main class for Flash Flash Revolution Robot
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
        //System.out.println("Hello Flash Flash!");
        initSteveoJFrame();
    }

    public static void initSteveoJFrame() {
        JFrame frame = new JFrame("Hello, Stev-o!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.pack();
        frame.setVisible(true);
    }
}

