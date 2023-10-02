import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        DbHelper helper = new DbHelper();

        PreparedStatement statement = null;

        try {
            // Create a connection to the database
            connection = helper.getConnection();

            // Prepare an SQL statement
            String sql = "DELETE FROM City WHERE ID = ?";
            statement = connection.prepareStatement(sql);

            // Set the parameters for the query
            statement.setInt(1, 4100);

            // Execute the query and delete the record
            statement.executeUpdate();

            // Report that the record has been deleted successfully
            System.out.println("DELETED");

        } catch (SQLException exception) {
            // Show an error message in case of an exception
            helper.showErrorMessage(exception);
        } finally {
            // Close the statement and connection
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public static void selectDemo() throws SQLException {

        Connection connection = null;
        DbHelper helper = new DbHelper();

        Statement statement = null;
        ResultSet resultSet;

        try {
            // Create a connection to the database
            connection = helper.getConnection();

            // Create an SQL statement
            statement = connection.createStatement();

            // Execute the query and retrieve the results
            resultSet = statement.executeQuery("SELECT Code, Name, Continent, Region from country ");

            ArrayList<Country> countries = new ArrayList<Country>();

            while (resultSet.next()) {
                // Process the results and add them to a list
                countries.add(new Country(
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("continent"),
                        resultSet.getString("region")));
            }

            // Print the number of results
            System.out.println(countries.size());

        } catch (SQLException exception) {
            // Show an error message in case of an exception
            helper.showErrorMessage(exception);
        } finally {
            // Close the connection
            connection.close();
        }

    }

    public static void insertData() throws SQLException {

        Connection connection = null;
        DbHelper helper = new DbHelper();

        PreparedStatement statement = null;

        try {
            // Create a connection to the database
            connection = helper.getConnection();

            // Prepare an SQL statement
            String sql = "INSERT INTO city (Name, CountryCode, District, Population) VALUES(?,?,?,?)";
            statement = connection.prepareStatement(sql);

            // Set the parameters for the query
            statement.setString(1, "Karabük");
            statement.setString(2, "TUR");
            statement.setString(3, "Turkey");
            statement.setInt(4, 70000);

            // Execute the query and save the data
            statement.executeUpdate();

            // Report that the data has been saved successfully
            System.out.println("Successfully Saved");

        } catch (SQLException exception) {
            // Show an error message in case of an exception
            helper.showErrorMessage(exception);
        } finally {
            // Close the statement and connection
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public void updateData() throws SQLException {

        Connection connection = null;
        DbHelper helper = new DbHelper();

        PreparedStatement statement = null;

        try {
            // Create a connection to the database
            connection = helper.getConnection();

            // Prepare an SQL statement
            String sql = "UPDATE city SET population = 100000, district = 'TUR' WHERE ID = ?";
            statement = connection.prepareStatement(sql);

            // Set the parameters for the query
            statement.setInt(1, 4100);

            // Execute the query and update the data
            statement.executeUpdate();

            // Report that the data has been updated successfully
            System.out.println("UPDATED");

        } catch (SQLException exception) {
            // Show an error message in case of an exception
            helper.showErrorMessage(exception);
        } finally {
            // Close the statement and connection
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

}
