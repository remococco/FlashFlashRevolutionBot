package robotcapabilitiestest;

// JUnit imports
import org.junit.*;
import static org.junit.Assert.*;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This test is intended test
 * the capabilities of 
 * translucent JFrames.
 *
 * @author Remo Cocco
 * @version 2011.01.29
 */
public class TranslucentJFrameTest {

    @Test
    public void passTest() {
        assertTrue(true);
    }

    @Test
    public void initTranslucentJFrame() {
        JFrame frame = new JFrame("Translucent JFRame") {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                System.out.println("Paint!");
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //frame.setWindowOpacity(0.75f);

        frame.pack();
        frame.setVisible(true);
    }
}

/*
All of this is the java7 way to do it

// swing imports
import java.awt.*;
import javax.swing.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

/**
 * This test is intended test
 * the capabilities of 
 * translucent JFrames.
 * This code was taken from 
 * the <a href="http://download.oracle.com/javase/tutorial/uiswing/misc/trans_shaped_windows.html">
 * How to Create Translucent 
 * and Shaped Windows</a>
 *
 * @author Remo Cocco
 * @version 2011.01.29
 */
 /*
public class TranslucentJFrameTest {

    @Test
    public void initTranslucentJFrame() {
        // Determine if the GraphicsDevice supports translucency.
        GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        //If translucent windows aren't supported, exit.
        if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
            fail("Translucency is not supported");
        }

        // Create the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TranslucentWindow tw = new TranslucentWindow();

                // Set the window to 55% opaque (45% translucent).
                tw.setOpacity(0.55f);

                // Display the window.
                tw.setVisible(true);
            }
        });
    }
}

class TranslucentWindow extends JFrame {
    public TranslucentWindow() {
        super("TranslucentWindow");
        setLayout(new GridBagLayout());

        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add a sample button.
        add(new JButton("I am a Button"));
    }
}
*/

