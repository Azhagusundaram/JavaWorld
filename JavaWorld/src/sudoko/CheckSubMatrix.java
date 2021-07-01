package sudoko;

public class CheckSubMatrix {
	public boolean submatrix(int[][] mat,int row,int col) {
		String str="123456789";
		for(int i=row-2;i<=row;i++) {
			for(int j=col-2;j<=col;j++) {
				String s=Integer.toString(mat[i][j]);
				if(str.contains(s)) {
					str=str.replace(s,"");
				}
			}
		}
		if(str.length()==0) 
			return true;
		else
			return false;

	}
		
}