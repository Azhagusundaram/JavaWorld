package com.substring;
public class TestRunner1 {

	public static void main(String[] args) {
		String str1="WELCOMETOZOHOCORPORATION";
		String str2="too";
		SubStringin2D obj=new SubStringin2D();
		obj.check(str1,str2);
	}
}
/*
 Save the string “WELCOMETOZOHOCORPORATION” in a two dimensional array and search 
for substring like “too” in the two dimensional string both from left to right and from top to bottom.
w E L C O
M E T O Z
O H O C O
R P O R A
T I O n 
And print the start and ending index as
Start index : <1,2>
End index: <3, 2>
*/