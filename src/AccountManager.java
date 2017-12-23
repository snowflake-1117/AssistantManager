import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class AccountManager extends Menu {
	private static final String FILENAME = "Accounts.txt";
	private Scanner scanner;
	private Vector<Record> collection = new Vector<Record>();
	protected static int ENDOFLIST = 0;

	@Override
	public void showAndSelect() {
		scanner = new Scanner(System.in);
		setup();
		run();
	}

	@Override
	protected void printMenu() {
		System.out.println("\n1. 가계부 생성");
		System.out.println("2. 가계부 리스트");
		System.out.println("3. 가계부 수정");
		System.out.println("4. 가계부 삭제");
		System.out.println("5. 뒤로가기");
	}

	protected void run() {
		int choice = -1;
		while (choice != 5) {
			printMenu();

			System.out.print("입력: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				insertRecord(ENDOFLIST);
				break;
			case 2:
				printAccounts();
				break;
			case 3:
				updateRecord();
				break;
			case 4:
				deleteRecord();
				break;
			case 5:
			default:
				tearDown();
				System.out.println();
				break;
			}
		}
	}

	protected void setup() {
		FileInputStream fis;
		ObjectInputStream ois;
		collection.clear();
		try {
			fis = new FileInputStream(FILENAME);
			ois = new ObjectInputStream(fis);
			Record temp;
			while ((temp = (Record) ois.readObject()) != null) // 파일 이끝나지 않았다면
				collection.add(temp);
			ois.close();
			fis.close();
		} catch (Exception e) {
			// 처음 파일을 생성해서 아직 파일이 없다
		}
		ENDOFLIST = collection.size();
	}

	private void insertRecord(int id) {
		++ENDOFLIST;
		Record record = getData();
		insertToList(id, record);
	}

	private Record getData() {
		System.out.print("\n날짜(yyyy.mm.dd):");
		String date = scanner.nextLine();
		if (!date.matches("^\\d{4}.\\d{2}.\\d{2}"))
			date = "0000.00.00";
		System.out.print("이름:");
		String name = scanner.nextLine();
		System.out.print("가격:");
		String price = scanner.nextLine();

		Record record = new Record(date, name, price);
		return record;
	}

	protected Record insertToList(int id, Record record) {
		collection.add(id, record);
		return collection.get(id);
	}

	private void printAccounts() {
		Iterator<Record> iterator = collection.iterator();
		int id = 1;
		while (iterator.hasNext()) {
			Record record = (Record) iterator.next();
			System.out.println(String.format("%3s %3s %5s %3s", id++, record.data[0], record.data[1], record.data[2]));
		}
	}

	private void updateRecord() {
		System.out.print("\n레코드 id:");
		int id = scanner.nextInt() - 1;
		scanner.nextLine();
		deleteAt(id);
		insertRecord(id);

	}

	private int deleteRecord() {
		System.out.print("\n레코드 id:");
		int id = scanner.nextInt() - 1;
		scanner.nextLine();
		try {
			deleteAt(id);
		} catch (Exception ex) {
			System.out.println("해당 레코드는 존재하지 않습니다.");
		}
		return id;
	}

	protected void deleteAt(int id) {
		collection.remove(id);
	}

	protected Record checkInsertedRecord(int id) {
		return collection.get(id);
	}

	protected void tearDown() {
		FileOutputStream fileOutputStream;
		ObjectOutputStream objectOutputStream;
		File file = new File(FILENAME);
		try {
			if (!file.exists())
				file.createNewFile();
			fileOutputStream = new FileOutputStream(FILENAME, false);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for (Record record : collection)
				objectOutputStream.writeObject((Record) record);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
