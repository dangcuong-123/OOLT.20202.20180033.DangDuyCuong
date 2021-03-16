
public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyQrdered = 0; 
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyQrdered > MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full");
			return ;
		}
		itemsOrdered[qtyQrdered] = disc;
		qtyQrdered++;
		System.out.println("The disc has been added");
	}
	
	public void removeDigitalVideoDisc(String titleDisc) {
		if(qtyQrdered <= 0) {
			System.out.println("The order is empty");
			return ;
		}
		int check = 0;
		for (int i = 0; i < qtyQrdered; i++) {
			if(titleDisc.equals(itemsOrdered[i].getTitle())) {
				for (int j = i; j < qtyQrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				qtyQrdered--;
				check = 1;
				break;
			}
		}
		if(check == 1) {
			System.out.println("The disc has been remove");
		}
		else {
			System.out.println("The disc not found");
		}
		
	}
	
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < qtyQrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
}
