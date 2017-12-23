import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoManager extends Menu {
	protected ArrayList<String> memoList = new ArrayList<String>();
	private static final String FILENAME = "memoManager.txt";
	protected boolean isModified = false;

	public void showAndSelect() {
		Scanner scan = new Scanner(System.in);
		readMemoFile();
		int n = 0;

		do {
			printMenu();
			System.out.print("입력: ");
			n = scan.nextInt();

			switch (n) {
			case 1:
				addMemo();
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
			case 5:
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		} while (n != 5);

		if (isModified)
			writeMemoFile();
	}

	private void readMemoFile() {
		try {
			initializeList();
		} catch (IOException e) {
			return;
		}
	}

	private void initializeList() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME));
		while (true) {
			String line = bufferedReader.readLine();
			if (line == null)
				break;
			memoList.add(line);
		}
		bufferedReader.close();
	}

	protected void writeMemoFile() {
		try {
			PrintWriter printWriter = new PrintWriter(FILENAME);
			for (int i = 0; i < memoList.size(); i++)
				printWriter.println(memoList.get(i));
			printWriter.close();
		} catch (Exception e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}

	protected String addMemo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("메모 추가: ");
		String memo = scan.nextLine();
		memoList.add(memo);
		isModified = true;
		setNewline();
		return memo;
	}

	private void listMemo() {
		if (checkEmptyList())
			return;
		for (int i = 0; i < memoList.size(); i++)
			System.out.println("[" + (i + 1) + "] " + memoList.get(i));
		setNewline();
	}

	protected String[] updateMemo() {
		String updateInfo[] = {"", ""};
		if (checkEmptyList())
			return updateInfo;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 메모의 번호: ");
		int id = scan.nextInt() - 1;
		updateInfo[0] = Integer.toString(id);
		scan.nextLine(); //버퍼 비움
		
		System.out.print("수정할 내용: ");
		String content = scan.nextLine();
		memoList.set(id, content);
		updateInfo[1] = content;
		isModified = true;
		setNewline();
		return updateInfo;
	}

	private void deleteMemo() {
		if (checkEmptyList())
			return;
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 메모의 번호: ");
		int id = scan.nextInt() - 1;
		memoList.remove(id);
		isModified = true;
		setNewline();
	}

	private boolean checkEmptyList() {
		if (memoList.size() < 1) {
			System.out.println("메모장이 비어 있습니다");
			return true;
		}
		return false;
	}

	protected void printMenu() {
		System.out.println("1. 메모 추가");
		System.out.println("2. 메모 리스트");
		System.out.println("3. 메모 수정");
		System.out.println("4. 메모 삭제");
		System.out.println("5. 뒤로가기");
	}

	private void setNewline() {
		System.out.println("");
	}
}