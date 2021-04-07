package hust.soict.hedspi.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	
	public Book(int id, String title) {
		super(id, title);
		}
	public Book(int id, String title, String category) {
		super(id, title, category);
	}
	public Book(int id, String title, String category, List<String> authors) {
		super(id, title, category);
		this.authors = authors;
	}
	public Book(int id, String title, String category, List<String> authors, float cost) {
		super(id, title,category,cost);
		this.authors = authors;
	}
	public Book(int id, String title, String category, float cost) {
		super(id, title,category,cost);
	}
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Author existed! Can not add!");
			return;
		}
		authors.add(authorName);
		System.out.println("Author add!");

	}
	
	public void removeAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			System.out.println("Can not find the author! Can not remove!");
			return;
		}
		authors.remove(authorName);
		System.out.println("Author is removed!");
	}
	
	public String displayInfo() {
		return String.join("","Book - ",title," - ",category," - ", authors.toString(),
				" : ",Float.toString(cost),"$" );
	}
}