package capitalTrustBank;

import java.util.Scanner;
import java.util.ArrayList;

class Account
{
	private int acccountNumber;
	private String accountType;
	private String serviceBranchIFSC;
	private float minimumBalance;
	private float availableBalance;
	private int customerID;
	private String customerName;
	private static int totalAccountCreated;

	Account()
	{
		acccountNumber =0;
		accountType= "";
		serviceBranchIFSC = "";
		minimumBalance = 0;
		availableBalance = 0;
		customerID = 0;
		customerName = "";
		totalAccountCreated++;
	}
	
	Account(int acc,String type,String branch,float min,float avail,int id,String name)
	{
		acccountNumber =acc;
		accountType= type;
		serviceBranchIFSC = branch;
		minimumBalance = min;
		availableBalance = avail;
		customerID = id;
		customerName = name;
		totalAccountCreated++;
	}
	
	public void setDetails()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the account no.");
		acccountNumber = sc.nextInt();
		String s = sc.nextLine();
		System.out.println("enter the account type");
		accountType = sc.nextLine();
		System.out.println("enter the Service branch IFSC");
		serviceBranchIFSC = sc.nextLine();
		System.out.println("enter minimum balance");
		minimumBalance = sc.nextFloat();
		System.out.println("enter available balance");
		availableBalance = sc.nextFloat();
		System.out.println("enter the customer id");
		customerID = sc.nextInt();
	    s = sc.nextLine();
		System.out.println("enter the customers name");
		customerName= sc.nextLine();
		
	}
	
	public void setDetails(int acc, String acctype, String branch, float min, float avail,int id, String name)
	{
		acccountNumber =acc;
		accountType= acctype;
		serviceBranchIFSC = branch;
		minimumBalance = min;
		availableBalance = avail;
		customerID = id;
		customerName = name;
	}
	public String getDetails(int accountNo)
	{
		String s = "The account no. is "+acccountNumber+"\nThe account type is "+accountType+"\nThe service branch IFSC is "+serviceBranchIFSC+"\nThe available balance is "+availableBalance+"\nThe customer id is "+customerID+"\nThe customer name is "+customerName;
		return s;
	}
	public void updatedetails(int accountNo)
	{
		int b;
		Scanner sc = new Scanner(System.in);
		
			
			System.out.println("Enter the no. for what you want to update:\n 1.Account type\n 2.Service branch IFSC\n 3.Customer id\n 4.customer name\n 5.Exit\n");
			b = sc.nextInt();
			switch(b) { 
			
			case 1:
				sc.nextLine();
				System.out.println("Enter the new account type");
				accountType = sc.nextLine();
				break;
			case 2:
				sc.nextLine();
				System.out.println("Enter the new service branch IFSC");
				serviceBranchIFSC = sc.nextLine();
				break;
			case 3:
				System.out.println("Enter the new customer id");
				customerID = sc.nextInt();
				
				break;
			case 4:
				String s1= sc.nextLine();
				System.out.println("Enter the new customer name");
				customerName = sc.nextLine();
				break;
			case 5:
				return;
			default:
				System.out.println("Wrong no. entered please enter again");
				break;
			
			}
			
	}
	
	public float getBalance(int accountNo)
	{
		return availableBalance;
	}
	
	public void deposit(int accountNo,float amount)
	{
		availableBalance = availableBalance + amount;
		System.out.printf("Amount deposited Successfully. The current balance is %f \n",availableBalance);
		
	}
	public void withdraw(int accountNo,float amount)
	{
		float current = (availableBalance - amount);
		if(current<minimumBalance)
		{
			System.out.println("Sorry, can't withdraw as there is no enough balance\n");
		}
		else
		{
			availableBalance = availableBalance - amount;
			System.out.printf("Amount withdrawl Successfully. The current balance is %f .\n",availableBalance);
			
		}
		
	}
	public static int totalAccount()
	{
		return totalAccountCreated;
	}
	public void compare( Account account1, Account account2){
        String s;
        if(account1.availableBalance<account2.availableBalance){
            s=account2.getDetails(account2.acccountNumber);
            System.out.println(s);
        }
        else{
            s=account1.getDetails(account1.acccountNumber);
            System.out.println(s);
        }
    }
	
	
	
}
public class CapitalTrustBank  {
  public static void main(String args[])
  {
	  int a;
	  
	  float amount;
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Account> b = new ArrayList<Account>();
	    Account b1 = new Account(0,"SAVING","HIN",11000,200000,1,"Heena Matlani");
	    Account b2 = new Account(1,"CURRENT","DIY",5000,11000,1,"Deepak");
		Account b3 = new Account(2,"SAVING","ISH",11000,30000,1,"Ishant");
		b.add(b1);
		b.add(b2);
		b.add(b3);
		Account operation = new Account();
	int acc;
		int i=3;
		
		while(true) {
		
		System.out.println("Enter the no. for what you wanna do from the options:\n 1.Update details\n 2.Get details\n 3.Deposit\n 4.Withdraw\n 5.Create an account\n 6.Total numbers of accounts\n 7.Compare accounts\n 8.Remove an account\n 9. Exit\n");
		a = sc.nextInt();
		switch(a) { 
		
		case 1:

			System.out.println("Enter the account no.");
			acc = sc.nextInt();
			b.get(acc).updatedetails(acc);
			break;
		case 2:
			System.out.println("Enter the account no.");
			acc = sc.nextInt();
			String s =b.get(acc).getDetails(acc);
			System.out.printf("%s\n",s);
			break;
		case 3:
			System.out.println("Enter the account no.");
			acc = sc.nextInt();
			System.out.println("Enter the amount");
			amount = sc.nextInt();
			b.get(acc).deposit(acc,amount);
			break;
		case 4:
			System.out.println("Enter the account no.");
			acc = sc.nextInt();
			System.out.println("Enter the amount");
			amount = sc.nextInt();
			b.get(acc).withdraw(acc,amount);
			break;
		case 5:
			Account acc0 = new Account();
			acc0.setDetails();
			i++;
			break;
		case 6:
			int accounts = Account.totalAccount();
			System.out.printf("The total numbers of account created is %d",accounts);
			break;
		case 7:
			System.out.println("Enter the first account no.");
			acc = sc.nextInt();
			System.out.println("Enter the second account no.");
			int acc1 = sc.nextInt();
			
				b.get(acc).compare(b.get(acc), b.get(acc1));
			
			break;
		case 8:
			System.out.println("Enter the account no.");
			acc = sc.nextInt();
			if(acc>i)
			{
				System.out.println("Not present");
			}
			else {
			b.remove(acc);
			}
			break;
		case 9:
			return;
		default:
			System.out.println("Wrong no. entered please enter again\n");
			break;
		
		}
		}
  }
}