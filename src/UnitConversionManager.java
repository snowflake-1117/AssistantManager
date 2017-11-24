import java.util.Scanner;

public class UnitConversionManager extends Menu {
    @Override
    public void showAndSelect() {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);

        while (choice != 4) {
            printMenu();
            ConversionPair conversionPair;
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    conversionPair = new WeightConversionPair();
                    conversionPair.showAndSelect();
                    break;
                case 2:
                    conversionPair = new LengthConversionPair();
                    conversionPair.showAndSelect();
                    break;
                case 3:
                    conversionPair = new TemperatureConversionPair();
                    conversionPair.showAndSelect();
                    break;
                case 4:
                    break;
                default:
                    String wrongInput = "잘못된 입력 값 입니다.";
                    System.out.println(wrongInput);
                    break;
            }
        }
    }

    @Override
    protected void printMenu() {
        System.out.println("1. pound <-> kg");
        System.out.println("2. inch <-> cm");
        System.out.println("3. °F <-> °C");
        System.out.println("4. 뒤로가기");
        System.out.print("입력: ");
    }
}
