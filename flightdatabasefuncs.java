import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class FlightDatabaseSetup {

    // Function to create a server connection - not used just yet
    private static Connection createServerConnection(String hostName, String userName, String userPassword) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + hostName, userName, userPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Function to create a database and establish a connection
    private static Connection createDatabaseConnection(String hostName, String userName, String userPassword, String databaseName) {
        Connection connection = createServerConnection(hostName, userName, userPassword);
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return createServerConnection(hostName, userName, userPassword, databaseName);
    }

    // Function to create a table
    private static void createTable(Connection connection, String createTableQuery) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String host = "localhost";
        String user = "root";
        String password = "bio"; 
        String database = "Flights";

        try (Connection connection = createDatabaseConnection(host, user, password, database)) {

            // Call the createTable method for each table
            createTable(connection, "CREATE TABLE IF NOT EXISTS USER (
            UserID INT AUTO_INCREMENT PRIMARY KEY,
            Fname VARCHAR(20) NOT NULL,
            Lname VARCHAR(20) NOT NULL,
            U_Password VARCHAR(255) NOT NULL,
            U_Role VARCHAR(20) NOT NULL
            );");
            createTable(connection, "CREATE TABLE IF NOT EXISTS CUSTOMER (
            C_UserID INT NOT NULL,
            Dno INT NOT NULL,
            DHours INT NOT NULL,
            PRIMARY KEY (D_UserID),
            FOREIGN KEY (D_UserID) REFERENCES USER (UserID)
                ON UPDATE CASCADE
            );");
            createTable(connection, "CREATE TABLE IF NOT EXISTS DOCTOR_SPECIALIST (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS NURSE (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS ADMIN (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS DEPARTMENT (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS DEPARTMENT_LOCATIONS (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS PATIENT (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS APPOINTMENT (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS INSURANCE (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS PATIENT_HISTORY (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS PATIENT_HISTORY_ALLERGIES (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS PATIENT_HISTORY_SURGERIES (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS PATIENT_HISTORY_MEDICATIONS (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS TAKE_CARE_OF (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS WORKS_IN (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS TEST (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS REQUESTS (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS GETS (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS MEDICINE (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS PRESCRIBES (...)");
            createTable(connection, "CREATE TABLE IF NOT EXISTS TAKEN_BY (...)");

            System.out.println("Tables created successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
