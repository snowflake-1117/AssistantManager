import java.util.Scanner;

abstract class ConversionPair extends Menu {
    private Scanner scanner = new Scanner(System.in);

    abstract String calculateUnitConversion(boolean isConversionFromAToB);

    @Override
    public void showAndSelect() {
        printMenu();
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
            case 2:
                String result = calculateUnitConversion(isConversionFromAToB(choice));
                System.out.println("변환 값: " + result);
                break;
            default:
                String wrongInput = "잘못된 입력 값 입니다.";
                System.out.println(wrongInput);
                break;
        }
    }

    private boolean isConversionFromAToB(int choice) {
        return choice == 1;
    }
}
