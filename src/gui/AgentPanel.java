package gui;

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
//import SeatingMap;

public class AgentPanel extends JFrame {
//    private UserController userController;
    private Agent currentAgent;
    private String destinationInput;
    private String originInput;
    private int price;
    private Address originAddress = new Address("9th St. NE", "Calgary", "Alberta", "Canada", "90210");
    private Address destAddress = new Address("9th Ave SW", "Vancouver", "British Columbia", "Canada", "01209");
    private String selectedLetter;
    private int selectedNumber = 0;
    private JPanel mainPanel = new JPanel();
    private ArrayList<Customer> passengers = new ArrayList<>();
    private JTextArea passengersTextArea = new JTextArea();


    private JFrame seatingMapFrame = new JFrame("App Name");

    public AgentPanel() {
//        this.userController = user;

        setTitle("Agent Profile");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {

        // Header


        JPanel panel = new JPanel(new GridLayout(5,2));
        ImageIcon headerIcon = resizeImageIcon( new ImageIcon("headerImage.jpg"), 1280, 300); // Header image
        JLabel headerLabel = new JLabel(headerIcon);
        panel.add(headerLabel);
        // Footer

        //SHOULD BE CHANGED TO GETCUSTOMER() FUNCTIONALITY
        Address address = new Address("55th", "Calgary", "Alberta", "Canada", "90210");
        currentAgent = new Agent("John Smith", address, "johnsmith00", "password123");
        //GETCUSTOMER()^^

        JLabel nameLabel = (new JLabel("Hey, " + currentAgent.getName()));
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 21)); // Set the font size to 16 (adjust as needed)
        JPanel memberButtonsPanel = new JPanel();

        panel.add(nameLabel);

        panel.add(new JLabel("Address: " + currentAgent.getAddress().toString()));
        JPanel flightPanel = new JPanel();

        JButton bookFlightButton = new JButton("View Flights!");
        Address address1 = new Address("69th", "Calgary", "Alberta", "Canada", "90210");
        Address address2 = new Address("1st", "Edmonton", "Alberta", "Canada", "90120");
        Address address3 = new Address("111th", "Vancouver", "BC", "Canada", "9021");
        passengers.add(new Customer("Tyler North", address1, "tylernorth00", "password1234"));
        passengers.add(new Customer("Tyler West", address2, "tylerwest00", "password12345"));
        passengers.add(new Customer("Tyler East", address3, "tylereast00", "password12346"));
        // in connection we will use the below line to copy a passenger list of the chosen flight (flightID) to the ArrayList passengers
        // which is implemented in the displayFlight method below.



        //Plane plane = new Plane(); /* initialize Plane */

        ArrayList<FlightAttendant> flightAttendants = new ArrayList<>();
        Pilot pilot = new Pilot("Johnathan Smith", address, "johnsmith01", "password1234");;

        // Create a Crew
        Crew crew = new Crew(pilot, flightAttendants);// initialize Crew

        // Create Airports
        Airport origin = new Airport(originAddress, "YYC"); /* initialize Airport */
        Airport destination = new Airport(destAddress, "YVR"); /* initialize Airport */

        // Set departure and arrival times
        LocalDateTime departureDateTime = LocalDateTime.now();
        LocalDateTime arrivalDateTime = departureDateTime.plusHours(2);

        price = 200;
        // Create a Flight object
//        Flight flight = new Flight(plane, crew, departureDateTime, arrivalDateTime, origin, destination, (float) price);
//
//        // Make calls to get methods
//        Plane flightPlane = flight.getPlane();
//        Crew flightCrew = flight.getCrew();
//        LocalDateTime flightDepartureDateTime = flight.getDepartureDateTime();
//        LocalDateTime flightArrivalDateTime = flight.getArrivalDateTime();
//        Airport flightOrigin = flight.getOrigin();
//        Airport flightDestination = flight.getDestination();
//        Map<String, Ticket> flightTickets = flight.getTickets();
//        boolean isSeatAvailable = flight.isSeatAvailable();/* provide seat location */
//        double flightNumber = flight.getFlightNumber();
//


