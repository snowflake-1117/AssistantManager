import java.io.Serializable;

public class Record implements Serializable {
	int id;
	String date;
	String name;
	String price;
	
	Record(int id, String date, String name, String price) {
		this.id = id;
		this.date = date;
		this.name = name;
		this.price = price;
	}
}
