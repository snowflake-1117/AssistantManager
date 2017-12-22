import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class MemoTest {
	MemoManager mm = new MemoManager();

	@Before
	public void listSetUp() {
		try {
			mm.initializeList();
		} catch (IOException e) {
		}
	}
	
	@Test
	public void addMemoTest() {
		String memo = mm.addMemo();
		int i = mm.memoList.size();
		assertEquals(memo, mm.memoList.get(i-1));
	}

}
