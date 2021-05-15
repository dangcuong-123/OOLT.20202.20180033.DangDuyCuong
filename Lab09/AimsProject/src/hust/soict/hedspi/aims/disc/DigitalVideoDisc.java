package hust.soict.hedspi.aims.disc;
import java.util.StringTokenizer;

import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public DigitalVideoDisc(int id, String title) {
		super(id, title);
	}
	
	public DigitalVideoDisc(int id, String title,String category) {
		super(id, title, category);
	}
	
	public DigitalVideoDisc(int id, String title,String category, float cost) {
		super(id, title, category, cost);
	}
	
	public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
		super(id, title,category,cost);
		this.director = director;
	}
	
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		this(id, title,category,director,cost);
		this.length = length;
	}
	
	public DigitalVideoDisc(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DigitalVideoDisc) {
			DigitalVideoDisc tmp = (DigitalVideoDisc)obj;
			
			if (this.title == null && tmp.title != null)
				return false;
			if (this.title != null) {
				if (tmp.title == null)
					return false;
				else if (this.title.equals(tmp.title) == false)
					return false;
			}
			return true;
		}
		return false;
	}
	
	public boolean search(String title) {
		StringTokenizer str_search = new StringTokenizer(title.toLowerCase());
		String str_title = this.title.toLowerCase();
		while (str_search.hasMoreTokens()) {
            if ( str_title.indexOf(str_search.nextToken()) == -1 )
            	return false;
        }
		return true;
	}
	
	public String toString() {
		return String.join("","DVD - ",title," - ",category," - ",director," - ",Integer.toString(length),
								" : ",Float.toString(cost),"$" );
	}
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		
	}
	
	@Override
	public int compareTo(Media obj) {
		if(obj instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc) obj;
			if(dvd.cost > this.cost) return -1;
			else if(dvd.cost < this.cost) return 1;
			else {
				if(dvd.length > this.length)return -1;
				else if(dvd.length < this.length)return 1;
				else return super.compareTo(obj);
			}
		}
		else return super.compareTo(obj);
	}
	
}