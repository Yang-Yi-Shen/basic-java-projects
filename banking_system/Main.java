package banking_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // bank object we will use for the duration of the program
        Bank TokyoChuo = new Bank();
        BankAccount HanzawaSan = null; // placeholder for logged-in user

        Scanner scanner = new Scanner(System.in);

        System.out.println("Supported input format: <login/newaccount/deposit/withdraw/exit> <PIN/amount>");

        while (true) {
            String[] input = scanner.nextLine().split(" ");

            // special cases
            if (input[0].equals("exit")) {
                break;
            } else if (input.length != 2) {
                System.out.println("ERROR: Invalid number of arguments");
                System.out.println("\n---Please enter your next command---");
                continue;
            }

            // other commands
            if (input[0].equals("login")) {
                try {
                    int PIN = Integer.parseInt(input[1]);
                    BankAccount[] accountList = TokyoChuo.getAccountList();

                    for (int i = 0; i < accountList.length; i++) {
                        BankAccount currentAccount = accountList[i];
                        if (currentAccount.login(PIN)) {
                            HanzawaSan = currentAccount;
                            System.out.println("Successfully logged in!");
                        }
                    }

                    if (HanzawaSan == null) {
                        System.out.println("ERROR: Incorrect PIN");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Value provided is not a PIN");
                }
            } else if (input[0].equals("newaccount")) {
                try {
                    int PIN = Integer.parseInt(input[1]);

                    BankAccount account = new BankAccount(PIN);
                    TokyoChuo.newAccount(account);
                    account.login(PIN); // log the user into the newly made account
                    HanzawaSan = account;
                    System.out.println("Account successfully created!");
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: PIN provided is not a number");
                }
            } else if (input[0].equals("deposit")) {
                if (HanzawaSan != null) {
                    try {
                        long amount = Long.parseLong(input[1]);

                        HanzawaSan.deposit(amount);
                        System.out.printf("Deposit successful! Your balance is now $%d.\n", HanzawaSan.getBalance());
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Value provided is not a number");
                    }
                } else {
                    System.out.println("ERROR: Not signed in");
                }
            } else if (input[0].equals("withdraw")) {
                if (HanzawaSan != null) {
                    try {
                        long amount = Long.parseLong(input[1]);

                        if (HanzawaSan.getBalance() > amount) {
                            HanzawaSan.withdraw(amount);
                        } else {
                            System.out.println("ERROR: Insufficient balance");
                        }
                        System.out.printf("Withdrawal successful! Your balance is now $%d.\n", HanzawaSan.getBalance());
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Value provided is not a number");
                    }
                } else {
                    System.out.println("ERROR: Not signed in");
                }
            } else {
                System.out.println("ERROR: Invalid argument");
            }

            System.out.println("\n---Please enter your next command---");
        }

        scanner.close();
    }
}