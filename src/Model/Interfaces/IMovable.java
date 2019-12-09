package Model.Interfaces;

/**
 * @author SM
 * Interface for objects that is movable
 */
public interface IMovable extends IPositionable {
    /**
     * Possible directions for object
     */
    enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    /**
     * Makes object move in current direction
     */
    void move();

    /**
     * Makes object turn left depending on current direction
     */
    void turnLeft();

    /**
     * Makes object turn right depending on current direction
     */
    void turnRight();
}