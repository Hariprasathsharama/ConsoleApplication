package BankConsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BankDatabase {
    private String password = "";
    private final String DB_URL = "jdbc:mysql://localhost/bankApplication";
    private final String USER = "root";
    private final String PASS = "Chrisevans@2309";
    String sql = "";

    public void updateDatabase(String name, String mobileNumber, String password, String accountNumber, int balance)
            throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "Insert into customerData" + "(userName,mobileNumber,accountNumber,password,balance) values"
                + "(?,?,?,?,?);";
        PreparedStatement preparedstatement = connection.prepareStatement(sql);
        preparedstatement.setString(1, name);
        preparedstatement.setString(2, mobileNumber);
        preparedstatement.setString(3, accountNumber);
        preparedstatement.setString(4, password);
        preparedstatement.setInt(5, balance);
        preparedstatement.addBatch();
        int[] count = preparedstatement.executeBatch();
        System.out.println(Arrays.toString(count));
    }
    public boolean accountVerify(String name, String passwords) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("select userName,password from customerData");
        while (resultset.next()) {
            if (resultset.getString(1).equals(name) && resultset.getString(2).equals(passwords)) {
                return true;
            }
        }
        return false;
    }
    public void checkBalance(String accountNumber) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        sql = "SELECT accountNumber,balance FROM customerData where accountNumber=" + accountNumber + " ";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            if (resultSet.getString(1).equals(accountNumber)) {
                System.out.println("your Balance is=" + resultSet.getInt(2));
            } else {
                System.out.println("Account number not exists");
            }
        }
        new BankTransaction().bankProcess();
    }
    public boolean verify(String accountNumber, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        sql = "SELECT accountNumber,password FROM customerData";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getString(1).equals(accountNumber) && resultSet.getString(2).equals(password)) {
                return true;
            }
        }
        return false;
    }
    public void withDraw(String accountNumber, String password, int withdrawAmount) throws SQLException {
        if (verify(accountNumber, password)) {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select accountNumber,balance from customerData where accountNumber=" + accountNumber + "");
            while (resultSet.next()) {
                int newAmount = resultSet.getInt(2) - withdrawAmount;
                updateAmount(newAmount, accountNumber);
                System.out.println("Withdraw Successfully");
                new BankTransaction().bankProcess();
            }
        } else {
            System.out.println("Account Number or password may be wrong");
            new BankTransaction().bankProcess();
        }
    }
    public void updateAmount(int newAmount, String accountNumber) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        sql = "update customerData set balance=" + " " + newAmount + " " + "where accountNumber=" + accountNumber + " ";
        statement.executeUpdate(sql);
        System.out.println("The  Balance of your account" + newAmount);
    }
    public void deposit(String accountNumber, String password, int deposit) throws SQLException {
        if (verify(accountNumber, password)) {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select accountNumber,balance from customerData where accountNumber=" + accountNumber + "");
            while (resultSet.next()) {
                int newAmount = resultSet.getInt(2) + deposit;
                updateAmount(newAmount, accountNumber);
                System.out.println("Deposited Successfully");
                new BankTransaction().bankProcess();
            }
        } else {
            System.out.println("Account Number or password may be wrong");
            new BankTransaction().bankProcess();
        }
    }

}


