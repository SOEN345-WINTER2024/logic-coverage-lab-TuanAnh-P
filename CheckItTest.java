import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CheckItTest {

    @Test
    public void testPredicateCoverage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CheckIt.checkIt(true, true, true);
        assertEquals("P is true\n", outContent.toString());

        outContent.reset();
        CheckIt.checkIt(true, false, true);
        assertEquals("P is true\n", outContent.toString());

        outContent.reset();
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true\n", outContent.toString());

        outContent.reset();
        CheckIt.checkIt(false, false, true);
        assertEquals("P isn't true\n", outContent.toString());
    }

    @Test
    public void testClauseCoverage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CheckIt.checkIt(true, true, true);
        assertEquals("P is true\n", outContent.toString());

        outContent.reset();
        CheckIt.checkIt(true, false, true);
        assertEquals("P is true\n", outContent.toString());

        outContent.reset();
        CheckIt.checkIt(false, true, false);
        assertEquals("P isn't true\n", outContent.toString());

        outContent.reset();
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true\n", outContent.toString());
    }

    @Test
    public void testCACC() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CheckIt.checkIt(true, true, true);
        assertEquals("P is true\n", outContent.toString());

        outContent.reset();
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true\n", outContent.toString());
    }

    @Test
    public void testRACC() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CheckIt.checkIt(false, true, true);
        assertEquals("P is true\n", outContent.toString());

        outContent.reset();
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true\n", outContent.toString());
    }
}

