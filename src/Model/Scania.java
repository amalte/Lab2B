package Model;

import java.awt.*;

/**
 * @author SM
 * Subclass of Truck. Represents a Truck of model Scania that has a flatbed (implements IFlatbed)
 */
public class Scania extends Truck {

    private Flatbed flatbed;
    /**
     * Constructor for Scania class
     */
    public Scania() {
        super(2, 250, Color.darkGray, "Scania", 2.5, 3, 7);
        flatbed = new Flatbed(70);
    }

    public void lowerFlatbed() {
        if(!isMoving()) {
            flatbed.lowerFlatbed();
        }
    }

    public void raiseFlatbed() {
        if(!isMoving()) {
            flatbed.raiseFlatbed();
        }
    }

    public int getMaxFlatbedAngle() {
        return flatbed.getMaxFlatbedAngle();
    }

    public boolean flatbedHasNoAngle() {
        return flatbed.flatbedHasNoAngle();
    }

    @Override
    public void gas(double amount) {
        if(flatbedHasNoAngle()) {
            super.gas(amount);
        }
    }

    @Override
    public void startEngine() {
        if(flatbedHasNoAngle()) {
            super.startEngine();
        }
    }

    public int getFlatbedAngle() {
        return flatbed.getFlatbedAngle();
    }

    public void setFlatbedAngle(int angle) {
        if(!isMoving()) {
            flatbed.setFlatbedAngle(angle);
        }
    }

    @Override
    public void setCurrentSpeed(double speed) {
        if(flatbedHasNoAngle()) {
            super.setCurrentSpeed(speed);
        }
    }
}