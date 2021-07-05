package com.commonfragment;
import java.util.Scanner;
import java.util.ArrayList;
public class TestRunner3
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of sentence");
		int num = scan.nextInt();
		scan.nextLine();
		String[] str=new String[num];
		for(int i=0;i<num;i++) {
			System.out.println("Enter the sentence"+(i+1));
			str[i]=scan.nextLine();
		}
		CommonFragment similar=new CommonFragment();
		similar.common(str,num);
	}
}
