import domain.PJObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;


public class PJObserverTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void updateTest() throws MalformedURLException {
        PJObserver ob = new PJObserver(null, new URL("www.onet.pl"));
        ob.update();
        assertEquals("page www.test.pl was updated\n",outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
