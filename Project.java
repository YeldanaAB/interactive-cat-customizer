import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame {
    // instance variables
    private Cat catPanel; // Draws cat
    private JButton changeCatColorButton; // Changes cat's body color
    private JButton changeEyeColorButton; //Changes cat's eye color
    private JCheckBox hatCheckBox; // Customize cat with hat 

    public Project() {
        this.setTitle("Project");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        catPanel = new Cat(); // Panel that draws the cat 

        changeCatColorButton = new JButton("Change Cat Color");
        changeEyeColorButton = new JButton("Change Eye Color");

        changeCatColorButton.setPreferredSize(new Dimension(250, 50));
        changeCatColorButton.setFont(new Font("Courier New", Font.BOLD, 20));

        changeEyeColorButton.setPreferredSize(new Dimension(250, 50));
        changeEyeColorButton.setFont(new Font("Courier New", Font.BOLD, 20));
    
        changeCatColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Color newColor = new Color((int)(Math.random() * 0x1000000)) ; // hex random color
               catPanel.setCatColor(newColor);
            }
        });

        changeEyeColorButton.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = new Color((int)(Math.random() * 0x1000000)) ; 
                catPanel.setEyeColor(newColor);
            }
        });

        hatCheckBox = new JCheckBox("Hat");
        hatCheckBox.setFont(new Font("Courier New", Font.BOLD, 20));
        hatCheckBox.setBackground(Color.WHITE);
        hatCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                catPanel.setHat(hatCheckBox.isSelected());
            }
        });

        // Button panel to group controls together
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(changeCatColorButton);
        buttonPanel.add(changeEyeColorButton);
        buttonPanel.add(hatCheckBox);

        // Layout with cat in center, controls at bottom
        this.setLayout(new BorderLayout());
        this.add(catPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }
}