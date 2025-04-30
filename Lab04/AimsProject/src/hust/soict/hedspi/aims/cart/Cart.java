package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Disc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cart {
	private ArrayList<Media> itemin = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (!itemin.contains(media)) {
			itemin.add(media);
			System.out.println( "added");
		} 
		else System.out.println("already exist");
	}

	public void removeMedia(Media media) {
		if (itemin.contains(media)) {
			itemin.remove(media);
			System.out.println("removed");
		}
		else System.out.println(" not found");
	}
	
	public float totalCost() {
		float total = 0;
		for (Media media : itemin) {
			total += media.getCost();
		}
		return Math.round(total * 100.0f) / 100.0f;
	}
    public Media search(int id) {
        for (Media item : itemin){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public Media search(String title) {
        for (Media item : itemin){
            if (item.isMatch(title)){
                return item;
            }
        }
        return null;
    }

    public ArrayList<Media> filterById(int id) {
        ArrayList<Media> media = new ArrayList<Media>();
        for (Media item : itemin){
            if (item.getId() == id){
                media.add(item);
            }
        }
        return media;
    }

    public ArrayList<Media> filterByTitle(String title) {
        ArrayList<Media> media = new ArrayList<Media>();
        for (Media item : itemin){
            if (item.isMatch(title)){
                media.add(item);
            }
        }
        return media;
    }

    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemin, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemin.iterator();
        iterator = itemin.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemin, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemin.iterator();
        iterator = itemin.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    
    public void playMedia(Media media) {
        System.out.println("Playing");
    }
    
    public void print(){
        System.out.println("**********************CART**********************");
        System.out.println("Ordered Items:");
        for (Media media: itemin) {
            System.out.println(media.getTitle() + " - " + media.getCost());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("*************************************************");
    }
}