package Model.Interfaces;
import java.util.Deque;

/**
 * @author SM
 * Interface for objects that have a Model.TransportableHolder
 */
public interface ITransportableHolder<T extends ITransportable> extends IPositionable {
    /**
     * Loads given object onto the Model.TransportableHolder
     * @param transport The object to be loaded
     * @return Returns true if load was successful
     */
    void loadTransport(T transport);

    /**
     * Drops a transport
     * @return Returns the dropped transport
     */
    ITransportable dropTransport();

    /**
     * Stack for all loaded transports
     * @return Returns loaded transports
     */
    Deque<T> getLoadedTransport();
}