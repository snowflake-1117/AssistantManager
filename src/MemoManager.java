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
				String newMemo = getMemo();
				addMemo(newMemo);
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

	protected String addMemo(String memo) {
		memoList.add(memo);
		isModified = true;
		setNewline();
		return memo;
	}
	
	private String getMemo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("메모 추가: ");
		String memo = scan.nextLine();	
		return memo;
	}

	private void listMemo() {
		if (isEmptyList())
			return;
		
		for (int i = 0; i < memoList.size(); i++)
			System.out.println("[" + (i + 1) + "] " + memoList.get(i));
		setNewline();
	}


	protected void updateMemo() {
		if (isEmptyList())
			return;

		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 메모 번호: ");
		int id = scan.nextInt() - 1;

		if (isInvalidId(id))
			return;

		scan.nextLine(); // 버퍼 비움

		System.out.print("수정할 내용: ");
		String content = scan.nextLine();
		memoList.set(id, content);

		isModified = true;
		setNewline();
		return;
	}

	private void deleteMemo() {

		if (isEmptyList())
			return;

		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 메모의 번호: ");
		int id = scan.nextInt() - 1;

		if (isInvalidId(id))
			return;

		memoList.remove(id);
		isModified = true;
		setNewline();
	}

	private boolean isEmptyList() {
		if (memoList.size() < 1) {
			System.out.println("메모장이 비어 있습니다");
			return true;
		}
		return false;
	}

	private boolean isInvalidId(int id) {
		if (id < 0 || id >= memoList.size()) {
			System.out.println("없는 번호입니다.");
			setNewline();
			return true;
		} 
		else
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