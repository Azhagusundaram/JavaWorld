package com.zcoinexchange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ZCoinExchange {
	static HashMap<String,AccountDetails>account=new HashMap<String,AccountDetails>();
	static HashMap<String,AccountDetails>employee=new HashMap<String,AccountDetails>();
	static HashMap<Integer, AccountDetails>zidaccount=new HashMap<Integer, AccountDetails>();
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
class AccountDetails{
	String name,password,mail;
	int Zid,rc,zcoin;
	long mobilenumber;
	static float conversionrate=2f,commission;
	ArrayList<String>rctranshistory=new ArrayList<String>();
	ArrayList<String>zcointranshistory=new ArrayList<String>();
	static Scanner scan=new Scanner(System.in);
	public void setDetails(String name,int zid,String password) {
		this.name=name;
		this.Zid=zid;
		this.password=password;
	} 
	public AccountDetails customerDetails(String mail) {
		System.out.println("Enter the Name:");
		this.name=scan.nextLine();
		System.out.println("Enter the mobile number");
		this.mobilenumber=scan.nextLong();
		scan.nextLine();
		System.out.println("Set the Password:(it must have one uppercase letter,one lowercase letter and numbers");
		this.password=UserDetails.setPassword(name,mail);
		this.mail=mail;
		System.out.println("Enter the Initial Real Currency Deposit:");
		this.rc=scan.nextInt();
		scan.nextLine();
		return this;
	}
	public ArrayList<String> getRcTransaction() {
		return rctranshistory;
	}
	public ArrayList<String> getZcoinTransaction() {
		return zcointranshistory;
	}
	public void changePassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public void setZid(int Zid) {
		this.Zid=Zid;
	}
	public int getZid() {
		return Zid;
	}
	public String getMail() {
		return mail;
	}
	public int getRc() {
		return rc;
	}
	public int getZcoin() {
		return zcoin;
	}
	public void transferZcoin(int amount) {
		zcoin-=amount;
	}
	public void receiveZcoin(int amount) {
		zcoin+=amount;
	}
	public void depositRc(int amount) {
		rc+=amount;
		rctranshistory.add("Deposit amount: "+amount+" Amount Balance: "+rc);
	}
	public void withdrawlRc(int amount) {
		rc-=amount;
		rctranshistory.add("Withdrawl amount: "+amount+" Amount Balance: "+rc);
	}
	public void convertRcToZcoin(int amount) {
		zcoin+=(int)(amount*conversionrate);
		rc-=amount;
	}
	public void changeRate() {
		System.out.println("Enter the conversion rate RC to Zcoin");
		conversionrate=scan.nextFloat();
	}
	public void convertZcoinToRc(int amount) {
		commission+=(amount/conversionrate)*0.15f;
		rc+=(int)((amount/conversionrate)-(amount/conversionrate)*0.15f);
		zcoin-=amount;
	}
}
class UserDetails extends ZCoinExchange{
	static Scanner scan=new Scanner(System.in);
	public static void getUserDetails(String log) {
		System.out.println("Enter the ZID:");
		int zid=scan.nextInt();
		if(account.get(log).getZid()==zid) {
			System.out.println("RC Balance: "+account.get(log).getRc()+"ZCoin Balance: "+account.get(log).getZcoin());
		}
		else {
			System.out.println("Invalid Zid");
		}
	}
	public static String setPassword(String name,String mail) {
		String password="";
		while(!Pattern.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$&\\*\\.><]).{8,15}", password)) {
			System.out.println("Password must contains 8 to 15 Character.Password must have one uppercase letter,one lowercase letter and numbers.\nEnter the Password");
			password=scan.nextLine();
		}
		return password;
	}
	public static void rcTransaction(String mail) {
		System.out.println("1.Deposit\n2.Withdrawl\n3.RC to ZCoin Conversion");
		int des=scan.nextInt();
		if(des==1) {
			System.out.println("Enter the Deposit amount");
			account.get(mail).depositRc(scan.nextInt());
		}
		else if(des==2) {
			System.out.println("Enter the Withdrawl amount");
			int withdrawl=scan.nextInt();
			if(withdrawl>account.get(mail).getRc()) {
				System.out.println("Insufficient Money");
			}
			else {
				account.get(mail).withdrawlRc(withdrawl);
			}
		}
		else if(des==3) {
			System.out.println("Enter the RC to ZCoin Coversion amount");
			account.get(mail).convertRcToZcoin(scan.nextInt());
		}
	}
	public static void transactionHistory(String mail) {
		System.out.println("1.RC Transaction History\n2.ZCoin Transaction History");
		int trans=scan.nextInt();
		if(trans==1) {
			ArrayList <String>transhistory=new ArrayList<String>(account.get(mail).getRcTransaction());
			for(String str:transhistory) {
				System.out.println(str);
			}
		}
		else if(trans==2) {
			ArrayList <String>transhistory=new ArrayList<String>(account.get(mail).getZcoinTransaction());
			for(String str:transhistory) {
				System.out.println(str);
			}
		}
	}
	public static void zcoinTransaction(String mail) {
		System.out.println("1.ZCoinTransaction\n2.ZCoin to RC Conversion");
		int des=scan.nextInt();
		if(des==1) {
			System.out.println("Enter the Zid to transfer the amount");
			int zid=scan.nextInt();
			if(zidaccount.containsKey(zid)) {
				System.out.println("Enter the amount to transfer");
				int amount=scan.nextInt();
				if(account.get(mail).getZcoin()>amount) {
					account.get(mail).transferZcoin(amount);
					zidaccount.get(account.get(mail).getZid()).transferZcoin(amount);
					zidaccount.get(zid).receiveZcoin(amount);
					account.get(zidaccount.get(zid).getMail()).receiveZcoin(amount);
				}
				else {
					System.out.println("You don't have enough ZCoin");
				}
			}	
		}
		else if(des==2) {
			System.out.println("Enter the amount to convert zcoin to rc for wihdrawl");
			account.get(mail).convertZcoinToRc(scan.nextInt());
		}
		
	}
}
class Login{
	static Scanner scan=new Scanner(System.in);
	public static String login(HashMap <String,AccountDetails>account) {
		System.out.println("Enter your Email Id:");
		String mail=scan.nextLine();
		int j=0;
		while(j==0) {
			if(account.containsKey(mail)) {
				System.out.println("Enter your Password:");
				String pass=scan.nextLine();
						if((account.get(mail).getPassword()).equals(pass)) {
							if(account.get(mail).getZid()!=0) {
								j=1;
							}
							else {
								System.out.println("Account in Waiting List");
								break;
							}
						}
						else {
							System.out.println("Invalid password\nExit Enter 2");
							System.out.println("Enter Your Mail ID:");
							mail=scan.nextLine();
						}					
			}
			else
			{
			System.out.println("Exit Enter 2\nEnter the correct Mail ID:");
			mail=scan.nextLine();
			}
			if(mail=="2") {
				j=2;
				break;
			}
		}
		System.out.println("Now Your are Logged in"+" Name: "+account.get(mail).getName()+" H_ID:"+account.get(mail).getZid());
		return mail;
}
}
class EmployeePanel extends ZCoinExchange{
	static Scanner scan=new Scanner(System.in);
	public static void idGiven(ArrayList<String>mail){
		for(String mailid:mail){
			System.out.println(account.get(mailid).getName()+" "+account.get(mailid).getMail()+"\n1.Accept\t2.reject");
			int decision=scan.nextInt();
			if(decision==1) {
				System.out.println("Enter the ZID:");
				zidaccount.put(scan.nextInt(),account.get(mailid));
			}
			else if(decision==2) {
				account.remove(mailid);
			}
		}
	}
}
