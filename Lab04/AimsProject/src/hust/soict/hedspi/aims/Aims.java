package hust.soict.hedspi.aims;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.MediaComparatorByCostTitle;
import hust.soict.hedspi.aims.media.MediaComparatorByTitleCost;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;

public class Aims {
	 static Scanner scanner = new Scanner(System.in);
	 static Store store = new Store();
	 static Cart cart = new Cart();
	 public static void main(String[] args) {
			DigitalVideoDisc dvd1 = new DigitalVideoDisc(10,"The Lion King","Animation","Roger Allers",87,19.95f);
	        DigitalVideoDisc dvd2 = new DigitalVideoDisc(12,"Star Wars","Science Fiction","George Lucas",87,24.95f);
	        DigitalVideoDisc dvd3 = new DigitalVideoDisc(15,"Aladin","Animation","minh",210, 18.99f);
	        Book book1 = new Book(5,"Clean Code", "Programming", 45.5f, Arrays.asList("Robert C. Martin"));
	        Book book2 = new Book(3,"The Pragmatic Programmer", "Programming", 50.0f, Arrays.asList("Andrew Hunt David Thomas"));
	        DigitalVideoDisc dvd4 = new DigitalVideoDisc(20, "Inception", "Science Fiction", "Christopher Nolan", 148, 29.99f);
	        DigitalVideoDisc dvd5 = new DigitalVideoDisc(21, "Interstellar", "Science Fiction", "Christopher Nolan", 169, 34.99f);
	        DigitalVideoDisc dvd6 = new DigitalVideoDisc(22, "Avengers: Endgame", "Action", "Anthony Russo", 181, 39.95f);
	        DigitalVideoDisc dvd7 = new DigitalVideoDisc(23, "Frozen", "Animation", "Chris Buck", 102, 21.50f);
	        Book book3 = new Book(6, "Design Patterns", "Software Engineering", 55.0f, Arrays.asList("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"));
	        Book book4 = new Book(7, "Introduction to Algorithms", "Algorithms", 70.0f, Arrays.asList("Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein"));
	        Book book5 = new Book(8, "Artificial Intelligence: A Modern Approach", "AI", 80.0f, Arrays.asList("Stuart Russell", "Peter Norvig"));
	        Book book6 = new Book(9, "Refactoring", "Programming", 47.25f, Arrays.asList("Martin Fowler"));
	        store.addMedia(dvd1);
	        store.addMedia(dvd2);
	        store.addMedia(dvd3);
	        store.addMedia(book1);
	        store.addMedia(book2);
	        cart.addMedia(dvd1);
	        cart.addMedia(dvd2);
	        store.addMedia(dvd4);
	        store.addMedia(dvd5);
	        store.addMedia(dvd6);
	        store.addMedia(dvd7);
	        store.addMedia(book3);
	        store.addMedia(book4);
	        store.addMedia(book5);
	        store.addMedia(book6);
	        showMenu();
		}
	public static void showMenu() {
		while(true) {
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");

			int choice = scanner.nextInt();
            if (choice == 0) {
            	System.out.println("Exit");
                break;
            }
            else if (choice == 1) {
                store.printStore();
                storeMenu();
            }
            else if (choice == 2) {
                updateStore();
            }
            else if (choice == 3) {
            	cart.print();
                cartMenu();
            }
            else System.out.println("invalid choice, pls try again");
		}

	}

