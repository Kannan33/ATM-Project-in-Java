package com.service;

public class LoadCash {
	private int twoth;
	private int fivehun;
	private int hundred;
	private double balance;
	public LoadCash(int twoth, int fivehun, int hundred,long balance) {
		super();
		this.twoth = twoth;
		this.fivehun = fivehun;
		this.hundred = hundred;
		this.balance=balance;
	}
	public int getTwoth() {
		return twoth;
	}
	public void setTwoth(int twoth) {
		this.twoth = twoth;
	}
	public int getFivehun() {
		return fivehun;
	}
	public void setFivehun(int fivehun) {
		this.fivehun = fivehun;
	}
	public int getHundred() {
		return hundred;
	}
	public void setHundred(int hundred) {
		this.hundred = hundred;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Denomination	Number	 Value\n 2000	* 	" + twoth +" = 	"+twoth*2000 + "\n 500	* 	" + fivehun+" = 	"+fivehun*500 + "\n 100	*	" + hundred+" = 	 " +hundred*100+;
	}
}
