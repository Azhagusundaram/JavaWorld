package com.lift;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class LiftSystem {
	static ArrayList<Lift>lifts=new ArrayList<>();
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		int l=1;
		new Lift();
		while(l==1) {
			System.out.println("\nThere are 5 lifts. lift 1 and lift 2 run between 0 to 5th floor,lift 4 and lift 5 run between 0 and 6th floor to 10th floor and lift 3 run between 0 to 10th floor");
			System.out.println("1.travel 2. exit");
			l=scan.nextInt();
			Lift.getInput();
			Lift.print();
		}
	}
}


