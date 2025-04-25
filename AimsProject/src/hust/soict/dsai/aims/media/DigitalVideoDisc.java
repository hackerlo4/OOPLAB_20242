package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		// TODO Auto-generated constructor stub
	}


    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
    public void play() {
        System.out.println("Playing DVD: " +getTitle());
        System.out.println("DVD length: " + getLength());
    }
    @Override
    public String toString() {
        return "DVD: " + getTitle() 
        + " - cateory:" + getCategory() 
        + " - director: " + getDirector() 
        + " - length: " + getLength() 
        +" - cost: "+ getCost() ;
    }
    
}
