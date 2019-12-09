package Model;

import Model.Interfaces.ITransportable;
import Model.Interfaces.ITransportableHolder;
import java.awt.*;
import java.util.Deque;

/**
 * @author SM
 * Represents a Model.CarFerry object (a ferry object that can hold car objects)
 */
public class CarFerry extends MotorizedVehicle implements ITransportableHolder<Car> {

    TransportableHolder transportableHolder;
    Ramp ramp;

    /**
     * Constructor for Model.CarFerry class
     *
     * @param nrDoors     Number of doors on a vehicle
     * @param enginePower Engine power of a vehicle
     * @param color       Color of a vehicle
     * @param modelName   Model name of a vehicle
     * @param width       Width in meters of vehicle
     * @param height      Height in meters of vehicle
     * @param length      Length in meters of vehicle
     */
    public CarFerry(int maxLoad, int loadAndDropDistanceMeter, double maxTransportWidthMeter, double maxTransportHeightMeter, double maxTransportLengthMeter, int nrDoors, double enginePower, Color color, String modelName, double width, double height, double length) {
        super(nrDoors, enginePower, color, modelName, width, height, length);
        transportableHolder = new TransportableHolder<Car>(maxLoad, loadAndDropDistanceMeter, maxTransportWidthMeter,maxTransportHeightMeter, maxTransportLengthMeter, getX(), getY());
        ramp = new Ramp();
    }

    public void openRamp() {
        ramp.openRamp();
    }

    public void closeRamp() {
        ramp.closeRamp();
    }

    public boolean isRampOpen() {
        return ramp.isRampOpen();
    }

    @Override
    public void loadTransport(Car transport) {
        if(isRampOpen() && transportableHolder.isTransportLoadable(transport)) {
            transportableHolder.loadTransport(transport);
        }
    }

    /**
     * Drops first loaded object
     * @return Returns first loaded object
     */
    @Override
    public ITransportable dropTransport() {
        if(isRampOpen() && transportableHolder.isTransportDroppable())
        {
            ITransportable t = getLoadedTransport().getLast(); // (.getLast() because it is reverse in a Deque)
            t.setX(x + transportableHolder.getLoadAndDropDistanceMeter());
            t.setY(y + transportableHolder.getLoadAndDropDistanceMeter());
            return t;
        }
        return null;
    }

    @Override
    public Deque<Car> getLoadedTransport() {
        return transportableHolder.getLoadedTransport();
    }
}
