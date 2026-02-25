import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Program 1: Registration Form using Java Swing
 * Components: Label, TextBox, Text Area, Checkbox, Radio Button, Button, Image
 */
public class RegistrationForm extends JFrame {
    private JLabel titleLabel, nameLabel, emailLabel, genderLabel, skillsLabel, imageLabel;
    private JTextField nameField, emailField;
    private JTextArea skillsArea;
    private JCheckBox javaCheckBox, pythonCheckBox, cppCheckBox;
    private JRadioButton maleRadio, femaleRadio, otherRadio;
    private ButtonGroup genderGroup;
    private JButton submitButton, resetButton;
    private JScrollPane scrollPane;

    public RegistrationForm() {
        // Frame Setup
        setTitle("User Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main Panel with border layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(245, 245, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Top Panel: Image and Title
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(new Color(100, 150, 200));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create a sample image (colored rectangle)
        imageLabel = new JLabel(createImageIcon());
        imageLabel.setPreferredSize(new Dimension(80, 80));
        topPanel.add(imageLabel);

        titleLabel = new JLabel("Registration Form");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Center Panel: Form Fields
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(245, 245, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Name Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        centerPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        nameField = new JTextField(20);
        centerPanel.add(nameField, gbc);

        // Email Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
        centerPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        centerPanel.add(emailField, gbc);

        // Gender Selection (Radio Buttons)
        gbc.gridx = 0;
        gbc.gridy = 2;
        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 12));
        centerPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.setBackground(new Color(245, 245, 250));
        genderGroup = new ButtonGroup();

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        otherRadio = new JRadioButton("Other");

        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);

        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        genderPanel.add(otherRadio);

        centerPanel.add(genderPanel, gbc);

        // Skills Selection (Checkboxes)
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        skillsLabel = new JLabel("Skills:");
        skillsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        centerPanel.add(skillsLabel, gbc);

        gbc.gridx = 1;
        JPanel skillsPanel = new JPanel();
        skillsPanel.setLayout(new BoxLayout(skillsPanel, BoxLayout.Y_AXIS));
        skillsPanel.setBackground(new Color(245, 245, 250));

        javaCheckBox = new JCheckBox("Java");
        pythonCheckBox = new JCheckBox("Python");
        cppCheckBox = new JCheckBox("C++");

        skillsPanel.add(javaCheckBox);
        skillsPanel.add(pythonCheckBox);
        skillsPanel.add(cppCheckBox);

        centerPanel.add(skillsPanel, gbc);

        // Text Area for Comments
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        JLabel commentsLabel = new JLabel("Comments:");
        commentsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        centerPanel.add(commentsLabel, gbc);

        gbc.gridx = 1;
        skillsArea = new JTextArea(5, 20);
        skillsArea.setLineWrap(true);
        skillsArea.setWrapStyleWord(true);
        skillsArea.setFont(new Font("Arial", Font.PLAIN, 11));
        scrollPane = new JScrollPane(skillsArea);
        centerPanel.add(scrollPane, gbc);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel: Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setBackground(new Color(245, 245, 250));

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.setPreferredSize(new Dimension(100, 35));
        submitButton.setBackground(new Color(76, 175, 80));
        submitButton.setForeground(Color.WHITE);
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.addActionListener(e -> submitForm());

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 12));
        resetButton.setPreferredSize(new Dimension(100, 35));
        resetButton.setBackground(new Color(244, 67, 54));
        resetButton.setForeground(Color.WHITE);
        resetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetButton.addActionListener(e -> resetForm());

        bottomPanel.add(submitButton);
        bottomPanel.add(resetButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    /**
     * Create a sample image icon (blue square with gradient)
     */
    private ImageIcon createImageIcon() {
        BufferedImage image = new BufferedImage(80, 80, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // Create gradient background
        GradientPaint gradient = new GradientPaint(0, 0, new Color(100, 150, 200),
                80, 80, new Color(50, 100, 150));
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, 80, 80);

        // Add border
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(0, 0, 79, 79);

        // Add text
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("U", 28, 55);

        g2d.dispose();
        return new ImageIcon(image);
    }

    /**
     * Submit form and display information
     */
    private void submitForm() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registration Details:\n\n");
        sb.append("Name: ").append(nameField.getText()).append("\n");
        sb.append("Email: ").append(emailField.getText()).append("\n");

        String gender = "";
        if (maleRadio.isSelected()) gender = "Male";
        else if (femaleRadio.isSelected()) gender = "Female";
        else if (otherRadio.isSelected()) gender = "Other";
        sb.append("Gender: ").append(gender).append("\n");

        sb.append("Skills: ");
        StringBuilder skills = new StringBuilder();
        if (javaCheckBox.isSelected()) skills.append("Java ");
        if (pythonCheckBox.isSelected()) skills.append("Python ");
        if (cppCheckBox.isSelected()) skills.append("C++ ");
        sb.append(skills.length() > 0 ? skills.toString() : "None").append("\n");

        sb.append("Comments: ").append(skillsArea.getText());

        JOptionPane.showMessageDialog(this, sb.toString(), "Registration Submitted", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Reset all form fields
     */
    private void resetForm() {
        nameField.setText("");
        emailField.setText("");
        genderGroup.clearSelection();
        javaCheckBox.setSelected(false);
        pythonCheckBox.setSelected(false);
        cppCheckBox.setSelected(false);
        skillsArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm());
    }
}
