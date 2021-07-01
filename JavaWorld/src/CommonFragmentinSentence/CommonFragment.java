package CommonFragmentinSentence;
import java.util.ArrayList;
public class CommonFragment
{
	public void  common(String[] str,int num)
	{
		String str1="";
		for(int i=0;i<num;i++){
			str1=str1+str[i]+" ";
		}
		String str2=str[0];
		ArrayList<String>words=ConvertStringToArray.stringtowords(str2);
		ArrayList<String>fullwords=ConvertStringToArray.stringtowords(str1);
		for(String k:words){
			int count=0;
			for(int i=0;i<fullwords.size();i++){
				if(k.equals(fullwords.get(i))){
					count++;
				}
			}
			if(count==num)
				System.out.print(k);
		}
	}
}