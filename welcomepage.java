package Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class WelcomePage extends JFrame 
{

    // Inner class representing a custom panel with a moving car animation and background image
    class MovingCarPanel extends JPanel 
    {
        private Image carImage;
        private Image backgroundImage;
        private int carY = 0;
        private int carSpeed = 3; // Speed of the car
        private Timer timer;

        public MovingCarPanel() {
            // Load the car image (change the path to your car image file)
            carImage = Toolkit.getDefaultToolkit().getImage("Login/images.jpeg");
            // Load the background image (change the path to your background image file)
            backgroundImage = Toolkit.getDefaultToolkit().getImage("Login/mechanic-servicing-car-engine.jpg");

            // Create a timer to update the car's position
            timer = new Timer(30, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Update the car's position vertically
                    carY += carSpeed;
                    if (carY > getHeight() - carImage.getHeight(null) || carY < 0) {
                        carSpeed = -carSpeed; // Reverse direction when reaching top or bottom
                    }
                    repaint(); // Repaint the panel
                }
            });
            timer.start(); // Start the timer
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            // Draw the car image at the current Y position
            g.drawImage(carImage, getWidth() / 2 - carImage.getWidth(null) / 2, carY, this);
        }
    }

    public WelcomePage() {
        // Set the frame title
        setTitle("Welcome to Our Garage System");
        // Set the frame size
        setSize(700, 400);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Create an instance of MovingCarPanel
        MovingCarPanel movingCarPanel = new MovingCarPanel();
        movingCarPanel.setLayout(null); // Absolute positioning layout

        // Create a JLabel with a welcome message
        JLabel welcomeLabel = new JLabel("Welcome to Our Garage System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.BLUE);
        welcomeLabel.setBounds(0, 10, getWidth(), 40);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        // Set the layout of the button panel to BoxLayout with vertical alignment
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Create the buttons
        JButton button1 = new JButton("Services Available");
        JButton button2 = new JButton("Complain");
        JButton button3 = new JButton("About Us");
        JButton button4 = new JButton("Address");

        // Add ActionListeners to the buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ServicesPage();
                // System.out.println("Services Available button clicked");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ComplaintBox();
                // System.out.println("Complain button clicked");
            }
        });

        // button3.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         System.out.println("About Us button clicked");
        //     }
        // });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new instance of WelcomePage and make it visible
                new AboutUsPage();
            }
        });
        

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerDetailsPage();
                // System.out.println("Address button clicked");
            }
        });

        // Add the buttons to the button panel
        buttonPanel.add(button1);
        buttonPanel.add(Box.createVerticalStrut(10)); // Adds spacing between buttons
        buttonPanel.add(button2);
        buttonPanel.add(Box.createVerticalStrut(10)); // Adds spacing between buttons
        buttonPanel.add(button3);
        buttonPanel.add(Box.createVerticalStrut(10)); // Adds spacing between buttons
        buttonPanel.add(button4);

        // Set the bounds for the button panel
        buttonPanel.setBounds(10, getHeight() / 2 - 75, 150, 300);

        // Add the welcome label and button panel to the MovingCarPanel
        movingCarPanel.add(welcomeLabel);
        movingCarPanel.add(buttonPanel);

        // Add the MovingCarPanel to the frame
        add(movingCarPanel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of WelcomePage
        new WelcomePage();
    }
}
