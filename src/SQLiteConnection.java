

//C:\\Users\\Ahmed.ElKady\\Desktop\\Recipe_System_DB.db


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {

    // Correct path to the encrypted SQLite database file
    private static final String DB_PATH = "jdbc:sqlite:C:/Users/Ahmed.ElKady/Desktop/Recipe_System_DB.db"; // Correct format with forward slashes

    // The password for your encrypted SQLite database
    private static final String DB_PASSWORD = "1234";

    public static Connection connect() {
        Connection conn = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Formulate the connection URL using SQLCipher parameters
            String connectionUrl = DB_PATH + "?cipher=sqlcipher&key=" + DB_PASSWORD;
            conn = DriverManager.getConnection(connectionUrl);

            System.out.println("Connection to the encrypted SQLite database established successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        try (Connection conn = connect()) {
            if (conn != null) {
                System.out.println("Database connection successful.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
