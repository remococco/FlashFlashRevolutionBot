package robotcapabilitiestest;

import com.sun.awt.AWTUtilities;

import org.junit.*;
import static org.junit.Assert.*;

public class TranslucencySupportedTest {
    @Ignore
    @Test
    public void ensureTranslucencySupported() {
        assertTrue(AWTUtilities.isTranslucencySupported(AWTUtilities.Translucency.TRANSLUCENT));
    }
}

