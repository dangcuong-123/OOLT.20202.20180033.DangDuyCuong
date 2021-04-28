package Lab04;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	private static final int MAX_LIMITED_ORDERS = 5;
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0; 
	private static int nbOrders = 0;
	MyDate dateOrdered;
	
	// constructor
    public Order() {
        if (nbOrders >= MAX_LIMITED_ORDERS) {
            System.out.println("Full orders !!!");
        } else {
            this.qtyOrdered = 0;
            this.dateOrdered = new MyDate();
            nbOrders++;
        }
    }
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full");
			return ;
		}
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered++;
		System.out.println("The disc has been added");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList)
	{
		int i;
		if(qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED)
		{
			System.out.println("The order is almost full");
			for (i = 0; i < dvdList.length; i++) {
				System.out.println("The DVD " + dvdList[i].getTitle() + " could not be added");
				
			}
		}
		else
		{
			for(i=0;i<dvdList.length;i++)
			{
				itemsOrdered[qtyOrdered] = dvdList[i]  ;
				qtyOrdered ++;
				System.out.println("Add new dvd " + dvdList[i].getTitle());
			}

		}
	}
	public void addDigitalVideoDisc (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2 ) {
		if(qtyOrdered >= MAX_NUMBERS_ORDERED)
		{
			System.out.println("The order is almost full");
			System.out.println("The DVD " + dvd1.getTitle() + " could not be added");
		}
		else
		{
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered ++;
			System.out.println("Add new dvd " + dvd1.getTitle());
		}
		if(qtyOrdered >= MAX_NUMBERS_ORDERED)
		{
			System.out.println("The order is almost full");
			System.out.println("The DVD " + dvd2.getTitle() + " could not be added");
		}
		else
		{
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered ++;
			System.out.println("Add new dvd " + dvd2.getTitle());
		}
	}
	
	public void removeDigitalVideoDisc(String titleDisc) {
		if(qtyOrdered <= 0) {
			System.out.println("The order is empty");
			return ;
		}
		int check = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if(titleDisc.equals(itemsOrdered[i].getTitle())) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				qtyOrdered--;
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
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
	
	public void printOrder() {
        System.out.println("***********************************Order***********************************");
        this.dateOrdered.print();
        System.out.println("Ordered items:");
        for (int i = 0; i < this.qtyOrdered; i++) {
            System.out.printf("%d. DVD - %s - %s - %s - %d min - %.2f$\n", (i + 1),
                    		   this.itemsOrdered[i].getTitle(), this.itemsOrdered[i].getCategory(),
                    		   this.itemsOrdered[i].getDirector(), this.itemsOrdered[i].getLength(),
                    		   this.itemsOrdered[i].getCost());
        }
        System.out.println("Total cost: " + this.totalCost() + "$");
        System.out.println("***************************************************************************");
    }
}
