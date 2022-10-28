package BankConsole;


import java.sql.SQLException;
import java.util.Random;

public class BankAdmin {
    public void createAccountNumber(String name, String mobileNumber, String password) throws SQLException {
        String accountNumber="";
        Random random=new Random();
        int length=11;
            for (int i = 0; i < length; i++) {
                accountNumber+=((Integer)random.nextInt(10)).toString();
            }
            int balance=0;
        new BankDatabase().updateDatabase(name,mobileNumber,password,accountNumber,balance);
        System.out.println("Your account is created");
        System.out.println("your account number is"+accountNumber);
    }
}
