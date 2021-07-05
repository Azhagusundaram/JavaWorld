package com.tollgate;

import java.util.ArrayList;
import java.util.Scanner;

public class Travelling{
		Scanner scan=new Scanner(System.in);
		int start,dest,vehicle;
		String vip,vehiclenumber;
		ArrayList<String>tollscrossed=new ArrayList<>();
		int amount=0;
		public void getDetails() {
				System.out.println("Enter the Starting point\n1.Sivaganga 2.Melur 3.Trichy 4.Perambalur\n5.Villupuram 6.Sengalpattu 7.Tambaram 8.Chennai");
				start=scan.nextInt();
				System.out.println("Enter the Destination Point\n1.Sivaganga 2.Melur 3.Trichy 4.Perambalur\n5.Villupuram 6.Sengalpattu 7.Tambaram 8.Chennai");
				dest=scan.nextInt();
				System.out.println("Enter the type of the Vehicle");
				System.out.println("1.Car/Jeep/Van\n2.LCV\n3.Bus/Truck\n4.Upto 3 Axle\n5.Above 3 Axle/HCM");
				vehicle=scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the Vehicle Number");
				vehiclenumber=scan.nextLine();
				System.out.println("Is it a VIP Traveller(y/n)");
				vip=scan.nextLine();
			}
		public void setTolls(ArrayList<String> journeytolls) {
			tollscrossed.addAll(journeytolls);
		}
		public ArrayList<String> getTolls() {
			return tollscrossed;
		}
		public int getStart() {
			return start;
		}
		public int getDest() {
			return dest;
		}
		public String getVip() {
			return vip;
		}
		public int getVehicleNum() {
			return vehicle;
		}
		public String getVehicle() {
			String []vehicles=new String[] {"Car/jeep/van","LCV","Bus/Truck","Upto 3 Axle","Above 3 Axle/HCM"};
			return vehicles[vehicle-1];
		}
		public void paidAmount(int amt) {
				amount=amount+amt;
		}
		public int getAmount() {
			return amount;
		}
		public String getVehicleNumber() {
			return vehiclenumber;
		}
}
