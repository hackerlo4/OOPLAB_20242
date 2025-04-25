package hust.soict.dsai.aims;
import java.util.Arrays;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
public class Aims {
	static Scanner scanner = new Scanner(System.in);
	 static Store store = new Store();
	 static Cart cart = new Cart();
	public static void main(String[] args) {
		CompactDisc cd1 = new CompactDisc(1, "xamvn.test", "Pop", 20.0f, 36, "manhthuong");
		CompactDisc cd2 = new CompactDisc(2, "cd2 title", "Rock", 25.5f, 45, "artist2");
		store.addMedia(cd1);
		store.addMedia(cd2);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(3, "dien dan xamvn", "Country", 30.0f, 96, "xuanha");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(4, "dvd2 title", "Action", 15.0f, 120, "director2");
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		Book book1 = new Book(5, "1984", "Novel", 69.0f);
		Book book2 = new Book(6, "Brave New World", "Novel", 59.0f);
		store.addMedia(book1);
		store.addMedia(book2);
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
		}
	}
	public  static void updateStore(){
		while(true) {
			System.out.println("--------------------------------");
		    System.out.println("1. add media");
		    System.out.println("2. remove media");
		    System.out.println("0. Exit");
		    System.out.println("--------------------------------");
		    System.out.println("Please choose a number: 0-1-2");
		    int choice=scanner.nextInt();
		    if(choice==0) {
		    	break;
		    }
		    else if(choice==1) {
		    	System.out.println("enter title: ");
		    	String x=scanner.nextLine();
		    	System.out.println("added");
		    }
		    else if(choice==2) {
		    	System.out.println("enter title: ");
		    	String x=scanner.nextLine();
		    	
		    }
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
		    	System.out.println("back");
		    	break;
		    }
		    else if (choice == 1) {
	            System.out.print("Please enter the title of media: ");
	            String mediaName = scanner.nextLine();
	            Media media = store.getMedia(mediaName);
	            if (media == null)
	            	System.out.println( " not found.");
	            else{
	                System.out.println(media.toString());
                    mediaDetailsMenu(media);
	            }
	        }
	        else if (choice == 2) {
	            System.out.print("Please enter the title of media: ");
	            scanner.nextLine();
	            String mediaName = scanner.nextLine();
	            Media media = store.getMedia(mediaName);
	            if (media == null)
	            	System.out.println("existed");
	            else{
	                cart.addMedia(media);
	                cart.print();
	            }
	        }
	        else if (choice == 3) {
	            System.out.print("Please enter the title of media: ");
	            scanner.nextLine();
	            String mediaName = scanner.nextLine();
	            Media media = store.getMedia(mediaName);
	            if (media == null)
	            	System.out.println(" not found.");
	            else if (media instanceof Book)
	            	System.out.println("Media need be CD or DVD");
	            else store.playMedia(media);
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
		    System.out.println("--------------------------------");
		    System.out.println("1. Add to cart");
		    System.out.println("2. Play");
		    System.out.println("0. Back");
		    System.out.println("--------------------------------");
		    System.out.println("Please choose a number: 0-1-2");
		    int choice = scanner.nextInt();

			if (choice == 0) break;
			else if (choice == 1) {
				cart.addMedia(media);
			}
			else if (choice == 2) {
				if(media instanceof Book) {
					System.out.println("khong hop le");
				}
				else System.out.println("Playing");
			}
		}
	}
	public static void cartMenu() {
		while(true) {
		    System.out.println("Options: ");
		    System.out.println("--------------------------------");
		    System.out.println("1. Filter media in cart");
		    System.out.println("2. Sort media in cart");
		    System.out.println("3. Remove media from cart");
		    System.out.println("4. Play a media");
		    System.out.println("5. Place order");
		    System.out.println("0. Back");
		    System.out.println("--------------------------------");
		    System.out.println("Please choose a number: 0-1-2-3-4-5");
		    int choice = scanner.nextInt();
			if (choice == 0) {
				break;
			}
			else if(choice==5) {
				System.out.println("done");
				cart=new Cart();
			}
	        else if (choice == 1) {
	            System.out.println("back or title or cart (0-1-2)?");
	            int cc=scanner.nextInt();
	            if(cc==2) {
	            	System.out.println("enter id: ");
	            	int ii=scanner.nextInt();
	            	cart.filterid(ii);
	            }
	            else if (cc==1) {
	            	System.out.println("enter title: ");
	            	String ss=scanner.nextLine();
	            	cart.filtertitle(ss);
	            }
	        }
	        else if (choice == 2) {
	        	System.out.println("back or title or cart (0-1-2)?");
	            int cc=scanner.nextInt();
	            if(cc==1) {
	            	cart.sortByTitle();
	            }
	            else if(cc==2) cart.sortByCost();
	        }
			else if (choice == 3) {
	            System.out.print("Please enter the title of media: ");
	            scanner.nextLine();
	            String mediaName = scanner.nextLine();
	            cart.remove(mediaName);
			}
			else if (choice == 4) {
	            System.out.print("Please enter the title of media: ");
	            scanner.nextLine();
	            String mediaName = scanner.nextLine();
	            Media media = store.getMedia(mediaName);
	            if (media == null)
	            	System.out.println("Media " + mediaName + " not found in cart.");
	            else if (media instanceof Book)
	            	System.out.println("Media need be CD or DVD.");
	            else System.out.println("playing");
			}
		}
	}
	
}
