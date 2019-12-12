package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel mainPanel = new JPanel();

    public MainFrame(String frameName) {
        this.setTitle(frameName);
        this.add(mainPanel);
        this.setVisible(true);  // Make the frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Make sure the frame exits when "x" is pressed


    }

    public void addView(View view) {
        mainPanel.add(view);
        mainPanel.repaint();
        //updatePosition();
        this.pack();    // Make the frame pack all it's components by respecting the sizes if possible.
    }

    private void updatePosition() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();    // Get the computer screen resolution
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); // Center the frame
    }
}
