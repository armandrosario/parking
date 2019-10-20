public class Ticket {
	private int price;
	private String time;
	
	public Ticket(int p,String s) {
		price=p;
		time=s;
	}
	public int getPrice() {
		return price;
	}
	public String getTime() {
		return time;
	}
}
