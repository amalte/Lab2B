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

    // Doesn't allow the vehicles to leave the panel
    void keepVehiclesInsidePanel() {
        for(VehicleGUI vehicleGUI : vehicleGUIs) {

            // Checks if the vehicle left the panel
            if(outOfPanel(vehicleGUI)) {
                vehicleGUI.getVehicle().stopEngine();

                // Corrects the position so the vehicle image isn't outside of panel anymore
                correctPosition(vehicleGUI);
                // Inverts direction so it continues the movement to the other side of the panel
                vehicleGUI.getVehicle().turnRight();
                vehicleGUI.getVehicle().turnRight();

                vehicleGUI.getVehicle().startEngine();
            }
        }
    }

    // Checks if a vehicle image has left the panel
    private boolean outOfPanel(VehicleGUI vehicleGUI) {
        return (vehicleGUI.getVehicle().getY() < 0) ||
                (vehicleGUI.getVehicle().getY() + vehicleGUI.getImage().getHeight() > getHeight() ||
                (vehicleGUI.getVehicle().getX() < 0) ||
                (vehicleGUI.getVehicle().getX() + vehicleGUI.getImage().getWidth() > getWidth()));
    }

    // Corrects the position so the vehicle image isn't outside of panel anymore
    private void correctPosition(VehicleGUI vehicleGUI) {
        double x = Math.min(vehicleGUI.getVehicle().getX(), getWidth() - vehicleGUI.getImage().getWidth());
        vehicleGUI.getVehicle().setX(Math.max(x, 0));
        double y = Math.min(vehicleGUI.getVehicle().getY(), getHeight() - vehicleGUI.getImage().getHeight());
        vehicleGUI.getVehicle().setY(Math.max(y, 0));
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
