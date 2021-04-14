package hust.soict.hedspi.test.utils;
import static hust.soict.hedspi.aims.utils.DateUtils.compare;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import hust.soict.hedspi.aims.utils.MyDate;
public class DateTest {
	public static void testCase1() {
		MyDate x = new MyDate("second", "September", "twenty nineteen");
		assertEquals("sai ngay",2,x.getDay());
		assertEquals("sai thang,",9,x.getMonth());
		assertEquals("sai nam",2019,x.getYear());
	}
	
	public static void testCase2() {
		MyDate x = new MyDate("second", "September", "twenty nineteen");
		x.print();
		x.print(1);
		x.print(2);
		x.print(3);
		x.print(4);
		x.print(5);
		x.print(6);
	}
	
	public static void testCase3() {
		MyDate x = new MyDate("twentieth-third", "February", "twenty hundred");
		assertEquals("sai ngay",23,x.getDay());
		assertEquals("sai thang,",2,x.getMonth());
		assertEquals("sai nam",2000,x.getYear());
	}
	
	public static void testCase4() {
		MyDate x = new MyDate("twentieth-third", "February", "twenty hundred");
		MyDate y = new MyDate(1,2,2000);
		assertTrue("so sanh sai",compare(x,y) != 1);
	}
	
	
	
	public static void main(String []args) {
		testCase1();
		testCase2();
		testCase3();
		testCase4();
	}
	
}
