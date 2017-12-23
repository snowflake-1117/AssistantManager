import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorManagerTest {
    @Test
    public void calculatorTest() throws Exception {
        CalculatorManager calculatorManager = new CalculatorManager();
        assertEquals("5.5", calculatorManager.calculate("2+3.5"));
        assertEquals("-1.5", calculatorManager.calculate("2-3.5"));
        assertEquals("7", calculatorManager.calculate("2*3.5"));
        assertEquals("-7", calculatorManager.calculate("2*-3.5"));
        assertEquals("3.5", calculatorManager.calculate("7/2"));
        assertEquals("-3.5", calculatorManager.calculate("7/-2"));
        assertEquals("89", calculatorManager.calculate("(2-3*6)/2+4/(-2)+9.9*10"));
    }

    @Test
    public void lengthConversionTest() throws Exception {
        LengthConversionPair lengthConversionPair = new LengthConversionPair();
        assertEquals("25.4 cm", lengthConversionPair.conversionToCm(10.0));
        assertEquals("-25.4 cm", lengthConversionPair.conversionToCm(-10));
        assertEquals("0.0 cm", lengthConversionPair.conversionToCm(0));
        assertEquals("9.842525 inch", lengthConversionPair.conversionToInch(25));
        assertEquals("-9.842525 inch", lengthConversionPair.conversionToInch(-25));
        assertEquals("0.0 inch", lengthConversionPair.conversionToInch(0));
    }

    @Test
    public void weightConversionTest() throws Exception {
        WeightConversionPair weightConversionPair = new WeightConversionPair();
        assertEquals("0.0 kg", weightConversionPair.conversionToKg(0));
        assertEquals("4.5392 kg", weightConversionPair.conversionToKg(10));
        assertEquals("-4.5392 kg", weightConversionPair.conversionToKg(-10.0));
        assertEquals("0.0 pound", weightConversionPair.conversionToPound(0));
        assertEquals("45.19470999999999 pound", weightConversionPair.conversionToPound(20.5));
        assertEquals("-45.19470999999999 pound", weightConversionPair.conversionToPound(-20.5));
    }

    @Test
    public void temperatureConversionTest() throws Exception {
        TemperatureConversionPair temperatureConversionPair = new TemperatureConversionPair();
        assertEquals("0.0 °C", temperatureConversionPair.conversionToCelsius(32));
        assertEquals("-35.55555555555556 °C", temperatureConversionPair.conversionToCelsius(-32));
        assertEquals("-17.77777777777778 °C", temperatureConversionPair.conversionToCelsius(0));
        assertEquals("32.0 °F", temperatureConversionPair.conversionToFahrenheit(0));
        assertEquals("50.900000000000006 °F", temperatureConversionPair.conversionToFahrenheit(10.5));
        assertEquals("14.0 °F", temperatureConversionPair.conversionToFahrenheit(-10));
    }
}