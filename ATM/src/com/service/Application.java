package com.service;

import java.util.List;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		System.out.println("\t\tWelcome to ATM");
		Scanner s=new Scanner(System.in);
		Customer op=new Customer();
		List<CustomerDetail> list=op.getAccount();
		LoadCash atm=null;
		boolean flag=true;
		do{
			System.out.println("\t< Enter the option >\n 1.Load Cash\n 2.Account Detail\n 3.Process");
			int choise=s.nextInt();
			switch (choise) {
			case 1:
				int am100,am500,am2000;
				System.out.println("Enter Cash Detail in Forllowing Order : 100s 500s 2000s");
				am100=s.nextInt();
				am500=s.nextInt();
				am2000=s.nextInt();
				int bal=(am2000*2000)+(am500*500)+(am100*100);
				if(am100<=1000 && am500<=600 && am2000<300){
					atm=new LoadCash(am2000, am500, am100,bal);
					System.out.println(String.format("%-15s%-20s%-15s","Denomination","Number","Value"));
					System.out.println(String.format("%-15s%-20s%-15s","2000",atm.getTwoth(),atm.getTwoth()*2000));
					System.out.println(String.format("%-15s%-20s%-15s","500",atm.getFivehun(),atm.getFivehun()*500));
					System.out.println(String.format("%-15s%-20s%-15s","2000",atm.getHundred(),atm.getHundred()*100));
					System.out.println("Total Amount Available in ATM = " + atm.getBalance()+"\n");
				}else{
					System.out.println("Deposit Value Exceeded\n");
				}
				break;
			case 2:
				System.out.println("< Customer Details >\n");
				System.out.println(String.format("%-15s%-20s%-20s%-20s","Acc No","Account Number","Pin Number","Account Balance"));
				for(CustomerDetail c: list){
					System.out.println(String.format("%-15s%-20s%-20s%-20s","Acc No",c.getAccno(),c.getName(),c.getPinno(),c.getBalance()));
				}
				break;
			case 3:
				long accNo;
				int mpin;
				System.out.print("Enter Your AccountNumber : ");
				accNo=s.nextLong();
				System.out.print("Enter Your Mpin : ");
				mpin=s.nextInt();
				int index=op.accCheack(list,accNo,mpin);
				if(index>=0){
					CustomerDetail ct=list.get(index);
					boolean tag=true;
					System.out.println("\t< Select Option >\n 1.Cheak Balance\n 2.withdraw Money\n 3.Transfer Money\n 4.Cheak ATM Balance\n 5.exit");
					do {
						int ch=s.nextInt();
						switch(ch){
						case 1:
							System.out.println("Your Balance is : "+ct.getBalance()+"\n");
							break;
						case 2:
							System.out.print("Enter Amount : ");
							long wdamt=s.nextLong();
							if(wdamt%100==0){
								int arr[]=op.findtype(wdamt, atm);							
								atm.setTwoth(atm.getTwoth()-arr[0]);
								atm.setFivehun(atm.getFivehun()-arr[1]);
								atm.setHundred(atm.getHundred()-arr[2]);
								ct.setBalance(ct.getBalance()-wdamt);
								atm.setBalance(atm.getBalance()-wdamt);
								list.set(index, ct);
								System.out.println("Amount Withdrawn Succesfully");
								System.out.println("Your Current Balance : "+ct.getBalance()+"\n");
							}else {
								System.out.println("Enter The Valid Amount !\n");
							}
							break;
						case 3:
							System.out.print("Account Number of Sender : ");
							long accno=s.nextLong();
							int pos=op.sendaccCheack(list, accno);
							if(pos>=0){
								CustomerDetail sendacc=list.get(pos);
								System.out.print("Enter Amouunt : ");
								long amt=s.nextInt();
								if(amt>=1000 && amt<=10000){
									ct.setBalance(ct.getBalance()-amt);
									list.set(index, ct);
									sendacc.setBalance(sendacc.getBalance()+amt);
									list.set(pos, sendacc);
									System.out.println("Amount Transferred Succesfully");
									System.out.println("Your Current Balance = "+ct.getBalance()+"\n");
								}else{
									System.out.println("Transfer Limit Exceeded\n");
								}
							}else{
								System.out.println("Account not Found !\n");
							}
							break;
						case 4:
							System.out.println(String.format("%-15s%-20s%-15s","Denomination","Number","Value"));
							System.out.println(String.format("%-15s%-20s%-15s","2000",atm.getTwoth(),atm.getTwoth()*2000));
							System.out.println(String.format("%-15s%-20s%-15s","500",atm.getFivehun(),atm.getFivehun()*500));
							System.out.println(String.format("%-15s%-20s%-15s","2000",atm.getHundred(),atm.getHundred()*100));
							System.out.println("Total Amount Available in ATM = " + atm.getBalance()+"\n");
							break;
						case 5:
							System.out.println("Exited\n");
							tag=false;
							break;
						default:
							tag=false;
						}
					}while(tag);
				}else{
					System.out.println("Invalid Username Or PassWord\n");
					s.close();
				}
				break;
			default:
				System.out.println("\n\t\tTHANK YOU");
				flag=false;
				s.close();
			}
		}while(flag);
	}
}
