package Model;

import Model.Interfaces.ITransportable;
import Model.Interfaces.ITransportableHolder;

import java.awt.*;
import java.util.Deque;

/**
 * @author SM
 * Subclass of Model.Truck. Represents a truck of model Model.VolvoFH16 that has a ramp and can hold Transportables (implements IRamp and ITransportableHolder)
 */
public class VolvoFH16 extends Truck implements ITransportableHolder<Car> {

    /**
     * This truck has a ramp and can hold Transportables (implements Model.Interfaces.IRamp and ITransportableHolder)
     */
    private TransportableHolder transportableHolder;
    private Ramp ramp;

    /**
     * Constructor for Model.VolvoFH16 class
     */
    public VolvoFH16() {
        super(2, 350, Color.white, "Model.VolvoFH16", 2.5, 3, 9);
        transportableHolder = new TransportableHolder<Car>(5, 3, 2, 1.8, 5, getX(), getY());
        ramp = new Ramp();
    }

    public void openRamp() {
        if(!isMoving()) {
            ramp.openRamp();
        }
    }

    public void closeRamp() {
        ramp.closeRamp();
    }

    @Override
    public void move() {
        super.move();
        transportableHolder.updatePosition(getX(), getY());
    }

    @Override
    public void gas(double amount) {
        if(!isRampOpen()) {
            super.gas(amount);
        }
    }

    @Override
    public void loadTransport(Car transport) {
        if(!isMoving() && isRampOpen() && transportableHolder.isTransportLoadable(transport)) {
            transportableHolder.loadTransport(transport);
        }
    }

    @Override
    public ITransportable dropTransport() {
        if(!isMoving() && isRampOpen()) {
            return transportableHolder.dropTransport();
        }
        return null;
    }

    public boolean isRampOpen() {
        return ramp.isRampOpen();
    }

    public int getMaxLoad() {
        return transportableHolder.getMaxLoad();
    }

    @Override
    public void setCurrentSpeed(double speed) {
        if(!isRampOpen()) {
            super.setCurrentSpeed(speed);
        }
    }

    @Override
    public Deque<Car> getLoadedTransport() {
        return transportableHolder.getLoadedTransport();
    }
}
