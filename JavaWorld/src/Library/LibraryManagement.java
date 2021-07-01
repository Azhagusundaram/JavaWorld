package Library;
import java.util.Scanner;
public class LibraryManagement {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("1.Admin 2.Student 3.exit");
		int des=scan.nextInt();		
	}
}
class Student{
	int roll;
	String name;
	static Scanner scan = new Scanner(System.in);
	public Student() {
		System.out.println("Enter the Name:");
		scan.nextLine();
		System.out.println("Enter the Roll Number:");
		scan.nextInt();
	}
}