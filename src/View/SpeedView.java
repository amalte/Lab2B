package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpeedView extends View {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 300;
    private final CarView carView;
    ArrayList<JLabel> labels = new ArrayList<>();
    ArrayList<Double> speeds = new ArrayList<>();

    public SpeedView(CarView carView) {
        super(WIDTH, HEIGHT);
        this.carView = carView;
        initComponents();
    }

    @Override
    protected void initComponents() {
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        renderText();
        updateView();
    }

    public void updateView() {
        updateSpeeds();
        for(JLabel label : labels) {
            label.setText(label.getText() + speeds.get(labels.indexOf(label)));
        }
        this.repaint();
    }

    private void renderText() {
        for(VehicleGUI vehicleGUI : carView.getVehicleGUIList()) {
            JLabel label = new JLabel(vehicleGUI.getVehicle().getModelName() + " speed: ");
            this.add(label);
            labels.add(label);
            speeds.add(vehicleGUI.getVehicle().getCurrentSpeed());
        }
    }

    private void updateSpeeds() {
        for(Double speed : speeds) {
            speed = carView.getVehicleGUIList().get(speeds.indexOf(speed)).getVehicle().getCurrentSpeed();
        }
    }
}
