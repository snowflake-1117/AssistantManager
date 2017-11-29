import java.io.File;
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
	private Scanner scanner;
	private Vector<Record> collection = new Vector<Record>();
	private Record record;

	@Override
	public void showAndSelect() {
		scanner = new Scanner(System.in);
		setup();
		run();
		tearDown();

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
		int choice = -1;
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
				delete();
				break;
			case 5:
			default:
				break;
			}
		}
	}

	private void setup() {
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

	}

	private void create() {
		System.out.println("레코드 생성");
		record = new Record();
		getDate();
		getName();
		getPrice();
		collection.add(record);
	}

	private void getDate() {
		System.out.print("날짜(yyyy.mm.dd):");
		String dateInput = scanner.nextLine();
		if (dateInput.matches("^\\d{4}.\\d{2}.\\d{2}"))
			record.date = dateInput;
		else
			record.date = "0000.00.00";
	}

	private void getName() {
		System.out.print("이름:");
		record.name = scanner.nextLine();
	}

	private void getPrice() {
		System.out.print("가격:");
		record.price = scanner.nextLine();
	}

	private void print() {
		System.out.println("레코드 출력");
		Iterator iterator = collection.iterator();
		int id = 1;
		while (iterator.hasNext()) {
			Record record = (Record) iterator.next();
			System.out.println(String.format("%3s %3s %3s %3s", id++, record.date, record.name, record.price));
		}
	}

	private void update() {
		System.out.print("수정할 레코드:");
		int id = scanner.nextInt() - 1;
		scanner.nextLine();
		try {
			record = collection.get(id);
			collection.remove(id);
			getDate();
			getName();
			getPrice();
			collection.add(id, record);
		} catch (Exception ex) {
			System.out.println("해당 레코드는 존재하지 않습니다.");
		}
	}

	private void delete() {
		System.out.print("삭제할 레코드:");
		int id = scanner.nextInt() - 1;
		scanner.nextLine();
		try {
			record = collection.get(id);
			collection.remove(id);
		} catch (Exception ex) {
			System.out.println("해당 레코드는 존재하지 않습니다.");
		}
	}

	private void tearDown() {

		FileOutputStream fos;
		ObjectOutputStream oos;
		File file = new File(FILENAME);
		try {
			if (!file.exists())
				file.createNewFile();
			fos = new FileOutputStream(FILENAME, false);
			oos = new ObjectOutputStream(fos);
			for (Record record : collection)
				oos.writeObject((Record) record);
			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
