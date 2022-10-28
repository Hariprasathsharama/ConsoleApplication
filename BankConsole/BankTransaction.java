package BankConsole;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankTransaction {
    private final BankDatabase bankDatabase = new BankDatabase();
    private final Scanner input = new Scanner(System.in);

    public void bankProcess() throws SQLException {
        byte selection = 0;
        System.out.println("Please select an option");
        System.out.println("1) Balance Enquiry");
        System.out.println("2) WITHDRAWAL");
        System.out.println("3) Deposit");
        System.out.println("4) Exit");
        System.out.print("Your selection: ");
        while (true) {
            try {
                selection = input.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Enter valid option");
                input.next();
            }
            String accountNumber = "";
            String password = "";
            switch (selection) {
                case 1 -> {
                    System.out.println("Enter the accountNumber");
                    accountNumber = input.next();
                    bankDatabase.checkBalance(accountNumber);
                }
                case 2 -> {
                    System.out.println("Enter the amount to withDraw");
                    int withDraw = getNumber();
                    System.out.println("Enter the accountNumber");
                    accountNumber = input.next();
                    System.out.println("Enter the password");
                    password = input.next();
                    bankDatabase.withDraw(accountNumber, password, withDraw);
                    break;
                }
                case 3 -> {
                    System.out.println("Enter the amount to Deposit");
                    int deposit = getNumber();
                    System.out.println("Enter the accountNumber");
                    accountNumber = input.next();
                    System.out.println("Enter the password");
                    password = input.next();
                    bankDatabase.deposit(accountNumber, password, deposit);
                    break;
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("Enter the correct option");
            }
        }
    }
    public int getNumber() {
        int number = 0;
        while (true) {
            try {
                number = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter valid number");
                input.next();
            }
            if (number > 0) return number;
        }
    }
}

