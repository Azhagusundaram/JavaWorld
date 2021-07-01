package ZCoin_Exchange;
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
			emp1.setdetails("Azhagu",2262,"Asdf*2dfs");
			employee.put(mailid,emp1);
			mailid="qwe@gmail.com";
			AccountDetails emp2=new AccountDetails();
			emp2.setdetails("Sundaram",23234,"Asdf<2dfs");
			employee.put(mailid, emp2);
		while(true) {
		System.out.println("1.Signup\n2.Login\n3.Exit");
		int a=scan.nextInt();
		scan.nextLine();
		if(a==1)
		{
			System.out.println("Enter your mail id:");
			String mail=scan.nextLine();
			account.put(mail,new AccountDetails().CustomerDetails(mail));
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
							UserDetails.getuserdetails(mail);
							break;
						case 2:
							UserDetails.transactionhistory(mail);
							break;
						case 3:
							account.get(mail).changepassword(UserDetails.setpassword(account.get(mail).getname(),mail));
							break;
						case 4:
							UserDetails.rctransaction(mail);
							break;
						case 5:
							UserDetails.zcointransaction(mail);
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
						EmployeePanel.idgiven(waitinglist);
						waitinglist.clear();
					}
					else if(id==2) {
						account.get(mail).changerate();
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
	public void setdetails(String name,int zid,String password) {
		this.name=name;
		this.Zid=zid;
		this.password=password;
	} 
	public AccountDetails CustomerDetails(String mail) {
		System.out.println("Enter the Name:");
		this.name=scan.nextLine();
		System.out.println("Enter the mobile number");
		this.mobilenumber=scan.nextLong();
		scan.nextLine();
		System.out.println("Set the Password:(it must have one uppercase letter,one lowercase letter and numbers");
		this.password=UserDetails.setpassword(name,mail);
		this.mail=mail;
		System.out.println("Enter the Initial Real Currency Deposit:");
		this.rc=scan.nextInt();
		scan.nextLine();
		return this;
	}
	public ArrayList<String> getrctransaction() {
		return rctranshistory;
	}
	public ArrayList<String> getzcointransaction() {
		return zcointranshistory;
	}
	public void changepassword(String password) {
		this.password=password;
	}
	public String getpassword() {
		return password;
	}
	public String getname() {
		return name;
	}
	public void setZid(int Zid) {
		this.Zid=Zid;
	}
	public int getZid() {
		return Zid;
	}
	public String getmail() {
		return mail;
	}
	public int getrc() {
		return rc;
	}
	public int getzcoin() {
		return zcoin;
	}
	public void transferzcoin(int amount) {
		zcoin-=amount;
	}
	public void receivezcoin(int amount) {
		zcoin+=amount;
	}
	public void depositrc(int amount) {
		rc+=amount;
		rctranshistory.add("Deposit amount: "+amount+" Amount Balance: "+rc);
	}
	public void withdrawlrc(int amount) {
		rc-=amount;
		rctranshistory.add("Withdrawl amount: "+amount+" Amount Balance: "+rc);
	}
	public void convertrctozcoin(int amount) {
		zcoin+=(int)(amount*conversionrate);
		rc-=amount;
	}
	public void changerate() {
		System.out.println("Enter the conversion rate RC to Zcoin");
		conversionrate=scan.nextFloat();
	}
	public void convertzcointorc(int amount) {
		commission+=(amount/conversionrate)*0.15f;
		rc+=(int)((amount/conversionrate)-(amount/conversionrate)*0.15f);
		zcoin-=amount;
	}
}
class UserDetails extends ZCoinExchange{
	static Scanner scan=new Scanner(System.in);
	public static void getuserdetails(String log) {
		System.out.println("Enter the ZID:");
		int zid=scan.nextInt();
		if(account.get(log).getZid()==zid) {
			System.out.println("RC Balance: "+account.get(log).getrc()+"ZCoin Balance: "+account.get(log).getzcoin());
		}
		else {
			System.out.println("Invalid Zid");
		}
	}
	public static String setpassword(String name,String mail) {
		String password="";
		while(!Pattern.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$&\\*\\.><]).{8,15}", password)) {
			System.out.println("Password must contains 8 to 15 Character.Password must have one uppercase letter,one lowercase letter and numbers.\nEnter the Password");
			password=scan.nextLine();
		}
		return password;
	}
	public static void rctransaction(String mail) {
		System.out.println("1.Deposit\n2.Withdrawl\n3.RC to ZCoin Conversion");
		int des=scan.nextInt();
		if(des==1) {
			System.out.println("Enter the Deposit amount");
			account.get(mail).depositrc(scan.nextInt());
		}
		else if(des==2) {
			System.out.println("Enter the Withdrawl amount");
			int withdrawl=scan.nextInt();
			if(withdrawl>account.get(mail).getrc()) {
				System.out.println("Insufficient Money");
			}
			else {
				account.get(mail).withdrawlrc(withdrawl);
			}
		}
		else if(des==3) {
			System.out.println("Enter the RC to ZCoin Coversion amount");
			account.get(mail).convertrctozcoin(scan.nextInt());
		}
	}
	public static void transactionhistory(String mail) {
		System.out.println("1.RC Transaction History\n2.ZCoin Transaction History");
		int trans=scan.nextInt();
		if(trans==1) {
			ArrayList <String>transhistory=new ArrayList<String>(account.get(mail).getrctransaction());
			for(String str:transhistory) {
				System.out.println(str);
			}
		}
		else if(trans==2) {
			ArrayList <String>transhistory=new ArrayList<String>(account.get(mail).getzcointransaction());
			for(String str:transhistory) {
				System.out.println(str);
			}
		}
	}
	public static void zcointransaction(String mail) {
		System.out.println("1.ZCoinTransaction\n2.ZCoin to RC Conversion");
		int des=scan.nextInt();
		if(des==1) {
			System.out.println("Enter the Zid to transfer the amount");
			int zid=scan.nextInt();
			if(zidaccount.containsKey(zid)) {
				System.out.println("Enter the amount to transfer");
				int amount=scan.nextInt();
				if(account.get(mail).getzcoin()>amount) {
					account.get(mail).transferzcoin(amount);
					zidaccount.get(account.get(mail).getZid()).transferzcoin(amount);
					zidaccount.get(zid).receivezcoin(amount);
					account.get(zidaccount.get(zid).getmail()).receivezcoin(amount);
				}
				else {
					System.out.println("You don't have enough ZCoin");
				}
			}	
		}
		else if(des==2) {
			System.out.println("Enter the amount to convert zcoin to rc for wihdrawl");
			account.get(mail).convertzcointorc(scan.nextInt());
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
						if((account.get(mail).getpassword()).equals(pass)) {
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
		System.out.println("Now Your are Logged in"+" Name: "+account.get(mail).getname()+" H_ID:"+account.get(mail).getZid());
		return mail;
}
}
class EmployeePanel extends ZCoinExchange{
	static Scanner scan=new Scanner(System.in);
	public static void idgiven(ArrayList<String>mail){
		for(String mailid:mail){
			System.out.println(account.get(mailid).getname()+" "+account.get(mailid).getmail()+"\n1.Accept\t2.reject");
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
