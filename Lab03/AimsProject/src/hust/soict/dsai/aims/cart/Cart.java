package hust.soict.dsai.aims.cart;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	private  List<Media> itemsOrdered = new  ArrayList<Media>();
	public float totalCost() {
	    float total = 0;
	    for (Media me : itemsOrdered) total += me.getCost();
	    return total;
	}
	public void addMedia(Media me) {
	    if (!itemsOrdered.contains(me)) {
	        itemsOrdered.add(me);
	        System.out.println("added");
	    } 
	    else  System.out.println("already existed");
	    
	}

	public void removeMedia(Media me) {
	    if (itemsOrdered.contains(me)) {
	        itemsOrdered.remove(me);
	        System.out.println("The media has been removed.");
	    } else  System.out.println("The media is not in the cart.");
	}
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    public void filtertitle(String name) {
    	for(Media m: itemsOrdered) {
    		if(m.getTitle().equals(name)) System.out.println(m.toString());
    	}
    }
    public void seachByTitle(String title) {
		if(itemsOrdered.isEmpty())
			System.out.print("The cart is empty");
		else {
			boolean cc=false;
			for(Media media: itemsOrdered) {
				if(media.getTitle().toLowerCase().contains(title.toLowerCase())) {
					System.out.println(media.toString());
					cc=true;
				}
			}
			if(cc=false) System.out.println("khong tim thay");
		}
	}
    public void filterid(int ii) {
    	for(Media m: itemsOrdered) {
    		if(m.getId()==ii) System.out.println(m.toString());
    	}
    }
    public void remove(String name) {
    	boolean check=false;
    	for(Media m: itemsOrdered) {
    		if(m.getTitle().equals(name)) {
    			removeMedia(m);
    			check=true;
    			System.out.println("removed");
    			break;
    		}
    	}
    	if(check==false) System.out.println("khong co");
    	
    }
    public void seachByID(int id) {
		if(itemsOrdered.isEmpty())
			System.out.print("The cart is empty");
		else {
			boolean cc=false;
			for(Media media: itemsOrdered) {
				if(media.getId()==id) {
					System.out.println(media.toString());
					cc=true;
				}
			}
			if(cc=false) System.out.println("khong tim thay");
		}
	}
    public void sortByTitle() {
		Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
	}
	public void sortByCost() {
		Collections.sort(itemsOrdered,Media.COMPARE_BY_COST_TITLE);
	}
}
