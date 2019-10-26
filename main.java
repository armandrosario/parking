import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws FileNotFoundException{
		boolean cont= true;
		String option="";
		File file= new File("C:\\Users\\arman_qia17n4\\eclipse-workspace\\Parking Lot\\src\\input.txt");//type in appropriate testing file name
		Scanner input = new Scanner(file);
		ArrayList<ParkingLot> lots= new ArrayList<>();
		ArrayList<String>names=new ArrayList<>();
		String plName=input.next();
		plName=plName.substring(plName.indexOf(":")+1,plName.length());
		ParkingLot parkinglot=new ParkingLot(input.nextInt(),input.nextInt(),plName);
		lots.add(parkinglot);
		while(input.hasNextLine()) {
			option =input.nextLine();
			if(option.indexOf("Enter")!=-1) {
				String name="";
				int i=option.indexOf(":")+1;
				while(! option.substring(i,i+1).equals(" ")) {
					name+=option.substring(i,i+1);
					i++;
				}
				if(names.contains(name)) {
					System.out.println("Invalid name. Car "+name+ " cannot be added");
				}
				else {
					names.add(name);
					Car aCar=new Car(name);
					String time="";
					i=option.indexOf("@")+1;
					while(i<option.length()&&! option.substring(i,i+1).equals(" ")) {
						time+=option.substring(i,i+1);
						i++;
					}
					Ticket ticket=new Ticket(parkinglot.getCost(),time);
					aCar.setTicket(ticket);
					//determine lowest price
					int lowest=lots.get(0).getCost();
					int index=0;
					for(int c=1;c<lots.size();c++) {
						if(lots.get(c).getCost()<lowest && lots.get(c).isFull()==false) {
							index=c;
							lowest=lots.get(c).getCost();
						}
					}
					if(! lots.get(index).isFull()) {
						lots.get(index).enter(aCar, time);
					}
					else {
						System.out.println("All lots full Car " + name+" cannot enter.");
					}
				}
			}
			else if(option.indexOf("Leaves")!=-1) {
					String name="";
					int i=option.indexOf(":")+1;
					int a=0,b=0;
					while(i<option.length()) {
						name+=option.substring(i,i+1);
						i++;
					}
					for(int r=0;r<lots.size();r++) {
						ArrayList<Car>cars=lots.get(r).getCars();
						for(int c=0;c<cars.size();c++) {
							if(cars.get(c).getName().equals(name)) {
								a=r;
								b=c;
							}
						}
					}
					lots.get(a).leave(name);
				
			}
			else if(option.indexOf("Group")!=-1) {
				plName=option.substring(option.indexOf(":")+1,option.length());
				int index=-1;
				for(int i=0;i<lots.size();i++) {
					if(lots.get(i).getName().equals(plName)) {
						index=i;
					}
				}
				if(index==-1) {
					parkinglot=new ParkingLot(input.nextInt(),input.nextInt(),plName);
					lots.add(parkinglot);
				}
				else {
					lots.get(index).setCapacity(input.nextInt());
					lots.get(index).setCost(input.nextInt());
					System.out.println("Lot "+plName+" cost set to: "+lots.get(index).getCost());
				}
			}
			else if(option.indexOf("Cost Interest")!=-1) {
				System.out.println("***Parking Lot Costs***");
				for(int i=0;i<lots.size();i++) {
					System.out.println(lots.get(i).getName()+" Cost: "+lots.get(i).getCost());
				}
			}
			else if(option.indexOf("Space Interest")!=-1) {
				System.out.println("***Parking Lot Space Availability***");
				for(int i=0;i<lots.size();i++) {
					lots.get(i).showSpace();
				}
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


