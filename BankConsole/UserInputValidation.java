package BankConsole;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidation {
    UserInputValidation validation;
    Scanner input=new Scanner(System.in);
    public String validName(){
        while (true) {
            String name = input.next();
            String regex = "[a-zA-Z]+\\.?";
            if (name.matches(regex)) {
                return name;
            } else {
                System.out.println("Enter the valid username");
            }
        }
       
    }
    public  String validPhonenumber() {
        while (true) {
            String number = input.next();
            Pattern p = Pattern.compile("^\\d{10}$");
            Matcher m = p.matcher(number);
            if (m.matches()) {
                return number;
            } else {
                System.out.println("----------------------");
                System.out.println("Enter the valid number");
                System.out.println("----------------------");
            }
        }
    }
}
