package projectFlights;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class SQLConnector {

    private static final String DB_URL_PREFIX = "jdbc:mysql://";

    // Function to create a server connection and database
    public static Connection createDatabaseConnection(String hostName, String userName, String userPassword, String databaseName) throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL_PREFIX + hostName, userName, userPassword);
        
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
        }

        // Reconnect to the specified database
        connection = DriverManager.getConnection(DB_URL_PREFIX + hostName + "/" + databaseName, userName, userPassword);
        
        return connection;
    }

    // Function to create a table
    public static void createTable(Connection connection, String createTableQuery) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createDatabase(){
        String host = "localhost:3306";
        String user = "root";
        String password = "bio"; 
        String database = "Flights";
        Connection connection = null;
        try {
            connection = createDatabaseConnection(host, user, password, database);
            // Call the createTable method for each table
            createTable(connection, "CREATE TABLE IF NOT EXISTS User (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "address_street VARCHAR(255) NOT NULL, " +
                "address_city VARCHAR(255) NOT NULL, " +
                "address_state VARCHAR(255) NOT NULL, " +
                "address_zip VARCHAR(10) NOT NULL, " +
                "username VARCHAR(255) UNIQUE NOT NULL, " +
                "password VARCHAR(255) NOT NULL" +
            ");");
            createTable(connection, "CREATE TABLE IF NOT EXISTS Membership (" +
                "mid INT PRIMARY KEY, " +
                "date_registered DATE NOT NULL, " +
                "expiry_date DATE NOT NULL, " +
                "companion_ticket_used BOOLEAN NOT NULL" +
            ");");
            createTable(connection, "CREATE TABLE IF NOT EXISTS Admin (" +
                "user_id INT PRIMARY KEY, " +
                "FOREIGN KEY (user_id) REFERENCES User(id)" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Agent (" +
                "user_id INT PRIMARY KEY, " +
                "FOREIGN KEY (user_id) REFERENCES User(id)" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Customer (" +
                "user_id INT PRIMARY KEY, " +
                "membership_id INT, " +
                "FOREIGN KEY (user_id) REFERENCES User(id), " +
                "FOREIGN KEY (membership_id) REFERENCES Membership(mid)" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS FlightAttendant (" +
                "user_id INT PRIMARY KEY, " +
                "FOREIGN KEY (user_id) REFERENCES User(id)" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Pilot (" +
                "id INT PRIMARY KEY, " +
                "FOREIGN KEY (id) REFERENCES User(id)" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Airport (" +
                "id INT PRIMARY KEY, " +
                "address_street VARCHAR(255) NOT NULL, " +
                "address_city VARCHAR(255) NOT NULL, " +
                "address_state VARCHAR(255) NOT NULL, " +
                "address_zip VARCHAR(10) NOT NULL, " +
                "code VARCHAR(10) NOT NULL" +
            ");");
            createTable(connection, "CREATE TABLE IF NOT EXISTS Plane (" +
                "id INT PRIMARY KEY, " +
                "numRows INT NOT NULL, " +
                "seatsPerRow INT NOT NULL" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Seat (" +
                "id INT PRIMARY KEY, " +
                "location VARCHAR(255) NOT NULL, " +
                "priceMultiplier FLOAT NOT NULL," +
                "airplane_id INT," + 
                "FOREIGN KEY (airplane_id) REFERENCES Plane(id)" + 
            ");");
            
            createTable(connection, "CREATE TABLE IF NOT EXISTS Crew (" +
                "id INT PRIMARY KEY, " +
                "pilot_id INT, " +
                "FOREIGN KEY (pilot_id) REFERENCES Pilot(id)" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Flight (" +
                "flightNumber INT PRIMARY KEY, " +
                "plane_id INT, " +
                "crew_id INT, " +
                "departureDateTime DATETIME NOT NULL, " +
                "arrivalDateTime DATETIME NOT NULL, " +
                "origin_id INT, " +
                "destination_id INT, " +
                "FOREIGN KEY (plane_id) REFERENCES Plane(id), " +
                "FOREIGN KEY (crew_id) REFERENCES Crew(id), " +
                "FOREIGN KEY (origin_id) REFERENCES Airport(id), " +
                "FOREIGN KEY (destination_id) REFERENCES Airport(id)" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS CancellationInsurance (" +
                "id INT PRIMARY KEY, " +
                "price FLOAT NOT NULL, " +
                "refundAmount FLOAT NOT NULL" +
            ");");
            
            createTable(connection, "CREATE TABLE IF NOT EXISTS Ticket (" +
                "id INT PRIMARY KEY, " +
                "ticketHolderId INT NOT NULL, " +
                "flight_num INT, " +
                "seat_id INT, " +
                "price FLOAT NOT NULL, " +
                "cancellationInsurance_id INT, " +
                "sold BOOLEAN NOT NULL, " +
                "FOREIGN KEY (flight_num) REFERENCES Flight(flightNumber), " +
                "FOREIGN KEY (seat_id) REFERENCES Seat(id), " +
                "FOREIGN KEY (cancellationInsurance_id) REFERENCES CancellationInsurance(id)," +
                "FOREIGN KEY (ticketHolderId) REFERENCES User(id)"+
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Receipt (" +
                "id INT PRIMARY KEY, " +
                "purchaserId VARCHAR(255) NOT NULL, " +
                "ticket_id INT, " +
                "dateTime DATETIME NOT NULL, " +
                "FOREIGN KEY (ticket_id) REFERENCES Ticket(id)" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS PaymentMethod (" +
                "id INT PRIMARY KEY" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Payment (" +
                "id INT PRIMARY KEY, " +
                "method_id INT, " +
                "receipt_id INT, " +
                "ticket_id INT, " +
                "FOREIGN KEY (method_id) REFERENCES PaymentMethod(id), " +
                "FOREIGN KEY (receipt_id) REFERENCES Receipt(id), " +
                "FOREIGN KEY (ticket_id) REFERENCES Ticket(id)" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS CreditCard (" +
                "number BIGINT PRIMARY KEY, " +
                "expiry INT NOT NULL, " +
                "cvv INT NOT NULL" +
            ");");

            
            System.out.println("Tables created successfully");
            }catch (SQLException e) {
                e.printStackTrace();
            
            } finally {
                try {
                // Close the connection in a finally block to ensure it's closed
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                        System.out.println("Connection closed successfully");
                    }
                } catch (SQLException e) {
                e.printStackTrace();
                }
            }
        }
    public static void main(String[] args) {
        createDatabase();
    }
}
