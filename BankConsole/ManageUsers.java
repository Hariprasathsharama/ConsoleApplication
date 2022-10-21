package BankConsole;
import java.sql.SQLException;
import java.util.Scanner;

public class ManageUsers {
    Scanner input = new Scanner(System.in);

    public void addCustomer() throws SQLException  {
        System.out.println("Enter your name");
        String name = new UserInputValidation().validName();
        System.out.println("Enter your Mobilenumber");
        String mobile = new UserInputValidation().validPhonenumber();
        System.out.println("Enter your password");
        String password = input.nextLine();
        new BankAdmin().createAccountnumber(name, mobile, password);
        
    }


    
    public void Login() throws SQLException {
        System.out.println("```````````````````````````````");
        System.out.println("LOGIN PAGE");
        System.out.println("```````````````````````````````");
        System.out.println("Please enter your login details:");
        System.out.println("Enter your username: ");
        String name = input.next();
        System.out.println("Enter your password");
        String passwords = input.next();

        if(new BankDatabase().isaccountVerify(name,passwords)){
            new BankTransaction().bankprocess();
        }
       
    }
    
   
        
    }


