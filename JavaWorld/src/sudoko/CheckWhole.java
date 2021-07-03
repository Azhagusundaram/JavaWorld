package sudoko;
public class CheckWhole {
	public boolean entireColumn(int [][]mat,int col) {
		String str="123456789";
		for(int i=0;i<9;i++) {
				String s=Integer.toString(mat[i][col]);
				if(str.contains(s)) {
					str=str.replace(s,"");
			}
		}
		if(str.length()==0) 
			return true;
		else
			return false;
	}
		public boolean entireRow(int [][]mat,int row) {
			String str="123456789";
			for(int i=0;i<9;i++) {
					String s=Integer.toString(mat[row][i]);
					if(str.contains(s)) {
						str=str.replace(s,"");
				}
			}
		if(str.length()==0) 
			return true;
		else
			return false;

	}
}
