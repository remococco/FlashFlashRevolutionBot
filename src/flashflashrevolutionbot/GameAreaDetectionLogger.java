package flashflashrevolutionbot;

import java.awt.Rectangle;

public class GameAreaDetectionLogger implements GameAreaDetectionListener {
    @Override
    public void didFinishRetreivingGameArea(Rectangle gameArea) {
        System.out.println("Detected game area: " + gameArea);
    }
}

