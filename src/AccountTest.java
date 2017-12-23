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
		Record expected = new Record("2010.06.20","아이스크림","500"); 
		manager.insertToList(AccountManager.ENDOFLIST, expected);
		
		Record received = manager.checkInsertedRecord(AccountManager.ENDOFLIST);
		assertArrayEquals(expected.data, received.data);
	}
	
	@Test
	public void testUpdateRecord() {
		Record beforeValue = new Record("2015.12.25", "지지고","3500"); 
		Record changedValue = new Record("2017.12.25","칠면조 요리","350000"); 
		
		update(AccountManager.ENDOFLIST,beforeValue, changedValue);
		
		Record received = manager.checkInsertedRecord(AccountManager.ENDOFLIST);
		assertArrayEquals(changedValue.data, received.data);
	}
	
	public void update(int id,Record before, Record after) {
		manager.insertToList(AccountManager.ENDOFLIST, before);
		manager.deleteAt(id);
		manager.insertToList(id, after);
	} 
	
	@Test
	public void testDeleteRecord () {
		manager.deleteAt(AccountManager.ENDOFLIST);
	} 
	
	@After
	public void tearDown() {
		manager.tearDown();
	}
	
}
