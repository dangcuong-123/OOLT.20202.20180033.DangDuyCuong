package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;
import hust.soict.hedspi.aims.*;

public class Aims {
    public static void main(String[] args) throws LimitExceededException {
        Scanner scan = new Scanner(System.in);
        int check = 0;
		Order anOrder = null;
        while (true){
            showMenu();
            String line = scan.nextLine();
            switch (line){
                case "1":
                	try {
                		anOrder = new Order();
                		System.out.println("Create successfully");
                		check = 1;
                		break;
                	} catch (LimitExceededException e) {
                        e.printStackTrace();
                    }
                	
                case "2":
                    if(check == 0) {
    					System.err.println("Please create new order!");
    					break;
				    }
                    showOrder();
                    String type = scan.nextLine();
                    switch (type){
                        case "1":
                        	addBook(anOrder,scan);
                            break;
                        case "2":
                        	addDvd(anOrder,scan);
                            break;
                        case "3":
                        	addCd(anOrder,scan);
                        	break;
                        case "0":
                            System.out.println("Exit submenu!");
                            break;
                        default:
                            System.out.println("Syntax error !. Exit submenu!");
                            break;
                    }
                    break;
                case "3":
                    if(check == 0) {
                        System.err.println("The Media list is empty !");
                        break;
                    }
                    System.out.println("Enter id that you want to delete the item: ");
                    int id = Integer.parseInt(scan.nextLine());
                    if(anOrder.searchById(id)==null)
                        System.out.println("Id not found !");
                    else {
                        anOrder.removeMedia(id);
                        System.out.println("Deleted !");
                    }
                    break;
                case "4":
                    if(check == 0) {
                        System.err.println("The Media list is empty !");
                        break;
                    }
                    System.out.println("The items list of order");
                    anOrder.printListOrder();
                    break;
                case "0":
                	scan.close();
                    System.out.println("Quit!");
                    return;
                default:
                    System.err.println("Syntax error!Please enter again!");
                    break;
            }
        }
    }
    public static void showOrder() {
        System.out.println("\tOrder");
        System.out.println("\t_____________________");
        System.out.println("\t1. Book");
        System.out.println("\t2. DVD");
        System.out.println("\t3. CD");
        System.out.println("\t0. Exit");
        System.out.println("\t_____________________");
        System.out.println("\tPlease choose a number: 0-1-2-3");
    }
    
	public static void showMenu(){
        System.out.println("Order Management Application");
        System.out.println("_____________________");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("_____________________");
        System.out.println("Please choose a number: 0-1-2-3-4");

    }
    
    private static void addDvd(Order anOrder, Scanner scan) {
        int id;
        do {
            System.out.printf("\t\tEnter id: ");
            id = Integer.parseInt(scan.nextLine());
            if(anOrder.searchById(id)!=null){
                System.out.println("\t\tThis id is already exists. Please enter id again");
            }
        }while (anOrder.searchById(id)!=null);
        System.out.printf("\t\tEnter title: ");
        String title = scan.nextLine();
        System.out.printf("\t\tEnter category: ");
        String category = scan.nextLine();
        System.out.printf("\t\tEnter director: ");
        String director = scan.nextLine();
        System.out.printf("\t\tEnter cost: ");
        float cost = scan.nextFloat();
        System.out.printf("\t\tEnter length: ");
        int length = scan.nextInt();
        scan.nextLine();
        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
        int choice;
        System.out.printf("\t\t\tDo you want to play ? ");
        System.out.printf("\t\t\t\t1.Yes");
        System.out.printf("\t\t\t\t2.No");
        System.out.println("\tPlease choose a number: 0-1");
        choice = scan.nextInt();
        switch (choice) {
        	case 1:
        		try {
        			System.out.println("\t_____________________");
                    dvd.play();
                    System.out.println("\t_____________________");
                } catch (PlayerException e) {
                    e.printStackTrace();
                }
        		
                break;
            case 2:
                break;
            default:
                System.err.println("Syntax error!");
        }
        scan.nextLine();
        try {
            anOrder.addMedia(dvd);
        } catch (AddMediaException e) {
            e.printStackTrace();
        }
    }
    
