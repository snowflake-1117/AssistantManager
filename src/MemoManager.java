import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoManager extends Menu {
	private ArrayList<String> memoList = new ArrayList<String>();
	private static final String FILENAME = "memoManager.txt";
	private boolean isModified=true;
	
	public void showAndSelect() {
		Scanner scan = new Scanner(System.in);
		readMemoFile();
		int n=0;
		
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
			}
		} while (n != 5);
		
		if (isModified)
			writeMemoFile();
  }
	
	private void readMemoFile() {
		try {
			initializeList();
		}
		catch (IOException e) {
			File file = new File(FILENAME);
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
	}
	
	private void addMemo() {
		Scanner scan = new Scanner(System.in);		
		System.out.print("메모 추가: ");
		String memo = scan.nextLine();
		memoList.add(memo);		
		isModified = true;
	}
	
	private void writeMemoFile() {
        try {
        	PrintWriter printWriter = new PrintWriter(FILENAME);
        	for (int i=0; i<memoList.size(); i++)
        		printWriter.println(memoList.get(i));
            printWriter.close();
            
        } catch (Exception e) {
        	System.out.println("파일을 찾을 수 없습니다");
        }
	}
	
	private void listMemo() {
    	for (int i=0; i<memoList.size(); i++)
    		System.out.println(memoList.get(i));
	}
	
	private void updateMemo() {
		
	}
	
	private void deleteMemo() {
		
	}

	protected void printMenu() {
		System.out.println("1. 메모 추가");
		System.out.println("2. 메모 리스트");
		System.out.println("3. 메모 수정");
		System.out.println("4. 메모 삭제");
		System.out.println("5. 뒤로가기");
	}
}
