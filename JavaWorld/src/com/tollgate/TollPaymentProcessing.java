package com.tollgate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TollPaymentProcessing {
	static int num=0,ind=0;
	public static void main(String[] args) {
		System.out.println("There are 8 points in Highway from Sivaganga to Chennai.They are");
		String[] stops=new String[]{"Sivaganga","Melur","Trichy","Perambalur","Villupuram","Sengalpattu","Tambaram","Chennai"};
		for(int i=0;i<8;i++) {
			System.out.print((i+1)+"."+stops[i]+"\t");
		}
		System.out.println("\nThere are 4 Tollgates in Highway from Sivaganga to Chennai.They are");
		ArrayList<String>tolls=new ArrayList<String>(Arrays.asList("Trichy","Perambalur","Villupuram","Tambaram"));
		for(int i=0;i<4;i++) {
			System.out.print((i+1)+"."+tolls.get(i)+"\t");
		}
		Scanner scan=new Scanner(System.in);
		
		ArrayList<Travelling>toll=new ArrayList<Travelling>();
		ArrayList<Tolls>alltolls=new ArrayList<Tolls>();
		System.out.println("\nDoes any vehicle travel between Sivaganga and Chennai(y/n)");
		String decision=scan.nextLine();
		while(decision.equals("y")) {
			toll.add(new Travelling());
			toll.get(num).getDetails();
			int begin=toll.get(num).getStart();
			int end=toll.get(num).getDest();
			ArrayList<String>journeystops=new ArrayList<String>();
			ArrayList<String>tollscrossed=new ArrayList<String>();
			ArrayList<Tolls>journeytolls=new ArrayList<Tolls>();
			for(int i=1;i<=8;i++) {
				if(i==begin) {
					for(int j=i;j<=end;j++) {
						journeystops.add(stops[j-1]);
						if(tolls.contains(stops[j-1])) {
							tollscrossed.add(stops[j-1]);
							journeytolls.add(new Tolls(stops[j-1]));	
						}
					}
				}
			}
			toll.get(num).setTolls(tollscrossed);
			for(Tolls str:journeytolls) {
				String s=str.getTollName();
				alltolls.add(new Tolls(s));
				alltolls.get(ind).setDetails(toll.get(num).getVehicleNumber(),toll.get(num).getVehicleNum()-1,str.getTollName(),toll.get(num).getVip());
				toll.get(num).paidAmount(alltolls.get(ind).getVehicleAmount());
				ind++;
			}
			System.out.println("Amount paid:"+toll.get(num).getAmount());
			System.out.println("Does any vehicle travel between Sivaganga and Chennai(y/n)");
			decision=scan.nextLine();
			num++;
		}
		System.out.println("Do u want individual details of all vehicles?(y/n)");
		if(scan.nextLine().equals("y")) {
			for(Travelling t:toll) {
				System.out.println("Vehicle Number:"+t.getVehicleNumber()+"\tVehicle Type:"+t.getVehicle()+"\tStarting point:"+stops[t.getStart()-1]+"\t Destination point:"+stops[t.getDest()-1]+"\tAmount Paid:"+t.getAmount()+"\nTolls in the journey");			
				System.out.println(t.getTolls());
			}
		}
		System.out.println("Do you want the individual details of all the Tolls?(y/n)");
		if(scan.nextLine().equals("y")) {
			int index=0,index1=0;
			for(String str:tolls) {
				System.out.println("\n\t"+str+" Toll");
				for(Tolls t:alltolls) {
					if(str.equals(t.getTollName())) {
						System.out.println("Vehicle Number :"+t.getVehicleNumber()+"\tAmount Paid:"+t.getVehicleAmount());
						index=alltolls.indexOf(t);
					}
				}
				System.out.println("Total Amount Paid in "+str+" Toll : "+alltolls.get(index).getTotalAmount(index1));
				index1++;
			}
		}
		scan.close();
	}
}
class Tolls{
	String vehiclenumber;
	int vehicleamount=0;
	String tollname;
	ArrayList<Integer>Trichy=new ArrayList<Integer>(Arrays.asList(50,80,175,190,275));
	ArrayList<Integer>Perambalur=new ArrayList<Integer>(Arrays.asList(40,70,165,180,255));
	ArrayList<Integer>Villupuram=new ArrayList<Integer>(Arrays.asList(45,75,170,185,265));
	ArrayList<Integer>Tambaram=new ArrayList<Integer>(Arrays.asList(55,90,195,200,295));

	static int[] totalamount=new int[4];
	public Tolls(String name) {
		this.tollname=name;
		}
	public void setDetails(String vehiclenum,int amt,String str,String vip) {
		vehiclenumber=vehiclenum;
		float dis=1f;
		if(vip.equals("y")) {dis=0.8f;}
		
		if(str.equals("Trichy")) {this.vehicleamount=(int)(dis*Trichy.get(amt));totalamount[0]=totalamount[0]+vehicleamount;}
		if(str.equals("Perambalur")) {this.vehicleamount=(int)(dis*Perambalur.get(amt));totalamount[1]=totalamount[1]+vehicleamount;}
		if(str.equals("Villupuram")) {this.vehicleamount=(int)(dis*Villupuram.get(amt));totalamount[2]=totalamount[2]+vehicleamount;}
		if(str.equals("Tambaram")) {this.vehicleamount=(int)(dis*Tambaram.get(amt));totalamount[3]=totalamount[3]+vehicleamount;}
	}
	public String getTollName() {
		return tollname;
	}
	public String getVehicleNumber() {
		return vehiclenumber;
	}
	public int getVehicleAmount() {
		return vehicleamount;
	}
	public int getTotalAmount(int i) {
		return totalamount[i];
	}
}
