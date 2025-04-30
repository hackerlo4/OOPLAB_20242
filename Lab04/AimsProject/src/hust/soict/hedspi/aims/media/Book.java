package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<>();
	public List<String> getAuthors() {
		return authors;
	}

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } 
        else System.out.println(" not found: " + authorName);
    }
    
    
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } 
        else System.out.println(" already exists: " + authorName);
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " - Book: " + this.getTitle() + " - Category: " + this.getCategory() + " - Cost: " + this.getCost();
    }

}