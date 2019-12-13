package View;

import Model.MotorizedVehicle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpeedView extends View {

    private static final int WIDTH = 150;
    private static final int HEIGHT = 150;
    private ArrayList<MotorizedVehicle> vehicles = new ArrayList<>();
    private ArrayList<JLabel> labels = new ArrayList<>();

    SpeedView() {
        super(0, 0);
        initComponents();
    }

    public void addVehicle(MotorizedVehicle... vehicles) {
        for(MotorizedVehicle motorizedVehicle : vehicles) {
            this.vehicles.add(motorizedVehicle);
            JLabel label = new JLabel(motorizedVehicle.getModelName() + " - Update Error");
            labels.add(label);
            this.add(label);
        }
    }

    @Override
    protected void initComponents() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.CYAN);
    }

    @Override
    public void updateView() {
        for(JLabel label : labels) {
            MotorizedVehicle currentVehicle = vehicles.get(labels.indexOf(label));
            label.setText(String.format("%s  speed:  %.2f", currentVehicle.getModelName(), currentVehicle.getCurrentSpeed()));
            this.repaint();
        }
    }
}
