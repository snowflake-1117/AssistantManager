import java.util.Scanner;

public class MemoManager extends Menu {
	
	public void showAndSelect() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		do {
			printMenu();
			switch (n) {
			case 1:
				createMemo();
				break;
			case 2:
				listMemo();
				break;
			case 3:
				updateMemo();
				break;
			case 4:
				deleteMemo();
				break;
			}
		} while (n != 5);
  }
	
	private void createMemo() {
		
	}
	
	private void listMemo() {
		
	}
	
	private void updateMemo() {
		
	}
	
	private void deleteMemo() {
		
	}

	protected void printMenu() {
		System.out.println("1. �޸� ����");
		System.out.println("2. �޸� ����Ʈ");
		System.out.println("3. �޸� ����");
		System.out.println("4. �޸� ����");
		System.out.println("5. �ڷΰ���");
	}
}
