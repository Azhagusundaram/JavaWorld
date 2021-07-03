package ChessTournament;
public class TournamentRounds {
	int win;
	public void playMatch(int num,PlayerDetails[] match) {
	System.out.println("First Round");
	for(int i=0;i<num/2;i++) {
		win=PlayerDetails.decideWinner(i,num-i-1,match);
		PlayerDetails.setPoints(win, match, i,num-i-1);
	}
	if(num%2==1) {
		PlayerDetails.setPoints(1,match,num/2,0);
	}
	System.out.println("Points Table after finishing First Round:");
	TournamentRounds.getTable(num, match);
	System.out.println("Second Round");
	for(int i=0;i<num/2;i++) {
		win=PlayerDetails.decideWinner(i,(num/2)+i,match);
		PlayerDetails.setPoints(win, match, i,(num/2)+i);
	}
	if(num%2==1) {
		PlayerDetails.setPoints(1,match,num-1,0);
	}
	System.out.println("Points Table after finishing Second Round:");
	TournamentRounds.getTable(num, match);
	System.out.println("Third Round");
	for(int i=0;i<(num/2)-1;i++) {
		win=PlayerDetails.decideWinner(i,(num/2)+i+1,match);
		PlayerDetails.setPoints(win, match, i,(num/2)+i+1);
	}
	win=PlayerDetails.decideWinner(num/2-1, num/2, match);
	if(num%2==1) {
		PlayerDetails.setPoints(1,match,num-1,0);
	}
	System.out.println("Points Table after finishing Third Round:");
	TournamentRounds.getTable(num, match);
	System.out.println("Fourth Round");
	for(int i=0;i<num/2-1;i++) {
		win=PlayerDetails.decideWinner(i,num-i-2,match);
		PlayerDetails.setPoints(win, match, i,num-i-2);
	}
	win=PlayerDetails.decideWinner(num/2-1, num-1, match);
	if(num%2==1) {
		PlayerDetails.setPoints(1,match,num/2,0);
	}
	System.out.println("The Final Points Table");
	TournamentRounds.getTable(num, match);
	}
	public static void getTable(int num,PlayerDetails[] match) {
	for(int j=0;j<num;j++) {
		System.out.println(match[j].getName()+" : "+match[j].getPoints());
	}
	}
}
