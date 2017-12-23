import java.util.Scanner;

public class WeightConversionPair extends ConversionPair {
    @Override
    protected void printMenu() {
        System.out.println("1. pound -> kg");
        System.out.println("2. kg -> pound");
        System.out.print("입력: ");
    }

    @Override
    String calculateUnitConversion(boolean isConversionFromPoundToKg) {
        String result;
        double inputNumber;
        Scanner scanner = new Scanner(System.in);

        if (isConversionFromPoundToKg) {
            System.out.print("변환할 pound 값을 입력하세요: ");
            inputNumber = scanner.nextDouble();
            result = conversionToKg(inputNumber);
        } else {
            System.out.print("변환할 kg 값을 입력하세요: ");
            inputNumber = scanner.nextDouble();
            result = conversionToPound(inputNumber);
        }
        return result;
    }

    String conversionToKg(double inputNumber) {
        return inputNumber * 0.45392 + " kg";
    }

    String conversionToPound(double inputNumber) {
        return inputNumber * 2.20462 + " pound";
    }
}
