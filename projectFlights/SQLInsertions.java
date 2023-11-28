package projectFlights;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLInsertions {

    public static void insertUserData(Connection connection, int id, String name, String addressStreet, String addressCity,
                                      String addressState, String addressZip, String username, String password) {
        try {
            String query = "INSERT INTO User (id, name, address_street, address_city, address_state, address_zip, username, password) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, addressStreet);
                preparedStatement.setString(4, addressCity);
                preparedStatement.setString(5, addressState);
                preparedStatement.setString(6, addressZip);
                preparedStatement.setString(7, username);
                preparedStatement.setString(8, password);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into User table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertMembershipData(Connection connection, int mid, String dateRegistered, String expiryDate, boolean companionTicketUsed) {
        try {
            String query = "INSERT INTO Membership (mid, date_registered, expiry_date, companion_ticket_used) " +
                           "VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, mid);
                preparedStatement.setString(2, dateRegistered);
                preparedStatement.setString(3, expiryDate);
                preparedStatement.setBoolean(4, companionTicketUsed);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Membership table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertAdminData(Connection connection, int userId) {
        try {
            String query = "INSERT INTO Admin (user_id) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Admin table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertAgentData(Connection connection, int userId) {
        try {
            String query = "INSERT INTO Agent (user_id) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Agent table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCustomerData(Connection connection, int userId, int membershipId) {
        try {
            String query = "INSERT INTO Customer (user_id, membership_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, membershipId);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Customer table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertCustomerData(Connection connection, int userId) {
        try {
            String query = "INSERT INTO Customer (user_id, membership_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setNull(2, java.sql.Types.INTEGER);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Customer table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertFlightAttendantData(Connection connection, int userId) {
        try {
            String query = "INSERT INTO FlightAttendant (user_id) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into FlightAttendant table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertPilotData(Connection connection, int userId) {
        try {
            String query = "INSERT INTO Pilot (id) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Pilot table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertAirportData(Connection connection, int airportId, String street, String city, String state, String zip, String code) {
        try {
            String query = "INSERT INTO Airport (id, address_street, address_city, address_state, address_zip, code) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, airportId);
                preparedStatement.setString(2, street);
                preparedStatement.setString(3, city);
                preparedStatement.setString(4, state);
                preparedStatement.setString(5, zip);
                preparedStatement.setString(6, code);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Airport table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertPlaneData(Connection connection, int planeId, int numRows, int seatsPerRow) {
        try {
            String query = "INSERT INTO Plane (id, numRows, seatsPerRow) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, planeId);
                preparedStatement.setInt(2, numRows);
                preparedStatement.setInt(3, seatsPerRow);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Plane table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertSeatData(Connection connection, int seatId, String location, float priceMultiplier, int airplane) {
        try {
            String query = "INSERT INTO Seat (id, location, priceMultiplier, airplane_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, seatId);
                preparedStatement.setString(2, location);
                preparedStatement.setFloat(3, priceMultiplier);
                preparedStatement.setInt(4, airplane);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Seat table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCrewData(Connection connection, int crewId, Integer pilotId) {
        try {
            String query = "INSERT INTO Crew (id, pilot_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, crewId);
                
                // Set pilotId to null if it is indeed null, otherwise set the actual value
                if (pilotId != null) {
                    preparedStatement.setInt(2, pilotId);
                } else {
                    preparedStatement.setNull(2, java.sql.Types.INTEGER);
                }

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Crew table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertFlightData(Connection connection, int flightNumber, int planeId, int crewId,
            String departureDateTime, String arrivalDateTime, int originId, int destinationId) {
        try {
            String query = "INSERT INTO Flight (flightNumber, plane_id, crew_id, departureDateTime, arrivalDateTime, " +
                    "origin_id, destination_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, flightNumber);
                preparedStatement.setInt(2, planeId);
                preparedStatement.setInt(3, crewId);
                preparedStatement.setString(4, departureDateTime);
                preparedStatement.setString(5, arrivalDateTime);
                preparedStatement.setInt(6, originId);
                preparedStatement.setInt(7, destinationId);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Flight table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCancellationInsuranceData(Connection connection, int insuranceId, float price, float refundAmount) {
        try {
            String query = "INSERT INTO CancellationInsurance (id, price, refundAmount) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, insuranceId);
                preparedStatement.setFloat(2, price);
                preparedStatement.setFloat(3, refundAmount);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into CancellationInsurance table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertTicketData(Connection connection, int ticketId, int ticketHolderId, int flightNumber,
            int seatId, float price, int cancellationInsuranceId, boolean sold) {
        try {
            String query = "INSERT INTO Ticket (id, ticketHolderId, flight_num, seat_id, price, " +
                    "cancellationInsurance_id, sold) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, ticketId);
                preparedStatement.setInt(2, ticketHolderId);
                preparedStatement.setInt(3, flightNumber);
                preparedStatement.setInt(4, seatId);
                preparedStatement.setFloat(5, price);
                preparedStatement.setInt(6, cancellationInsuranceId);
                preparedStatement.setBoolean(7, sold);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Ticket table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertReceiptData(Connection connection, int receiptId, int purchaserId, int ticketId, String dateTime) {
        try {
            String query = "INSERT INTO Receipt (id, purchaserId, ticket_id, dateTime) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, receiptId);
                preparedStatement.setInt(2, purchaserId);
                preparedStatement.setInt(3, ticketId);
                preparedStatement.setString(4, dateTime);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Receipt table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertPaymentMethodData(Connection connection, int methodId) {
        try {
            String query = "INSERT INTO PaymentMethod (id) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, methodId);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into PaymentMethod table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertPaymentData(Connection connection, int paymentId, int methodId, int receiptId, int ticketId) {
        try {
            String query = "INSERT INTO Payment (id, method_id, receipt_id, ticket_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, paymentId);
                preparedStatement.setInt(2, methodId);
                preparedStatement.setInt(3, receiptId);
                preparedStatement.setInt(4, ticketId);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Payment table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCreditCardData(Connection connection, long cardNumber, int expiry, int cvv) {
        try {
            String query = "INSERT INTO CreditCard (number, expiry, cvv) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, cardNumber);
                preparedStatement.setInt(2, expiry);
                preparedStatement.setInt(3, cvv);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into CreditCard table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testInsertions(){
        String host = "localhost:3306";
        String user = "root";
        String password = "bio";
        String database = "Flights";
        Connection connection = null;


        try {
            connection = SQLConnector.createDatabaseConnection(host, user, password, database);
            SQLConnector.createDatabase();
            
            // Insert data into the User table
            insertUserData(connection, 111111, "John Doe", "123 Main Ave", "Vancouver", "CA", "12345", "john_doe", "password123");
            insertUserData(connection, 222222, "John Woe", "4567 Jacky St", "Calgary", "AB", "12345", "john_woe", "password456");
            insertUserData(connection, 333333, "Aidan Patterson", "11245 Southy Ave", "Ottawa", "ON", "12345", "aidan_patterson", "password789");
            insertUserData(connection, 444444, "Johny Pearson", "8439 Main St", "Saskatoon", "SK", "12345", "johny_pearson", "password234");
            insertUserData(connection, 555555, "Sammy Dappy", "1842 Jorch Ave", "Johnsville", "PEI", "12345", "sammy_dappy", "password890");
            insertUserData(connection, 666666, "Keith Lordly", "199 Pooch St", "Lordsville", "BC", "12345", "keith_lordly", "password222");
            // Insert data into other tables by calling respective insert methods

            insertMembershipData(connection, 555555, "2023-01-01", "2023-12-31", false);
            insertAdminData(connection, 222222);
            insertAgentData(connection, 333333);
            //insertCustomerData(connection, 444444, 555555); 
            insertCustomerData(connection, 444444);     //testing to see if membership can be null within a customer
            insertFlightAttendantData(connection, 666666);
            insertPilotData(connection, 111111);
            insertAirportData(connection, 1, "1 Airport Ave", "Vancouver", "CA", "52467", "YYV");
            insertAirportData(connection, 2, "31 Airport Ave", "Calgary", "CA", "52467", "YYC");
            insertPlaneData(connection, 1, 4, 2);
            insertSeatData(connection, 1, "A1", 1.5f, 1);
            insertCrewData(connection, 1, 111111);
            insertFlightData(connection, 123456, 1, 1, "2023-01-01 12:00:00", "2023-01-01 15:00:00", 1, 2);
            insertCancellationInsuranceData(connection, 1, 25.0f, 125.0f);
            insertTicketData(connection, 1, 444444, 123456, 1, 100.0f, 1, true);
            insertReceiptData(connection, 1, 444444, 1, "2023-01-01 14:30:00");
            insertPaymentMethodData(connection, 1);
            insertPaymentData(connection, 1, 1, 1, 1);
            insertCreditCardData(connection, 1234567890123456L, 1225, 123);

        } catch (Exception e) {
                e.printStackTrace();
        }finally {
            try {
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
        testInsertions();
    }
}
