package Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CustomerDetailsPage extends JFrame {

    public CustomerDetailsPage() {
        // Set the frame title
        setTitle("Customer Details");
        
        // Set the frame size
        setSize(800, 600);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Set the layout of the frame to BorderLayout
        setLayout(new BorderLayout());

        // Create labels to hold the background images for each direction
        JLabel northImage = new JLabel(new ImageIcon("Login\\cust.jpeg"));
        JLabel southImage = new JLabel(new ImageIcon("Login\\ga.jpeg"));
        JLabel eastImage = new JLabel(new ImageIcon("Login\\se.jpeg"));
        JLabel westImage = new JLabel(new ImageIcon("Login\\download.jpeg"));

        // Add the image labels to the corresponding regions of the frame
        add(northImage, BorderLayout.NORTH);
        add(southImage, BorderLayout.SOUTH);
        add(eastImage, BorderLayout.EAST);
        add(westImage, BorderLayout.WEST);

        // Create a panel for the form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Create labels and text fields for customer details
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 10;
        gbc.gridy = 10;
        formPanel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(15);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 1;
        gbc.gridx = 0;
        formPanel.add(addressLabel, gbc);

        JTextField addressField = new JTextField(15);
        gbc.gridx = 1;
        formPanel.add(addressField, gbc);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 2;
        gbc.gridx = 0;
        formPanel.add(contactLabel, gbc);

        JTextField contactField = new JTextField(15);
        gbc.gridx = 1;
        formPanel.add(contactField, gbc);

        JLabel serviceLabel = new JLabel("Service Type:");
        serviceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 3;
        gbc.gridx = 0;
        formPanel.add(serviceLabel, gbc);

        JTextField serviceField = new JTextField(15);
        gbc.gridx = 1;
        formPanel.add(serviceField, gbc);

        JLabel secretCodeLabel = new JLabel("Secret Code:");
        secretCodeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 4;
        gbc.gridx = 0;
        formPanel.add(secretCodeLabel, gbc);

        JTextField secretCodeField = new JTextField(15);
        gbc.gridx = 1;
        formPanel.add(secretCodeField, gbc);

        // Create a button for submitting the form
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(100, 149, 237));
        submitButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 10;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(submitButton, gbc);

        // Add an ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gather customer details
                String name = nameField.getText();
                String address = addressField.getText();
                String contact = contactField.getText();
                String serviceType = serviceField.getText();
                String secretCode = secretCodeField.getText();
                
                // Handle form submission (e.g., save the data, display a confirmation message, etc.)
                JOptionPane.showMessageDialog(null, "Customer details submitted successfully.\n"
                        + "Name: " + name + "\n"
                        + "Address: " + address + "\n"
                        + "Contact: " + contact + "\n"
                        + "Service Type: " + serviceType + "\n"
                        + "Secret Code: " + secretCode);
            }
        });

        // Add the form panel to the center of the frame
        add(formPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of CustomerDetailsPage
        new CustomerDetailsPage();
    }
}
