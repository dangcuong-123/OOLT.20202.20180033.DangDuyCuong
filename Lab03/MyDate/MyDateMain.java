
public class MyDateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate a = new MyDate("February 18th 2019");
		a.print();
		
		a = new MyDate(2,5,2000);
		a.print();
		
		a = new MyDate();
		a.print();
		
		a.accept();
		a.print();
	}
}
