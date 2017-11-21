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
		System.out.println("1. 가계부 생성");
		System.out.println("2. 가계부 리스트");
		System.out.println("3. 가계부 수정");
		System.out.println("4. 가계부 삭제");
		System.out.println("5. 뒤로가기");
	}

	protected void run() {
		while (choice != 5) {
			printMenu();

			System.out.print("입력: ");
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
			while ((temp = (Record) ois.readObject()) != null) {// 파일 이끝나지 않았다면
				collection.add(temp); // collection에 저장
				ois.close();
			}
			fos = new FileOutputStream(FILENAME);
			oos = new ObjectOutputStream(fos);
		} catch (Exception ex) {
		}

	}

	private void create() {
		System.out.println("레코드 생성");
		System.out.print("날짜:");
		date = scanner.nextLine();
		System.out.print("이름:");
		name = scanner.nextLine();
		System.out.print("가격:");
		price = scanner.nextLine();
		Record temp = new Record(collection.size() + 1, date, name, price);
		collection.add(temp);
	}

	private void print() {
		System.out.println("레코드 출력");
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			Record record = (Record) iterator.next();
			System.out.println(String.format("%3s %3s %3s %3s", record.id, record.date, record.name, record.price));
		}
	}

	private void update() {
		System.out.println("레코드 수정");
		System.out.print("수정할 레코드:");
		id = scanner.nextInt();
		Record record = collection.get(id-1);
		System.out.print("날짜:");
		record.date = scanner.nextLine();
		System.out.print("이름:");
		record.name = scanner.nextLine();
		System.out.print("가격:");
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
