package View;

import Model.MotorizedVehicle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends View {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;


    // Panels
    DrawPanel drawPanel;
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();

    // Gas spinner
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    // Buttons
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Raise Bed");
    JButton lowerBedButton = new JButton("Scania Lower Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(){
        super(WIDTH, HEIGHT);
        drawPanel = new DrawPanel(WIDTH, HEIGHT-240);
        initComponents();
    }

    // Sets everything in place and fits everything
    @Override
    protected void initComponents() {

        // General
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);

        // Gas spinner
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        // Gas Panel
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);

        // Control panel
        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((WIDTH/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);
        this.add(controlPanel);

        // Start button
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(WIDTH/5-15,200));
        this.add(startButton);

        // Stop button
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(WIDTH/5-15,200));
        this.add(stopButton);





    }

    public void updateView() {
        for (int i = 0; i < drawPanel.getVehicleGUIs().size(); i++) {
            drawPanel.getVehicleGUIs().get(i).getVehicle().move();
            drawPanel.repaint();    //Calls the paintComponent method of the panel
        }
        keepVehiclesInsidePanel();
    }

    // Doesn't allow the vehicles to leave the panel
    void keepVehiclesInsidePanel() {
        for(VehicleGUI vehicleGUI : drawPanel.getVehicleGUIs()) {

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
                (vehicleGUI.getVehicle().getY() + vehicleGUI.getImage().getHeight() > drawPanel.getHeight() ||
                        (vehicleGUI.getVehicle().getX() < 0) ||
                        (vehicleGUI.getVehicle().getX() + vehicleGUI.getImage().getWidth() > drawPanel.getWidth()));
    }

    // Corrects the position so the vehicle image isn't outside of panel anymore
    private void correctPosition(VehicleGUI vehicleGUI) {
        double x = Math.min(vehicleGUI.getVehicle().getX(), drawPanel.getWidth() - vehicleGUI.getImage().getWidth());
        vehicleGUI.getVehicle().setX(Math.max(x, 0));
        double y = Math.min(vehicleGUI.getVehicle().getY(), drawPanel.getHeight() - vehicleGUI.getImage().getHeight());
        vehicleGUI.getVehicle().setY(Math.max(y, 0));
    }

    // Adds a vehicle to the view (panel)
    public void addVehicle(MotorizedVehicle vehicle) {
        drawPanel.getVehicleGUIs().add(new VehicleGUI(vehicle));
    }

    // Adds a vehicle to the view on the given coordinates (panel)
    public void addVehicle(MotorizedVehicle vehicle, double x, double y) {
        drawPanel.getVehicleGUIs().add(new VehicleGUI(vehicle));
        vehicle.setX(x);
        vehicle.setY(y);
    }

    public ArrayList<VehicleGUI> getVehicleGUIList() {
        return drawPanel.getVehicleGUIs();
    }

    public VehicleGUI getVehicleGUI(int i) {
        return drawPanel.getVehicleGUIs().get(i);
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public JButton getGasButton() {
        return gasButton;
    }

    public JButton getBrakeButton() {
        return brakeButton;
    }

    public JButton getTurboOnButton() {
        return turboOnButton;
    }

    public JButton getTurboOffButton() {
        return turboOffButton;
    }

    public JButton getLiftBedButton() {
        return liftBedButton;
    }

    public JButton getLowerBedButton() {
        return lowerBedButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }
}