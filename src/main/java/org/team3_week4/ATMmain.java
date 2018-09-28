package org.team3_week4;

public class ATMmain {
    public static void main(String args[]){
        Man a = new Man();

        a.setID("권희수");
        a.setPW(1111);
        a.setMoney(50000);

        withdraw A= new withdraw(a);
        A.withdraw(10000);
    }
}

