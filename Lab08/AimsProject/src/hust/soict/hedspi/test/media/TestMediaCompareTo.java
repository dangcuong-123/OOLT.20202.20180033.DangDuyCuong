package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Collection;
public class TestMediaCompareTo {
	
	public static void testcase1() {
		System.out.println("Test 1");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory ("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		Collection collection = new ArrayList();
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		// unsort
		java.util.Iterator iterator = collection.iterator();
		
		System.out.println("----------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		
		//sort
		java.util.Collections.sort((java.util.List) collection); 
		iterator = collection.iterator();
		System.out.println("----------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
	}
	
	public static void testcase2() {
		System.out.println("Test 2");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory ("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		Collection collection = new ArrayList();
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		// unsort
		java.util.Iterator iterator = collection.iterator();
		
		System.out.println("----------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		
		//sort
		java.util.Collections.sort((java.util.List) collection); 
		iterator = collection.iterator();
		System.out.println("----------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		// remove order 
		collection.remove(dvd1);
		iterator = collection.iterator();
		System.out.println("----------------------------------");
		System.out.println("The DVDs in remove order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
	}
	
	public static void testcase3() {
		System.out.println("Test 3");
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
		System.out.println("The Books currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((Book) iterator.next()).getTitle());
		}
		
		//sort
		java.util.Collections.sort((java.util.List) collection); 
		iterator = collection.iterator();
		System.out.println("----------------------------------");
		System.out.println("The Books in sorted order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((Book) iterator.next()).getTitle());
		}
	}
	
	public static void testcase4() {
		System.out.println("Test 4");
		Book dvd1 = new Book(1,"The Lion King");
		dvd1.setCost(19.95f);
		
		CompactDisc dvd2 = new CompactDisc(2,"Star Wars");
		dvd2.setCost(24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
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
			System.out.println(((Media) iterator.next()).getTitle());
		}
		
		//sort
		java.util.Collections.sort((java.util.List) collection); 
		iterator = collection.iterator();
		System.out.println("----------------------------------");
		System.out.println("The lists in sorted order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((Media) iterator.next()).getTitle());
		}
	}
	
	public static void main(String[] args) {
		testcase1();
		testcase2();
		testcase3();
		testcase4();
	}

}
