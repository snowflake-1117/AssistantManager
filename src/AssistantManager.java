import java.util.Scanner;

public class AssistantManager extends Menu {

	public static void main(String[] args) {
		AssistantManager manager = new AssistantManager();
		manager.showAndSelect();
	}
	
	@Override
	public void showAndSelect() {
		int choice=-1;
		Scanner scanner = new Scanner(System.in);

		while (choice != 4) {
            printMenu();

			System.out.print("�Է�: ");
			choice = scanner.nextInt();
			
			switch (choice) {
				case 1:
					CalculatorManager calculator = new CalculatorManager();
					calculator.showAndSelect();
					break;
				case 2:
					MemoManager memo = new MemoManager();
					memo.showAndSelect();
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					scanner.close();
					break;
			}
		}
	}
	
	@Override
	protected void printMenu() {
		System.out.println("1.���� ");
		System.out.println("2.�޸��� ");
		System.out.println("3.����� ");
		System.out.println("4.����");
	}
}
