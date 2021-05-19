package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.PlayerException;

public class Track implements Playable{
	private String title;
    private int length;

    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return this.title;
    }

    public int getLength() {
        return this.length;
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof Track){
            Track track = (Track)o;
            if (this.title.equals(track.getTitle()) && this.length == track.getLength()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
	public void play() throws PlayerException {
    	if(this.getLength() > 0) {
    		System.out.println("Playing DVD: " + this.getTitle());
    		System.out.println("DVD length: " + this.getLength());
    	}
    	else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
    
    public String getMessage() {
        return "\nPlaying Track: " + this.getTitle() + "\nTrack length: " + this.getLength();
    }
}
