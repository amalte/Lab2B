package View;

public class ViewFactory {

    // Private so class cannot be instanciable through constructor
    private ViewFactory() {}

    public static SpeedView createSpeedView() {
        return new SpeedView();
    }

    public static VehicleView createCarView() {
        return new VehicleView();
    }
}
