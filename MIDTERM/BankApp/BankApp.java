//package MIDTERM.BankApp;

import java.util.*;

class BankAccount {
    BankAccount(int acntNum, String acntName, double balance) {
        this.acntNum = acntNum;
        this.acntName = acntName;
        this.balance = balance;
    }

    int acntNum;
    String acntName;
    double balance = 0;

    void deposit(double amount) {
        balance += amount;
        System.out.println("\n[ DEPOSIT SUCCESSFUL ]");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("\n[ INSUFFICIENT BALANCE! ]");
        } else {
            balance -= amount;
            System.out.println("\n[ WITHDRAW SUCCESSFUL ]");
        }
    }

    void displayBal() {
        System.out.printf("\n[ Account name: %s ]\n", acntName);
        System.out.printf("[ Account number: %d ]\n", acntNum);
        System.out.printf("[ Account balance: %.2f ]\n", balance);
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int acntNum;
        String acntName;
        double amount;
        byte option = 0;

        // User login
        System.out.println("[ BANKO SENTRAL DE CEBU ]");
        System.out.println("[ Enter account name: ]");
        System.out.print("[] : ");
        acntName = scan.nextLine();
        System.out.println("[ Enter account number: ]");
        System.out.print("[] : ");
        acntNum = scan.nextInt();

        BankAccount bankAccount = new BankAccount(acntNum, acntName, 0);

        System.out.println("\n[ SUCCESSFULLY LOGGED IN! ]");
        do {
            try {
                System.out.println("\n[ 1. Deposit ]");
                System.out.println("[ 2. Withdraw ]");
                System.out.println("[ 3. Preview Balance ]");
                System.out.println("[ 4. Exit ]");
                System.out.print("[] : ");
                option = scan.nextByte();

                switch (option) {
                    case 1:
                        System.out.println("\n[ Enter amount to deposit: ]");
                        System.out.print("[] : ");
                        amount = scan.nextDouble();
                        bankAccount.deposit(amount);
                        break;
                    case 2:
                        System.out.println("\n[ Enter amount to withdraw: ]");
                        System.out.print("[] : ");
                        amount = scan.nextDouble();
                        bankAccount.withdraw(amount);
                        break;
                    case 3:
                        bankAccount.displayBal();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("\n[ ERROR! ]");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\n[ ERROR! ]");
                option = 1;
                scan.next();
            }
        } while (option != 4);
        scan.close();
        System.out.println("[ THANK YOU FOR USING BANKO SENTRAL DE CEBU! ]");
    }
}