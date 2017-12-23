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
		Record expected = new Record("2010.06.20", "아이스크림", "500");
		Record received = manager.insertToList(AccountManager.ENDOFLIST, expected);

		assertArrayEquals(expected.data, received.data);
	}

	@Test
	public void testUpdateRecord() {
		Record beforeValue = new Record("2015.12.25", "지지고 1단계", "3500");
		Record changedValue = new Record("2017.12.25", "지지고 2단계/치즈", "4000");
		Record received = update(AccountManager.ENDOFLIST, beforeValue, changedValue);

		assertArrayEquals(changedValue.data, received.data);
	}

	public Record update(int id, Record before, Record after) {
		manager.insertToList(id, before);
		manager.deleteAt(id);
		Record record = manager.insertToList(id, after);
		return record;
	}

	@After
	public void tearDown() {
		try {
			manager.deleteAt(AccountManager.ENDOFLIST);
			manager.tearDown();
		} catch (Exception ex) {
		}
	}

}
