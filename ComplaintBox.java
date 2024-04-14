package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComplaintBox extends JFrame {

    public ComplaintBox() {
        // Set the frame title
        setTitle("Complaint Box");

        // Set the frame size
        setSize(300, 350); // Set a small frame size
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Create a main panel and set its layout to BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create a JLabel for the page title and set its font and color
        JLabel titleLabel = new JLabel("Complaint Box");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.MAGENTA);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);

        // Create a label for the user's name
        JLabel nameLabel = new JLabel("Name of owner of vehicle and details of car :");
        mainPanel.add(nameLabel);

        // Create a JTextField for the user's name and wrap it in a JScrollPane
        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.BOLD, 14));
        nameField.setForeground(Color.BLUE);
        JScrollPane nameScrollPane = new JScrollPane(nameField);
        nameScrollPane.setPreferredSize(new java.awt.Dimension(150, 20)); // Set reduced width and height
        mainPanel.add(nameScrollPane);

        // Create a label for the user's email
        JLabel emailLabel = new JLabel("Enter details of our staff who repaired your car and how much you  paid ");
        mainPanel.add(emailLabel);

        // Create a JTextField for the user's email and wrap it in a JScrollPane
        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.ITALIC, 14));
        emailField.setForeground(Color.RED);
        JScrollPane emailScrollPane = new JScrollPane(emailField);
        emailScrollPane.setPreferredSize(new java.awt.Dimension(150, 20)); // Set reduced width and height
        mainPanel.add(emailScrollPane);

        // Create a label and combo box for selecting the service being complained about
        JLabel serviceLabel = new JLabel("Service:");
        String[] services = {"Tyre Change", "Engine Service", "Washing", "Painting", "Servicing of all internal parts"};
        JComboBox<String> serviceComboBox = new JComboBox<>(services);
        mainPanel.add(serviceLabel);
        mainPanel.add(serviceComboBox);

        // Create a label and text area for the complaint
        JLabel complaintLabel = new JLabel("Complaint:");
        JTextArea complaintArea = new JTextArea(4, 20); // Set smaller area for complaint
        JScrollPane complaintScrollPane = new JScrollPane(complaintArea);
        mainPanel.add(complaintLabel);
        mainPanel.add(complaintScrollPane);

        // Create a submit button and add an action listener to handle the complaint submission
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrievethe entered data
                String name = nameField.getText();
                String email = emailField.getText();
                String service = (String) serviceComboBox.getSelectedItem();
                String complaint = complaintArea.getText();

                // Display a confirmation message
                JOptionPane.showMessageDialog(
                    null,
                    "Complaint submitted!\n\n" +
                    "Name OF OWNER : " + name +
                    "\nStaff name : " + email +
                    "\nService: " + service +
                    "\nComplaint: " + complaint,
                    "Complaint Submitted",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        mainPanel.add(submitButton);

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of ComplaintBox
        new ComplaintBox();
    }
}