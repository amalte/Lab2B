import Controller.CarController;
import View.CarView;
import Model.Saab95;
import Model.Scania;
import Model.Volvo240;
import View.MainFrame;
import View.SpeedView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    static CarView carView = new CarView();
    static SpeedView speedView = new SpeedView(carView);

    public static void main(String[] args) {

        // The delay (ms) corresponds to 20 updates a sec (hz)
        final int delay = 50;
        // The timer is started with an listener (see below) that executes the statements each step between delays.
        Timer timer = new Timer(delay, new TimerListener());

        // Initialize the controller and start a new view
        MainFrame view = new MainFrame("CarSim 1.3");

        view.addView(carView);


        CarController cc = new CarController(carView);

        carView.addVehicle(new Volvo240());
        carView.addVehicle(new Saab95(), 0, 100);
        carView.addVehicle(new Scania(), 0, 200);



        view.addView(speedView);

        // Start the timer
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carView.updateView();
            speedView.updateView();
        }
    }
}
