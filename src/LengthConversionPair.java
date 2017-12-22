import java.util.Scanner;

public class LengthConversionPair extends ConversionPair {
    @Override
    protected void printMenu() {
        System.out.println("1. inch -> cm");
        System.out.println("2. cm -> inch");
        System.out.print("입력: ");
    }

    @Override
    String calculateUnitConversion(boolean isConversionFromInchToCm) {
        String result;
        double inputNumber;
        Scanner scanner = new Scanner(System.in);

        if (isConversionFromInchToCm) {
            System.out.print("변환할 inch 값을 입력하세요: ");
            inputNumber = scanner.nextDouble();
            result = conversionToCm(inputNumber);
        } else {
            System.out.print("변환할 cm 값을 입력하세요: ");
            inputNumber = scanner.nextDouble();
            result = conversionToInch(inputNumber);
        }
        return result;
    }

    String conversionToCm(double inputNumber) {
        return inputNumber * 2.54 + " cm";
    }

    String conversionToInch(double inputNumber) {
        return inputNumber * 0.393701 + " inch";
    }
}
