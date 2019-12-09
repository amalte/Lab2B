package Model;

import java.awt.*;

/**
 * @author SM
 * Subclass of Model.Car. Represents a car of model Model.Saab95
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Constructor for Saab95 class
     */
    public Saab95(){
        super(2, 125, Color.red, "Saab95", 1.8, 1.4, 4.8);
	    turboOn = false;
    }

    /**
     * Turns on turbo (sets turboOn to true)
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns off turbo (sets turboOn to false)
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Calculates the speed factor (overrides method from Model.MotorizedVehicle)
     * @return Returns the speed factor (factor the speed is changed by)
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}