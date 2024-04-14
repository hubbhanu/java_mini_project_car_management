package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class ServicesPage extends JFrame {

    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;

    public ServicesPage() {
        // Set the frame title8
        setTitle("Garage Services");

        // Set the frame size
        setSize(400, 300);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Create a panel for the checkboxes and set its layout to GridLayout
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(5, 1)); // 5 rows, 1 column

        // Create checkboxes for each service and add them to the panel
        checkBox1 = new JCheckBox("1) Tyre Change - $50");
        checkBox1.setBackground(Color.RED);
        checkBoxPanel.add(checkBox1);

        checkBox2 = new JCheckBox("2) Engine Service - $150");
        checkBox2.setBackground(Color.BLUE);
        checkBoxPanel.add(checkBox2);

        checkBox3 = new JCheckBox("3) Washing - $30");
        checkBox3.setBackground(Color.GREEN);
        checkBoxPanel.add(checkBox3);

        checkBox4 = new JCheckBox("4) Painting - $200");
        checkBox4.setBackground(Color.YELLOW);
        checkBoxPanel.add(checkBox4);

        checkBox5 = new JCheckBox("5) Servicing of all internal parts - $300");
        checkBox5.setBackground(Color.ORANGE);
        checkBoxPanel.add(checkBox5);

        // Create a button to proceed after selecting services
        JButton proceedButton = new JButton("Proceed");
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTotalCost();
            }
        });

        // Create a main panel and set its layout to BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create a JLabel for the page title and set its font and color
        JLabel titleLabel = new JLabel("Select a Service:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.MAGENTA);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Add the title label, checkbox panel, and proceed button to the main panel
        mainPanel.add(titleLabel);
        mainPanel.add(checkBoxPanel);
        mainPanel.add(proceedButton);

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    // Method to show the total cost of selected services
    private void showTotalCost() {
        int totalCost = 0;

        // Calculate the total cost based on selected services
        if (checkBox1.isSelected()) {
            totalCost += 50; // Cost of Tyre Change
        }

        if (checkBox2.isSelected()) {
            totalCost += 150; // Cost of Engine Service
        }

        if (checkBox3.isSelected()) {
            totalCost += 30; // Cost of Washing
        }

        if (checkBox4.isSelected()) {
            totalCost += 200; // Cost of Painting
        }

        if (checkBox5.isSelected()) {
            totalCost += 300; // Cost of Servicing of all internal parts
        }

        // Display the total cost in a pop-up dialog
        JOptionPane.showMessageDialog(this, "Total cost: $" + totalCost, "Total Cost", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Create an instance of ServicesPage
        new ServicesPage();
    }
}
