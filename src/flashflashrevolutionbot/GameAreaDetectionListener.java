package flashflashrevolutionbot;

import java.awt.Rectangle;

/**
 * Interface for listening for the game area to be detected
 */
public interface GameAreaDetectionListener {
    /**
     * Alert the listener that the game area was retreved
     *
     * @param gameArea The area of the game that was detected
     */
    public void didFinishRetreivingGameArea(Rectangle gameArea);
}

