import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Program 3: Color Selection using List Box
 * Components: List Box with color names, Button, Panel
 * Functionality: Change panel background color based on selection from list
 */
public class ColorSelector extends JFrame {
    private JList<String> colorList;
    private JPanel displayPanel;
    private JButton selectButton;
    private DefaultListModel<String> listModel;

    // Color mapping
    private java.util.HashMap<String, Color> colorMap;

    public ColorSelector() {
        // Frame Setup
        setTitle("Color Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        // Initialize color map
        colorMap = new java.util.HashMap<>();
        colorMap.put("Red", new Color(220, 20, 60));
        colorMap.put("Green", new Color(34, 139, 34));
        colorMap.put("Blue", new Color(30, 144, 255));
        colorMap.put("Yellow", new Color(255, 215, 0));
        colorMap.put("Purple", new Color(147, 51, 234));
        colorMap.put("Orange", new Color(255, 140, 0));

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBackground(new Color(240, 240, 245));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(50, 50, 100));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JLabel titleLabel = new JLabel("Color Selector - Choose a Color");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // Left Panel: List Box
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout(10, 10));
        leftPanel.setBackground(new Color(240, 240, 245));

        JLabel listLabel = new JLabel("Available Colors:");
        listLabel.setFont(new Font("Arial", Font.BOLD, 14));
        leftPanel.add(listLabel, BorderLayout.NORTH);

        // Create List Box
        listModel = new DefaultListModel<>();
        listModel.addElement("Red");
        listModel.addElement("Green");
        listModel.addElement("Blue");
        listModel.addElement("Yellow");
        listModel.addElement("Purple");
        listModel.addElement("Orange");

        colorList = new JList<>(listModel);
        colorList.setFont(new Font("Arial", Font.PLAIN, 14));
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colorList.setSelectedIndex(0);
        colorList.setBackground(new Color(255, 255, 255));
        colorList.setForeground(new Color(50, 50, 50));

        // Scroll Pane for List
        JScrollPane scrollPane = new JScrollPane(colorList);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(leftPanel, BorderLayout.WEST);

        // Right Panel: Display Panel and Button
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout(10, 10));
        rightPanel.setBackground(new Color(240, 240, 245));

        JLabel displayLabel = new JLabel("Color Preview:");
        displayLabel.setFont(new Font("Arial", Font.BOLD, 14));
        rightPanel.add(displayLabel, BorderLayout.NORTH);

        // Display Panel
        displayPanel = new JPanel();
        displayPanel.setBackground(colorMap.get("Red"));
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        rightPanel.add(displayPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 245));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        selectButton = new JButton("Apply Color");
        selectButton.setFont(new Font("Arial", Font.BOLD, 13));
        selectButton.setPreferredSize(new Dimension(120, 40));
        selectButton.setBackground(new Color(76, 175, 80));
        selectButton.setForeground(Color.WHITE);
        selectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        selectButton.addActionListener(e -> applySelectedColor());

        buttonPanel.add(selectButton);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(rightPanel, BorderLayout.CENTER);

        // Add mouse listener to list for double-click functionality
        colorList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    applySelectedColor();
                }
            }
        });

        add(mainPanel);
        setVisible(true);
    }

    /**
     * Apply the selected color from the list box to the display panel
     */
    private void applySelectedColor() {
        String selectedColor = colorList.getSelectedValue();
        if (selectedColor != null) {
            Color newColor = colorMap.get(selectedColor);
            displayPanel.setBackground(newColor);
            displayPanel.repaint();

            // Show confirmation message
            JOptionPane.showMessageDialog(this,
                    "Panel color changed to: " + selectedColor,
                    "Color Changed",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a color from the list!",
                    "Selection Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorSelector());
    }
}
