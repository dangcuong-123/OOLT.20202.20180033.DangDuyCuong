package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable <Media>{
	protected String title;
	protected String category;
	protected float cost;
	protected int id;

	public Media() {}
	
	public Media(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public Media(int id, String title, String category) {
		this.id = id;
		this.title = title;
		this.category = category;
	}
	
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public void discount(int cost) {
		this.cost = cost;
	}
	
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
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
	@Override
	public boolean equals(Object o)  throws NullPointerException, ClassCastException{
		if(o != null){
			if (o instanceof Media) {
				Media media = (Media)o;
				if (this.id == media.getId()) {
					return true;
				}
				return false;
			} else 
				throw new ClassCastException("ERROR: Object casting");
		}else 
			throw new NullPointerException("ERROR: Null pointerexception");
    }
	public static int stringCompare(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int) str1.charAt(i);
            int str2_ch = (int) str2.charAt(i);
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        }
        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }
	
	public int compareTo(Media media) throws NullPointerException, ClassCastException{
		if(media != null){
			if(media instanceof Media) {
				return this.stringCompare(media.getTitle(),this.getTitle());
			} else {
				throw new ClassCastException("ERROR: Object casting");
			}
		}else 
			throw new NullPointerException("ERROR: Null pointerexception");
	}
}