package org.team3_week4;
import java.util.HashMap;
import java.util.Scanner;

class ATMmain {

    Scanner in = new Scanner(System.in);
    HashMap<String, Customer> customers; // All Customers Data (access by ID(key))

    Customer tempCust;
    Customer curCust; // Customer who logged in


    ATMmain() {
        customers = new HashMap<>();
        tempCust = new Customer();

        execute();
    }

    /**
     * UI Part
     */

    void execute() {
        /**
         * this Method execute coverall Methods.
         */
        showOpening();

        int choice = 0;

        while (true) {
            int money = 0;

            if (curCust == null) {
                showMenu(0);
                choice = in.nextInt(); in.nextLine();

                switch (choice) {
                    case 1:
                        makeAccount();
                        break;
                    case 2:
                        login();
                        break;
                    case 3 :
                        System.out.println("Exit System");
                        return;

                }
            } else {
                showMenu(1);
                choice = in.nextInt(); in.nextLine();
                switch (choice) {

                    case 1:
                        showWarning();
                        System.out.println("Please enter the amount to be paid.");
                        money = in.nextInt();

                        if(money < 0 || money > Integer.MAX_VALUE) { System.out.println("Wrong Input"); }
                        else {  deposit(money, curCust); }

                        break;

                    case 2:
                        showWarning();
                        System.out.println("Please enter the amount to be paid.");
                        money = in.nextInt();

                        if(money < 0 || money > Integer.MAX_VALUE) { System.out.println("Wrong Input"); }
                        else { withdraw(money, curCust); }

                        break;

                    case 3:
                        showAccount(curCust);
                        break;
                    case 4 :
                        logout();
                        break;

                    default:
                        System.out.println("You entered wrong number. Please re-enter.");
                        break;
                }
            }
        }
    }

    void showOpening(){
        System.out.println("_______ ______          __  __   ____          _______ __  __ ");
        System.out.println(" |__   __|  ____|   /\\   |  \\/  | |___ \\      /\\|__   __|  \\/  |");
        System.out.println("    | |  | |__     /  \\  | \\  / |   __) |    /  \\  | |  | \\  / |");
        System.out.println("    | |  |  __|   / /\\ \\ | |\\/| |  |__ <    / /\\ \\ | |  | |\\/| |");
        System.out.println("    | |  | |____ / ____ \\| |  | |  ___) |  / ____ \\| |  | |  | |");
        System.out.println("    |_|  |______/_/    \\_\\_|  |_| |____/  /_/    \\_\\_|  |_|  |_|");
    }

    void showWarning() {
        String check = "";
        while (true) {
            System.out.println("Are you doing this transaction after receiving a call from an agency (IRS, prosecutor's financial institution, etc.) or a stranger?");
            System.out.println("Y / N");
            check = in.nextLine();

            if (check.equals("y") || check.equals("Y")) {
                System.out.println("Be careful of voice phishing.");
                System.out.println("Exit System");
                System.exit(0);
            } else if (check.equals("n") || check.equals("N")) {
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }
    }

    void showMenu(int menuCase) {
        /**
         * to show menus in this Method
         * need :: to add Menus
         */
        switch (menuCase) {
            case 0:
                /**
                 * before Login
                 */

                System.out.println("==============");
                System.out.println("1. AddAccount");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println("==============");
                break;

            case 1:
                /**
                 * after Login
                 */
                System.out.println("==============");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. ShowAccount");
                System.out.println("4. Logout");
                System.out.println("==============");
                break;
        }
    }

    /**
     * Mechanism Part
     */

    void login() {

        System.out.print("Please enter id : ");
        String id = in.nextLine();

        if (customers.containsKey(id)) {
            System.out.print("Please enter Password : ");
            String password = in.nextLine();

            if (customers.get(id).getPassword().compareTo(password) == 0) {
                curCust = customers.get(id);
                System.out.println(curCust.getId() + " Logged in");
                return;

            } else {
                System.out.println("Wrong Password");
                return;
            }
        } else {
            System.out.println("ID dosen't exists");
            return;
        }
    }

    void logout() {
        System.out.println(curCust.getId() + "have logged out.");
        curCust = null;
    }

    void makeAccount(){
        System.out.print("Please enter id : ");
        String id = in.nextLine();

        if(customers.containsKey(id)) {
            System.out.println("ID already exists");
            return;
        }

        System.out.print("Please enter Password : ");
        String password = in.nextLine();
        tempCust = new Customer(id, password);
        customers.put(id, tempCust);
    }

    void deposit(int money, Customer cust) {
        cust.setMoney(cust.getMoney()+money);
        showAccount(cust);
    }
    void withdraw(int money, Customer cust) {
        if(cust.getMoney()>=money)
            cust.setMoney(cust.getMoney()-money);
        else
            System.out.println("You don't have enough Money");

        showAccount(cust);
    }
    void showAccount(Customer cust) {
        System.out.println("Your balance is " + cust.getMoney() + "Won");
        System.out.println();
    }
}

