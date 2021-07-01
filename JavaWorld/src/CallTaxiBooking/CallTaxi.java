package CallTaxiBooking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CallTaxi {
	static int num=4;
	static ArrayList<taxidetails>alltaxi=new ArrayList<>();
	static ArrayList<customerdetails>customer=new ArrayList<>();
	static HashMap<String,ArrayList<BookingDetails>>bookings=new HashMap<String,ArrayList<BookingDetails>>();
	public static void main(String[] args) {
		ArrayList<String>taxis=new ArrayList<>();
		for(int i=1;i<=num;i++) {
			taxis.add("Taxi "+i);
			alltaxi.add(new taxidetails(taxis.get(i-1)));
		}
		Scanner scan=new Scanner(System.in);
		while(true) {
		System.out.println("Welcome to Azhagu Call Taxi\nWe have 4 taxi\nOur taxi running stops 1.A\t2.B\t3.C\t4.D\t5.E\t6.F\n1.Start Booking\t2.Exit");
		int decision=scan.nextInt();
		if(decision==1) {
			customer.add(new customerdetails());
			TaxiBooking.checktaxi();
			
		}
		else if(decision==2) {
			System.out.println("Thank You");
			break;
		}
		}
		System.out.println("Taxi Details");
		TaxiBooking.taxidetails();
		scan.close();
		
	}
}
class taxidetails{
	String position;
	int time;
	String taxiname;
	public taxidetails(String name) {
		position="A";
		time=0;
		taxiname=name;
	}
	public String gettaxiname() {
		return taxiname;
	}
	public String getposition() {
		return position;
	}
	public int gettime() {
		return time;
	}
	public void settime(int pickuptime,int diff) {
		time=pickuptime+diff;
		if(time>=24) {
			time=24-time;
		}
	}
	public void setposition(String pos) {
		position=pos;
	}
}
class customerdetails{
	String customername,start,dest;
	int time;
	int amount;
	public customerdetails() {
		Scanner scan = new Scanner(System.in); 
			System.out.println("Enter the Customer Name:");
			customername=scan.nextLine();
			System.out.println("Enter the Pickup Point:");
			start=scan.nextLine();
			System.out.println("Enter the Stop Point:");
			dest=scan.nextLine();
			System.out.println("Enter the PickupTime:");
			time=scan.nextInt();
		
}
	public String getcustomername() {
		return customername;
	}
	public String getstart() {
		return start;
	}
	public String getdest() {
		return dest;
	}
	public int gettime() {
		return time;
	}
	public void setamount(String start,String dest) {
		int n=Math.abs(start.charAt(0)-dest.charAt(0));
		amount=n*15*10+50;
	}
	public int getamount() {
		return amount;
	}
}
class TaxiBooking extends CallTaxi{
	public static void checktaxi() {
		ArrayList<Integer>diff=new ArrayList<>();
		for(int i=0;i<num;i++) {
			if(alltaxi.get(i).gettime()<=customer.get(0).gettime()) {
				diff.add(Math.abs(alltaxi.get(i).getposition().charAt(0)-(customer.get(0).getstart().charAt(0))));
			}
			else {
				diff.add(100);
			}
		}
		int distance=diff.indexOf(Collections.min(diff));
		if((Collections.min(diff))<100) {
			System.out.println("Your Booking is Confirmed with taxi Number "+alltaxi.get(distance).gettaxiname());
			customer.get(0).setamount(customer.get(0).getstart(),customer.get(0).getdest());
			System.out.println("Amount for Journey is "+customer.get(0).getamount());
			alltaxi.get(distance).settime(customer.get(0).gettime(),Math.abs(customer.get(0).getstart().charAt(0)-customer.get(0).getdest().charAt(0)));
			alltaxi.get(distance).setposition(customer.get(0).getdest());
			bookings.put(alltaxi.get(distance).gettaxiname(),BookingDetails.getlists(alltaxi.get(distance).gettaxiname(), distance));
			customer.remove(0);
		}
		else {
			System.out.println("Sorry!Bookings is Fulled");
			customer.remove(0);
		}
	}
	public static void taxidetails() {
		System.out.println("Customer Name    PickupTime    Droptime    Starting Point    Destination Point    Amount");
		for(Entry<String, ArrayList<BookingDetails>> lists:bookings.entrySet()) {
			System.out.println(lists.getKey());
			for(BookingDetails book:lists.getValue()) {
					System.out.println(book.customername+" "+book.pickuptime+" "+book.droptime+" "+book.start+" "+book.dest+" "+book.amount);
			}
		}
	}
}
class BookingDetails extends CallTaxi{
	int pickuptime,droptime,amount;
	String start,dest,customername;
	static ArrayList<BookingDetails>taxi1=new ArrayList<>();
	static ArrayList<BookingDetails>taxi2=new ArrayList<>();
	static ArrayList<BookingDetails>taxi3=new ArrayList<>();
	static ArrayList<BookingDetails>taxi4=new ArrayList<>();
	public BookingDetails(String name,int pickup,int drop,int amt,String startpoint,String destpoint) {
		customername=name;
		pickuptime=pickup;
		droptime=drop;
		amount=amt;
		start=startpoint;
		dest=destpoint;	
	}
	public static ArrayList<BookingDetails> getlists(String taxi,int i) {
		if(taxi.equals("Taxi 1")) {
			taxi1.add(new BookingDetails(customer.get(0).getcustomername(),customer.get(0).gettime(),alltaxi.get(i).gettime(),customer.get(0).getamount(),customer.get(0).getstart(),customer.get(0).getdest()));
			return taxi1;
		}
		else if(taxi.equals("Taxi 2")) {
			taxi2.add(new BookingDetails(customer.get(0).getcustomername(),customer.get(0).gettime(),alltaxi.get(i).gettime(),customer.get(0).getamount(),customer.get(0).getstart(),customer.get(0).getdest()));
			return taxi2;
		}
		else if(taxi.equals("Taxi 3")) {
			taxi3.add(new BookingDetails(customer.get(0).getcustomername(),customer.get(0).gettime(),alltaxi.get(i).gettime(),customer.get(0).getamount(),customer.get(0).getstart(),customer.get(0).getdest()));
			return taxi3;
		}
		else {
			taxi4.add(new BookingDetails(customer.get(0).getcustomername(),customer.get(0).gettime(),alltaxi.get(i).gettime(),customer.get(0).getamount(),customer.get(0).getstart(),customer.get(0).getdest()));
			return taxi4;
		}
	}
}