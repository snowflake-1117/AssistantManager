import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    AccountManager manager;
    Record baseRecord, secondRecord;

    @Before
    public void setup() {
        manager = new AccountManager();
        manager.setup();

        baseRecord = new Record("2015.12.25", "book", "25000");
        secondRecord = new Record("2016.12.25", "GG-GO", "3500");
    }

    @Test
    public void testCreateRecord() {
        Record receivedRecord = manager.insertAt(AccountManager.ENDOFLIST, baseRecord);
        assertArrayEquals(baseRecord.data, receivedRecord.data);
    }

    @Test
    public void testUpdateRecord() {
        manager.insertAt(AccountManager.ENDOFLIST, baseRecord);
        Record result = manager.updateAt(AccountManager.ENDOFLIST, secondRecord);

        assertArrayEquals(secondRecord.data, result.data);
    }


    @Test
    public void testDeleteRecord() {
        manager.insertAt(AccountManager.ENDOFLIST, baseRecord);
        manager.insertAt(AccountManager.ENDOFLIST, secondRecord);
        manager.deleteAt(AccountManager.ENDOFLIST);

        Record result = manager.getRecord(AccountManager.ENDOFLIST);

        assertArrayEquals(baseRecord.data, result.data);
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