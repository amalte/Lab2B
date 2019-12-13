package View;

import Controller.IObserver;
import Model.MotorizedVehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpeedView extends View implements IObserver {

    private static final int WIDTH = 150;
    private static final int HEIGHT = 250;
    private ArrayList<MotorizedVehicle> vehicles = new ArrayList<>();
    private ArrayList<JLabel> labels = new ArrayList<>();

    SpeedView() {
        initComponents();
    }

    /*
    public void addVehicle(MotorizedVehicle... vehicles) {
        for(MotorizedVehicle motorizedVehicle : vehicles) {
            this.vehicles.add(motorizedVehicle);
            JLabel label = new JLabel(motorizedVehicle.getModelName() + " - Update Error");
            labels.add(label);
            this.add(label);
        }
    }*/

    @Override
    protected void initComponents() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.CYAN);
    }

    /*@Override
    public void updateView() {
        for(JLabel label : labels) {
            MotorizedVehicle currentVehicle = vehicles.get(labels.indexOf(label));
            label.setText(String.format("%s  speed:  %.2f", currentVehicle.getModelName(), currentVehicle.getCurrentSpeed()));
            this.repaint();
        }
    }*/

    @Override
    public void actOnVehicleListChange(ArrayList<VehicleGUI> vehicleGUIList) {
            if(vehicleGUIList.size() < labels.size()) {
                this.remove(labels.get(labels.size() - 1));
                labels.remove(labels.get(labels.size() - 1));
            } else if(vehicleGUIList.size() > labels.size()){
                JLabel label = new JLabel(vehicleGUIList.get(vehicleGUIList.size() - 1).getVehicle().getModelName() + " speed: 0");
                this.add(label);
                labels.add(label);
            }
        this.validate();
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
