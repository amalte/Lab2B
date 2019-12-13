package Model;

import Model.Interfaces.ISizeable;
import java.awt.*;

/**
 * @author SM
 * Abstract superclass to all MotorVehicle subobjects. Extends Model.Movable and Implements ISizeable
 */
public abstract class MotorizedVehicle extends Movable implements ISizeable {
    private final int nrDoors; // Number of doors on the vehicle
    private double enginePower; // Engine power of the vehicle
    private Color color; // Color of the vehicle
    private final String modelName; // The vehicle model name

    private double widthMeter; // Width of vehicle in meters
    private double heightMeter; // Height of vehicle in meters
    private double lengthMeter; // Length of vehicle meters

    /**
     * Constructor for Model.MotorizedVehicle class
     * @param nrDoors Number of doors on a vehicle
     * @param enginePower Engine power of a vehicle
     * @param color Color of a vehicle
     * @param modelName Model name of a vehicle
     * @param widthMeter Width in meters of vehicle
     * @param heightMeter Height in meters of vehicle
     * @param lengthMeter Length in meters of vehicle
     */
    public MotorizedVehicle(int nrDoors, double enginePower, Color color, String modelName, double widthMeter, double heightMeter, double lengthMeter) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.widthMeter = widthMeter;
        this.heightMeter = heightMeter;
        this.lengthMeter = lengthMeter;
        stopEngine();
    }

    /**
     * Increases speed of car depending on amount by calling on incrementSpeed
     * @param amount Amount the speed should be increased with
     */
    public void gas(double amount) {
        if(getCurrentSpeed() != 0) {
            amount = Math.max(amount, 0);
            incrementSpeed(Math.min(amount, 1));
        }
    }

    /**
     * Decreases speed of car depending on amount by calling on decrementSpeed
     * @param amount Amount the speed should be decreased with
     */
    public void brake(double amount){
        amount = Math.max(amount, 0);
        decrementSpeed(Math.min(amount, 1));
    }

    /**
     * Returns speed factor of car
     * @return Returns speed factor (can be overridden in subclasses)
     */
    protected double speedFactor() { return 1; }

    /**
     * Increments speed of car depending on amount
     * @param amount Amount the speed should increment with
     */
    private void incrementSpeed(double amount) { setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount); }

    /**
     * Decrements speed of car depending on amount
     * @param amount Amount the speed should decrement with
     */
    private void decrementSpeed(double amount){ setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount); }

    /**
     * Starts engine by setting currentSpeed to 0.1
     */
    public void startEngine(){
        if(currentSpeed <= 0) {
            currentSpeed = 0.1;
        }
    }

    /**
     * Stops engine by setting currentSpeed to 0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Returns if a Model.Car object is moving or not
     * @return Returns true or false depending on if a Model.Car object is moving or not
     */
    public boolean isMoving() {
        return getCurrentSpeed() != 0;
    }

    /**
     * Gets the model name of vehicle
     * @return Returns model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Returns number of doors on car
     * @return number of doors on car
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns engine power of car
     * @return Engine power of car
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Sets current speed of car to a valid value in the interval [0, enginePower]
     * @param speed Sets current speed of car
     */
    @Override
    public void setCurrentSpeed(double speed) {
        speed = Math.min(speed, enginePower);
        currentSpeed = Math.max(speed, 0);
    }

    /**
     * Gets color of car
     * @return Color of car
     */
    public Color getColor(){
        return color;
    }

    /**
     * Sets color of car to valid color
     * @param clr Sets the color of car
     */
    public void setColor(Color clr){
        color = clr;
    }

    public double getWidth() {
        return widthMeter;
    }

    public void setWidth(double width) {
        this.widthMeter = width;
    }

    public double getHeight() {
        return heightMeter;
    }

    public void setHeight(double height) {
        this.heightMeter = height;
    }

    public double getLength() {
        return lengthMeter;
    }

    public void setLength(double length) {
        this.lengthMeter = length;
    }
}