package hust.soict.dsai.aims.store;


import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> items;
	public Store(){
		items = new ArrayList<Media>();
	}
	public void addMedia(Media media) {
        if (!items.contains(media)) {
        	items.add(media);
            System.out.println("added");
        } else {
            System.out.println("no");
        }
    }

    public void removeMedia(Media media) {
        if (items.contains(media)) {
        	items.remove(media);
            System.out.println("remoeved");
        } else {
            System.out.println(" no");
        }
    }

    public Media getMedia(String title) {
        for (Media m : items) {
            if (m.getTitle().equals(title)) {
                return m;
            }
        }
        return null;
    }

    public void playMedia(Media media) {
        System.out.println("Playing");
    }

    public void printStore(){
        System.out.println("*********************** STORE ***********************");
        System.out.println("Items in Store:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).toString());
        }
        System.out.println("*****************************************************");
    }
    public void remove(String name) {
    	for(Media m: items) {
    		if(m.getTitle().equals(name)) {
    			removeMedia(m);
    			break;
    		}
    	}
    }
}

