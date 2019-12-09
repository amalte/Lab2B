package Model;

/**
 * @author SM
 * Represents a Model.Ramp object
 */
public class Ramp {

    private boolean rampOpen = false; // The ramps state (open [true] or closed [false])

    public void openRamp() {
        rampOpen = true;
    }

    public void closeRamp() {
        rampOpen = false;
    }

    public boolean isRampOpen() {
        return rampOpen;
    }
}
