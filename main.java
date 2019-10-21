import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws FileNotFoundException{
		boolean cont= true;
		String option="";
		File file= new File("C:\\Users\\arman_qia17n4\\eclipse-workspace\\Parking Lot\\src\\input.txt");//type in appropriate testing file name
		Scanner input = new Scanner(file);
		ParkingLot parkinglot=new ParkingLot(input.nextInt(),input.nextInt());
		while(input.hasNextLine()) {
			option =input.nextLine();
			if(option.indexOf("Enter")!=-1) {
				String name="";
				int i=option.indexOf(":")+1;
				while(! option.substring(i,i+1).equals(" ")) {
					name+=option.substring(i,i+1);
					i++;
				}
				Car aCar=new Car(name);
				String time="";
				i=option.indexOf("@")+1;
				while(i<option.length()&&! option.substring(i,i+1).equals(" ")) {
					time+=option.substring(i,i+1);
					i++;
				}
				Ticket ticket=new Ticket(parkinglot.getCost(),time);
				aCar.setTicket(ticket);
				parkinglot.enter(aCar, time);
			}
			else if(option.indexOf("Leaves")!=-1) {
					String name="";
					int i=option.indexOf(":")+1;
					while(i<option.length()) {
						name+=option.substring(i,i+1);
						i++;
					}
					parkinglot.leave(name);
				
			}
			/*else if(option==3) {
				parkinglot.getProfit();
			}
			else if(option==4) {
				System.out.println("Capacity: "+parkinglot.getCapacity());
				System.out.println("Price: $"+parkinglot.getCost());
				parkinglot.print();
			}
			else if(option==5) {
				boolean valid=false;
				int cost=0;
				while(valid==false) {
					System.out.print("New ticket cost: ");
					cost=input.nextInt();
					if(cost>0) {
						valid =true;
						parkinglot.setCost(cost);
					}
					else {
						System.out.println("Invalid cost.");
					}
				}
			}
			else if(option==6) {
				boolean valid =false;
				int capacity=0;
				while(valid ==false) {
					System.out.print("New capacity:");
					capacity=input.nextInt();
					if(capacity>=parkinglot.getCars().size()) {
						valid =true;
						parkinglot.setCapacity(capacity);
					}
					else {
						System.out.println("Invalid capacity.");
					}
				}
			}
			else if(option==0) {
				cont=false;
			}
			*/
		}
		/*File file = new File("C:\\Users\\arman_qia17n4\\Desktop\\input1.txt");
		BufferedReader br;
		int numLines=0;
		ArrayList<String>input=new ArrayList<String>();
		String st; 
		try{
			br = new BufferedReader(new FileReader(file));
			try {
				while ((st = br.readLine()) != null) {
				    input.add(st);
					numLines++;
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
		String curr="";
		String time="";
		String name = "";
		int cost=Integer.parseInt(input.get(1));
		int capacity=Integer.parseInt(input.get(0));
		ParkingLot parkinglot=new ParkingLot(capacity,cost);
		for(int i=2;i<numLines;i++) {
			curr=input.get(i);
			int tempIndex;
			tempIndex=curr.indexOf("Car")+2;
			while(tempIndex<curr.length() && curr.substring(tempIndex,tempIndex+1)!=" ") {
				name+=curr.substring(tempIndex,tempIndex+1);
				tempIndex++;
			}
			if(curr.indexOf("enters")!=-1) {
				Car aCar=new Car(name);
				tempIndex=curr.indexOf("at")+2;
				while(tempIndex<curr.length() && curr.substring(tempIndex,tempIndex+1)!=" ") {
					time+=curr.substring(tempIndex,tempIndex+1);
					tempIndex++;
				}
				Ticket tick=new Ticket(cost,time);
				aCar.setTicket(tick);
				parkinglot.enter(aCar, time);
			}
			else if(curr.indexOf("leaves")!=-1) {
				parkinglot.leave(name);
			}
			
		}*/
	
	}

}

