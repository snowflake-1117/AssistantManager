import java.util.Scanner;

public class LengthConversionPair extends ConversionPair {
    @Override
    protected void printMenu() {
        System.out.println("1. inch -> cm");
        System.out.println("2. cm -> inch");
        System.out.print("�Է�: ");
    }

    @Override
    String calculateUnitConversion(boolean isConversionFromInchToCm) {
        String result;
        double inputNumber;
        Scanner scanner = new Scanner(System.in);

        if (isConversionFromInchToCm) {
            System.out.print("��ȯ�� inch ���� �Է��ϼ���: ");
            inputNumber = scanner.nextDouble();
            result = inputNumber * 2.54 + " cm";
        } else {
            System.out.print("��ȯ�� cm ���� �Է��ϼ���: ");
            inputNumber = scanner.nextDouble();
            result = inputNumber * 0.393701 + " inch";
        }
        return result;
    }
}
