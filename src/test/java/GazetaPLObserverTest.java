import domain.GazetaPLObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;


public class GazetaPLObserverTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void updateTest() throws MalformedURLException {
        GazetaPLObserver ob = new GazetaPLObserver(null, new URL("www.testowanie.pl"));
        ob.update();
        assertEquals("page www.testowanie.pl was updated\n",outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
