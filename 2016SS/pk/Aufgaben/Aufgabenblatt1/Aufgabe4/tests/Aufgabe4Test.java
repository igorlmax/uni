import org.junit.Rule;
import org.junit.Test;
import java.lang.reflect.Method;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class Aufgabe4Test {

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Test
    public void testCalcCrossSum() throws Exception{
        Method method = Aufgabe4.class.getDeclaredMethod("calcCrossSum", int.class);
        assertEquals(true, method.getReturnType().equals(Integer.TYPE));
        method.setAccessible(true);
        assertEquals(0, method.invoke(null, 0));
        assertEquals(1, method.invoke(null, 1));
        assertEquals(10, method.invoke(null, 1234));
        assertEquals(10, method.invoke(null, 123400));
        assertEquals(46, method.invoke(null, Integer.MAX_VALUE));
    }
}