package Model;

import java.awt.*;

/**
 * @author SM
 * Subclass of Model.Car. Represents a car of model Volvo240
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * Constructor for Model.Volvo240 class
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240", 1.8, 1.4, 4.5);
    }

    /**
     * Calculates the speed factor (overrides method from Model.MotorizedVehicle)
     * @return The speed factor (factor the speed is changed by)
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}