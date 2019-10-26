import java.util.*;
public class ParkingLot {
	private int capacity;
	private int totalCars;
	private ArrayList<Car> cars=new ArrayList<Car>();
	private int cost;
	private int profit;
	private String name;
	
	public ParkingLot(int c,int co,String n) {
		name=n;
		capacity=c;
		totalCars=0;
		cost=co;
		System.out.println("Parking lot " +name+ " created.");
		System.out.println("Capacity:"+capacity);
		System.out.println("Price:$"+cost);
	}
	public boolean isFull() {
		if(totalCars==capacity) {
			return true;
		}
		else {
			return false;
		}
	}
	public String getName() {
		return name;
	}
	public void showSpace() {
		System.out.println("Lot " +name+" Available spots: "+(capacity-totalCars));
	}
	public ParkingLot() {}
	ArrayList<Car> getCars(){
		return cars;
	}
	public void setCapacity(int c) {
		capacity=c;
	}
	public void setCost(int c) {
		cost = c;
	}
	public int getCost() {
		return cost;
	}
	public int getCapacity() {
		return capacity;
	}
	public int getTotal() {
		return totalCars;
	}
	public void getProfit() {
		System.out.println("Total profit:$"+profit);
	}
	public void print() {
		System.out.println("Parking lot: "+name);
		System.out.println("***Current Cars "+totalCars+"***");
		for(int i=0;i<cars.size();i++) {
			System.out.println((i+1)+". "+cars.get(i).getName());
		}
	}
	public void leave(String n) {
		boolean left=false;
		Car c=new Car();
		for(int i=0;i<cars.size();i++) {
			if(cars.get(i).getName().equals(n)) {
				c=cars.get(i);
				cars.remove(i);
				left=true;
			}
		}
		if(left==true) {
			System.out.print(c.getName()+" is leaving Lot "+name);
			System.out.print(". Time of entrance: "+c.getTicket().getTime());
			System.out.println(". $"+c.getTicket().getPrice()+" made.");
			profit+=cost;
			totalCars--;
			if(totalCars==0) {
				System.out.println("Parking lot now empty");
			}
		}
		else {
			System.out.println(c.getName()+"not found.");
		}
		
	}
	public void enter(Car car,String time) {
		if(totalCars<capacity) {
			System.out.println(car.getName()+" has entered Lot "+name+" at "+time);
			cars.add(car);
			totalCars++;
			if(isFull()) {
				System.out.println("Parking lot "+name+ " now full!");
			}
		}
		else {
			System.out.println("Parking lot "+ name+ " full Car " +car.getName()+" cannot enter.");
		}
	}
	
}
