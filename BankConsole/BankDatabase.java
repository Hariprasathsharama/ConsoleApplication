package BankConsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class BankDatabase {
    ArrayList<UserDetails> userList = new ArrayList<>();

    public void updatetoDatabase(String name, String mobileNumber, String password, String accountNumber)
            throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bankapplication", "root",
                "Chrisevans@2309");
        String sql = "Insert into customerdata" + "(username,mobileNumber,accountNumber,password) values"
                + "(?,?,?,?);";
        PreparedStatement preparedstatement = connection.prepareStatement(sql);
        preparedstatement.setString(1, name);
        preparedstatement.setString(2, mobileNumber);
        preparedstatement.setString(3, accountNumber);
        preparedstatement.setString(4, password);
        preparedstatement.addBatch();
        int[] count = preparedstatement.executeBatch();
        System.out.println(Arrays.toString(count));

            }
            
    public boolean isaccountVerify(String name, String passwords) {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/bankapplication", "root",
                    "Chrisevans@2309");

            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select userName,password from customerdata");
            int flag = 0;
            while (resultset.next()) {
                if (resultset.getString(1).equals(name) && resultset.getString(2).equals(passwords)) {
                    flag = 1;
                    return true;
                }

            }
           
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        
    }

}
