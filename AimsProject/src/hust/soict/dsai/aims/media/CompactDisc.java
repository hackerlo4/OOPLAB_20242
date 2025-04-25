package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{

	public CompactDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		// TODO Auto-generated constructor stub
	}
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) {
		boolean check=true;
		for(int i=0; i<tracks.size();i++) {
			if(tracks.get(i).equals(track)) check=false;
		}
		if(check) {
			tracks.add(track);
			System.out.println("added");
		}
		else System.out.println("already exist");
	}
	public void removeTrack(Track track) {
		boolean check=false;
		for(int i=0; i<tracks.size();i++) {
			if(tracks.get(i).equals(track)) {
				check=true;
				tracks.remove(i);
				System.out.println("rmoved");
				break;
			}
		}
		if(check==false) System.out.println("no exist");
	}
	public int getLength() {
		int x=0;
		for(Track y:tracks) {
			x+=y.getLength();
		}
		return x;
	}
	public void play() {
	    System.out.println("Playing CD: " + this.getTitle());
	    System.out.println("CD length: " + this.getLength());
	    for (Track track : tracks) {
	        track.play();
	    }
	}
	@Override
	public String toString() {
		return "CompactDisc | id: " + getId() +
			" title: " + getTitle() +
			" category: " + getCategory() +
			" director: " + getDirector() +
			" length: " + getLength() +
			" cost: " + getCost();
	}
}