    private static void addBook(Order anOrder,Scanner scan) {
        int id;
        do {
            System.out.printf("\t\tEnter id: ");
            id = Integer.parseInt(scan.nextLine());
            if(anOrder.searchById(id)!=null){
                System.out.println("\t\tThis id is already exists. Please enter id again");
            }
        }while (anOrder.searchById(id)!=null);
        System.out.printf("\t\tEnter title: ");
        String title = scan.nextLine();
        System.out.printf("\t\tEnter category: ");
        String category = scan.nextLine();
        System.out.printf("\t\tEnter cost: ");
        float cost = Float.parseFloat(scan.nextLine());
        Book book = new Book(id, title, category, cost);
        
        int count = 0;
        do {
            System.out.printf("\t\tEnter numbers of authors: ");
            count = Integer.parseInt(scan.nextLine());
            if(count <= 0)
                System.err.println("\t\tPlease enter again! (Numbers of authors must >= 0)");
        }while (count <=0);
        
        for(int i = 0 ; i< count ; i++) {
            System.out.printf("\t\tEnter author's name: ");
            String author = scan.nextLine();
            book.addAuthor(author);
        }
        try {
        	anOrder.addMedia(book);
        } catch (AddMediaException e) {
            e.printStackTrace();
        }
        
    }
    private static void addCd(Order anOrder, Scanner scan) {
    	int id;
        do {
            System.out.printf("\t\tEnter id: ");
            id = Integer.parseInt(scan.nextLine());
            if(anOrder.searchById(id)!=null){
                System.out.println("\t\tThis id is already exists. Please enter id again");
            }
        }while (anOrder.searchById(id)!=null);
        System.out.printf("\t\tEnter title: ");
        String title = scan.nextLine();
        System.out.printf("\t\tEnter category: ");
        String category = scan.nextLine();
        System.out.printf("\t\tEnter artist: ");
        String artist = scan.nextLine();
        System.out.printf("\t\tEnter cost: ");
        float cost = scan.nextFloat();
        scan.nextLine();
        System.out.printf("\t\tEnter numbers of list Track: ");
        int count = scan.nextInt();
        while(count <= 0) {
            System.err.println("\t\tPlease enter again! (Numbers of authors must have >= 0)");
            System.out.printf("\t\tnter numbers of list Track:  ");
            count = scan.nextInt();
        }
        scan.nextLine();
        CompactDisc cd = new CompactDisc(id, title, category,cost ,artist);
        Track track = new Track();
        String titleTrack;
        int lengthTrack;
        for(int i = 0; i < count; i++) {
            System.out.println("***\t\t\tTrack " + (i+1));
            System.out.printf("\t\t\tEnter title of track: ");
            titleTrack = scan.nextLine();
            System.out.printf("\t\t\tEnter length of track: ");
            lengthTrack = scan.nextInt();
            track = new Track(titleTrack, lengthTrack);
            cd.addTrack(track);
            scan.nextLine();
        }
        int choice;
        System.out.printf("\t\t\tDo you want to play ? ");
        System.out.printf("\t\t\t\t1.Yes");
        System.out.printf("\t\t\t\t2.No");
        System.out.println("\tPlease choose a number: 0-1");
        choice = scan.nextInt();
        switch (choice) {
        	case 1:
        		try {
        			System.out.println("\t_____________________");
                    cd.play();
                    System.out.println("\t_____________________");
                } catch (PlayerException e) {
                    e.printStackTrace();
                }
        		
                break;
            case 2:
                break;
            default:
                System.err.println("Syntax error!");
        }
        scan.nextLine();
        try {
        	anOrder.addMedia(cd);
        } catch (AddMediaException e) {
            e.printStackTrace();
        }
        
	}
}