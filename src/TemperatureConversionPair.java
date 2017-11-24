import java.util.Scanner;

public class TemperatureConversionPair extends ConversionPair {
    @Override
    protected void printMenu() {
        System.out.println("1. ��F -> ��C");
        System.out.println("2. ��C -> ��F");
        System.out.print("�Է�: ");
    }

    @Override
    String calculateUnitConversion(boolean isConversionFromFahrenheitPoundToCelsius) {
        String result;
        double inputNumber;
        Scanner scanner = new Scanner(System.in);

        if (isConversionFromFahrenheitPoundToCelsius) {
            System.out.print("��ȯ�� ��F ���� �Է��ϼ���: ");
            inputNumber = scanner.nextDouble();
            result = (inputNumber - 32) / 1.8 + " ��C";
        } else {
            System.out.print("��ȯ�� ��C ���� �Է��ϼ���: ");
            inputNumber = scanner.nextDouble();
            result = (inputNumber * 1.8 + 32) + " ��F";
        }
        return result;
    }
}
