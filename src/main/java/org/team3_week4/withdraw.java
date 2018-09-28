package org.team3_week4;

public class withdraw {
    private Man cust;
    public withdraw(Man cust){
        this.cust = cust;
    }
    public void withdraw(int Money){
        cust.Money -= Money;
        System.out.println(cust.ID+"님 계좌에서 "+Money+"원이 출금되었습니다.");
        System.out.println("잔액은 "+cust.Money+"원입니다.");
    }
}
