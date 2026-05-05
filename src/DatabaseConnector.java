

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String DB_URL = "jdbc:sqlserver://192.168.17.100:2020;databaseName=Teleskop;integratedSecurity=true";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
    
    
    public static void main (String  [] args) {
        
        connect();
        
    }
    
}

