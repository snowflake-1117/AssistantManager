import java.util.Scanner;

public class MemoManager {
	
	public void showAndSelect() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		do {
			printMenu();
			switch (n) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
		} while (n != 5);
  }

	protected void printMenu() {
		System.out.println("1. 메모 생성");
		System.out.println("2. 메모 리스트");
		System.out.println("3. 메모 수정");
		System.out.println("4. 메모 삭제");
		System.out.println("5. 뒤로가기");
	}
}
