import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	AccountManager manager;
	
	@Before
	public void setup() {
		manager = new AccountManager();
		manager.setup();
	}
	
	@Test
	public void testCreateRecord() {
		
		String date = "2010.06.20";
		String name = "���̽�ũ��";
		String price = "500";
		
		Record expected = new Record(date,name,price); 
		manager.insertToList(AccountManager.ENDOFLIST, date,name,price);
		Record received = manager.checkInsertedRecord(AccountManager.ENDOFLIST);
		assertArrayEquals(expected.data, received.data);
	}
	
	@Test
	public void testUpdateRecord() {
		String date = "2017.12.25";
		String name = "���̽�ũ�� ����";
		String price = "34500";
		
		Record expected = new Record(date,name,price); 
		manager.deleteAt(AccountManager.ENDOFLIST);
		manager.insertToList(AccountManager.ENDOFLIST, date,name,price);
		Record received = manager.checkInsertedRecord(AccountManager.ENDOFLIST);
		assertArrayEquals(expected.data, received.data);
	}
	
	@After
	public void tearDown() {
		manager.tearDown();
	}
	
}
