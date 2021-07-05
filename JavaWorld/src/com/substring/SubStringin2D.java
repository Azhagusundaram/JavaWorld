package com.substring;
public class SubStringin2D {
	public void check(String str1,String str2) {
		int len=str1.length();
		int k=0;
		double num=Math.sqrt(len);
		if(num!=(int)num) {
			num=(int)num+1;
		}
		char arr[][]=new char[(int) num][(int) num];
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				if(k>=len) {
					break;
				}
				arr[i][j]=str1.charAt(k);
				k++;				
			}
		}
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
		str2=str2.toUpperCase();
		for(int i=0;i<num-2;i++) {
			for(int j=0;j<num-2;j++) {
				if(arr[i][j]==str2.charAt(0)) {
					if(arr[i+1][j]==str2.charAt(1)) {
						if(arr[i+2][j]==str2.charAt(2)) {
							System.out.println("Start index: "+i+","+j);
							System.out.println("End index: "+(i+2)+","+j);
						}
					}
					else if(arr[i][j+1]==str2.charAt(1)){
						if(arr[i][j+2]==str2.charAt(2)) {
							System.out.println("Start index: "+i+","+j);
							System.out.println("End index: "+i+","+(j+2));
						}
					}
				}
			}
		}
}
}