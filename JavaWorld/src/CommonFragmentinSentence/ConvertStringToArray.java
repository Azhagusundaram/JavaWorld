package CommonFragmentinSentence;
import java.util.ArrayList;
public class ConvertStringToArray
{
	public static ArrayList<String> stringtowords(String str)
	{
		ArrayList<String> words= new ArrayList<String>();
		int j=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' '||i==str.length()-1){
				String word="";
				while(j<=i){
					word=word+str.charAt(j);
					j++;
				}
				j=i+1;
				words.add(word);
			}	
		}
		return words;
	}
}