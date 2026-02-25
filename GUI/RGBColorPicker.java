import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Program 4: RGB Color Picker using Combo Boxes
 * Components: 3 Labels (Red, Green, Blue), 3 Combo Boxes (0-255 values), Button, Panel
 * Functionality: Change panel background color based on RGB values selected
 */
public class RGBColorPicker extends JFrame {
    private JComboBox<Integer> redCombo, greenCombo, blueCombo;
    private JPanel displayPanel;
    private JButton showButton;
    private JLabel redValueLabel, greenValueLabel, blueValueLabel, rgbDisplayLabel;

    public RGBColorPicker() {
        // Frame Setup
        setTitle("RGB Color Picker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBackground(new Color(245, 245, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(70, 130, 180));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JLabel titleLabel = new JLabel("RGB Color Picker");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // Center Panel: Input Controls and Display
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(245, 245, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.anchor = GridBagConstraints.WEST;

        // Row 1: Red Component
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel redLabel = new JLabel("Red:");
        redLabel.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(redLabel, gbc);

        gbc.gridx = 1;
        redCombo = createColorComboBox();
        redCombo.addActionListener(e -> updateColorPreview());
        centerPanel.add(redCombo, gbc);

        gbc.gridx = 2;
        redValueLabel = new JLabel("(0)");
        redValueLabel.setFont(new Font("Arial", Font.BOLD, 12));
        redValueLabel.setForeground(new Color(220, 20, 60));
        centerPanel.add(redValueLabel, gbc);

        // Row 2: Green Component
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel greenLabel = new JLabel("Green:");
        greenLabel.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(greenLabel, gbc);

        gbc.gridx = 1;
        greenCombo = createColorComboBox();
        greenCombo.addActionListener(e -> updateColorPreview());
        centerPanel.add(greenCombo, gbc);

        gbc.gridx = 2;
        greenValueLabel = new JLabel("(0)");
        greenValueLabel.setFont(new Font("Arial", Font.BOLD, 12));
        greenValueLabel.setForeground(new Color(34, 139, 34));
        centerPanel.add(greenValueLabel, gbc);

        // Row 3: Blue Component
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel blueLabel = new JLabel("Blue:");
        blueLabel.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(blueLabel, gbc);

        gbc.gridx = 1;
        blueCombo = createColorComboBox();
        blueCombo.addActionListener(e -> updateColorPreview());
        centerPanel.add(blueCombo, gbc);

        gbc.gridx = 2;
        blueValueLabel = new JLabel("(0)");
        blueValueLabel.setFont(new Font("Arial", Font.BOLD, 12));
        blueValueLabel.setForeground(new Color(30, 144, 255));
        centerPanel.add(blueValueLabel, gbc);

        // Row 4: RGB Display Value
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        rgbDisplayLabel = new JLabel("RGB(0, 0, 0)");
        rgbDisplayLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rgbDisplayLabel.setForeground(new Color(50, 50, 50));
        centerPanel.add(rgbDisplayLabel, gbc);
        gbc.gridwidth = 1;

        // Row 5: Display Panel
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel previewLabel = new JLabel("Color Preview:");
        previewLabel.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(previewLabel, gbc);

        gbc.gridy = 5;
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(250, 150));
        displayPanel.setBackground(new Color(0, 0, 0));
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        centerPanel.add(displayPanel, gbc);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(245, 245, 250));

        showButton = new JButton("Show Output");
        showButton.setFont(new Font("Arial", Font.BOLD, 13));
        showButton.setPreferredSize(new Dimension(140, 40));
        showButton.setBackground(new Color(76, 175, 80));
        showButton.setForeground(Color.WHITE);
        showButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showButton.addActionListener(e -> showColorOutput());

        buttonPanel.add(showButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    /**
     * Create a combo box with values from 0 to 255
     */
    private JComboBox<Integer> createColorComboBox() {
        Integer[] values = new Integer[256];
        for (int i = 0; i <= 255; i++) {
            values[i] = i;
        }

        JComboBox<Integer> combo = new JComboBox<>(values);
        combo.setFont(new Font("Arial", Font.PLAIN, 12));
        combo.setPreferredSize(new Dimension(80, 30));
        return combo;
    }

    /**
     * Update the color preview based on selected RGB values
     */
    private void updateColorPreview() {
        int red = (Integer) redCombo.getSelectedItem();
        int green = (Integer) greenCombo.getSelectedItem();
        int blue = (Integer) blueCombo.getSelectedItem();

        // Update color panel
        displayPanel.setBackground(new Color(red, green, blue));
        displayPanel.repaint();

        // Update RGB display label
        rgbDisplayLabel.setText("RGB(" + red + ", " + green + ", " + blue + ")");

        // Update individual value labels
        redValueLabel.setText("(" + red + ")");
        greenValueLabel.setText("(" + green + ")");
        blueValueLabel.setText("(" + blue + ")");
    }

    /**
     * Show the final color output in a dialog
     */
    private void showColorOutput() {
        int red = (Integer) redCombo.getSelectedItem();
        int green = (Integer) greenCombo.getSelectedItem();
        int blue = (Integer) blueCombo.getSelectedItem();

        String message = String.format("Selected Color:\n\nRGB(%d, %d, %d)\n\nRed: %d\nGreen: %d\nBlue: %d",
                red, green, blue, red, green, blue);

        JOptionPane.showMessageDialog(this, message, "Color Output", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RGBColorPicker());
    }
}
