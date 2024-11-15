import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneApp extends JFrame {
    private JTextField phoneNumberField;
    private JButton callButton;
    private JLabel statusLabel;
    private boolean callActive = false;

    public PhoneApp() {
        createComponents();
        setLayout(null);
        addComponents();
        addListeners();
        setTitle("Phone App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createComponents() {
        phoneNumberField = new JTextField();
        callButton = new JButton("CALL");
        statusLabel = new JLabel("");

        // Set bounds for the text field, call button, and status label
        phoneNumberField.setBounds(50, 30, 300, 30);
        callButton.setBounds(150, 300, 100, 30);
        statusLabel.setBounds(50, 260, 300, 30);
    }

    public void addComponents() {
        // Add text field, call button, and status label
        add(phoneNumberField);
        add(callButton);
        add(statusLabel);

        // Add number buttons (0 to 9) to a panel
        JPanel numberPad = new JPanel();
        numberPad.setBounds(50, 80, 300, 150);
        numberPad.setLayout(new GridLayout(4, 3, 5, 5));

        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new NumberButtonListener());
            numberPad.add(button);
        }

        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(new NumberButtonListener());
        numberPad.add(zeroButton);

        // Add the number pad to the main frame
        add(numberPad);
    }

    public void addListeners() {
        callButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!callActive) {
                    String phoneNumber = phoneNumberField.getText();
                    if (phoneNumber.isEmpty()) {
                        statusLabel.setText("Enter a valid number.");
                    } else {
                        statusLabel.setText("Calling " + phoneNumber + "...");
                        callButton.setText("Hang Up");
                        callActive = true;
                    }
                } else {
                    statusLabel.setText("");
                    phoneNumberField.setText("");
                    callButton.setText("CALL");
                    callActive = false;
                }
            }
        });
    }

    // Inner class for number button listeners
    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String number = ((JButton) e.getSource()).getText();
            phoneNumberField.setText(phoneNumberField.getText() + number);
        }
    }

    public static void main(String[] args) {
        new PhoneApp();
    }
}
