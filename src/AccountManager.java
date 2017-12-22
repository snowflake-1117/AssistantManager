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
		tearDown();
	}

	@Override
	protected void printMenu() {
		System.out.println("\n1. ����� ����");
		System.out.println("2. ����� ����Ʈ");
		System.out.println("3. ����� ����");
		System.out.println("4. ����� ����");
		System.out.println("5. �ڷΰ���");
	}

	protected void run() {
		int choice = -1;
		while (choice != 5) {
			printMenu();
			
			System.out.print("�Է�: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				insertRecordAt(ENDOFLIST);
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
			while ((temp = (Record) ois.readObject()) != null) // ���� �̳����� �ʾҴٸ�
				collection.add(temp);
			ois.close();
			fis.close();
		} catch (Exception e) {
			// ó�� ������ �����ؼ� ���� ������ ����
		}
		ENDOFLIST = collection.size();
	}

	private void insertRecordAt(int id) {
		++ ENDOFLIST;
		System.out.print("\n��¥(yyyy.mm.dd):");
		String date = scanner.nextLine();
		if (!date.matches("^\\d{4}.\\d{2}.\\d{2}"))
			date = "0000.00.00";
		System.out.print("�̸�:");
		String name = scanner.nextLine();
		System.out.print("����:");
		String price = scanner.nextLine();
		
		insetToList(id,  date, name, price);
	}
	
	protected void insetToList(int id, String date, String name, String price) {
		Record record = new Record(date,name,price);
		collection.add(id,record);
	}
	
	private void printAccounts() {
		
		Iterator<Record> iterator = collection.iterator();
		int id = 1;
		while (iterator.hasNext()) {
			Record record = (Record) iterator.next();
			System.out.println(String.format("%3s %3s %3s %3s", id++, record.data[0], record.data[1], record.data[2]));
		}
	}

	private void updateRecord() {
			int id = deleteRecord();
			insertRecordAt(id);
	}

	private int deleteRecord() {
		System.out.print("\n���ڵ� id:");
		int id = scanner.nextInt() - 1;
		scanner.nextLine();
		try {
			collection.remove(id);
		} catch (Exception ex) {
			System.out.println("�ش� ���ڵ�� �������� �ʽ��ϴ�.");
		}
		return id;
	}
	
	protected Record checkInsertedRecord(int id){
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
