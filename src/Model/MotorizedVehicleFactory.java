package Model;


import java.awt.*;

public class MotorizedVehicleFactory {

    // Private so class cannot be instanciable through constructor
    private MotorizedVehicleFactory(){}

    public static MotorizedVehicle createVolvo240() {
        return new Volvo240();
    }

    public static MotorizedVehicle createSaab95() {
        return new Saab95();
    }

    public static MotorizedVehicle createScania() {
        return new Scania();
    }

    public static MotorizedVehicle createVolvoFH16() {
        return new VolvoFH16();
    }

    public static MotorizedVehicle createCarFerry(int maxLoad, Color color) {
        return new CarFerry(maxLoad, 3, 3, 3.5, 7, 0, 300, color, "Car Ferry", 15, 20, 40);
    }
}
