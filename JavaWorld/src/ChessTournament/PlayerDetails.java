package ChessTournament;
import java.util.Scanner;
public class PlayerDetails {
		String name;
		float point;
		public void setName(String name1) {
			name=name1;
		}		
		public String getname() {
			return name;
		}
		public void addpoints(float add) {
			point=point+add;
		}
		public float getpoints() {
			return point;
		}
		public static int decidewinner(int i,int j, PlayerDetails[] match) {
			System.out.print("1."+match[i].getname());
			System.out.println("2."+match[j].getname());
			System.out.println("who is winner? 1 or 2,if tied enter 3");
			Scanner scan = new Scanner(System.in);
			int won=scan.nextInt();
			scan.close();
			if(won==1) return 1;
			else if(won==2) return 2;
			else if(won==3) return 3;
			return 0;
		}
		public static void setpoints(int win,PlayerDetails[] match,int k,int l) {
			if(win==1) match[k].addpoints(1);
			else if(win==2) match[l].addpoints(1);
			else if(win==3) {
				match[k].addpoints(0.5f);
				match[l].addpoints(0.5f);
			}
		}
}
