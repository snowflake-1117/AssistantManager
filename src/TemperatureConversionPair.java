import java.util.Scanner;

public class TemperatureConversionPair extends ConversionPair {
    @Override
    protected void printMenu() {
        System.out.println("1. °F -> °C");
        System.out.println("2. °C -> °F");
        System.out.print("입력: ");
    }

    @Override
    String calculateUnitConversion(boolean isConversionFromFahrenheitPoundToCelsius) {
        String result;
        double inputNumber;
        Scanner scanner = new Scanner(System.in);

        if (isConversionFromFahrenheitPoundToCelsius) {
            System.out.print("변환할 °F 값을 입력하세요: ");
            inputNumber = scanner.nextDouble();
            result = (inputNumber - 32) / 1.8 + " °C";
        } else {
            System.out.print("변환할 °C 값을 입력하세요: ");
            inputNumber = scanner.nextDouble();
            result = (inputNumber * 1.8 + 32) + " °F";
        }
        return result;
    }
}
