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
		int n=0;
		
		do {
			printMenu();
			System.out.print("�Է�: ");
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
	
	protected String addMemo() {
		Scanner scan = new Scanner(System.in);		
		System.out.print("�޸� �߰�: ");
		String memo = scan.nextLine();
		memoList.add(memo);		
		isModified = true;
		setNewline();
		return memo;
	}
	
	protected void writeMemoFile() {
        try {
        	PrintWriter printWriter = new PrintWriter(FILENAME);
        	for (int i=0; i<memoList.size(); i++)
        		printWriter.println(memoList.get(i));
            printWriter.close();            
        } catch (Exception e) {
        	System.out.println("������ ã�� �� �����ϴ�");
        }
	}
	
	private void listMemo() {
		if (checkEmptyList())
			return;
    	for (int i=0; i<memoList.size(); i++)
    		System.out.println("["+(i+1)+"] "+memoList.get(i));
		setNewline();
	}
	
	private boolean checkEmptyList() {
		if (memoList.size()<1) {
			System.out.println("�޸����� ��� �ֽ��ϴ�");
			return true;
		}		
		return false;
	}
	
	private void updateMemo() {
		if (checkEmptyList())
			return;
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �޸��� ��ȣ: ");
		int id = scan.nextInt()-1;
		scan.nextLine();
		System.out.print("������ ����: ");
		String content = scan.nextLine();
		memoList.set(id, content);
		isModified = true;
		setNewline();
	}
	
	private void deleteMemo() {
		if (checkEmptyList())
			return;
		Scanner scan = new Scanner(System.in);				
		System.out.print("������ �޸��� ��ȣ: ");
		int id = scan.nextInt()-1;
		memoList.remove(id);
		isModified = true;
		setNewline();
	}

	protected void printMenu() {
		System.out.println("1. �޸� �߰�");
		System.out.println("2. �޸� ����Ʈ");
		System.out.println("3. �޸� ����");
		System.out.println("4. �޸� ����");
		System.out.println("5. �ڷΰ���");
	}
	
	private void setNewline() {
		System.out.println("");
	}
}
