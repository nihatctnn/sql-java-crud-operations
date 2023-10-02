import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String userName = ""; // Database username
    private String password = ""; // Database password
    private String dbUrl = "jdbc:mysql://localhost:3306/world"; // Database URL

    // Get a database connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    // Display an error message along with error code
    public void showErrorMessage(SQLException exception) {
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error Code: " + exception.getErrorCode());
    }
}
