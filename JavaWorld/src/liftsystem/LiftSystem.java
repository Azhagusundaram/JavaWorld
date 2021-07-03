package liftsystem;
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
class Lift extends LiftSystem{
	int position;
	String liftname;
	public Lift(String name) {
		position=0;
		this.liftname=name;
	}
	public Lift() {
		for(int i=0;i<5;i++) {
			lifts.add(new Lift("lift "+(i+1)));
		}
	}
	public void changePosition(int position) {
		this.position=position;
	}
	public static void print() {
		System.out.print("\nLift  :");
	for(int i=0;i<5;i++) {
		System.out.print("\t"+lifts.get(i).liftname);
	}
		System.out.print("\nFloor :");
	for(int i=0;i<5;i++) {
		System.out.print("\t"+lifts.get(i).position);
	}
	}
	public static void getInput() {
		System.out.println("\nEnter the your starting and destination position");
		int start=scan.nextInt();
		int dest=scan.nextInt();
		Comparator<Lift>com=new Comparator<Lift>() {
			public int comparision(int position1,int position2) {
				if((Math.abs(start-position1)>Math.abs(start-position2))) 
					return 1;
				else if((Math.abs(start-position1)<Math.abs(start-position2))) 
					return -1;
				else if((Math.abs(start-position1)==Math.abs(start-position2))&&(Math.abs(dest-position1)<Math.abs(dest-position2))) 
					return 1;
				else if((Math.abs(start-position1)==Math.abs(start-position2))&&(Math.abs(dest-position1)>Math.abs(dest-position2))) 
					return -1;
				else
					return 0;
			}
			@Override
			public int compare(Lift o1, Lift o2) {
				if(start<=5&&dest<=5) {
					if((!o2.liftname.equals("lift 4")||!o2.liftname.equals("lift 5"))&&(o1.liftname.equals("lift 4")||o1.liftname.equals("lift 5"))) 
						return 1;
					else if((o2.liftname.equals("lift 4")||o2.liftname.equals("lift 5"))) 
						return -1;
					else 
						return comparision(o1.position,o2.position);
				}
				else if((start>5||start==0)&&(dest>5||dest==0)) {
					if((start>5&&dest==0)||(dest>5&&start==0)) {
						if((!o2.liftname.equals("lift 1")||!o2.liftname.equals("lift 2")||!o2.liftname.equals("lift 3"))&&(o1.liftname.equals("lift 1")||o1.liftname.equals("lift 2")||o1.liftname.equals("lift 3"))) 
							return 1;
						else if((o2.liftname.equals("lift 1")||o2.liftname.equals("lift 2")||o2.liftname.equals("lift 3"))) 
							return -1;
						else 
							return comparision(o1.position,o2.position);
					}
					else {
						if((!o2.liftname.equals("lift 1")||!o2.liftname.equals("lift 2"))&&(o1.liftname.equals("lift 1")||o1.liftname.equals("lift 2"))) 
							return 1;
						else if((o2.liftname.equals("lift 1")||o2.liftname.equals("lift 2"))) 
							return -1;
						else 
							return comparision(o1.position,o2.position);
					}
				}
				else {
					if((o2.liftname.equals("lift 3"))&&(!o1.liftname.equals("lift 3"))) 
						return 1;
					else if((!o2.liftname.equals("lift 3"))||(!o1.liftname.equals("lift 3"))) 
						return -1;
					else 
						return comparision(o1.position,o2.position);				
				}
			}
		};
		Comparator<Lift>comname=new Comparator<Lift>() {

			@Override
			public int compare(Lift o1, Lift o2) {
				return o1.liftname.compareTo(o2.liftname);
			}
			
		};
		lifts.sort(com);
		Lift selectedlift=lifts.get(0);
		selectedlift.changePosition(dest);
		lifts.sort(comname);
		
	}
}

