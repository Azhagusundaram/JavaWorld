package RailwayReservation;
import java.util.Scanner;
public class RailwayTicketReservation {

	public static void main(String[] args) {
		int i=1;
		int wt=0,rt=0,ct=0;
		int lower=1,middle=2,upper=3,sideupper=55,sidelower=64;
		Scanner scan=new Scanner(System.in);
		Booking[] b=new Booking[92];
		String yn="no";
		System.out.println("Start the booking");
		while(true) {
			System.out.println("1.Are you booking:\n2.Are you cancel the ticket\n3.Printing Booking Tickets\n4.Available Tickets");
			String s= scan.nextLine();
			System.out.println(s);
			System.out.println((s.equals("1")));
			if(s.equals("1")) {
				System.out.println("Confirmed Tickets:"+ct);
				System.out.println("RAC Tickets:"+rt);
				System.out.println("Waiting List Tickets:"+wt);
				if(63>ct) {
					b[i]=new Booking();
					b[i].book();
					ct++;
					if(b[i].getgender().equals("Female")||b[i].getage()>=60) {
						if(lower<=52) {
							b[i].position("Lower"+lower);
							lower+=3;
						}
						else if(middle<=53){
							b[i].position("Middle"+middle);
							middle+=3;
						}
						else if(upper<=54){
							b[i].position("Upper"+upper);
							upper+=3;
						}
						else if(sideupper<=63){
							b[i].position("Side-Upper"+sideupper);
							sideupper+=1;
						}
					}
					else {
						if(middle<=53){
							b[i].position("Middle"+middle);
							middle+=3;
						}
						else if(upper<=54){
							b[i].position("Upper"+upper);
							upper+=3;
						}
						else if(sideupper<=63){
							b[i].position("Side-Upper"+sideupper);
							sideupper++;
						}
						else if(lower<=52) {
							b[i].position("Lower"+lower);
							lower+=3;
						}
					}
				}
				else if(18>rt) {
					b[i]=new Booking();
					b[i].book();
					rt++;
					if(sidelower<=81) {
						b[i].position("Side-Lower"+sidelower);
						sidelower++;
					}
				}
				else if(10>wt) {
					b[i]=new Booking();
					b[i].book();
					wt++;
				}
				else if(wt==10) {
					System.out.println("No Tickets Available");
				}
				i++;
			}
			if(s.equals("2")) {
				System.out.println("Enter Ticket number");
				int j=scan.nextInt();
				if(j<=63) {
					if(rt>0) {
						b[j].changebook(b[64].getname(),b[64].getage(),b[64].getgender(),b[64].getposition());
						if(wt>0) {
							b[64].changebook(b[82].getname(),b[82].getage(),b[82].getgender(),b[82].getposition());
							wt--;
						}
					}
				}
				else if(j>=81) {
					if(wt>0) {
						b[j].changebook(b[82].getname(),b[82].getage(),b[82].getgender(),b[82].getposition());
						wt--;
					}
				}
				else if(j<=91) {
					wt--;
				}
				i--;
			}
			if(s.equals("3")) {
				for(int k=1;k<i;k++) {
					System.out.println(b[k].getname()+" "+b[k].getage()+" "+b[k].getgender()+" "+b[k].getposition());
				}
				int result=(i-1>81)?81:(i-1);
				System.out.println("Number tickets booked:"+result);
			}
			if(s.equals("4")) {
				int result=(i-1<=81)?81-i+1:0;
				System.out.println("Number of tickets available:"+result);
			}
			System.out.println("Are you continueing the booking system:yes/no");
			yn=scan.nextLine();
			System.out.println(yn);
			if(yn=="no") {
				break;
			}
		}
	}
}
class Booking{
	Scanner scan=new Scanner(System.in);
	String name;
	int age;
	String gender;
	String position;
	public void book() {
		System.out.println("Enter the Name:");	
		name=scan.nextLine();
		System.out.println("Enter the Age:");
		age=scan.nextInt();
		System.out.println("Enter the Gender");
		scan.nextLine();
		gender=scan.nextLine();
	}
	public String getname() {
		return name;
	}
	public int getage() {
		return age;
	}
	public String getgender() {
		return gender;
	}
	public void changebook(String name1,int age1,String gender1,String pos1){
		name=name1;
		age=age1;
		gender=gender1;
		position=pos1;
	}
	public void position(String pos) {
		position=pos;
	}
	public String getposition() {
		return position;
	}
}

