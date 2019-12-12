package View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.
public class DrawPanel extends JPanel {

    private ArrayList<VehicleGUI> vehicleGUIs = new ArrayList<>();

    // Initializes the panel and reads the images.
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(VehicleGUI vehicleGUI : vehicleGUIs) {
            g.drawImage(vehicleGUI.getImage(), (int) vehicleGUI.getVehicle().getX(), (int) vehicleGUI.getVehicle().getY(), null); // see javadoc for more info on the parameters
        }
    }

    ArrayList<VehicleGUI> getVehicleGUIs() {
        return vehicleGUIs;
    }
}
