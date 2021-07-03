package CallTaxiBooking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CallTaxi {
	static int num=4;
	static ArrayList<TaxiDetails>alltaxi=new ArrayList<>();
	static ArrayList<CustomerDetails>customer=new ArrayList<>();
	static HashMap<String,ArrayList<BookingDetails>>bookings=new HashMap<String,ArrayList<BookingDetails>>();
	public static void main(String[] args) {
		ArrayList<String>taxis=new ArrayList<>();
		for(int i=1;i<=num;i++) {
			taxis.add("Taxi "+i);
			alltaxi.add(new TaxiDetails(taxis.get(i-1)));
		}
		Scanner scan=new Scanner(System.in);
		while(true) {
		System.out.println("Welcome to Azhagu Call Taxi\nWe have 4 taxi\nOur taxi running stops 1.A\t2.B\t3.C\t4.D\t5.E\t6.F\n1.Start Booking\t2.Exit");
		int decision=scan.nextInt();
		if(decision==1) {
			customer.add(new CustomerDetails());
			TaxiBooking.checkTaxi();
			
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
class TaxiDetails{
	String position;
	int time;
	String taxiname;
	public TaxiDetails(String name) {
		position="A";
		time=0;
		taxiname=name;
	}
	public String getTaxiName() {
		return taxiname;
	}
	public String getPosition() {
		return position;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int pickuptime,int diff) {
		time=pickuptime+diff;
		if(time>=24) {
			time=24-time;
		}
	}
	public void setPosition(String pos) {
		position=pos;
	}
}
class CustomerDetails{
	String customername,start,dest;
	int time;
	int amount;
	public CustomerDetails() {
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
	public String getCustomerName() {
		return customername;
	}
	public String getStart() {
		return start;
	}
	public String getDest() {
		return dest;
	}
	public int getTime() {
		return time;
	}
	public void setAmount(String start,String dest) {
		int n=Math.abs(start.charAt(0)-dest.charAt(0));
		amount=n*15*10+50;
	}
	public int getAmount() {
		return amount;
	}
}
class TaxiBooking extends CallTaxi{
	public static void checkTaxi() {
		ArrayList<Integer>diff=new ArrayList<>();
		for(int i=0;i<num;i++) {
			if(alltaxi.get(i).getTime()<=customer.get(0).getTime()) {
				diff.add(Math.abs(alltaxi.get(i).getPosition().charAt(0)-(customer.get(0).getStart().charAt(0))));
			}
			else {
				diff.add(100);
			}
		}
		int distance=diff.indexOf(Collections.min(diff));
		if((Collections.min(diff))<100) {
			System.out.println("Your Booking is Confirmed with taxi Number "+alltaxi.get(distance).getTaxiName());
			customer.get(0).setAmount(customer.get(0).getStart(),customer.get(0).getDest());
			System.out.println("Amount for Journey is "+customer.get(0).getAmount());
			alltaxi.get(distance).setTime(customer.get(0).getTime(),Math.abs(customer.get(0).getStart().charAt(0)-customer.get(0).getDest().charAt(0)));
			alltaxi.get(distance).setPosition(customer.get(0).getDest());
			bookings.put(alltaxi.get(distance).getTaxiName(),BookingDetails.getlists(alltaxi.get(distance).getTaxiName(), distance));
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
			taxi1.add(new BookingDetails(customer.get(0).getCustomerName(),customer.get(0).getTime(),alltaxi.get(i).getTime(),customer.get(0).getAmount(),customer.get(0).getStart(),customer.get(0).getDest()));
			return taxi1;
		}
		else if(taxi.equals("Taxi 2")) {
			taxi2.add(new BookingDetails(customer.get(0).getCustomerName(),customer.get(0).getTime(),alltaxi.get(i).getTime(),customer.get(0).getAmount(),customer.get(0).getStart(),customer.get(0).getDest()));
			return taxi2;
		}
		else if(taxi.equals("Taxi 3")) {
			taxi3.add(new BookingDetails(customer.get(0).getCustomerName(),customer.get(0).getTime(),alltaxi.get(i).getTime(),customer.get(0).getAmount(),customer.get(0).getStart(),customer.get(0).getDest()));
			return taxi3;
		}
		else {
			taxi4.add(new BookingDetails(customer.get(0).getCustomerName(),customer.get(0).getTime(),alltaxi.get(i).getTime(),customer.get(0).getAmount(),customer.get(0).getStart(),customer.get(0).getDest()));
			return taxi4;
		}
	}
}