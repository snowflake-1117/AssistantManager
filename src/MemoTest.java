import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class MemoTest {
	MemoManager mm = new MemoManager();

	@Test
	public void addMemoTest() {
		String addedMemo = mm.addMemo("memo for addMemoTest");
		int lastNode = mm.memoList.size() - 1;
		assertEquals(addedMemo, mm.memoList.get(lastNode));
	}

	@Test
	public void writeMemoFileTest() throws IOException {
		mm.memoList.add("memo for writeMemoFileTest");
		int lastNode = mm.memoList.size() - 1;
		String memoLastLine = mm.memoList.get(lastNode);

		mm.writeMemoFile();

		String fileLastLine = getFileLastLine();
		assertEquals(memoLastLine, fileLastLine);
	}

	private String getFileLastLine() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("memoManager.txt"));
		String readLine = "", line;
		while (true) {
			line = bufferedReader.readLine();
			if (line == null)
				break;
			readLine = line;
		}
		bufferedReader.close();
		return readLine;
	}

}
