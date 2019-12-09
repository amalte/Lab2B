package Model;

import Model.Interfaces.ITransportable;
import Model.Interfaces.ITransportableHolder;

import java.util.Deque;

/**
 * @author SM
 * Class for workshops that only take in Model.Car objects
 */
public class CarWorkshop<T extends Car> implements ITransportableHolder<T> {

    TransportableHolder transportableHolder;
    private double x;
    private double y;

    /**
     * Constructor for Model.CarWorkshop
     * @param maxLoad Max amount of Model.Car objects to be loaded
     * @param maxTransportWidthMeter Max width of Model.Car objects to be loaded
     * @param maxTransportHeightMeter Max height of Model.Car objects to be loaded
     * @param maxTransportLengthMeter Max length of Model.Car objects to be loaded
     * @param x X position for the workshop
     * @param y Y position for the workshop
     */
    public CarWorkshop(int maxLoad, int loadAndDropDistanceMeter, double maxTransportWidthMeter, double maxTransportHeightMeter, double maxTransportLengthMeter, double x, double y) {
        this.x = x;
        this.y = y;
        transportableHolder = new TransportableHolder<T>(maxLoad, loadAndDropDistanceMeter, maxTransportWidthMeter, maxTransportHeightMeter, maxTransportLengthMeter, x, y);
    }

    @Override
    public void loadTransport(T transport) {
        if(transportableHolder.isTransportLoadable(transport))
            transportableHolder.loadTransport(transport);
    }

    @Override
    public ITransportable dropTransport() {
        return transportableHolder.dropTransport();
    }

    @Override
    public Deque<T> getLoadedTransport() {
        return transportableHolder.getLoadedTransport();
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
