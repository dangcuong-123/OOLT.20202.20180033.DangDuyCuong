package hust.soict.hedspi.test.book;

import java.util.ArrayList;
import java.util.Collection;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;

public class BookTest {
	
	public static void testcase1() {
		System.out.println("Test 1");
		Book dvd1 = new Book(1,"The Lion King");
		dvd1.setCost(19.95f);
		
		Book dvd2 = new Book(2,"Star Wars");
		dvd2.setCost(24.95f);
		
		Book dvd3 = new Book(3,"Aladdin");
		dvd3.setCost(18.99f);
		
		Collection collection = new ArrayList();
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		// unsort
		java.util.Iterator iterator = collection.iterator();
		
		System.out.println("----------------------------------");
		System.out.println("The lists currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((Book) iterator.next()).getTitle());
		}
		
		//sort
		java.util.Collections.sort((java.util.List) collection); 
		iterator = collection.iterator();
		System.out.println("----------------------------------");
		System.out.println("The lists in sorted order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((Book) iterator.next()).getTitle());
		}
	}
	
	public static void testcase2() {
		System.out.println("Test 2");
		Book dvd1 = new Book(1,"The Lion King");
		dvd1.setCost(19.95f);
		dvd1.setContent("This is a book1");
		
		Book dvd2 = new Book(2,"Star Wars");
		dvd2.setCost(24.95f);
		dvd2.setContent("This is a book2. this book is funny");
		
		Book dvd3 = new Book(3,"Aladdin");
		dvd3.setCost(18.99f);
		dvd3.setContent("This is a book3. this book is story");
		
		Collection collection = new ArrayList();
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		java.util.Iterator iterator = collection.iterator();
		
		//sort
		java.util.Collections.sort((java.util.List) collection); 
		iterator = collection.iterator();
		System.out.println("----------------------------------");
		System.out.println("The lists in sorted order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((Book) iterator.next()).getTitle());
		}
		iterator = collection.iterator();
		System.out.println("----------------------------------");
		System.out.println("print info book: ");
		while(iterator.hasNext()) {
			System.out.println(((Book) iterator.next()).toString());
		}
	}
	
	public static void main(String[] args) {
		testcase1();
		testcase2();
	}

}
