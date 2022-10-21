package BankConsole;


import java.sql.SQLException;
import java.util.Random;

public class BankAdmin {
    public void createAccountnumber(String name,String mobileNumber,String password) throws SQLException {
        String accountNumber;
        Random random=new Random();
        int length=11;
        // boolean nonUnique;
        // do {
            accountNumber="";
            for (int i = 0; i < length; i++) {
                accountNumber+=((Integer)random.nextInt(10)).toString();
            }
            // nonUnique=false;
            // if(new BankDatabase().checkinDatabase(accountNumber)){
            //     nonUnique=true;
            //     break;
            // }
        // }while(nonUnique);
        new BankDatabase().updatetoDatabase(name,mobileNumber,password,accountNumber);
        
    }

    
}
