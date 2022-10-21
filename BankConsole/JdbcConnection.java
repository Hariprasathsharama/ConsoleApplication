package BankConsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnection {
    

    public JdbcConnection() {

    }

    // private static Connection getConnection() {
    //     if (connection == null) {
    //         try {
                
    //         } catch (SQLException e) {
                
    //             e.printStackTrace();
    //         }
           
    //     }
    //     return connection;

    // }
    
    public ResultSet getData (String sql) throws SQLException{

        ResultSet resultset;
        
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bankapplication", "root", "Chrisevans@2309");
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            resultset = statement.executeQuery();

        return resultset;
        
    }
    public boolean putData(String sql) throws SQLException{
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bankapplication", "root", "Chrisevans@2309");
            
        PreparedStatement statement = connection.prepareStatement(sql);
        
       int count= statement.executeUpdate(sql);
       if(count>0) return true;

       return false;
    }

}
