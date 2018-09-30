package org.team3_week4;
import java.util.Scanner;

class ATMmain {

    Scanner in = new Scanner(System.in);
    int choice = 0;

    ATMmain(){
        /**
         * this Method execute coverall Methods.
         */
        Customer cust = new Customer();
        System.out.println("Please enter ID");
        String Id = in.nextLine();
        cust.setID(Id);
        System.out.println("Please enter Password");
        int Pw = in.nextInt();
        cust.setPW(Pw);

        while(true) {
            showMenu();
            choice = in.nextInt();
            int money = 0;
            switch(choice) {
                case 1:
                    System.out.println("Exit System");
                    return;
                case 2 :
                    System.out.println("Please enter the amount to be paid.");
                    money = in.nextInt();
                    deposit(money,cust);
                    break;
                case 3 :
                    System.out.println("Please enter the amount to be paid.");
                    money = in.nextInt();
                    withdraw(money,cust);
                    break;
                case 4 :
                    showAccount(cust); break;
                default :
                    System.out.println("You entered wrong number. Please re-enter.");
                    break;
            }
        }
    }

    void deposit(int money, Customer cust) {
        cust.setMoney(cust.getMoney()+money);
        showAccount(cust);
    }
    void withdraw(int money, Customer cust) {
        if(cust.getMoney()>=money)
            cust.setMoney(cust.getMoney()-money);
        showAccount(cust);
    }
    void showAccount(Customer cust) {
        System.out.println("Your balance is "+cust.getMoney() + "Won");
        System.out.println();
    }

    void showMenu(){
        /**
         * to show menus in this Method
         * need :: to add Menus
         */
        System.out.println("1. Exit");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. ShowAccount");
    }
}

