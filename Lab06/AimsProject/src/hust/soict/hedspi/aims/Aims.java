package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int case1 = 0;
		Order anOrder = null;
        while (true){
            showMenu();
            String line = sc.nextLine();
            switch (line){
                case "1":
                    anOrder = new Order();
                    System.out.println("Create successfully");
                    case1 = 1;
                    break;
                case "2":
                    if(case1 == 0) {
    					System.err.println("Please create new order before add anything! ");
    					break;
				    }
                    showMenuMedia();
                    String type = sc.nextLine();
                    switch (type){
                        case "1":
                            addBookToOrder(anOrder,sc);
                            break;
                        case "2":
                            addDvdToOrder(anOrder,sc);
                        case "0":
                            System.out.println("Exit submenu!");
                            break;
                        default:
                            System.out.println("Syntax error !. Exit submenu!");
                            break;
                    }
                    break;
                case "3":
                    if(case1 == 0) {
                        System.err.println("The Media list is empty !");
                        break;
                    }
                    System.out.println("Enter id that you want to delete the item which has this id ");
                    int id = Integer.parseInt(sc.nextLine());
                    if(anOrder.searchById(id)==null)
                        System.out.println("Id not found !");
                    else {
                        anOrder.removeMedia(id);
                        System.out.println("Deleted !");
                    }
                    break;
                case "4":
                    if(case1 == 0) {
                        System.err.println("The Media list is empty !");
                        break;
                    }
                    System.out.println("The items list of order");
                    anOrder.printListOrder();
                    break;
                case "0":
                    sc.close();
                    System.out.println("Quit!");
                    return;
                default:
                    System.err.println("Syntax error!Please enter again!");
                    break;
            }
        }
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
    public static void showMenuMedia() {
        System.out.println("\tSelect Book or DVD ");
        System.out.println("\t_____________________");
        System.out.println("\t1. Book");
        System.out.println("\t2. DVD");
        System.out.println("\t0. Exit");
        System.out.println("\t_____________________");
        System.out.println("\tPlease choose a number: 0-1-2");
    }
    private static void addDvdToOrder(Order anOrder, Scanner sc) {
        int id;
        do {
            System.out.printf("\t\tEnter id: ");
            id = Integer.parseInt(sc.nextLine());
            if(anOrder.searchById(id)!=null){
                System.out.println("\t\tMedia which have this id is already exists. Please enter id again");
            }
        }while (anOrder.searchById(id)!=null);
        System.out.printf("\t\tEnter title: ");
        String title = sc.nextLine();
        System.out.printf("\t\tEnter category: ");
        String category = sc.nextLine();
        System.out.printf("\t\tEnter director: ");
        String director = sc.nextLine();
        System.out.printf("\t\tEnter cost: ");
        float cost = sc.nextFloat();
        System.out.printf("\t\tEnter length: ");
        int length = sc.nextInt();
        sc.nextLine();
        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
        anOrder.addMedia(dvd);
    }
    private static void addBookToOrder(Order anOrder,Scanner sc) {
        int id;
        do {
            System.out.printf("\t\tEnter id: ");
            id = Integer.parseInt(sc.nextLine());
            if(anOrder.searchById(id)!=null){
                System.out.println("\t\tMedia which have this id is already exists. Please enter id again");
            }
        }while (anOrder.searchById(id)!=null);
        System.out.printf("\t\tEnter title: ");
        String title = sc.nextLine();
        System.out.printf("\t\tEnter category: ");
        String category = sc.nextLine();
        System.out.printf("\t\tEnter cost: ");
        float cost = Float.parseFloat(sc.nextLine());
        Book book = new Book(id, title, category, cost);
        int numOfAuthors = 0;
        do {
            System.out.printf("\t\tEnter numbers of authors: ");
            numOfAuthors = Integer.parseInt(sc.nextLine());
            if(numOfAuthors <= 0)
                System.err.println("\t\tNumbers of authors must have >= 0. Please enter again");
        }while (numOfAuthors <=0);
        for(int i = 0 ; i< numOfAuthors ; i++) {
            System.out.printf("\t\tEnter author's name: ");
            String author = sc.nextLine();
            book.addAuthor(author);
        }
        anOrder.addMedia(book);
    }
}