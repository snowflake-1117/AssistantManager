import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorManagerTest {
    @Test
    public void calculatorTest() {
        CalculatorManager calculatorManager = new CalculatorManager();
        assertEquals("5.5", calculatorManager.calculate("2+3.5"));
        assertEquals("-1.5", calculatorManager.calculate("2-3.5"));
        assertEquals("7", calculatorManager.calculate("2*3.5"));
        assertEquals("-7", calculatorManager.calculate("2*-3.5"));
        assertEquals("3.5", calculatorManager.calculate("7/2"));
        assertEquals("-3.5", calculatorManager.calculate("7/-2"));
        assertEquals("89", calculatorManager.calculate("(2-3*6)/2+4/(-2)+9.9*10"));
    }
}