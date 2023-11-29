package boundary;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import utility.*;
import entity.*;

public class SQLConnector extends Singleton{
    public static SQLConnector getInstance() {
		return (SQLConnector) Singleton.getInstance();
	}
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
                "country VARCHAR(20) NOT NULL," + 
                "address_zip VARCHAR(10) NOT NULL, " +
                "username VARCHAR(255) UNIQUE NOT NULL, " +
                "u_password VARCHAR(255) NOT NULL" +
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

            createTable(connection, "CREATE TABLE IF NOT EXISTS Pilot (" +
                "id INT PRIMARY KEY, " +
                "FOREIGN KEY (id) REFERENCES User(id)" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Airport (" +
                "id INT PRIMARY KEY, " +
                "address_street VARCHAR(255) NOT NULL, " +
                "address_city VARCHAR(255) NOT NULL, " +
                "address_state VARCHAR(255) NOT NULL, " +
                "country VARCHAR(20) NOT NULL," + 
                "address_zip VARCHAR(10) NOT NULL, " +
                "code VARCHAR(10) NOT NULL" +
            ");");
            createTable(connection, "CREATE TABLE IF NOT EXISTS Plane (" +
                "id INT PRIMARY KEY, " +
                "numRows INT NOT NULL, " +
                "seatsPerRow INT NOT NULL" +
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Seat (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
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

            createTable(connection, "CREATE TABLE IF NOT EXISTS FlightAttendant (" +
                "user_id INT PRIMARY KEY, " +
                "crew_id INT," +
                "FOREIGN KEY (crew_id) REFERENCES Crew(id),"+
                "FOREIGN KEY (user_id) REFERENCES User(id)" +
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
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "ticketHolderId INT, " +
                "flight_num INT, " +
                "seat_id INT, " +
                "price FLOAT NOT NULL, " +
                "cancellationInsurance_id INT, " +
                "sold BOOLEAN NOT NULL, " +
                "FOREIGN KEY (flight_num) REFERENCES Flight(flightNumber), " +
                "FOREIGN KEY (seat_id) REFERENCES Seat(id), " +
                "FOREIGN KEY (cancellationInsurance_id) REFERENCES CancellationInsurance(id) ON DELETE CASCADE," +
                "FOREIGN KEY (ticketHolderId) REFERENCES User(id),"+
                "UNIQUE (seat_id)," +
                "UNIQUE (cancellationInsurance_id)" + 
            ");");

            createTable(connection, "CREATE TABLE IF NOT EXISTS Receipt (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
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
        //-----------------------------------------------------------------------//
        //---------------------------- HELPERS-----------------------------------//
        //-----------------------------------------------------------------------//

        private static void makeSeats(int airplane_id, Plane plane){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;

            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM Seat WHERE airplane_id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, airplane_id);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            String location = resultSet.getString("location");
                            float multi = resultSet.getFloat("priceMultiplier");

                            plane.setSeatFromSql(location, multi);
                        }
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
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

        private static Plane makePlane(int plane_id){
            Plane plane = null;
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;

            try {

                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM Plane WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, plane_id);
                    
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            int numRows = resultSet.getInt("numRows");
                            int seatsPerRow = resultSet.getInt("seatsPerRow"); 
                            plane = new Plane(numRows,seatsPerRow);

                            makeSeats(plane_id, plane);
                            plane.setID(plane_id);
                        }
                    }
                }

            }catch (SQLException e){
                e.printStackTrace();
            }finally {
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
            return plane;
        }
        private static Address makeAddress(int user_id){
            Address address = null;
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {

                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM User WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, user_id);
                    
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String street = resultSet.getString("address_street");
                            String city = resultSet.getString("address_city");
                            String state = resultSet.getString("address_state");
                            String postal = resultSet.getString("address_zip");
                            String country = resultSet.getString("country");
                            address = new Address(street, city, state, country, postal);
                        }
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
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
            return address;
        }

        private static FlightAttendant makeFA(int user_id){
            FlightAttendant FA = null;
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {

                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM User WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, user_id);
                    
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String name = resultSet.getString("name");
                            Address address = makeAddress(user_id);
                            String username = resultSet.getString("username");
                            String user_password = resultSet.getString("u_password");
                            FA = new FlightAttendant(name, address, username, user_password);
                        }
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
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
            return FA;
        }

        private static ArrayList<FlightAttendant> makeFAList(int crew_id){
            ArrayList<FlightAttendant> FAlist = new ArrayList<>();
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {

                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM FlightAttendant WHERE crew_id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(2, crew_id);
                    
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            FlightAttendant FA = makeFA(resultSet.getInt("user_id"));
                            FAlist.add(FA);
                        }
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
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
            return FAlist;
        }
        private static Pilot makePilot(int pilot_id){
            Pilot pilot = null;
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {

                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM User WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, pilot_id);
                    
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String name = resultSet.getString("name");
                            Address address = makeAddress(pilot_id);
                            String username = resultSet.getString("username");
                            String user_password = resultSet.getString("u_password");
                            pilot = new Pilot(name, address, username, user_password);
                        }
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
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
            return pilot;
        }

        private static Airport makeAirport(int airport_id){
            Airport airport = null;
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {

                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM Airport WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, airport_id);
                    
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String street = resultSet.getString("address_street");
                            String city = resultSet.getString("address_city");
                            String state = resultSet.getString("address_state");
                            String country = resultSet.getString("country");
                            String postal = resultSet.getString("address_zip");
                            String code = resultSet.getString("code");
                            Address a_Address = new Address(street, city, state, country, postal);

                            airport = new Airport(a_Address, code);
                        }
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
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
            return airport;
        }
        private static Crew makeCrew(int crew_id){
            Crew crew = null;
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;

            try {

                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM Crew WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, crew_id);
                    
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            ArrayList<FlightAttendant> FAlist = makeFAList(crew_id);
                            Pilot pilot = makePilot(resultSet.getInt("pilot_id"));
                            crew = new Crew(pilot, FAlist);
                        }
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
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
            return crew;
        }
        private static Flight mapResultSetToFlight(ResultSet resultSet) throws SQLException {
        
            int flight_number = (resultSet.getInt("flightNumber"));

            Flight flight = new Flight(
                makePlane(resultSet.getInt("plane_id")), 
                makeCrew(resultSet.getInt("crew_id")),  
                resultSet.getObject("departureDateTime", LocalDateTime.class),
                resultSet.getObject("arrivalDateTime", LocalDateTime.class),
                makeAirport(resultSet.getInt("origin_id")), 
                makeAirport(resultSet.getInt("destination_id")), 
                0.0f 
            );
            flight.setFlightNum(flight_number);
            return flight;
        }

        private static int getDestinationId(String destination){
            int destination_id = 0;
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM Airport WHERE address_city = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, destination);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            //Do a bunch more queries inside this query to get all other information required - Airports with their addresses
                            destination_id = resultSet.getInt("id");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
            return destination_id;
        }
        private static int findCrew(int pilot_id){
            int crew_id = 0;
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM Crew WHERE pilot_id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, pilot_id);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            crew_id = resultSet.getInt("id");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
            return crew_id;
        }

        private static int findSeat(Ticket ticket, Seat seat){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            int seat_id = 0;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT s.seat_id " +
                                "FROM Ticket t " +
                                "JOIN Flight f ON t.flight_num = f.flightNumber " +
                                "JOIN Seat s ON f.plane_id = s.airplane_id" + 
                                "WHERE t.flight_num = ? AND s.location = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, ticket.getFlight().getFlightNum());
                    preparedStatement.setString(2, seat.getLocation());
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            seat_id = resultSet.getInt("id");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
            return seat_id;
        }

        private static void addMembership(Membership mb){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;

            try {
                connection = createDatabaseConnection(host, user, password, database);
                SQLInsertions.insertMembershipData(connection, mb.getID(), mb.getRegDate().toString(), mb.getExpDate().toString(), mb.getCompUsed());
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
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

        private static void addUser(User newUser){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;

            try {
                connection = createDatabaseConnection(host, user, password, database);
                SQLInsertions.insertUserData(connection, newUser.getId(), newUser.getName(), newUser.getAddress().getStreet(), newUser.getAddress().getCity(), 
                                                newUser.getAddress().getProvince(), newUser.getAddress().getCountry(), newUser.getAddress().getPostalCode(), 
                                                newUser.getUsername(),newUser.getPassword());
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
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

        private static Customer mapResultSetToCustomer(ResultSet resultSet) throws SQLException {
        
            int id = (resultSet.getInt("id"));

            Customer customer = new Customer(
                resultSet.getString("name"),  
                makeAddress(id),
                resultSet.getString("username"),
                resultSet.getString("u_password")
            );
            customer.setId(id);
            return customer;
        }

        private static int getTicketID(Ticket ticket){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            int ticket_id = 0;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT t.id"+
                                "FROM Receipt r" + 
                                "JOIN Ticket t ON r.purchaserId = t.ticketHolderId" + 
                                "WHERE r.purchaserId = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, ticket.getTicketHolderId());
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            ticket_id = resultSet.getInt("id");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
            return ticket_id;
        }
        //---------------------------------------------------------------------------------------------------------------//
        //------------------------------------------- SQL FUNCTIONS -----------------------------------------------------//
        //---------------------------------------------------------------------------------------------------------------//


        public static void updateCustomer(Customer customer) {
            addMembership(customer.getMembership()); 
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "UPDATE Customer SET membership_id = ? WHERE user_id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, customer.getMembership().getID());
                    preparedStatement.setInt(2, customer.getId());

                    int rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) updated in Customer table.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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

        public static ArrayList<Flight> getAllFlights(){
            ArrayList<Flight> flights = new ArrayList<>();
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM Flight";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            //Do a bunch more queries inside this query to get all other information required - Airports with their addresses
                            Flight flight = mapResultSetToFlight(resultSet);
                            flights.add(flight);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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

            return flights;
        }
        
        public static ArrayList<Flight> getFlightsByDestination(String destination){
            ArrayList<Flight> flights = new ArrayList<>();
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            int destination_id = getDestinationId(destination);
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM Flight WHERE flightNumber = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, destination_id);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            //Do a bunch more queries inside this query to get all other information required - Airports with their addresses
                            Flight flight = mapResultSetToFlight(resultSet);
                            flights.add(flight);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
            return flights;
        }

        public static Flight getFlight(Flight flight){
            Flight the_Flight = null;
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM Flight WHERE flightNumber = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, flight.getFlightNum());
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            //Do a bunch more queries inside this query to get all other information required - Airports with their addresses
                            the_Flight = mapResultSetToFlight(resultSet);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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

            return the_Flight;
        }

        public static void addFlight(Flight newFlight){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            LocalDateTime departTime = newFlight.getDepartureDateTime();
            LocalDateTime arrriveTime = newFlight.getDepartureDateTime();
                      
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
            String formattedArriveTime = arrriveTime.format(dateTimeFormatter);  
            String formattedDepartTime = departTime.format(dateTimeFormatter);
            try {
                connection = createDatabaseConnection(host, user, password, database);
                SQLInsertions.insertFlightData(connection, newFlight.getFlightNum(), newFlight.getPlane().getID(), 
                                                findCrew(newFlight.getCrew().getPilot().getId()), formattedDepartTime,
                                                formattedArriveTime, getDestinationId(newFlight.getOrigin().getAddress().getCity()),
                                                getDestinationId(newFlight.getDestination().getAddress().getCity()));
            }catch(SQLException e) {
                e.printStackTrace();
            }finally {
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

        public static void removeFlight(int flightNumber){
            //deletes from db the flight
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "DELETE FROM Flight WHERE flightNumber = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, flightNumber);
                    
                    int rowsAffected = preparedStatement.executeUpdate();

                    if(rowsAffected > 0){
                        System.out.println("Flight with flightNumber " + flightNumber + " removed successfully.");
                    } else {
                        System.out.println("No flight found with flightNumber " + flightNumber + ".");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
        
        public static void updateFlight(Flight updatedFlight){
            //finds flight from flightNumber and updates it
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String updateQuery = "UPDATE Flight SET plane_id=?, crew_id=?, " +
                                    "departureDateTime=?, arrivalDateTime=?, origin_id=?, destination_id=? " +
                                    "WHERE flightNumber=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setInt(1, updatedFlight.getPlane().getID());
                    preparedStatement.setInt(2, findCrew(updatedFlight.getCrew().getPilot().getId()));
                    preparedStatement.setTimestamp(3, Timestamp.valueOf(updatedFlight.getDepartureDateTime()));
                    preparedStatement.setTimestamp(4, Timestamp.valueOf(updatedFlight.getArrivalDateTime()));
                    preparedStatement.setInt(5, getDestinationId(updatedFlight.getOrigin().getAddress().getCity()));
                    preparedStatement.setInt(6, getDestinationId(updatedFlight.getDestination().getAddress().getCity()));
                    preparedStatement.setInt(7, updatedFlight.getFlightNum());
                                        
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
        

        public static User getUser(int user_id){
            User retrieved_user = null;
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM User WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, user_id);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            Address address = makeAddress(user_id);
                            retrieved_user = new User(resultSet.getString("name"), address, resultSet.getString("username"), 
                                                    resultSet.getString("u_password"));
                            
                            
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
            return retrieved_user;
        }

        public static void addTicket(Ticket ticket){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;

            try {
                connection = createDatabaseConnection(host, user, password, database);
                SQLInsertions.insertTicketData(connection, null, ticket.getFlight().getFlightNum(), 
                                                findSeat(ticket, ticket.getSeat()), ticket.getPrice(), null, false);
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
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

        public static void updateTicket(Ticket ticket){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            
            try {
                connection = createDatabaseConnection(host, user, password, database);
                SQLInsertions.insertCancellationInsuranceData(connection, ticket.getCancellationInsurance());

                String query = "UPDATE Ticket SET cancellationInsurance_id = ?, sold = ? WHERE ticketHolderId = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, ticket.getCancellationInsurance().getId());
                    preparedStatement.setBoolean(2, ticket.isSold());
                    preparedStatement.setInt(3, ticket.getTicketHolderId());

                    int rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) updated in Customer table.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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

        public static User login(String username, String U_password){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            User logginUser = null;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT * FROM User WHERE username = ? and u_password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(1, U_password);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            Address address = makeAddress(resultSet.getInt("id"));
                            logginUser = new User(resultSet.getString("name"), address, resultSet.getString("username"), 
                                                    resultSet.getString("u_password"));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
            return logginUser;
        }

        public static void addCustomer(Customer newCust){
            addUser(newCust);
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;

            try {
                connection = createDatabaseConnection(host, user, password, database);
                SQLInsertions.insertCustomerData(connection, newCust.getId(), null);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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

        public static ArrayList<Customer> getRegisteredUsers(){
            ArrayList<Customer> regCustomers = new ArrayList<>();
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;

            try {
                connection = createDatabaseConnection(host, user, password, database);
                String query = "SELECT User.*" +
                                "FROM Customer" + 
                                "JOIN User ON Customer.user_id = User.id" + 
                                "WHERE Customer.membership_id IS NOT NULL;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            Customer customer = mapResultSetToCustomer(resultSet);
                            regCustomers.add(customer);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
            return regCustomers;
        }

        public static void addReceipt(Receipt receipt){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                SQLInsertions.insertReceiptData(connection, receipt.getPurchaserID(), getTicketID(receipt.getTicket()), receipt.getDateTime().toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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

        public static void addPayment(Payment payment){
            String host = "localhost:3306";
            String user = "root";
            String password = "bio"; 
            String database = "Flights";
            Connection connection = null;
            try {
                connection = createDatabaseConnection(host, user, password, database);
                SQLInsertions.insertPaymentData(connection, payment.getID(), 1, null, 0);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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


        //Admin Features
    
        //public static void getAllPlanes(){}
        //public static void addPlane(Plane newPlane){}
        //public static void removePlane(){}
    }
        
