package flashflashrevolutionbot.gameareadetection;

import java.awt.AWTEvent;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;


import com.sun.awt.AWTUtilities;

/**
 * A special opaque frame used to detect the game area
 *
 * @author Remo Cocco
 *
 * @version 2011.03.05
 */
class GameAreaDetectionFrame extends javax.swing.JFrame implements javax.swing.RootPaneContainer {

    private static final long serialVersionUID = 4509847006666348735L;

    /** Creates new form GameAreaDetectionFrame */
    public GameAreaDetectionFrame() {
        super(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration());
        // take up the whole screen so we hear all of the mouse clicks
        this.setBounds(0, 0, 
            Toolkit.getDefaultToolkit().getScreenSize().width, 
            Toolkit.getDefaultToolkit().getScreenSize().height);
        AWTUtilities.setWindowOpacity(this, 0.75f);
        setUndecorated(true);
        setMinimumSize(new java.awt.Dimension(1,1));
    }
}

