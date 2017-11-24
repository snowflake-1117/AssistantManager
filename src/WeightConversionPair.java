import java.util.Scanner;

public class WeightConversionPair extends ConversionPair {
    @Override
    protected void printMenu() {
        System.out.println("1. pound -> kg");
        System.out.println("2. kg -> pound");
        System.out.print("�Է�: ");
    }

    @Override
    String calculateUnitConversion(boolean isConversionFromPoundToKg) {
        String result;
        double inputNumber;
        Scanner scanner = new Scanner(System.in);

        if (isConversionFromPoundToKg) {
            System.out.print("��ȯ�� pound ���� �Է��ϼ���: ");
            inputNumber = scanner.nextDouble();
            result = inputNumber * 0.45392 + " kg";
        } else {
            System.out.print("��ȯ�� kg ���� �Է��ϼ���: ");
            inputNumber = scanner.nextDouble();
            result = inputNumber * 2.20462 + " pound";
        }
        return result;
    }
}
