package hust.soict.hedspi.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
	private String title;
	private String category;
	private float cost;
	private String director;
    private int length;
    private static int qDigitalVideoDiscs = 0;


    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
    	super(id, title, category, cost, length, director);
        this.director = director;
        this.length = length;
        qDigitalVideoDiscs++;
    }
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
    
	public boolean isMatch(String title) {
        if (title == null || getTitle() == null) return false;
        String[] tmp = title.split(" ");
        for (String s : tmp) {
            if (s != null && getTitle().contains(s)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isMatch(int id) {
        return getId() == id;
    }

    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost();
    }
    
    
    public void play() {
		System.out.println("Playing " + this.getTitle());
	}
}