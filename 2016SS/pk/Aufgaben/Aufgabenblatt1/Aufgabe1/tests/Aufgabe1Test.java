import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class Aufgabe1Test {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Test
    public void testOutput() {
        String[] testValues = new String[]{"10", "3", "3"};
        StringBuilder testString = new StringBuilder();
        for(String i: testValues) {
            testString.append(i).append(System.lineSeparator());
        }
        Aufgabe1.main(new String[]{});
        assertEquals(testString.toString(), log.getLog());
    }
}
