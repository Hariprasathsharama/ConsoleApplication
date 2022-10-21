package BankConsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankTransaction {

    private JdbcConnection database = new JdbcConnection();

    Scanner input = new Scanner(System.in);

    public void bankprocess() throws SQLException {
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

            }

            switch (selection) {
                case 1: {
                    checkBalance();
                    break;
                }
                case 2: {
                    withdraw();
                    break;
                }
                case 3: {
                    deposit();
                    break;
                }
                case 4: {
                    return;
                }
                default:
                    System.out.println("Enter the correct option");
            }
        }
    }

    public void checkBalance() throws SQLException {
        String sql="select accountNumber from customerdata";
        ResultSet resultset = database.getData(sql);
        System.out.println("Enter your account numebr");
        String accountnumber = input.next();
        while (resultset.next()) {

            if (resultset.getString(1).equals(accountnumber)) {
                String sql2="select balance from customerdata";
                System.out.println("Your balance is " +database.getData(sql2) );

            }

        }
    }

    public void withdraw() throws SQLException {
        System.out.println("Enter your account number");
        String accountnumber = "";
        System.out.print("Enter your password");
        String password = "";
        String sql = "SELECT accountNumber FROM customerdata";
        ResultSet resultset = database.getData(sql);
        int withdrawamount = 0;
        String sql2 = "update bank set balance=" + " " + withdrawamount + " " + "where accountnumber="
                + accountnumber + " ";
    
        }
    

    public void deposit() throws SQLException {
        System.out.println("Enter your username");
        String name = input.next();
        System.out.println("Enter your account number");
        String accountnumber = "";
        try {
            accountnumber = input.next();
        } catch (InputMismatchException e) {
            System.out.println("please enter numeric value");
            input.nextLine();
            withdraw();
        }

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Bankapplication", "root", "Chrisevans@2309");
            java.sql.Statement stmt = con.createStatement();
            ResultSet resultset = stmt.executeQuery("select * from bank");
            int exsistedamount = 0;
            int newamount = 0;
            while (resultset.next()) {
                if (accountnumber == resultset.getString(3) && name.equals(resultset.getString(1))) {
                    System.out.print("Enter the amount to deposit :");
                    int amount = input.nextInt();
                    exsistedamount = resultset.getInt(4);
                    newamount = exsistedamount + amount;
                    System.out.println(newamount + "  rupees " + "deposited successfully");
                    stmt.executeUpdate(
                            "update bank set balance=" + newamount + " where accountnumber = " + accountnumber + " ");
                    bankprocess();
                }

            }
            System.out.println("No account found");
            deposit();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
