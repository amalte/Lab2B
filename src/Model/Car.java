package Model;

import Model.Interfaces.ITransportable;

import java.awt.*;

/**
 * @author SM
 * Abstract superclass to all Model.Car subobjects
 */
public abstract class Car extends MotorizedVehicle implements ITransportable {

    private boolean loaded;

    /**
     * Constructor for Model.Car class
     * @param nrDoors Number of doors on a vehicle
     * @param enginePower Engine power of a vehicle
     * @param color Color of a vehicle
     * @param modelName Model name of a vehicle
     * @param widthMeter Width in meters of vehicle
     * @param heightMeter Height in meters of vehicle
     * @param lengthMeter Length in meters of vehicle
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, double widthMeter, double heightMeter, double lengthMeter) {
        super(nrDoors, enginePower, color, modelName, widthMeter, heightMeter, lengthMeter);
        stopEngine();
    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }

    @Override
    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
}