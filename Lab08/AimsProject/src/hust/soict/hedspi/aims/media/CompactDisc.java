package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class CompactDisc extends Media implements Playable{
	private String artist;
	private List <Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
        return this.artist;
    }
	
	public CompactDisc() {};
	public CompactDisc(int id, String title) {
		super(id,title);
	}
	
	public CompactDisc(int id, String title, String category) {
		super(id,title,category);
	}
	
	public CompactDisc(int id, String title, String category, float cost) {
		super(id,title,category,cost);
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist) {
		super(id,title,category,cost);
		this.artist = artist;
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		super(id,title,category,cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public boolean addTrack(Track track) {
		for (int i = 0; i < tracks.size();i++) {
            if (tracks.get(i).equals(track)){
                System.out.println("already exist.");
                return false;
            }
        }
        tracks.add(track);
//        this.length = this.getLength();
        return true;
    }
	
	public void removeTrack(Track track){
        int check = 0;
        for (int i = 0; i < tracks.size();i++) {
            if (tracks.get(i).equals(track)){
            	check = 1;
                break;
            }
        }
        if(check == 1)
            tracks.remove(track);
        else
            System.out.println("This track not found in the track list");
    }
	
	public int getLength() {
	     int sum = 0;
	     for (int i = 0; i < tracks.size();i++) {
	    	 sum += tracks.get(i).getLength();
	     }
	     return sum;
	}
	
	@Override
	public void play() {
		System.out.println("Artist: " + this.artist);
		for (int i = 0; i < tracks.size();i++) {
	    	 Track track = tracks.get(i);
	    	 track.play();
	     }
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc) obj;
			if(cd.tracks.size() > this.tracks.size()) return -1;
			else if(cd.tracks.size() < this.tracks.size()) return 1;
			else {
				if(cd.getLength() > this.getLength())return -1;
				else if(cd.getLength() < this.getLength())return 1;
				else return super.compareTo(obj);
			}
		}
		else return super.compareTo(obj);
	}
}
