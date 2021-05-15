package hust.soict.hedspi.aims.media;
import java.util.*;

public class Book extends Media{
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List <String> contentTokens = new ArrayList<String>();
	private Map <String, Integer> wordFrequency = new TreeMap<>();
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		processContent();
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
	public void processContent() {
		contentTokens.addAll(Arrays.asList(content.split(" ")));
		Collections.sort(contentTokens);
        Iterator<String> iterator = contentTokens.iterator();
        while(iterator.hasNext()) {
            String temp = iterator.next();
            if (!wordFrequency.containsKey(temp)) {
                wordFrequency.put(temp, 1);
            }else {
                int count = wordFrequency.get(temp);
                count++;
                wordFrequency.put(temp, count);
            }
        }
	}
	
	public String toString() {
        String string = "";
        string += "Id: " + super.getId() + "\n";
        string += "Title: "	+ super.getTitle() + "\n";
        string += "Category: " + super.getCategory() + "\n";
        string += "Cost: " + super.getCost()+ "\n";
        string += "Author: " + getAuthors()+ "\n";
        string += "Content: " + this.content + "\n"; 
        string += "Content Length: " + this.contentTokens.size() + "\n";
        string += "Work frequency \t" + "Word" + "\n";
        string += "Content Token in sorted order: " + this.contentTokens;
        for(Map.Entry<String, Integer> e: wordFrequency.entrySet()) {
            string += e.getKey() + " - "+ e.getValue() + "\n";
        }
        return string;
    }
	
}