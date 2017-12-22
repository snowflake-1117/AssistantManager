import java.io.Serializable;

public class Record implements Serializable {
	String [] data;
	Record (String date, String name, String price) {
		data = new String[3];
		data[0] = date;
		data[1] = name;
		data[2] = price;
	}
}
