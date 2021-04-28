package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	protected String director;
	protected int length;
	
	public Disc() {};
	public Disc(int id,String title, String category, String director, int length, float cost) {
		super(id,title,category,cost);
		this.director = director;
		this.length = length;
	}
	
	public Disc(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public Disc(int id, String title, String category) {
		this.id = id;
		this.title = title;
		this.category = category;
	}
	
	public Disc(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
}
