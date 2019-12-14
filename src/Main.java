import Controller.VehicleController;

import View.MainFrame;
import View.SpeedView;
import View.VehicleView;
import View.ViewFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static VehicleView vehicleView = ViewFactory.createCarView();
    static SpeedView speedView = ViewFactory.createSpeedView();

    public static void main(String[] args) {

        final int delay = 50;   // The delay (ms) corresponds to 20 updates a sec (hz)
        Timer timer = new Timer(delay, new TimerListener());    // The timer is started with an listener (see below) that executes the statements each step between delays.

        // Initialize the frame and its views
        MainFrame view = new MainFrame("CarSim 1.5");
        view.addView(vehicleView);
        view.addView(speedView);

        // Initialize the CarController
        VehicleController cc = new VehicleController(vehicleView);
        cc.addObserver(speedView);

        // Start the timer
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vehicleView.updateView();
        }
    }
}
