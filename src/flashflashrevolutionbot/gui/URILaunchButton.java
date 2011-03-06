package flashflashrevolutionbot.gui;

import java.awt.Desktop;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;

public class URILaunchButton extends JButton 
    implements ActionListener {

    private static final long serialVersionUID = -4672143427848797405L;

    /** The URI to launch to */
    private URI destination;

    /**
     * Create a URI launch button with the given text. 
     * When this button is pressed, it will launch
     * the default browser with the given URI
     *
     * @param text The text for the button
     * @param destination The destination for when the button is pressed
     *
     * @throws URISyntaxException If the given string violates RFC 2396, as augmented by the above deviations
     * @see <a href="http://www.ietf.org/rfc/rfc2396.txt"> RFC 2396 </a>
     * @see java.net.URI#URI(String)
     */
    public URILaunchButton(String text, URI destination) throws URISyntaxException {
        super(text);
        this.destination = destination;
        this.addActionListener(this);
    }

    /**
     * Convenience constructor that makes a uri from the destination string
     *
     * @param text The text for the button
     * @param destination The destination for when the button is pressed
     *
     * @throws URISyntaxException If the given string violates RFC 2396, as augmented by the above deviations
     *
     * @see #URI(String, URI)
     */
    public URILaunchButton(String text, String destination) throws URISyntaxException {
        this(text, new URI(destination));
    }

    /**
     * Convenience constructor that makes will put the text
     * launch followed the URI name in the button's text.
     *
     * @param destination The destination for when the button is pressed
     *
     * @throws URISyntaxException If the given string violates RFC 2396, as augmented by the above deviations
     *
     * @see #URI(String, URI)
     */
    public URILaunchButton(URI destination) throws URISyntaxException {
        this("Launch " + destination, destination);
    }

    /**
     * Convenience constructor that makes will put the text
     * launch followed the URI name in the button's text, and
     * will construct URI from the destination String.
     *
     * @param destination The destination for when the button is pressed
     *
     * @throws URISyntaxException If the given string violates RFC 2396, as augmented by the above deviations
     *
     * @see #URI(String, URI)
     */
    public URILaunchButton(String destination) throws URISyntaxException {
        this(new URI(destination));
    }

    /* ActionListener Method */

    /**
     * Launch the browser to the URI
     */
    public void actionPerformed(ActionEvent e) {
        try {
            Desktop.getDesktop().browse(destination);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

