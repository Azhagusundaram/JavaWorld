package ShortestTimeDuration;
import java.util.Scanner;
public class TestRunner
{
	private static Scanner scan;

	public static void main(String [] args)
	{
		scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		String [] times=new String[num];
		for(int i=0;i<num;i++){
			times[i]=scan.nextLine();
		}
		ShortestTimeDuration std=new ShortestTimeDuration();
		std.shortTime(times,num);
	}
}
