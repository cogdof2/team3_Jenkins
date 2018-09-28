package org.team3_week4;

public class ATMmain {
    public static void main(String args[]){
        Man a = new Man();

    }

    public static void deposit(int money, Man cust) {
	cust.money += money;
    }
    
    public static void showAccount(Man cust) {
	System.out.println(cust.money + "원");
   }
}

