package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	private int id;

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
	private String title;

	private String category;

	private float cost;
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true; 
	    if (obj == null || getClass() != obj.getClass()) return false; 

	    Media me = (Media) obj;
	    return this.title != null && this.title.equals(me.getTitle());
	}
	 public String toString() {
	        return "Media: " + getTitle() +" - Category: " + getCategory() + " - Cost: " + getCost();
	    }
	 public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	 public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	 
	
	
}
