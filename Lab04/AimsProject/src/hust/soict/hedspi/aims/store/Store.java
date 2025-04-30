package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class Store {
	private ArrayList<Media> items;
	public Store(){
		items = new ArrayList<Media>();
	}
	public void addMedia(Media media) {
        if (!items.contains(media)) {
        	items.add(media);
            System.out.println(" added ");
        } 
        else System.out.println(" already exist ");
    }

    public Media getMedia(String title) {
        for (Media m : items) {
            if (m.getTitle().equals(title)) return m;
        }
        return null;
    }

    public void playMedia(Media media) {
        System.out.println("playing this one");
    }
    
    public void removeMedia(Media media) {
        if (items.contains(media)) {
        	items.remove(media);
            System.out.println(" removed");
        } 
        else System.out.println(" not found ");
    }
    
    public void printStore(){
        System.out.println("********************  STORE  ********************");
        System.out.println("Items in Store:");
        for (int i = 0; i < items.size(); i++)  System.out.println(items.get(i).toString());
        System.out.println("*************************************************");
    }
    public ArrayList<Media> getitems() {
        return items;
    }
}