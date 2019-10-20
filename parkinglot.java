import java.util.*;
public class ParkingLot {
	private int capacity;
	private int totalCars;
	private ArrayList<Car> cars=new ArrayList<Car>();
	private int cost;
	private int profit;
	
	public ParkingLot(int c,int co) {
		capacity=c;
		totalCars=0;
		cost=co;
		System.out.println("Parking lot created.");
		System.out.println("Capacity:"+capacity);
		System.out.println("Price:$"+cost);
	}
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
		System.out.println("***Current Cars "+totalCars+"***");
		for(int i=0;i<cars.size();i++) {
			System.out.println((i+1)+". "+cars.get(i).getName());
		}
	}
	public void leave(String name) {
		boolean left=false;
		Car c=new Car();
		for(int i=0;i<cars.size();i++) {
			if(cars.get(i).getName().equals(name)) {
				c=cars.get(i);
				cars.remove(i);
				left=true;
			}
		}
		if(left==true) {
			System.out.println(c.getName()+" is leaving.");
			System.out.println("Time of entrance:"+c.getTicket().getTime());
			System.out.println("$"+c.getTicket().getPrice()+" made.");
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
			System.out.println(car.getName()+" has entered at "+time);
			cars.add(car);
			totalCars++;
			if(totalCars==capacity) {
				System.out.println("Parking lot now full!");
			}
		}
		else {
			System.out.println("Parking lot full.");
		}
	}
	
}
