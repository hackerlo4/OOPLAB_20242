package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	
    public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}
	private List<String> authors = new ArrayList<String>();
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("existed");
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
           authors.remove(authorName);
        } else {
            System.out.println("not existed");
        }
    }
    @Override
    public String toString() {
        return "Book - " + getTitle() 
        + " - " + getCategory() 
        + " - " + getCost();
    }

}