	public static void storeMenu() {
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");

			int choice = scanner.nextInt();
            if (choice == 0) {
            	break;
            }
            else if (choice == 1) {
                System.out.print("title: ");
                scanner.nextLine();
                String mediaName = scanner.nextLine();
                Media media = store.getMedia(mediaName);
                if (media == null) System.out.println(" not found.");
                else mediaDetailsMenu(media);
            }
            else if (choice == 2) {
                System.out.print("title: ");
                scanner.nextLine();
                String mediaName = scanner.nextLine();
                Media media = store.getMedia(mediaName);
                if (media == null) System.out.println(" not found this one");
                else cart.addMedia(media);
            }
            else if (choice == 3) {
                System.out.print("title: ");
                scanner.nextLine();
                String mediaName = scanner.nextLine();
                Media media = store.getMedia(mediaName);
                if (media == null) System.out.println(" not found.");
                else if (media instanceof Book) System.out.println("cant playing book");
                else System.out.println("playing this one");
            }
            else if (choice == 4) {
            	cart.print();
            	cartMenu();
            }
		}
	}

	public static void mediaDetailsMenu(Media media) {
		while(true) {
			System.out.println("Options: ");
			System.out.println("----------------------------------");
			System.out.println("1. Add to cart");
			 System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("---------------------------------");
			System.out.print("Please choose a number: 0-1");

			int choice = scanner.nextInt();
			if (choice == 0) {
				System.out.println("back");
				break;
			}
			else if (choice == 1)  cart.addMedia(media);
			else if (choice == 2) {
				if (media instanceof Book) System.out.println("cant play book");
				else System.out.println("playing this one");
			}
		}
	}
	
	public static void cartMenu() {
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");

			int choice = scanner.nextInt();
			
    		if (choice == 0) {
    			System.out.println("back");
    			break;
    		}
            else if (choice == 1) {
           		System.out.println("choose one: ");
           		System.out.println("1. By id");
           		System.out.println("2. By title");
           		
           		int choi = scanner.nextInt();
           		
           		if (choi == 1) {
           			System.out.println("id: ");
           			int id = scanner.nextInt();
           			ArrayList<Media> media = cart.filterById(id);
           			if (!media.isEmpty()){
           				for (Media item : media) {
           					System.out.println(item.toString());
           				}
           			}
           			else System.out.println(" not found");
           		}
           		else if (choi == 2) {
           			System.out.println("title: ");
           			scanner.nextLine();
           			String title = scanner.nextLine();
           			ArrayList<Media> media = cart.filterByTitle(title);
           			if (!media.isEmpty()) {
           				for (Media item : media) {
           					System.out.println(item.toString());
           				}
           			}
           			else System.out.println(" not found");
           		}
            }
            else if (choice == 2) {
               	System.out.println("choose one: ");
               	System.out.println("1. By title");
               	System.out.println("2. By cost");
               	int choi = scanner.nextInt();
               	if (choi == 1)  cart.sortMediaByTitle();
               	else if (choi == 2)  cart.sortMediaByCost(); 
            }
    		else if (choice == 3) {
                System.out.print("title: ");
                scanner.nextLine();
                String mediaName = scanner.nextLine();
                Media media = cart.search(mediaName);
                if (media == null) System.out.println(" not found");
                else cart.removeMedia(media);
    		}
    		else if (choice == 4) {
                System.out.print("title: ");
                scanner.nextLine();
                String mediaName = scanner.nextLine();
                Media media = store.getMedia(mediaName);
                if (media == null || media instanceof Book) System.out.println(" cant play");
                else System.out.println("playing this");
    		}
    		else if (choice == 5) {
                System.out.println("created order");
                System.out.println("clear cart");
                cart = new Cart();
    		}
		}
	}

    public static void updateStore() {
    	while(true) {
    		System.out.println("choose: ");
    		System.out.println("--------------------------------");
    		System.out.println("1. Add a media to store");
    		System.out.println("2. Remove a media from store");
    		System.out.println("0. Back");
    		System.out.println("--------------------------------");

    		int choice = scanner.nextInt();
    		if (choice == 0) {
    			System.out.println("back");
    			break;
    		}
    		else if (choice == 1) {
    			addamedia();
    		}
    		else if (choice == 2) {
    			scanner.nextLine();
    			System.out.print("title: ");
    			String mediaName = scanner.nextLine();
    			Media media = store.getMedia(mediaName);
    			store.removeMedia(media);
    		}
    	}
    }

    static public void addamedia(){
       	System.out.println("add!");

   }
	

}