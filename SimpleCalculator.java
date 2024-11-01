import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    // Declare components
    private JTextField displayField;
    private double num1 = 0, num2 = 0;
    private String operator = "";

    public SimpleCalculator() {
        // Create the frame
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the display field
        displayField = new JTextField();
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        // Create the panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Create buttons and add them to the panel
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "C":
                // Clear the display
                displayField.setText("");
                num1 = num2 = 0;
                operator = "";
                break;
            case "=":
                // Perform the calculation
                num2 = Double.parseDouble(displayField.getText());
                try {
                    double result = calculate(num1, num2, operator);
                    displayField.setText(String.valueOf(result));
                } catch (ArithmeticException ex) {
                    displayField.setText("Error: " + ex.getMessage());
                }
                break;
            default:
                // Handle number and operator input
                if ("+-*/".contains(command)) {
                    num1 = Double.parseDouble(displayField.getText());
                    operator = command;
                    displayField.setText("");
                } else {
                    // Append digit to the display
                    displayField.setText(displayField.getText() + command);
                }
                break;
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return num1 / num2;
            default:
                throw new UnsupportedOperationException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}
