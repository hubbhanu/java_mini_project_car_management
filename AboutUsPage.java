package Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AboutUsPage extends JFrame {

    // Initialize the like and dislike counts
    private int likeCount = 0;
    private int dislikeCount = 0;

    // Initialize the car position and the panel
    private int carX = 0;
    private MovingCarPanel carPanel;

    public AboutUsPage() {
        // Set the frame title
        setTitle("About Us");

        // Set the frame size
        setSize(600, 600);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Create the main panel with GridBagLayout for flexible layout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Create a JLabel for the page title and set its font and color
        JLabel titleLabel = new JLabel("About Us");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);

        // Create a custom panel to display the moving car
        carPanel = new MovingCarPanel();
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.3;
        mainPanel.add(carPanel, gbc);

        // Create a JTextArea for displaying an introduction and wrap it in a JScrollPane
        JTextArea introTextArea = new JTextArea(
            "At our garage, we take pride in offering top-notch services for your vehicles.\n" +
            "Our team of experienced technicians is dedicated to providing exceptional customer service\n" +
            "and ensuring your vehicle is in excellent condition. We offer a wide range of services including\n" +
            "tyre changes, engine services, washing, painting, and servicing of all internal parts."
        );
        introTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        introTextArea.setLineWrap(true);
        introTextArea.setWrapStyleWord(true);
        introTextArea.setEditable(false);
        JScrollPane introScrollPane = new JScrollPane(introTextArea);
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.3;
        mainPanel.add(introScrollPane, gbc);

        // Create a section to showcase achievements
        JLabel achievementsLabel = new JLabel("Our Achievements");
        achievementsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        achievementsLabel.setForeground(Color.DARK_GRAY);
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 0;
        mainPanel.add(achievementsLabel, gbc);

        // Create a JTextArea for displaying achievements and wrap it in a JScrollPane
        JTextArea achievementsTextArea = new JTextArea(
            "• Awarded 'Best Garage of the Year' for five consecutive years.\n" +
            "• Achieved a customer satisfaction rating of 98%.\n" +
            "• Successfully serviced over 10,000 vehicles in the last year.\n" +
            "• Recognized for excellence in vehicle repairs by industry organizations.\n" +
            "• Featured in various automotive magazines for our outstanding services."
        );
        achievementsTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        achievementsTextArea.setLineWrap(true);
        achievementsTextArea.setWrapStyleWord(true);
        achievementsTextArea.setEditable(false);
        JScrollPane achievementsScrollPane = new JScrollPane(achievementsTextArea);
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.3;
        mainPanel.add(achievementsScrollPane, gbc);

        // Create like and dislike buttons with icons
        ImageIcon thumbsUpIcon = new ImageIcon("path_to_thumbs_up_icon.png");
        ImageIcon thumbsDownIcon = new ImageIcon("path_to_thumbs_down_icon.png");

        JButton likeButton = new JButton("Like", thumbsUpIcon);
        likeButton.setBackground(Color.GREEN);
        likeButton.setToolTipText("Click to like");

        JButton dislikeButton = new JButton("Dislike", thumbsDownIcon);
        dislikeButton.setBackground(Color.RED);
        dislikeButton.setToolTipText("Click to dislike");

        JLabel likeCountLabel = new JLabel("Likes: " + likeCount);
        JLabel dislikeCountLabel = new JLabel("Dislikes: " + dislikeCount);

        // Add ActionListeners to the buttons to increase the like and dislike counts
        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                likeCount++;
                likeCountLabel.setText("Likes: " + likeCount);
            }
        });

        dislikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dislikeCount++;
                dislikeCountLabel.setText("Dislikes: " + dislikeCount);
            }
        });

        // Add the like and dislike buttons and their counts to the main panel
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        mainPanel.add(likeButton, gbc);
        gbc.gridx = 1;
        mainPanel.add(likeCountLabel, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        mainPanel.add(dislikeButton, gbc);
        gbc.gridx = 1;
        mainPanel.add(dislikeCountLabel, gbc);

        // Create a button to navigate back to the main page or another action
        JButton backButton = new JButton("Back to Home");
        backButton.addActionListener(e -> {
            // Add your action here for when the button is clicked
            // For example, navigate back to the main page
            System.out.println("Back to Home button clicked");
        });

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        mainPanel.add(backButton, gbc);

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    // Inner class for the custom panel with moving car animation
    class MovingCarPanel extends JPanel {
        private Image carImage; // Image of the car
        private Timer timer; // Timer for the animation

        public MovingCarPanel() {
            // Load the car image (change the path to your own car image path)
            carImage = Toolkit.getDefaultToolkit().getImage("Login\\images.jpeg");

            // Create a timer that updates the position of the car every 50 ms
            timer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carX += 2; // Increment the car's x-coordinate
                    if (carX > getWidth()) {
                        carX = -carImage.getWidth(null); // Reset position if car goes off screen
                    }
                    repaint(); // Repaint the panel to update the car's position
                }
            });
            timer.start(); // Start the timer
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the car image at its current position
            g.drawImage(carImage, carX, getHeight() / 2 - carImage.getHeight(null) / 2, this);
        }
    }

    public static void main(String[] args) {
        // Create an instance of AboutUsPage
        new AboutUsPage();
    }
}
