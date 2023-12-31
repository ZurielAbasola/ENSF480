package src.gui;

import gui.PaymentPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

import src.controllers.*;
import src.entity.*;
import src.entity.Crew;
import src.entity.Plane;
import src.gui.*;

public class ProfilePage extends JFrame {
    private User currentCustomer;
    private String destinationInput;
    private String originInput;
    private int price;
    private String selectedLetter;
    private int selectedNumber = 0;
    private JPanel mainPanel = new JPanel();
    private ArrayList<Flight> testArrayFlights = new ArrayList<>();
    private int flightNumberFlights = 0;
    private Flight flightChosen;
    private Ticket chosenTicket;
    private Plane planeFlights;
    private Airport originFlights;
    private Airport destinationFlights;
    private ArrayList<FlightAttendant> testArrayFlightAttendants = new ArrayList<>();
    private float basePriceFlights;



    private JFrame seatingMapFrame = new JFrame("Seating");
    private JFrame paymentFrame = new JFrame("Payment");

    public ProfilePage() {
        setTitle("User Profile");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {

        JPanel panel = new JPanel(new GridLayout(5,2));
        ImageIcon headerIcon = resizeImageIcon( new ImageIcon("headerImage.jpg"), 1280, 300); // Header image
        JLabel headerLabel = new JLabel(headerIcon);
        panel.add(headerLabel);

        //GETCUSTOMER() FUNCTIONALITY
        currentCustomer = src.controllers.UserController.getCurrentUser();

        JLabel nameLabel = (new JLabel("Hey " + currentCustomer.getName() + ","));
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 26)); // Set the font size to 16 (adjust as needed)
        JPanel memberButtonsPanel = new JPanel();

        panel.add(nameLabel);

        panel.add(new JLabel("Address: " + currentCustomer.getAddress().toString()));
        JPanel flightPanel = new JPanel();

        JButton bookFlightButton = new JButton("Book a Flight!");

        // Create a Flight object
        testArrayFlights = FlightController.getInstance().getFlights();

        flightPanel.add(bookFlightButton);
        panel.add(flightPanel);
        JPanel searchByPanel = new JPanel();
        JTextField destTextBox = new JTextField(20);
        searchByPanel.add(new JLabel("Enter a destination (City):"));
        searchByPanel.add(destTextBox);

        // Create and add the second text box
        JTextField originTextBox = new JTextField(20);
        searchByPanel.add(new JLabel("Enter the origin (City):"));
        searchByPanel.add(originTextBox);

        bookFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(panel);
                JLabel nameLabel = (new JLabel("You can search for a flight by typing a destination or a origin or both!\n Please use the code of the desired airport, e.g. if your desired origin is Calgary, please type YYC, if it's Vancouver, type YYV, etc.\n"));
                flightPanel.add(nameLabel);
                flightPanel.add(searchByPanel);
                flightPanel.remove(bookFlightButton);
                add(flightPanel);
                revalidate();
                repaint();
            }
        });
        // Create a button to trigger action (optional)
        JButton saveButton = new JButton("Search for a flight!");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUserInputs(originTextBox, destTextBox);
                displayFlight(flightPanel);
                revalidate();
                repaint();
            }
        });
        searchByPanel.add(saveButton);
        // Make the frame visible
        setVisible(true);
        add(panel);

    }

    private void displayFlight(JPanel currentPanel) {
        JPanel allFlightsPanel = new JPanel(new GridLayout(0, 3));
        for (Flight flight : testArrayFlights) {
            // Check if getOrigin or getDestination equals user input
            if (flight.getOrigin().getCode().equals(originInput) || flight.getDestination().getCode().equals(destinationInput)) {
                // Create a JTextLabel for the matching flight
                JTextArea flightDetails = new JTextArea("Flight number: " + flight.getFlightNum()+"\nDeparting From: " + flight.getOrigin().getCode() + "\nDeparting at: " + flight.getDepartureDateTime() + "\nArriving to: " + flight.getDestination().getCode() + "\nArriving at: " + flight.getArrivalDateTime() + "\nPrice: " + flight.getBasePrice());
                flightDetails.setEditable(false);
                JPanel flightPanelDisplay = new JPanel();
                // Add the JTextLabel to the panel
                flightPanelDisplay.add(flightDetails);
                JButton selectSeatsButton = new JButton("Select Seats for flight");
                selectSeatsButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        performSeatingMapFunctionality(currentPanel);
                        flightChosen = flight;
                        revalidate();
                        repaint();
                    }
                });
                flightPanelDisplay.add(selectSeatsButton);
                allFlightsPanel.add(flightPanelDisplay);
                revalidate();
                repaint();
            }

        }
        currentPanel.add(allFlightsPanel);
        revalidate();
        repaint();
    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void saveUserInputs(JTextField origin, JTextField destination) {
        // Retrieve user inputs from text boxes and save them to variables
        this.originInput = origin.getText().trim();
        this.destinationInput = destination.getText().trim();
    }
    private void performSeatingMapFunctionality(JPanel currentPanel) {
        // Encapsulated functionality from SeatingMap
        JButton btn = new JButton("View Seating Map");
        JButton submitButton = new JButton("Submit");
        JTextArea textArea = new JTextArea();
        JPanel initialView = new JPanel();
        JPanel imageAndSelectionView = new JPanel();
        JLabel imageLabel = new JLabel();
        JComboBox<Integer> numberDropdown = new JComboBox<>(createNumberArray());
        JComboBox<String> menuDropdown = new JComboBox<>(createLetterArray());
        JLabel selectionLabel = new JLabel("Your selected seat: ");
        // Set layout for the main panel
        mainPanel.setLayout(new CardLayout());
        // Set layout for initial view
        initialView.setLayout(new BorderLayout());
        btn.setPreferredSize(new Dimension(200, 50));
        initialView.add(btn, BorderLayout.CENTER);

        // Set layout for image and selection view
        imageAndSelectionView.setLayout(new BorderLayout());
        imageAndSelectionView.add(imageLabel, BorderLayout.CENTER);

        // Create a sub-panel for the number and letter dropdowns, submit button, and selection label
        JPanel subPanel = new JPanel(new FlowLayout());
        subPanel.add(numberDropdown);
        subPanel.add(menuDropdown);
        subPanel.add(submitButton);
        subPanel.add(selectionLabel);

        // Add the sub-panel to the image and selection view
        imageAndSelectionView.add(subPanel, BorderLayout.SOUTH);

        // Add views to the main panel
        mainPanel.add(initialView, "initial");
        mainPanel.add(imageAndSelectionView, "imageAndSelection");

        // Set frame properties
        seatingMapFrame.getContentPane().add(mainPanel);
        seatingMapFrame.setSize(1080, 720);
        seatingMapFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        seatingMapFrame.setVisible(true);

        // Add action listeners
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showImage(imageLabel, mainPanel);
                subPanel.setVisible(true);
                switchView(mainPanel, "imageAndSelection");
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAction(imageAndSelectionView, menuDropdown, numberDropdown, selectionLabel);
                System.out.println("Right After returning to PerfromSeatingMap");

//                displayPayment(chosenTicket, imageAndSelectionView);
                revalidate();
                System.out.println("Right After validate PerfromSeatingMap");

                repaint();
                System.out.println("Right After repaint to PerfromSeatingMap");

            }
        });
        
        currentPanel.add(mainPanel);
        System.out.println("Here line 230");

        revalidate();
        System.out.println("Here line 230 After revalidate");

        repaint();
        System.out.println("Here line 230 After repaint");

    }
    public void displayPayment(Ticket theTicket, JPanel thePanel){
        thePanel.removeAll();
        JPanel mainPaymentPanel = new JPanel();
        Flight paymentForFlight = FlightController.getInstance().getFlight(chosenTicket.getFlight());
        JTextArea checkOutDetails = new JTextArea("Origin: " + paymentForFlight.getOrigin().getAddress().getCity() + ", " + paymentForFlight.getOrigin().getCode() +"\nDestination: " + paymentForFlight.getDestination().getAddress().getCity() + ", " + paymentForFlight.getDestination().getCode() + "\nPrice: $" + paymentForFlight.getBasePrice() + "Seat: " + chosenTicket.getSeat().getLocation());
        checkOutDetails.setEditable(false);
        JButton cancelBookingButton = new JButton("Cancel Flight Booking");
        JButton creditCardButton = new JButton("Credit Card Payment");

        cancelBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCancellationNotification();
            }
        });

        creditCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCreditCardPaymentDialog();
            }
        });

        mainPaymentPanel.add(checkOutDetails);
        mainPaymentPanel.add(cancelBookingButton);
        mainPaymentPanel.add(creditCardButton);
        thePanel.add(mainPaymentPanel);

        paymentFrame.getContentPane().add(mainPaymentPanel);
        paymentFrame.setSize(1080, 720);
        paymentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        paymentFrame.setVisible(true);
        revalidate();
        repaint();
    }

    private void showCancellationNotification() {
        JOptionPane.showMessageDialog(this, "Cancellation notification\nBooking is now cancelled.");
    }

    private void showCreditCardPaymentDialog() {
        JTextField cardNumberField = new JTextField();
        JTextField expirationDateField = new JTextField();
        JTextField cvvField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Credit Card Number:"));
        panel.add(cardNumberField);
        panel.add(new JLabel("Expiration Date:"));
        panel.add(expirationDateField);
        panel.add(new JLabel("CVV:"));
        panel.add(cvvField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Enter Credit Card Details",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            // User pressed OK, create CreditCard object with entered details
            String cardNumber = cardNumberField.getText();
            String expirationDate = expirationDateField.getText();
            String cvv = cvvField.getText();

            CreditCard creditCard = new CreditCard(Long.parseLong(cardNumber) , Integer.parseInt(expirationDate), Integer.parseInt(cvv));
            // Perform further actions with the credit card object as needed
            System.out.println("Credit Card Details: " + creditCard.toString());
            if(PaymentController.getInstance().makePayment(chosenTicket, creditCard, chosenTicket.getCancellationInsurance())){
                JOptionPane.showMessageDialog(this, "Ticket has been successfully booked! you will receive an email shortly");
            } else{
                JOptionPane.showMessageDialog(this, "An issue has occured with Payment, You are now returning to the main Page!");
            }
        }
    }

    private void switchView(JPanel mainPanel, String viewName) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, viewName);
    }

    // Method to show the image
    private void showImage(JLabel imageLabel, JPanel mainPanel) {
        ImageIcon icon = new ImageIcon("SeatingMap.jpg");
        Image image = icon.getImage().getScaledInstance(mainPanel.getWidth() - 100, mainPanel.getHeight() - 120, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));
        mainPanel.add(imageLabel);
    }

    // Method to perform the action when the submit button is clicked
    private void submitAction(JPanel panel, JComboBox<String> menuDropdown, JComboBox<Integer> numberDropdown, JLabel selectionLabel) {
        selectedLetter = (String) menuDropdown.getSelectedItem();
        selectedNumber = (Integer) numberDropdown.getSelectedItem();
        String result = selectedNumber + selectedLetter;
        if ((selectedLetter.equals("C") || selectedLetter.equals("D")) && (selectedNumber == 1 || selectedNumber == 2 || selectedNumber == 3)) {
            JOptionPane.showMessageDialog(null, "Please select a valid seat");
        } else {
            chosenTicket = flightChosen.getTickets().get(result);
            if (chosenTicket.getSeat().getLocation().equals(result)){
                //JOptionPane.showMessageDialog(null, "You selected seat: " + result);
                
                selectionLabel.setText("Your selection: " + result);
                //panel.setVisible(false);
                //seatingMapFrame.setVisible(false);
//                displayPayment(chosenTicket, panel);
                System.out.println("Right Before calling PaymentFrame");
                PaymentPanel paymentFrame = new PaymentPanel(chosenTicket, chosenTicket.getCancellationInsurance());
                paymentFrame.setVisible(true);
                paymentFrame.pack();
                paymentFrame.setLocationRelativeTo(null);
                System.out.println("Right After calling PaymentFrame");
            } else {
                JOptionPane.showMessageDialog(null, "This seat is taken, please select an empty seat (currently 0A and 0B are empty)");
            }
        }
    }

    private Integer[] createNumberArray() {
        Integer[] numbers = new Integer[20];
        for (int i = 0; i < 20; i++) {
            numbers[i] = i;
        }
        return numbers;
    }

    // Helper method to create an array of numbers from 1 to 20
    private String[] createLetterArray() {
        String[] choices = new String[]{"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < 6; i++) {
            choices[i] = Character.toString((char) ('A' + i));
        }
        return choices;
    }

}
