package org.team3_week4;
import java.util.Scanner;

class ATMmain {

    Scanner in = new Scanner(System.in);
    int choice = 0;

    ATMmain(){
        /**
         * this Method execute coverall Methods.
         */
        while(true) {
            showMenu();
            choice = in.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Exit System");
                    return;
                default :
                    System.out.println("You entered wrong number. Please re-enter.");
                    break;
            }
        }
    }

    void deposit(int money, Customer cust) {
	    cust.money += money;
    }

    void showAccount(Customer cust) {
	    System.out.println(cust.money + "Won");
    }

    void showMenu(){
        /**
         * to show menus in this Method
         * need :: to add Menus
         */

        System.out.println("1. Exit");
    }
}

