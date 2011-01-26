package flashflashrevolutionbot;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Main class for Flash Flash Revolution Robot
 */
public class Main {
    /**
     * Main Methods
     * This will set up the application and run it
     */
    public static void main (String... args) {
        //System.out.println("Hello Flash Flash!");
        JFrame frame = new JFrame("Hello, Stev-o!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.pack();
        frame.setVisible(true);
    }
}

