import java.util.Scanner;

public class AssistantManager extends Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			
			switch (choice) {
				case 1:
					break;
				case 2:
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
		System.out.println("1.계산기 ");
		System.out.println("2.메모장 ");
		System.out.println("3.가계부 ");
		System.out.println("4.종료");
	}
}
