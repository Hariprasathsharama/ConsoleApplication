package BankConsole;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
class BankingApplication {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        BankingApplication bankingApplication = new BankingApplication();
        bankingApplication.welcomePage();
        bankingApplication.userChoice();
    }
    public void welcomePage() {
        System.out.println("-------WELCOME TO INDIAN BANK--------");
        System.out.println("Choose one of  the option");
        System.out.println("1) SIGN UP");
        System.out.println("2) LOGIN");
        System.out.println("3) EXIT");
    }
    public void userChoice() throws SQLException {
        System.out.println("Enter one of the option");
        byte option = 0;
        WHILE_LABEL:
        while (true) {
            try {
                option = input.nextByte();
                if (option < 1 || option > 3)
                    System.out.println("ENTER VALID NUMBER : ");
                else
                    break WHILE_LABEL;
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Enter valid entry");
            }
        }
        switch (option) {
            case 1 -> new ManageUsers().addCustomer();
            case 2 -> new ManageUsers().login();
            default -> {
            }
        }
    }
}

