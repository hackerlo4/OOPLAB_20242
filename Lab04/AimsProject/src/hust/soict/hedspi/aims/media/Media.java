package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int qMedia = 0;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }


    public boolean isMatch(String title) {
		return this.title.equals(title);
	}

	public boolean isMatch(int id) {
		return this.id == id;
	}
	
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	@Override
	 public String toString() {
        return "Media: " + this.getTitle() +" - Category: " + this.getCategory() + " - Cost: " + this.getCost();
    }

	public static int getqMedia() {
		return qMedia;
	}
}