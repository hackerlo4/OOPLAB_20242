package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
		super(id, title, category, cost, length, director);

        this.artist = artist;
        this.tracks = tracks;
    }

	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("already exists");
        } 
        else {
            tracks.add(track);
            System.out.println("added.");
        }
    }

	public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("deleted.");
        } 
        else System.out.println("not found this one");
    }

	public int getLength() {
        int s = 0;
        for (Track track : tracks) s += track.getLength();
        return s;
    }
	@Override
	public void play() throws PlayerException {
	    if(this.getLength() > 0) {
	        // TODO: Phát tất cả các tracks trong CD mà bạn đã cài đặt
	        java.util.Iterator iter = tracks.iterator();
	        Track nextTrack;
	        while(iter.hasNext()) {
	            nextTrack = (Track) iter.next();
	            try {
	                nextTrack.play();
	            } catch(PlayerException e) {
	                throw e; // Ném lại ngoại lệ nếu một track gặp lỗi
	            }
	        }
	    } else {
	        throw new PlayerException("ERROR: CD length is non-positive!");
	    }
	}


    public String toString() {
        return "ID: " + this.getId() + " - CD: " + this.getTitle() + " - Category: " + this.getCategory() + " - Artist" + this.getArtist() + " - Length: " + this.getLength() + " seconds" +" - Cost: " + this.getCost();
    }

}