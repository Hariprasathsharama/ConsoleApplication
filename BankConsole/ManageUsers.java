package BankConsole;
import java.sql.SQLException;
import java.util.Scanner;
public class ManageUsers {
    Scanner input = new Scanner(System.in);
    public void addCustomer() throws SQLException  {
        System.out.println("Enter your name");
        String name = new UserInputValidation().validName();
        System.out.println("Enter your MobileNumber");
        String mobile = new UserInputValidation().validPhoneNumber();
        System.out.println("Enter your password");
        String password = input.nextLine();
        new BankAdmin().createAccountNumber(name, mobile, password);
        new ManageUsers().login();
    }
    public void login() throws SQLException {
        System.out.println("```````````````````````````````");
        System.out.println("LOGIN PAGE");
        System.out.println("```````````````````````````````");
        System.out.println("Please enter your login details:");
        System.out.println("Enter your username: ");
        String name = input.next();
        System.out.println("Enter your password");
        String passwords = input.next();

        if(new BankDatabase().accountVerify(name,passwords)){
            new BankTransaction().bankProcess();
        }
        else{
            System.out.println("Your account Not found");
            System.out.println("Try again");
            login();
        }
    }
    }


