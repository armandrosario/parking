public class Car {
	private String licensePlate;
	private Ticket ticket;
	
	public Car(String n) {
		licensePlate=n;
	}
	public Car() {
		
	}
	public Car getCar() {
		return this;
	}
	public void setTicket(Ticket t) {
		ticket=t;
	}
	public void leave(String t) {
		ticket=null;
	}
	public String getName() {
		return licensePlate;
	}
	public void enter(String t) {
		System.out.println(licensePlate+":entering parking lot at"+t);
	}
	public Ticket getTicket() {
		return ticket;
	}
}

