package robotcapabilitiestest;

import com.sun.awt.AWTUtilities;

import java.awt.Color;
import java.awt.Event;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This test is intended test
 * the capabilities of 
 * translucent JFrames.
 *
 * @author Remo Cocco
 * @version 2011.01.29
 */
public class TranslucentJFrameTest {

    private volatile boolean frameIsOpen = true;
    private JFrame frame;

    @Before
    @SuppressWarnings("serial")
    public void initFrameAndListener() {
        frame = new JFrame("Translucent JFrame") {
            /* This is the heart of the test, 
             * this will make it opawue
             */
            @Override
            public void paint(Graphics g) {
                super.paint(g);
            }
            /*
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 240;
                    final int G = 240;
                    final int B = 240; 


                    Paint p =
                        new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
                                getWidth(), getHeight(), new Color(R, G, B, 255), true);
                    Graphics2D g2d = (Graphics2D)g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());

                } else {
                    super.paintComponent(g);
                }
            }
            */
        };

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                TranslucentJFrameTest.this.frameIsOpen = true;
            }
            @Override
            public void windowClosed(WindowEvent e) {
                TranslucentJFrameTest.this.frameIsOpen = false;
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Test
    public void initTranslucentJFrame() {
        //frame.setWindowOpacity(0.75f);
        AWTUtilities.setWindowOpaque(frame, false);
        frame.pack();
        frame.setVisible(true);
    }

    @After
    public void waitForWindowToClose() {
        while (frameIsOpen) {
            try {
                System.out.println("Waiting for Window to close");
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
            }
        }
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

