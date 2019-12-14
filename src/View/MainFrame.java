package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel mainPanel = new JPanel();

    public MainFrame(String frameName) {
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(mainPanel);

        this.setLayout(new FlowLayout());
        this.setTitle(frameName);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Make sure the frame exits when "x" is pressed
        this.setVisible(true);  // Make the frame visible
    }

    public void addView(View view) {
        mainPanel.add(view);
        mainPanel.repaint();
        this.pack();    // Make the frame pack all it's components by respecting the sizes if possible.
        this.setLocationRelativeTo(null);   // Sets frame position to center of screen depending on the frames component sizes.
    }
}
