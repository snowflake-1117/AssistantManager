import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class MemoTest {
	static MemoManager mm = new MemoManager();

	@BeforeClass
	public static void listSetUp() {
		mm.readMemoFile();
		mm.listMemo();
	}
	
	@Test
	public void writeToListTest() {
		String addedMemo = mm.addMemo();
		int lastNode = mm.memoList.size()-1;
		assertEquals(addedMemo, mm.memoList.get(lastNode));
	}
	
	@Test
	public void writeToFileTest() throws IOException {
		mm.memoList.add("memo for file write test");
		int lastNode = mm.memoList.size()-1;
		String memoLastLine = mm.memoList.get(lastNode);
		mm.writeMemoFile();

		BufferedReader bufferedReader = new BufferedReader(new FileReader("MemoManager.txt"));		
		String readLine = "", line;
		while (true) {
			line = bufferedReader.readLine();
			if (line == null)
				break;
			readLine = line;
		}
		bufferedReader.close();
		String fileLastLine = readLine;
		assertEquals(memoLastLine, fileLastLine);
			
	}
	
	

}
