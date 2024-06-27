package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VJames
 */
public class DatabaseContext {

    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=DNTours";
    private static final String USER_DB = "admin";
    private static final String PASS_DB = "admin...1122";

    private static final Logger LOGGER = Logger.getLogger(DatabaseContext.class.getName());

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER_NAME);
            con = DriverManager.getConnection(DB_URL, USER_DB, PASS_DB);
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, "Failed to create the database connection.", ex);
        }

        return con;
    }

    public static void main(String[] args) {
        try (Connection con = getConnection()) {
            if (con != null) {
                System.out.println("Connection successful.");
            } else {
                System.out.println("Connection failed.");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "An error occurred while closing the connection.", ex);
        }
    }
}
