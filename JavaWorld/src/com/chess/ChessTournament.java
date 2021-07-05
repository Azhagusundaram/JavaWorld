package com.chess;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class ChessTournament {
	static Scanner scan = new Scanner(System.in);
	public static void main(String [] args){
		  	int num;
		  	System.out.println("Number of players must be greater than 8");
		  	System.out.println("Enter the number of players:");
			num=scan.nextInt();
			scan.nextLine();
			PlayerDetails match[]=new PlayerDetails[num];
			for(int i=0;i<num;i++) {
				match[i]=new PlayerDetails();
				System.out.println("Enter the player name :"+(i+1));
				match[i].setName(scan.nextLine());
			}
			TournamentRounds rounds= new TournamentRounds();
			rounds.playMatch(num,match);
			ArrayList<Float>pointstable=new ArrayList<Float>();
			ArrayList<String>winners=new ArrayList<String>();
			for(int i=0;i<num;i++) {
				pointstable.add(match[i].getPoints());
			}
			float max=Collections.max(pointstable);
			for(int i=0;i<num;i++) {
				if(match[i].getPoints()==max) {
					winners.add(match[i].getName());
				}
			}
			System.out.println("The Winner of the chessTournament :");
			for(String w:winners) {
				System.out.println(w);
			}
	}			
}
