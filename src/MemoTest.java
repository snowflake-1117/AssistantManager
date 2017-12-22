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
		int lastNode = mm.memoList.size()-1;
		String memoLastLine = mm.memoList.get(lastNode);
		mm.writeMemoFile();

		BufferedReader bufferedReader = new BufferedReader(new FileReader("MemoManager.txt"));		
		String readLine[] = new String[2];
		int i = 0;
		while (true) {
			String line = bufferedReader.readLine();
			readLine[(i%2)] = line;
			i++;
			if (line == null)
				break;
		}
		String fileLastLine = readLine[i%2];
		assertEquals(memoLastLine, fileLastLine);
			
	}
	
	

}
