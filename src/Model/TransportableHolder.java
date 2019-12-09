package Model;

import Model.Interfaces.IPositionable;
import Model.Interfaces.ITransportable;
import Model.Interfaces.ITransportableHolder;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author SM
 * Represents a Model.TransportableHolder object (an object that can hold objects)
 */
public class TransportableHolder<T extends ITransportable> implements ITransportableHolder<T> {

    private final int maxLoad; // Max amount of object that can be loaded
    private final double maxTransportWidthMeter; // Max width in meters of object to be transported
    private final double maxTransportHeightMeter; // Max height in meters of object to be transported
    private final double maxTransportLengthMeter; // Max length in meters of object to be transported
    protected Deque<T> loadedTransport = new ArrayDeque<>(); // Stack of all loaded objects
    private final double loadAndDropDistanceMeter; // Distance in meters that an object can be loaded, and will drop from current position
    private double x; // X Position of the Model.TransportableHolder
    private double y; // Y Position of the Model.TransportableHolder

    /**
     * Constructor for Model.TransportableHolder class
     * @param maxLoad Max amount of object that can be loaded
     * @param maxTransportWidthMeter Max width in meters of object to be transported
     * @param maxTransportHeightMeter Max height in meters of object to be transported
     * @param maxTransportLengthMeter Max length in meters of object to be transported
     * @param loadAndDropDistanceMeter // Distance in meters that an object can be loaded, and will drop from current position
     * @param x // X Position of the Model.TransportableHolder
     * @param y // Y Position of the Model.TransportableHolder
     */
    public TransportableHolder(int maxLoad, double loadAndDropDistanceMeter, double maxTransportWidthMeter, double maxTransportHeightMeter, double maxTransportLengthMeter, double x, double y) {
        this.maxLoad = maxLoad;
        this.loadAndDropDistanceMeter = loadAndDropDistanceMeter;
        this.maxTransportWidthMeter = maxTransportWidthMeter;
        this.maxTransportHeightMeter = maxTransportHeightMeter;
        this.maxTransportLengthMeter = maxTransportLengthMeter;
        this.x = x;
        this.y = y;
    }

    /**
     * Updates position of the Model.TransportableHolder and all objects it currently holds
     * @param x X Position to set to
     * @param y Y Position to set to
     */
    public void updatePosition(double x, double y) {
        this.x = x;
        this.y = y;
        for(ITransportable t : loadedTransport) {
            t.setX(x);
            t.setY(y);
        }
    }

    /**
     * Checks if the object can be loaded
     * @param transport Object to be loaded
     * @return Returns true if object can be loaded and false if it cannot
     */
    protected boolean isTransportLoadable(T transport) {
        return loadedTransport.size() < maxLoad
                && transportCloseEnough(transport)
                && !transportTooBig(transport)
                && !transport.isLoaded();
    }

    /**
     * Checks if an object which is already loaded can be dropped
     * @return Returns true if object can be dropped
     */
    protected boolean isTransportDroppable() {
        return loadedTransport.size() != 0;
    }

    /**
     * Checks if object is close enough to be loaded
     * @param transport Object to load
     * @return Returns true if it is close enough to be loaded and false if it is not.
     */
    protected boolean transportCloseEnough(T transport) {
        return ((Math.abs(x - transport.getX())) < loadAndDropDistanceMeter) && ((Math.abs(y - transport.getY())) < loadAndDropDistanceMeter);
    }

    /**
     * Checks if object is too big to be loaded
     * @param transport Object to be loaded
     * @return Returns true if object is too big to be loaded and false if it can be loaded
     */
    protected boolean transportTooBig(T transport) {
        return (transport.getWidth() > maxTransportWidthMeter) || (transport.getHeight() > maxTransportHeightMeter) || (transport.getLength() > maxTransportLengthMeter);
    }

    @Override
    public void loadTransport(T transport) {
        loadedTransport.push(transport);
        transport.setX(x);
        transport.setY(y);
        transport.setLoaded(true);
    }

    /**
     * Drops most recently loaded object (last object to be loaded)
     * @return Returns most recently loaded object (last object to be loaded)
     */
    @Override
    public ITransportable dropTransport() {
        T transport = loadedTransport.pop();
        transport.setX(x + loadAndDropDistanceMeter);
        transport.setY(y + loadAndDropDistanceMeter);
        transport.setLoaded(false);
        return transport;
    }

    public double getMaxTransportWidthMeter() {
        return maxTransportWidthMeter;
    }

    public double getMaxTransportHeightMeter() {
        return maxTransportHeightMeter;
    }

    public double getMaxTransportLengthMeter() {
        return maxTransportLengthMeter;
    }

    public double getLoadAndDropDistanceMeter() {
        return loadAndDropDistanceMeter;
    }

    @Override
    public Deque<T> getLoadedTransport() {
        return loadedTransport;
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

    public int getMaxLoad() {
        return maxLoad;
    }
}