import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatingMap extends JFrame {

    private JButton btn;
    private JButton submitButton;
    private JTextArea textArea;
    private JPanel mainPanel;
    private JPanel initialView;
    private JPanel imageAndSelectionView;
    private JLabel imageLabel;
    private JComboBox<Integer> numberDropdown;

    private JComboBox<String> menuDropdown;
    private JLabel selectionLabel;
    private JButton viewMapButton;
    private JButton profileButton;


    public SeatingMap() {
        super("App Name");

        viewMapButton = new JButton("Pick a flight seat");
        profileButton = new JButton("View Profile");
        btn = new JButton("View Seating Map");
        submitButton = new JButton("Submit");
        textArea = new JTextArea();
        mainPanel = new JPanel();
        initialView = new JPanel();
        imageAndSelectionView = new JPanel();
        imageLabel = new JLabel();
        numberDropdown = new JComboBox<>(createNumberArray());
        menuDropdown = new JComboBox<>(createLetterArray());
        selectionLabel = new JLabel("Your selected seat: ");

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
        // Add main panel to the frame
        add(mainPanel);

        // Set frame properties
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Add action listeners
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showImage();
                subPanel.setVisible(true);
                switchView("imageAndSelection");
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAction(imageAndSelectionView);
            }
        });
    }

    private void switchView(String viewName) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, viewName);
    }

    // Method to show the image
    private void showImage() {
        ImageIcon icon = new ImageIcon("SeatingMap.jpg");
        Image image = icon.getImage().getScaledInstance(mainPanel.getWidth() -100, mainPanel.getHeight()-120, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));
    }

    // Method to perform the action when the submit button is clicked
    private void submitAction(JPanel panel) {
        String selectedLetter =  (String) menuDropdown.getSelectedItem();
        int selectedNumber = (Integer) numberDropdown.getSelectedItem();
        String result = selectedNumber + selectedLetter;
        if ((selectedLetter.equals("C") || selectedLetter.equals("D")) && (selectedNumber == 1 || selectedNumber == 2 || selectedNumber == 3)) {
            JOptionPane.showMessageDialog(this, "Please select a valid seat");
        } else {
            JOptionPane.showMessageDialog(this, "You selected seat: " + result);
            selectionLabel.setText("Your selection: " + result);
            panel.setVisible(false);
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
