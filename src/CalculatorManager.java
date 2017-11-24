import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class CalculatorManager extends Menu {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showAndSelect() {
        int choice = -1;

        while (choice != 3) {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();// Prevent to skip Numerical expression input
                    System.out.print("수식 입력: ");
                    String numericalExpression = scanner.nextLine();
                    String result = calculate(numericalExpression);
                    System.out.println("답: " + result);
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

    private String calculate(String numericalExpression) {
        if(numericalExpression.equals("")){
            return "0";
        }

        double result = 0;
        result = calculateByOperators(numericalExpression, result);

        final String DECIMAL_FORMAT = "#.######";
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);

        return decimalFormat.format(result);
    }

    private double calculateByOperators(String numericalExpression, double result) {
        Stack<Double> stackForCalculate = new Stack<>();
        StringTokenizer number = new StringTokenizer(numericalExpression, "+-/* ");
        StringTokenizer operator = new StringTokenizer(numericalExpression, "1234567890. ");

        stackForCalculate.push(Double.parseDouble(number.nextToken()));
        while (number.hasMoreTokens()) {
            char currentOperator = operator.nextToken().charAt(0);
            String num = number.nextToken();
            double operand;

            switch (currentOperator) {
                case '+':
                    stackForCalculate.push(Double.parseDouble(num));
                    break;
                case '-':
                    stackForCalculate.push(-Double.parseDouble(num));
                    break;
                case '*':
                    operand = stackForCalculate.pop();
                    operand *= Double.parseDouble(num);
                    stackForCalculate.push(operand);
                    break;
                case '/':
                    operand = stackForCalculate.pop();
                    operand /= Double.parseDouble(num);
                    stackForCalculate.push(operand);
            }
        }

        while (!stackForCalculate.isEmpty()) {
            result += stackForCalculate.pop();
        }

        return result;
    }

    @Override
    protected void printMenu() {
        System.out.println("1. 계산기");
        System.out.println("2. 단위변환");
        System.out.println("3. 뒤로가기");
        System.out.print("입력: ");
    }
}
