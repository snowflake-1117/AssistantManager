import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class AccountManager extends Menu {
	private static final String FILENAME = "Accounts.txt";
	Scanner scanner;
	private Vector<Record> collection = new Vector<Record>();
	FileInputStream fis;
	ObjectInputStream ois;
	FileOutputStream fos;
	ObjectOutputStream oos;
	int id;
	int choice = -1;
	String date;
	String name;
	String price;

	@Override
	public void showAndSelect() {
		scanner = new Scanner(System.in);
		setup();
		run();
	}

	@Override
	protected void printMenu() {
		System.out.println("1. ����� ����");
		System.out.println("2. ����� ����Ʈ");
		System.out.println("3. ����� ����");
		System.out.println("4. ����� ����");
		System.out.println("5. �ڷΰ���");
	}

	protected void run() {
		while (choice != 5) {
			printMenu();

			System.out.print("�Է�: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				create();
				break;
			case 2:
				print();
				break;
			case 3:
				update();
				break;
			case 4:
				break;
			default:
				scanner.close();
				tearDown();
				break;
			}
		}

	}

	private void setup() {
		collection.clear();
		try {
			fis = new FileInputStream(FILENAME);
			ois = new ObjectInputStream(fis);
			Record temp;
			while ((temp = (Record) ois.readObject()) != null) {// ���� �̳����� �ʾҴٸ�
				collection.add(temp); // collection�� ����
				ois.close();
			}
			fos = new FileOutputStream(FILENAME);
			oos = new ObjectOutputStream(fos);
		} catch (Exception ex) {
		}

	}

	private void create() {
		System.out.println("���ڵ� ����");
		System.out.print("��¥:");
		date = scanner.nextLine();
		System.out.print("�̸�:");
		name = scanner.nextLine();
		System.out.print("����:");
		price = scanner.nextLine();
		Record temp = new Record(collection.size() + 1, date, name, price);
		collection.add(temp);
	}

	private void print() {
		System.out.println("���ڵ� ���");
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			Record record = (Record) iterator.next();
			System.out.println(String.format("%3s %3s %3s %3s", record.id, record.date, record.name, record.price));
		}
	}

	private void update() {
		System.out.println("���ڵ� ����");
		System.out.print("������ ���ڵ�:");
		id = scanner.nextInt();
		Record record = collection.get(id-1);
		System.out.print("��¥:");
		record.date = scanner.nextLine();
		System.out.print("�̸�:");
		record.name = scanner.nextLine();
		System.out.print("����:");
		record.price = scanner.nextLine();
		scanner.nextLine();
		collection.remove(id-1);
		collection.add(record);
	}

	private void tearDown(){
		try{
	      fos = new FileOutputStream(FILENAME);
	      oos = new ObjectOutputStream(fos);
	      for (Record record: collection) 
	    	  oos.writeObject((Record)record);
		}catch(Exception ex){}
	}
}
