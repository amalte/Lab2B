package View;

import Controller.IObserver;
import Model.MotorizedVehicle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class SpeedView extends View implements IObserver {

    private static int WIDTH = 150;
    private static int HEIGHT = 40;
    private ArrayList<JLabel> labels = new ArrayList<>();
    private JLabel viewName = new JLabel("<html><h3><u>Vehicle Speeds</u></h3></html>");

    SpeedView() {
        initComponents();
    }

    private void addSpeedLabel(ArrayList<VehicleGUI> vehicleGUIList) {
        JLabel label = new JLabel(vehicleGUIList.get(vehicleGUIList.size() - 1).getVehicle().getModelName() + "  speed:  0,00");
        label.setBorder(new EmptyBorder(0, 5, 0, 0));
        this.add(label);
        labels.add(label);
        HEIGHT += 16;
    }

    private void removeSpeedLabel() {
        this.remove(labels.get(labels.size() - 1));
        labels.remove(labels.get(labels.size() - 1));
        HEIGHT -= 16;
    }

    @Override
    protected void initComponents() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.LIGHT_GRAY);

        viewName.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(viewName);
    }

    @Override
    public void actOnVehicleListChange(ArrayList<VehicleGUI> vehicleGUIList) {
        if(vehicleGUIList.size() > labels.size()) {         // Add speed label
            addSpeedLabel(vehicleGUIList);
        } else if(vehicleGUIList.size() < labels.size()){   // Remove speed label
            removeSpeedLabel();
        }
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actOnVehicleSpeedChange(ArrayList<VehicleGUI> vehicleGUIList) {
        for (JLabel label : labels) {
            MotorizedVehicle currentVehicle = vehicleGUIList.get(labels.indexOf(label)).getVehicle();
            label.setText(String.format("%s  speed:  %.2f", currentVehicle.getModelName(), currentVehicle.getCurrentSpeed()));
        }
    }
}
