import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Program 2: Simple Calculator using Java Swing
 * Components: Labels, Text Fields, Buttons for Add, Subtract, Multiply, Reset
 * Functionality: Performs arithmetic operations on two numbers
 */
public class SimpleCalculator extends JFrame {
    private JLabel firstNumberLabel, secondNumberLabel, resultLabel;
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, resetButton;
    private JPanel mainPanel, inputPanel, buttonPanel;

    public SimpleCalculator() {
        // Frame Setup
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBackground(new Color(240, 248, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(30, 144, 255));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel titleLabel = new JLabel("Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // Input Panel (Center)
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // First Number Label and Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        firstNumberLabel = new JLabel("Enter First Number:");
        firstNumberLabel.setFont(new Font("Arial", Font.BOLD, 13));
        inputPanel.add(firstNumberLabel, gbc);

        gbc.gridx = 1;
        firstNumberField = new JTextField(20);
        firstNumberField.setFont(new Font("Arial", Font.PLAIN, 13));
        inputPanel.add(firstNumberField, gbc);

        // Second Number Label and Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        secondNumberLabel = new JLabel("Enter Second Number:");
        secondNumberLabel.setFont(new Font("Arial", Font.BOLD, 13));
        inputPanel.add(secondNumberLabel, gbc);

        gbc.gridx = 1;
        secondNumberField = new JTextField(20);
        secondNumberField.setFont(new Font("Arial", Font.PLAIN, 13));
        inputPanel.add(secondNumberField, gbc);

        // Result Label and Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 13));
        inputPanel.add(resultLabel, gbc);

        gbc.gridx = 1;
        resultField = new JTextField(20);
        resultField.setFont(new Font("Arial", Font.PLAIN, 13));
        resultField.setEditable(false);
        resultField.setBackground(new Color(200, 220, 255));
        inputPanel.add(resultField, gbc);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Button Panel (South)
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(240, 248, 255));

        // Add Button
        addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.BOLD, 13));
        addButton.setPreferredSize(new Dimension(100, 40));
        addButton.setBackground(new Color(76, 175, 80));
        addButton.setForeground(Color.WHITE);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.addActionListener(e -> performAddition());
        buttonPanel.add(addButton);

        // Subtract Button
        subtractButton = new JButton("Subtract");
        subtractButton.setFont(new Font("Arial", Font.BOLD, 13));
        subtractButton.setPreferredSize(new Dimension(100, 40));
        subtractButton.setBackground(new Color(255, 152, 0));
        subtractButton.setForeground(Color.WHITE);
        subtractButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        subtractButton.addActionListener(e -> performSubtraction());
        buttonPanel.add(subtractButton);

        // Multiply Button
        multiplyButton = new JButton("Multiply");
        multiplyButton.setFont(new Font("Arial", Font.BOLD, 13));
        multiplyButton.setPreferredSize(new Dimension(100, 40));
        multiplyButton.setBackground(new Color(156, 39, 176));
        multiplyButton.setForeground(Color.WHITE);
        multiplyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        multiplyButton.addActionListener(e -> performMultiplication());
        buttonPanel.add(multiplyButton);

        // Reset Button
        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 13));
        resetButton.setPreferredSize(new Dimension(100, 40));
        resetButton.setBackground(new Color(244, 67, 54));
        resetButton.setForeground(Color.WHITE);
        resetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetButton.addActionListener(e -> resetCalculator());
        buttonPanel.add(resetButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    /**
     * Perform addition operation
     */
    private void performAddition() {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = num1 + num2;
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
            resultField.setText("");
        }
    }

    /**
     * Perform subtraction operation
     */
    private void performSubtraction() {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = num1 - num2;
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
            resultField.setText("");
        }
    }

    /**
     * Perform multiplication operation
     */
    private void performMultiplication() {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = num1 * num2;
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
            resultField.setText("");
        }
    }

    /**
     * Reset all fields
     */
    private void resetCalculator() {
        firstNumberField.setText("");
        secondNumberField.setText("");
        resultField.setText("");
        firstNumberField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}
