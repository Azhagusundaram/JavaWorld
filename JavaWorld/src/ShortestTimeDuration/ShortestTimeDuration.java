package ShortestTimeDuration;
import java.util.ArrayList;
public class ShortestTimeDuration{
	public void shortTime(String []times,int num){
		ArrayList<Integer> hhmmss=new ArrayList<Integer>();
		ArrayList<Integer> inseconds=new ArrayList<Integer>();
		ArrayList<Integer> diff=new ArrayList<Integer>();
		for(int i=0;i<num;i++){
			String str=times[i];
			String[] str1=str.split(":");
			for(int j=0;j<3;j++){		
				hhmmss.add(Integer.parseInt(str1[j]));
			}
		}
		for(int i=0;i<hhmmss.size();i=i+3){
			inseconds.add(hhmmss.get(i)*60*60+hhmmss.get(i+1)*60+hhmmss.get(i+2));
		}
		for(int i=0;i<inseconds.size()-1;i++){
			for(int j=i+1;j<inseconds.size();j++){
				diff.add(Math.abs(inseconds.get(i)-inseconds.get(j)));
			}
		}
		for(int i=1;i<diff.size();i++){
			if(diff.get(0)>diff.get(i))
				diff.set(0,diff.get(i));
		}
		System.out.println(diff.get(0)/3600+":"+(diff.get(0)/60)%60+":"+diff.get(0)%60);
		
	}
}
