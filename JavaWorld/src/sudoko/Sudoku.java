package sudoko;
import java.util.Scanner;
public class Sudoku {
	public static void main(String[] args) {
		int row=2,count=0,colcount=0,rowcount=0;
		int [][] mat=new int[9][9];
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<9;i++) {
			for(int j = 0;j<9;j++) {
				mat[i][j]=scan.nextInt();
			}
		}
		CheckSubMatrix sub= new CheckSubMatrix();
		for(int i=0;i<3;i++) {
			int col=2;
			for(int j=0;j<3;j++) {
				if(sub.subMatrix(mat,row,col))
					count++;
				col=col+3;
			}
			row=row+3;
		}
		CheckWhole full=new CheckWhole();
		for(int i=0;i<9;i++) {
			if(full.entireColumn(mat,i))
				colcount++;	
		}
		for(int i=0;i<9;i++) {
			if(full.entireRow(mat,i))
				rowcount++;
		}
		if(count==9&&colcount==9&&rowcount==9)
			System.out.println("yes");
		else
			System.out.println("no");
}
}
