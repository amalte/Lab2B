import Controller.CarController;
import View.CarView;
import Model.Saab95;
import Model.Scania;
import Model.Volvo240;


public class Main {
    public static void main(String[] args) {

        // Initialize the controller and start a new view
        CarView view = new CarView("CarSim 1.3");
        CarController cc = new CarController(view);

        view.addVehicle(new Volvo240());
        view.addVehicle(new Saab95(), 0, 100);
        view.addVehicle(new Scania(), 0, 200);

        // Start the timer
        view.startTimer();
    }
}
