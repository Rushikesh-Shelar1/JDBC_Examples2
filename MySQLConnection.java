package jdbc_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    // JDBC URL, user name, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tiger";

    public static void main(String[] args) {
        // Initialize connection object
        Connection connection = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Print message indicating successful connection
            System.out.println("Connected to the MySQL database!");
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQLException
            e.printStackTrace();
        } finally {
            // Close the connection object
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Handle SQLException while closing connection
                    e.printStackTrace();
                }
            }
        }
    }
}
