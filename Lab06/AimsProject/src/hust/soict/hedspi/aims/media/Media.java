package hust.soict.hedspi.aims.media;

public class Media {
	protected String title;
	protected String category;
	protected float cost;
	protected int id;

	public Media() {}
	
	public Media(int id, String title) {
		setId(id);
		setTitle(title);
	}
	
	public Media(int id, String title, String category) {
		setId(id);
		setTitle(title);
		setCategory(category);
	}
	
	public Media(int id, String title, String category, float cost) {
		setId(id);
		setTitle(title);
		setCategory(category);
		setCost(cost);
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}