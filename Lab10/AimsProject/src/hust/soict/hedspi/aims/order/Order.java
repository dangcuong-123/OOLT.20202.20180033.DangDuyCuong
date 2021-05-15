package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import hust.soict.hedspi.aims.AddMediaException;
import hust.soict.hedspi.aims.LimitExceededException;
import hust.soict.hedspi.aims.LuckyItemException;
import hust.soict.hedspi.aims.media.Media;

import hust.soict.hedspi.aims.utils.MyDate;


public class Order {
	
	public static final int MAX_NUMBERS_ORDERED = 5;
	public static final int MAX_LIMITED_ORDERS = 5;
	
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private int qtyOrdered;
	private MyDate dateOrderd;
	
	private static int nbOrders = 0;
	
	public static final double probability = 0.9;
	private float thresholdsTotal = 300;
    private float thresholdsSale = 200;
    private int thresholdsOrders = 10;
	
	public float getThresholdsTotal() {
		return thresholdsTotal;
	}
	public void setThresholdsTotal(float thresholdsTotal) {
		this.thresholdsTotal = thresholdsTotal;
	}
	public float getThresholdsSale() {
		return thresholdsSale;
	}
	public void setThresholdsSale(float thresholdsSale) {
		this.thresholdsSale = thresholdsSale;
	}
	public int getThresholdsOrders() {
		return thresholdsOrders;
	}
	public void setThresholdsOrders(int thresholdsOrders) {
		this.thresholdsOrders = thresholdsOrders;
	}
	public static double getProbability() {
		return probability;
	}
	
	public Order() throws LimitExceededException {
		if (nbOrders > MAX_LIMITED_ORDERS)
		{
			throw new LimitExceededException("ERROR: The number of orders has reached its limit!");
			
		}
		else {
			this.qtyOrdered = 0;
			this.dateOrderd = new MyDate();
			nbOrders++;
		}
	}
	public Order(String date)
	{
		if (nbOrders > MAX_LIMITED_ORDERS)
		{
			System.out.println("Over limited number of orders.");
			return;
			
		}
		
		this.qtyOrdered = 0;
		this.dateOrderd = new MyDate(date);
		nbOrders++;
		
	}
	
	public int getQtyOrdered() {
		return this.qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	
	public MyDate getDateOrderd() {
		return dateOrderd;
	}
	public void setDateOrderd(MyDate dateOrderd) {
		this.dateOrderd = dateOrderd;
	}
	
	public static int getNbOrders() {
		return nbOrders;
	}
	public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
	
	public static void setNbOrders(int nbOrders) {
		Order.nbOrders = nbOrders;
	}
	public void addMedia(Media media) throws AddMediaException{
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED )
            this.itemsOrdered.add(media);
        else
            throw new AddMediaException("ERROR: The list media is full !");
    }

    public void removeMedia(Media media){
        this.itemsOrdered.remove(media);
    }
    
    public void removeMedia(int id){
        this.itemsOrdered.removeIf(o->o.getId()==id);
    }
    
	public void printListOrder()
	{
		System.out.println("****************ORDER************");
		dateOrderd.print();
		System.out.println("Ordered Items : ");
		
		for (int i = 0; i < qtyOrdered; i++)
		{
			System.out.print("DVD : " + this.itemsOrdered.get(i).getTitle());
			System.out.print(" -  " + this.itemsOrdered.get(i).getCategory());
			System.out.println(" - " + this.itemsOrdered.get(i).getCost() + "$");
		}
		
		System.out.println("Total Cost : " + this.totalCost());
		System.out.println("****************************");
		
	}
	public float totalCost()
	{
		float total_cost = 0;
		for (Media o : itemsOrdered)
		{
			total_cost += o.getCost();
		}
		return total_cost;
	}
	
	private int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public Media getLuckyItem() throws LuckyItemException {
		
		if(itemsOrdered.size() >= thresholdsOrders && this.totalCost() >= thresholdsTotal) {
            if(checkOrder(this)) {
                double xs = Math.random();
                if(xs <= probability){
                    int item = 0;
                    do {
                        double rand = getRandomNumber(0,1000);
                        rand *= itemsOrdered.size();
                        item = (int)rand;
                    } while (itemsOrdered.get(item).getCost() <= this.totalCost()*thresholdsSale);
                    return itemsOrdered.get(item);
                }
                else{
                    throw new LuckyItemException("random < probability (" +  probability + ")");
                }
            }else {
                throw new LuckyItemException("all order > thresholdsSale (" + thresholdsSale + ")");
            }
        }else {
            throw new LuckyItemException("Not eligible to receive lucky Order\nNumber Orders >= " + thresholdsOrders + "\nTotal Order >= " + thresholdsTotal);
        }
    }
		
	private boolean checkOrder(Order order) {
        for(Media media: order.itemsOrdered) {
            if(media.getCost() <= thresholdsSale)
                return true;
        }
        return false;
    }
	
	public Media searchById(int id){
        Media media =  this.itemsOrdered.stream().filter(o->o.getId()==id).findFirst().orElse(null);
        return media;
    }
	
}