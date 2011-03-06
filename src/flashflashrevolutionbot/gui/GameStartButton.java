package FlashFlashRevolutionBot.gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class GameStartButton extends JButton 
    implements ActionListener {

    /** The Text for the button */
    private final static String BUTTON_TEXT = "Start Game";

    public GameStartButton() {
        super(BUTTON_TEXT);
        this.addActionListener(this);
    }

    /* ActionListener Method */

    /**
     * Start the game
     */
    public void actionPerformed(ActionEvent e) {
        // TODO Start the game!
    }
}

