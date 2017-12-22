import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {
	AccountManager manager;
	
	@Test
	public void testCreateRecord() {
		manager = new AccountManager();
		manager.setup();
		
		String date = "2017.12.25";
		String name = "아이스크림 케익";
		String price = "34500";
		
		Record expected = new Record(date,name,price); 
		manager.insertToList(AccountManager.ENDOFLIST, date,name,price);
		Record received = manager.checkInsertedRecord(AccountManager.ENDOFLIST);
		assertArrayEquals(expected.data, received.data);
	}
	
	@Test
	public void testWrittenToFile() {
		
	}
}
