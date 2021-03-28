package Lab04;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());

	}

	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	public static void swapObject(Object o1, Object o2) {
		DigitalVideoDisc d1 = (DigitalVideoDisc)o1;
		DigitalVideoDisc d2 = (DigitalVideoDisc)o2;
		if (d1 != null && d2 != null) {
			String temp1 = d1.getTitle();
			d1.setTitle(d2.getTitle());
			d2.setTitle(temp1);
			
			String temp2 = d1.getCategory();
			d1.setCategory(d2.getCategory());
			d2.setCategory(temp2);

			String temp3 = d1.getDirector();
			d1.setDirector(d2.getDirector());
			d2.setDirector(temp3);

			int temp4 = d1.getLength();
			d1.setLength(d2.getLength());
			d2.setLength(temp4);

			float temp5 = d1.getCost();
			d1.setCost(d2.getCost());
			d2.setCost(temp5);
		}
		
	}
}
