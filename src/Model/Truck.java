package Model;

import java.awt.*;

/**
 * @author SM
 * Subclass of Model.MotorizedVehicle. Represents a Model.Truck object
 */
public abstract class Truck extends MotorizedVehicle {

    /**
     * Constructor for Model.Truck class
     * @param nrDoors Number of doors on a vehicle
     * @param enginePower Engine power of a vehicle
     * @param color Color of a vehicle
     * @param modelName Model name of a vehicle
     * @param widthMeter Width in meters of vehicle
     * @param heightMeter Height in meters of vehicle
     * @param lengthMeter Length in meters of vehicle
     */
    public Truck(int nrDoors, double enginePower, Color color, String modelName, double widthMeter, double heightMeter, double lengthMeter) {
        super(nrDoors, enginePower, color, modelName, widthMeter, heightMeter, lengthMeter);
        stopEngine();
    }
}