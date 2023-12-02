package src.boundary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import src.entity.CancellationInsurance;

public class SQLInsertions {

    public static void insertUserData(Connection connection, int id, String name, String addressStreet, String addressCity,
                                      String addressState, String country, String addressZip, String username, String password) {
        try {
            String query = "INSERT INTO User (id, name, address_street, address_city, address_state, country, address_zip, username, u_password) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, addressStreet);
                preparedStatement.setString(4, addressCity);
                preparedStatement.setString(5, addressState);
                preparedStatement.setString(6, country);
                preparedStatement.setString(7, addressZip);
                preparedStatement.setString(8, username);
                preparedStatement.setString(9, password);

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

    public static void insertCustomerData(Connection connection, int userId, Integer membershipId) {
        try {
            String query = "INSERT INTO Customer (user_id, membership_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                if (membershipId != null) {
                    preparedStatement.setInt(2, membershipId);
                } else {
                    preparedStatement.setNull(2, java.sql.Types.INTEGER);
                }
                
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Customer table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertFlightAttendantData(Connection connection, int userId, int crew_id) {
        try {
            String query = "INSERT INTO FlightAttendant (user_id, crew_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, crew_id);

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
    public static void insertAirportData(Connection connection, int airportId, String street, String city, String state, String country, String zip,  String code) {
        try {
            String query = "INSERT INTO Airport (id, address_street, address_city, address_state, country,  address_zip, code) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, airportId);
                preparedStatement.setString(2, street);
                preparedStatement.setString(3, city);
                preparedStatement.setString(4, state);
                preparedStatement.setString(5, country);
                preparedStatement.setString(6, zip);
                preparedStatement.setString(7, code);

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

    public static void insertSeatData(Connection connection, String location, float priceMultiplier, int airplane) {
        try {
            String query = "INSERT INTO Seat (location, priceMultiplier, airplane_id) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, location);
                preparedStatement.setFloat(2, priceMultiplier);
                preparedStatement.setInt(3, airplane);

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
            String departureDateTime, String arrivalDateTime, int originId, int destinationId, float basePrice) {
        try {
            String query = "INSERT INTO Flight (flightNumber, plane_id, crew_id, departureDateTime, arrivalDateTime, " +
                    "origin_id, destination_id, basePrice) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, flightNumber);
                preparedStatement.setInt(2, planeId);
                preparedStatement.setInt(3, crewId);
                preparedStatement.setString(4, departureDateTime);
                preparedStatement.setString(5, arrivalDateTime);
                preparedStatement.setInt(6, originId);
                preparedStatement.setInt(7, destinationId);
                preparedStatement.setFloat(8, basePrice);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Flight table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCancellationInsuranceData(Connection connection, CancellationInsurance CI) {
        float price = CI.getPrice();
        float refundAmount = CI.getRefundAmount();
        int id = CI.getId();
        try {
            String query = "INSERT INTO CancellationInsurance (id, price, refundAmount) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setFloat(1, id);
                preparedStatement.setFloat(2, price);
                preparedStatement.setFloat(3, refundAmount);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into CancellationInsurance table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertTicketData(Connection connection, String ticketHolderId, int flightNumber,
            int seatId, float price, Integer cancellationInsuranceId, boolean sold) {
        try {
            String query = "INSERT INTO Ticket (ticketHolderId, flight_num, seat_id, price, " +
                    "cancellationInsurance_id, sold) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                if (ticketHolderId != null) {
                    preparedStatement.setString(1, ticketHolderId);
                } else {
                    preparedStatement.setNull(1, java.sql.Types.INTEGER);
                }
                preparedStatement.setInt(2, flightNumber);
                preparedStatement.setInt(3, seatId);
                preparedStatement.setFloat(4, price);
                if (cancellationInsuranceId != null) {
                    preparedStatement.setInt(5, cancellationInsuranceId);
                } else {
                    preparedStatement.setNull(5, java.sql.Types.INTEGER);
                }
                preparedStatement.setBoolean(6, sold);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Ticket table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertReceiptData(Connection connection, Integer purchaserId, int ticketId, String dateTime) {
        try {
            String query = "INSERT INTO Receipt (purchaserId, ticket_id, dateTime) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, purchaserId);
                preparedStatement.setInt(2, ticketId);
                preparedStatement.setString(3, dateTime);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Receipt table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public static void insertPaymentMethodData(Connection connection, int methodId) {

    //     PaymentMethod instanceof cred
    //     try {
    //         String query = "INSERT INTO PaymentMethod (id) VALUES (?)";
    //         try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    //             preparedStatement.setInt(1, methodId);

    //             int rowsAffected = preparedStatement.executeUpdate();
    //             System.out.println(rowsAffected + " row(s) inserted into PaymentMethod table.");
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }

    public static void insertPaymentData(Connection connection, int paymentId, long methodId, Integer receiptId, int ticketId) {
        try {
            String query = "INSERT INTO Payment (id, creditCard, receipt_id, ticket_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setInt(1, paymentId);
                preparedStatement.setLong(2, methodId);
                if (receiptId != null) {
                    preparedStatement.setInt(3, receiptId);
                } else {
                    preparedStatement.setNull(3, java.sql.Types.INTEGER);
                }
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
        String password = "Mysql1969?";
        String database = "Flights";
        Connection connection = null;


        try {
            connection = SQLConnector.createDatabaseConnection(host, user, password, database);
            SQLConnector.createDatabase();
            
            // Insert data into the User table
            insertUserData(connection, 111111, "John Doe", "123 Main Ave", "Vancouver", "CA", "Canada", "12345", "john_doe", "password123");
            insertUserData(connection, 222222, "John Woe", "4567 Jacky St", "Calgary", "AB","Canada", "12345", "john_woe", "password456");
            insertUserData(connection, 333333, "Aidan Patterson", "11245 Southy Ave", "Ottawa", "ON","Canada", "12345", "aidan_patterson", "password789");
            insertUserData(connection, 444444, "Johny Pearson", "8439 Main St", "Saskatoon", "SK","Canada", "12345", "johny_pearson", "password234");
            insertUserData(connection, 555555, "Sammy Dappy", "1842 Jorch Ave", "Johnsville", "PEI","Canada", "12345", "sammy_dappy", "password890");
            insertUserData(connection, 666666, "Keith Lordly", "199 Pooch St", "Lordsville", "BC","Canada", "12345", "keith_lordly", "password222");

            insertMembershipData(connection, 555555, "2023-01-01", "2023-12-31", false);
            insertAdminData(connection, 222222);
            insertAgentData(connection, 333333);
            
            insertCustomerData(connection, 333333, 555555); 
            insertCustomerData(connection, 444444, null);     //testing to see if membership can be null within a customer

            insertPilotData(connection, 111111);
            insertAirportData(connection, 1, "1 Airport Ave", "Vancouver", "CA", "Canada", "52467", "YYV");
            insertAirportData(connection, 2, "31 Airport Ave", "Calgary", "CA", "Canada", "52467", "YYC");
            insertPlaneData(connection, 1, 4, 2);
            insertSeatData(connection, "A1", 1.35f, 1);
            insertSeatData(connection, "A2", 1.35f, 1);
            insertCrewData(connection, 1, 111111);
            insertFlightAttendantData(connection, 666666, 1);
            insertFlightData(connection, 123456, 1, 1, "2023-01-01 12:00:00", "2023-01-01 15:00:00", 1, 2, 25.0f);
            CancellationInsurance CI = new CancellationInsurance(1, 5.0f, 100.0f);
            CancellationInsurance CI2 = new CancellationInsurance(2, 10.0f, 125.0f);

            insertCancellationInsuranceData(connection, CI);
            insertCancellationInsuranceData(connection, CI2);

            insertTicketData(connection, "444444", 123456, 1, 100.0f, 1, true);
            insertTicketData(connection, null, 123456, 2, 100.0f, 2, false); //testing to see if ticketholderID can be null within ticket
            
            insertReceiptData(connection, 444444, 1, "2023-01-01 14:30:00");
            // insertPaymentMethodData(connection, 1);
            insertCreditCardData(connection, 1234567890123456L, 1225, 123);
            //insertPaymentData(connection, 1, 1, 1, 1);
            insertPaymentData(connection, 1, 1234567890123456L, null, 1);  //testing to see if receipt can be null

            

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
