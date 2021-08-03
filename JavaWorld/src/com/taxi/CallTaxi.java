package com.taxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CallTaxi {
	static int num=4;
	static ArrayList<TaxiDetails> allTaxi =new ArrayList<>();
	static ArrayList<CustomerDetails> customer=new ArrayList<>();
	static HashMap<String,ArrayList<BookingDetails>> bookings=new HashMap<String,ArrayList<BookingDetails>>();
	public static void main(String[] args) {
		ArrayList<String>taxis=new ArrayList<>();
		for(int i=1;i<=num;i++) {
			taxis.add("Taxi "+i);
			allTaxi.add(new TaxiDetails(taxis.get(i-1)));
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
		TaxiBooking.taxiDetails();
		scan.close();
		
	}
}

