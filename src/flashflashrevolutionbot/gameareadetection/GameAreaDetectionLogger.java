package flashflashrevolutionbot.gameareadetection;

import java.awt.Rectangle;

import java.io.PrintStream;

public class GameAreaDetectionLogger implements GameAreaDetectionListener {

    /** {@link PrintStream} to print to */
    private PrintStream printStream;

    /**
     * Create a GameAreaDetectionLogger that will print to the given print screen
     *
     * @param printStream The {@link java.io.PrintStream} to print to
     */
    public GameAreaDetectionLogger(PrintStream printStream) {
        this.printStream = printStream;
    }

    /**
     * Create a GameAreaDetectionLogger that will print to {@link java.lang.System#out System.out}
     */
    public GameAreaDetectionLogger() {
        this(System.out);
    }

    /**
     * @inheritDoc
     * 
     * Print the output to stdout
     */
    @Override
    public void didFinishRetreivingGameArea(Rectangle gameArea) {
        System.out.println("Detected game area: " + gameArea);
    }
}

