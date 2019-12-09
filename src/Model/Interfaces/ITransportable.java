package Model.Interfaces;

public interface ITransportable extends IPositionable, ISizeable {
    /**
     * Is transport currently loaded?
     * @return Returns if transport is loaded
     */
    boolean isLoaded();

    /**
     * Sets object to be loaded (true) or not (false)
     */
    void setLoaded(boolean loaded);
}
