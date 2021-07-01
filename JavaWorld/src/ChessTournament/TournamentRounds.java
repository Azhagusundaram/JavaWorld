package ChessTournament;
public class TournamentRounds {
	int win;
	public void playmatch(int num,PlayerDetails[] match) {
	System.out.println("First Round");
	for(int i=0;i<num/2;i++) {
		win=PlayerDetails.decidewinner(i,num-i-1,match);
		PlayerDetails.setpoints(win, match, i,num-i-1);
	}
	if(num%2==1) {
		PlayerDetails.setpoints(1,match,num/2,0);
	}
	System.out.println("Points Table after finishing First Round:");
	TournamentRounds.gettable(num, match);
	System.out.println("Second Round");
	for(int i=0;i<num/2;i++) {
		win=PlayerDetails.decidewinner(i,(num/2)+i,match);
		PlayerDetails.setpoints(win, match, i,(num/2)+i);
	}
	if(num%2==1) {
		PlayerDetails.setpoints(1,match,num-1,0);
	}
	System.out.println("Points Table after finishing Second Round:");
	TournamentRounds.gettable(num, match);
	System.out.println("Third Round");
	for(int i=0;i<(num/2)-1;i++) {
		win=PlayerDetails.decidewinner(i,(num/2)+i+1,match);
		PlayerDetails.setpoints(win, match, i,(num/2)+i+1);
	}
	win=PlayerDetails.decidewinner(num/2-1, num/2, match);
	if(num%2==1) {
		PlayerDetails.setpoints(1,match,num-1,0);
	}
	System.out.println("Points Table after finishing Third Round:");
	TournamentRounds.gettable(num, match);
	System.out.println("Fourth Round");
	for(int i=0;i<num/2-1;i++) {
		win=PlayerDetails.decidewinner(i,num-i-2,match);
		PlayerDetails.setpoints(win, match, i,num-i-2);
	}
	win=PlayerDetails.decidewinner(num/2-1, num-1, match);
	if(num%2==1) {
		PlayerDetails.setpoints(1,match,num/2,0);
	}
	System.out.println("The Final Points Table");
	TournamentRounds.gettable(num, match);
	}
	public static void gettable(int num,PlayerDetails[] match) {
	for(int j=0;j<num;j++) {
		System.out.println(match[j].getname()+" : "+match[j].getpoints());
	}
	}
}
