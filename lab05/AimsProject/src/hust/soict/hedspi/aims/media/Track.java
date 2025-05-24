package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable  {

	private String artist;
	private int length;
	private String title;

	public String getArtist() {
		return artist;
	}

	public int getLength() {
		return length;
	}

	public String getTitle() {
		return title;
	}
	public Track(String title, int length, String artist) {
		this.title = title;
		this.length = length;
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Track: title=" + getTitle() + ", artist=" + artist + ", length=" + length;
	}

	
	@Override
	public void play() throws PlayerException {
		if(this.length > 0) {
			System.out.println("Playing track: " + this.title);
		} else {
			throw new PlayerException("Track length is not set. Cannot play.");
		}
	}
}