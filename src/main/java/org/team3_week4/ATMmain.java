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
        System.out.println("=== :) ===");

        System.out.println("===Welcome to Team3 's ATM!!===");
        System.out.println("Please enter ID");
        System.out.println("==============");
        String Id = in.nextLine();
        cust.setID(Id);
        System.out.println("Please enter Password");
        System.out.println("==============");
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
                    showWarning();
                    System.out.println("Please enter the amount to be paid.");
                    money = in.nextInt();
                    deposit(money,cust);
                    break;
                case 3 :
                    showWarning();
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

    void showWarning() {
        String check="";
        in.nextLine();
        while(true){
            System.out.println("Are you doing this transaction after receiving a call from an agency (IRS, prosecutor's financial institution, etc.) or a stranger?");
            System.out.println("Y / N");
            check = in.nextLine();

            if(check.equals("y")|| check.equals("Y")){
                System.out.println("Be careful of voice phishing.");
                System.out.println("Exit System");
                System.exit(0);
            }
            else if(check.equals("n") || check.equals("N")){
                break;
            }
            else{
                System.out.println("Wrong input.");
            }
        }


    }

    void showMenu(){
        /**
         * to show menus in this Method
         * need :: to add Menus
         */
        showOpening();
        System.out.println("==============");
        System.out.println("1. Exit");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. ShowAccount");
        System.out.println("==============");
    }

    void showOpening(){
        System.out.println("_______ ______          __  __   ____          _______ __  __ ");
        System.out.println(" |__   __|  ____|   /\\   |  \\/  | |___ \\      /\\|__   __|  \\/  |");
        System.out.println("    | |  | |__     /  \\  | \\  / |   __) |    /  \\  | |  | \\  / |");
        System.out.println("    | |  |  __|   / /\\ \\ | |\\/| |  |__ <    / /\\ \\ | |  | |\\/| |");
        System.out.println("    | |  | |____ / ____ \\| |  | |  ___) |  / ____ \\| |  | |  | |");
        System.out.println("    |_|  |______/_/    \\_\\_|  |_| |____/  /_/    \\_\\_|  |_|  |_|");

    }
}

