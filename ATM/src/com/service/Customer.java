package com.service;


import java.util.Arrays;
import java.util.List;

public class Customer {

	public  List<CustomerDetail> getAccount(){
		CustomerDetail[] detail=new CustomerDetail[]{
				new CustomerDetail(101,"Suresh",2343,25234),
				new CustomerDetail(102,"Ganesh",5432,34123),
				new CustomerDetail(103,"Magesh",7854,26100),
				new CustomerDetail(104,"Naresh",2345,80000),
				new CustomerDetail(105,"Harish",1907,103400)
		};
		return Arrays.asList(detail);
	}
	public  int accCheack(List<CustomerDetail> list,long acno,int mpin){
		int count=-1;
		for(CustomerDetail test: list){
			count++;
			if(test.getAccno()==acno && test.getPinno()==mpin){
				return count;
			}
		}
		return count;
	}
	public  int sendaccCheack(List<CustomerDetail> list,long acno){
		int count=-1;
		for(CustomerDetail test: list){
			count++;
			if(test.getAccno()==acno ){
				return count;
			}
		}
		return count;
	}
	public int[] findtype(long amt,LoadCash atm){
		int[] arr=new int[3];
			if(amt>=2000){
				int a=(int) amt/2000;
				if(a<=atm.getTwoth()) {
					arr[0]=a;
					amt=amt-(2000*arr[0]);
				}
			}
			if(amt>=500){
				int b=(int) amt/500;
				if(b<=atm.getFivehun()) {
					arr[1]=b;
					amt=amt-(b*500);
				}
			}
			if(amt>=100) {
				int c=(int) amt/100;
				if(c<=atm.getHundred()) {
					arr[2]=c;
					amt=amt-(100*c);
				}
			}
		return arr;
	}
}
