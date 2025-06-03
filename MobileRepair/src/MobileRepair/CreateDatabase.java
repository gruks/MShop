package MobileRepair;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateDatabase {
	
	public static String databaseName;
	public static String userName;
	public static String password;
    public static void main(String[] args) {
    	Scanner sc = new Scanner (System.in);
    	System.out.println("Enter Database Name: ");
        databaseName = sc.nextLine();
        System.out.println("Enter Username of MySQL server e.g.'root' ");
        userName = sc.nextLine();
        System.out.println("Enter Password");
        password = sc.nextLine();
        String url = "jdbc:mysql://localhost:3306/?zeroDateTimeBehavior=convertToNull";

        try (Connection connection = DriverManager.getConnection(url, userName, password);
             Statement statement = connection.createStatement()) {

            String sql = "CREATE DATABASE IF NOT EXISTS " + databaseName+";";
            statement.executeUpdate(sql);

            System.out.println("Database '" + databaseName + "' created successfully.");
            String select = "USE " +databaseName+";";
            statement.executeUpdate(select);
            String createTableSQL = "CREATE TABLE IF NOT EXISTS repair (" +
            //repairno,custname,status,phoneno,dmodel,sn,prob,fee,pay,due
            		
                    "repairno VARCHAR(255)," +
                    "custname VARCHAR(255)," +
                    "status VARCHAR(255)," +
                    "phoneno VARCHAR(255)," +
                    "dmodel VARCHAR(255)," +
                    "sn VARCHAR(255)," +
                    "prob VARCHAR(255)," +
                    "fee INT," +
                    "pay INT," +
                    "due INT" +
                    ");";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully.");

            EventQueue.invokeLater(() -> {
                mshop shopWindow = new mshop();
                shopWindow.setVisible(true);
                shopWindow.setLocation(200, 0); 
                shopWindow.setAlwaysOnTop(true);
            });
        } catch (SQLException e) {
            System.out.println("Error creating database: " + e.getMessage());
        }
        sc.close();
    }
    
}