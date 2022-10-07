package com.service;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerDetail implements Serializable{
	/**
	 * 
	 */
	public static ArrayList<CustomerDetail> c;
	private static final long serialVersionUID = 1L;
	private long accno;
	private String name;
	private int pinno;
	private double balance;
	public CustomerDetail(long accno, String name, int pinno, double balance) {
		super();
		this.accno = accno;
		this.name = name;
		this.pinno = pinno;
		this.balance = balance;
	}

	public long getAccno() {
		return accno;
	}


	public void setAccno(long accno) {
		this.accno = accno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPinno() {
		return pinno;
	}

	public void setPinno(int pinno) {
		this.pinno = pinno;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
