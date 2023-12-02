import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentGUI extends JFrame {
    private Flight flight;
    private String seat;
    private Ticket ticket;
    private CancellationInsurance insurance;
    private CreditCard creditCard;
    private Payment payment;
    private PaymentController paymentController;

    private JTextArea checkOutDetails


    public PaymentGUI(Flight flight, String seat, CancellationInsurance insurance) {
        this.flight = flight;
        this.seat = seat;
        this.insurance = insurance;

        initializeComponents();
        setupLayout();
    }

    private void initializeComponents() {
        JTextArea checkOutDetails = new JTextArea("Origin: " + flight.getOrigin() +"\nDestination: " + flight.getDestination() + "\nPrice: $" + flight.getBasePrice() + "Seat: " + seat);
        flightDetails.setEditable(false);
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

        add(checkOutDetails);
        add(cancelBookingButton);
        add(creditCardButton);
    }

    private void setupLayout() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
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
            long cardNumber = cardNumberField.getText();
            int expirationDate = expirationDateField.getText();
            int cvv = cvvField.getText();

            CreditCard creditCard = new CreditCard(cardNumber, expirationDate, cvv);
            // Perform further actions with the credit card object as needed
            System.out.println("Credit Card Details: " + creditCard.toString());
            //if(makePayment(ticket, creditCard, insurance)){
//            JOptionPane.showMessageDialog(this, "Ticket has been successfully booked! you will receive an email shortly");
            // } else{
//            JOptionPane.showMessageDialog(this, "An issue has occured with Payment, You are now returning to the main Page!");
            // }
        }
    }

//    public static void main(String[] args) {
//        // Example usage:
//        PaymentGUI paymentGUI = new PaymentGUI(sampleFlight, "A1", sampleInsurance);
//    }
}