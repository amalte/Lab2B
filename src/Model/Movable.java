package Model;

import Model.Interfaces.IMovable;

/**
 * @author SM
 * Represents a Model.Movable object
 */
public abstract class Movable implements IMovable {

    protected double currentSpeed; // The current speed of the object
    protected Direction currentDirection = Direction.EAST; // Direction the object is facing
    protected double x; // X position of object
    protected double y; // Y position of object

    /**
     * Moves the object depending on the direction it's facing. Inherits from Model.Interfaces.IMovable interface
     */
    @Override
    public void move() {
        switch (currentDirection){
            case NORTH:
                y -= currentSpeed;
                break;
            case EAST:
                x += currentSpeed;
                break;
            case SOUTH:
                y += currentSpeed;
                break;
            case WEST:
                x -= currentSpeed;
                break;
        }
    }

    /**
     * Turns the object to the left depending on it's current direction. Inherits from Model.Movable interface
     */
    @Override
    public void turnLeft() {
        switch (currentDirection) {
            case NORTH:
                currentDirection = Direction.WEST;
                break;
            case EAST:
                currentDirection = Direction.NORTH;
                break;
            case SOUTH:
                currentDirection = Direction.EAST;
                break;
            case WEST:
                currentDirection = Direction.SOUTH;
                break;
        }
    }

    /**
     * Turns the object to the right depending on it's current direction. Inherits from Model.Movable interface
     */
    @Override
    public void turnRight() {
        switch (getCurrentDirection()) {
            case NORTH:
                currentDirection = Direction.EAST;
                break;
            case EAST:
                currentDirection = Direction.SOUTH;
                break;
            case SOUTH:
                currentDirection = Direction.WEST;
                break;
            case WEST:
                currentDirection = Direction.NORTH;
                break;
        }
    }

    private void invertDirection(Direction direction) {
        switch (direction) {

        }
    }

    /**
     * Returns current direction of object
     * @return Current direction (the direction the object is currently facing)
     */
    public Direction getCurrentDirection() { return currentDirection; }

    /**
     * Sets current direction of object to a valid direction
     * @param currentDirection Current direction of object to set
     */
    public void setCurrentDirection(Direction currentDirection) { this.currentDirection = currentDirection; }

    /**
     * Gets current speed of object
     * @return Current speed of object
     */
    public double getCurrentSpeed() { return currentSpeed; }

    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }
}
