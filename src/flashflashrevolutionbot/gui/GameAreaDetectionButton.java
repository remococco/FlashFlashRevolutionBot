package FlashFlashRevolutionBot.gui;

import flashflashrevolutionbot.gameareadetection.GameAreaDetectionController;
import flashflashrevolutionbot.gameareadetection.GameAreaDetectionListener;

import java.awt.Rectangle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class GameAreaDetectionButton extends JButton 
    implements ActionListener, GameAreaDetectionListener {

    /** The Text for the button */
    private final static String BUTTON_TEXT = "Set Game Area";

    public GameAreaDetectionButton() {
        super(BUTTON_TEXT);
        this.addActionListener(this);
    }

    /* ActionListener Method */

    /**
     * Detect the game area when the button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        new GameAreaDetectionController(this);
    }

    /* GameAreaDetectionListener Method */

    public void didFinishRetreivingGameArea(Rectangle gameArea) {
        // TODO handle receiving the game area
    }
}

