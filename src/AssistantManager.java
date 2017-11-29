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
			System.out.print("입력: ");
      
			choice = scanner.nextInt();
			scanner.nextLine();
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
					AccountManager account = new AccountManager();
					account.showAndSelect();
					break;
				case 4:
					default:
					break;
			}
		}
		scanner.close();
	}
	
	@Override
	protected void printMenu() {
		System.out.println("1.계산기 ");
		System.out.println("2.메모장 ");
		System.out.println("3.가계부 ");
		System.out.println("4.종료");
	}
}
