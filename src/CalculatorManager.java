import java.util.Scanner;

public class CalculatorManager extends Menu {
    @Override
    public void showAndSelect() {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);

        while (choice != 4) {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calculate();
                    break;
                case 2:
                    UnitConversionManager unitConversionManager = new UnitConversionManager();
                    unitConversionManager.showAndSelect();
                    break;
                case 3:
                    break;
                default:
                    String wrongInput = "잘못된 입력 값 입니다.";
                    System.out.println(wrongInput);
                    break;
            }
        }
    }

    private void calculate() {
    }

    @Override
    protected void printMenu() {
        System.out.println("1. 계산기");
        System.out.println("2. 단위변환");
        System.out.println("3. 뒤로가기");
        System.out.print("입력: ");
    }
}
