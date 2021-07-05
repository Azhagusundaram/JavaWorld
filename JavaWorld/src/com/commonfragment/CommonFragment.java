package com.commonfragment;
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
		ArrayList<String>words=ConvertStringToArray.stringToWords(str2);
		ArrayList<String>fullwords=ConvertStringToArray.stringToWords(str1);
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