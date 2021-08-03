package com.zcoinexchange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ZCoinExchange {
	static HashMap<String,AccountDetails> account=new HashMap<String,AccountDetails>();
	static HashMap<String,AccountDetails> employee=new HashMap<String,AccountDetails>();
	static HashMap<Integer, AccountDetails> zidAccount =new HashMap<Integer, AccountDetails>();
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<String>waitinglist=new ArrayList<String>();
			String mailid="azg@gmail.com";
			AccountDetails emp1=new AccountDetails();
			emp1.setDetails("Azhagu",2262,"Asdf*2dfs");
			employee.put(mailid,emp1);
			mailid="qwe@gmail.com";
			AccountDetails emp2=new AccountDetails();
			emp2.setDetails("Sundaram",23234,"Asdf<2dfs");
			employee.put(mailid, emp2);
		while(true) {
		System.out.println("1.Signup\n2.Login\n3.Exit");
		int a=scan.nextInt();
		scan.nextLine();
		if(a==1)
		{
			System.out.println("Enter your mail id:");
			String mail=scan.nextLine();
			account.put(mail,new AccountDetails().customerDetails(mail));
			waitinglist.add(mail);
		}
		else if(a==2) {
			System.out.println("Login as\n1.Agent Login\t2.User Login\t3.Exit");
			int login=scan.nextInt();
			String mail;
			scan.nextLine();
			if(login==2) {
				mail=Login.login(account);
				if(account.get(mail).getZid()!=0) {
					int user=0;
					while(user!=6) {
					System.out.println("1.Account Details\n2.Transaction History of User\n3.Change Password\n4.RC Transaction\n5.ZCoin Transaction\n6.Exit");
					user=scan.nextInt();
					scan.nextLine();
					switch(user){
						case 1:
							UserDetails.getUserDetails(mail);
							break;
						case 2:
							UserDetails.transactionHistory(mail);
							break;
						case 3:
							account.get(mail).changePassword(UserDetails.setPassword(account.get(mail).getName(),mail));
							break;
						case 4:
							UserDetails.rcTransaction(mail);
							break;
						case 5:
							UserDetails.zcoinTransaction(mail);
							break;
					}
					}
				}
				else {
					System.out.println("Your account is not accepted yet.");
				}
			}
			else if(login==1) {
				mail=Login.login(employee);
					System.out.println("1.ZID Given\n2.Change coversion rate");
					int id=scan.nextInt();
					if(id==1) {
						EmployeePanel.idGiven(waitinglist);
						waitinglist.clear();
					}
					else if(id==2) {
						account.get(mail).changeRate();
					}
			}
			else if(login==3) {
				
			}
		}
		else if(a==3) {
			break;
		}
		}
	}

}