        flightPanel.add(bookFlightButton);
        panel.add(flightPanel);
        JPanel browseFlightsPanel = new JPanel( new GridLayout(5,2));
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
                JLabel nameLabel = (new JLabel("You can search for a flight by typing a destination or a origin or both!\nPlease use the code of the desired airport, e.g. if your desired origin is Calgary, please type YYC, if it's Edmonton, type YEG, etc.\n"));                flightPanel.add(nameLabel);
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
                System.out.println("Origins (input):|" + originInput + "|onFile: |" + originAddress.getCity() + "|");
                System.out.println("destination (input):|" + destinationInput + "|onFile: |" + destAddress.getCity() + "|");

                if (originAddress.getCity().equals( originInput) && destAddress.getCity().equals( destinationInput)){
                    displayFlight(flightPanel);//flight Number should be passed as an argument with the panel
                    System.out.println("We are here!");
                } else if (originInput.equals(originAddress.getCity()) && destinationInput.equals("")) {
                    displayFlight(flightPanel);
                    System.out.println("We are here elseif!");
                } else if (destinationInput.equals(destAddress.getCity()) && originInput.equals("")) {
                    displayFlight(flightPanel);
                    System.out.println("We are here elseif2!");
                } else {
                    System.out.println("We are here else!");
                }
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
        JPanel allFlightsPanel = new JPanel();
        for (Flight flight : FlightController.getInstance().getFlights()) {
            // Check if getOrigin or getDestination equals user input
            if (flight.getOrigin().getCode().equals(originInput) || flight.getDestination().getCode().equals(destinationInput)) {
                // Create a JTextLabel for the matching flight
                JTextArea flightDetails = new JTextArea("Flight number: " + flight.getFlightNum()+"\nDeparting From: " + flight.getOrigin().getCode() + "\nDeparting at: " + flight.getDepartureDateTime() + "Arriving to: " + flight.getDestination().getCode() + "\nArriving at: " + flight.getArrivalDateTime() + "\nPrice: " + flight.getBasePrice());
                flightDetails.setEditable(false);

                // Add the JTextLabel to the panel
                allFlightsPanel.add(flightDetails);
                JPanel TextPanel = new JPanel();
                JButton selectSeatsButton = new JButton("Check Seats for flight");
                JButton viewPassengersButton = new JButton("View Passengers!");
                JButton cancelButton = new JButton("Return to main page");
                selectSeatsButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        performSeatingMapFunctionality(currentPanel);

                        revalidate();
                        repaint();
                    }
                });
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new AgentPanel();
                        dispose();

                    }
                });
                viewPassengersButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        passengersTextArea.setText("Passenger Names:\n");
                        for (User passenger : FlightController.getInstance().getFlightPassengers(flight)) {
                            passengersTextArea.append(passenger.getName());
                            passengersTextArea.append("\n");
                        }
                        passengersTextArea.setEditable(false);

                        // Create a scrollable JTextArea and display it in a JFrame
                        JScrollPane scrollPane = new JScrollPane(passengersTextArea);
                        JFrame passengersFrame = new JFrame("Passenger List");
                        passengersFrame.add(scrollPane);
                        passengersFrame.setSize(400, 300);
                        passengersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        passengersFrame.setVisible(true);
                    }
                });
                TextPanel.add(flightDetails);
                TextPanel.add(selectSeatsButton);
                TextPanel.add(cancelButton);
                TextPanel.add(viewPassengersButton);
                currentPanel.add(TextPanel);


                revalidate();
                repaint();
            }
        }
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
        //currentPanel.add(mainPanel);
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
        seatingMapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            }
        });
        revalidate();
        repaint();
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
    }

    // Method to perform the action when the submit button is clicked
    private void submitAction(JPanel panel, JComboBox<String> menuDropdown, JComboBox<Integer> numberDropdown, JLabel selectionLabel) {
        selectedLetter = (String) menuDropdown.getSelectedItem();
        selectedNumber = (Integer) numberDropdown.getSelectedItem();
        String result = selectedNumber + selectedLetter;
        if ((selectedLetter.equals("C") || selectedLetter.equals("D")) && (selectedNumber == 1 || selectedNumber == 2 || selectedNumber == 3)) {
            JOptionPane.showMessageDialog(null, "Please select a valid seat");
        } else {
            JOptionPane.showMessageDialog(null, "You selected seat: " + result);
            selectionLabel.setText("Your selection: " + result);
            panel.setVisible(false);
            seatingMapFrame.setVisible(false);

        }
    }

    private Integer[] createNumberArray() {
        Integer[] numbers = new Integer[20];
        for (int i = 0; i < 20; i++) {
            numbers[i] = i + 1;
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
