import org.junit.Rule;
import org.junit.Test;
import java.lang.reflect.Method;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class Aufgabe3Test {

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Test
    public void testIsSumDiv() throws Exception{
        Method method = Aufgabe3.class.getDeclaredMethod("isSumDiv", int.class, int.class, int.class);
        assertEquals(true, method.getReturnType().equals(Boolean.TYPE));
        method.setAccessible(true);
        assertEquals(false, method.invoke(null, 6, 1, 1));
        assertEquals(false, method.invoke(null, 1, 6, 0));
        assertEquals(true, method.invoke(null, 1, 6, 7));
        assertEquals(true, method.invoke(null, 1, 6, 21));
        assertEquals(false, method.invoke(null, 0, 6, 2));
        assertEquals(true, method.invoke(null, 0, 6, 3));
    }
}