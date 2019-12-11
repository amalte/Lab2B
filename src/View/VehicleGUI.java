package View;

import Model.MotorizedVehicle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class VehicleGUI {

    private static ArrayList<String> picPaths = new ArrayList<>();
    private final MotorizedVehicle vehicle;
    private BufferedImage image;

    public VehicleGUI(MotorizedVehicle vehicle) {
        this.vehicle = vehicle;
        picPaths.add(vehicle.getModelName());
        selectPicPath();
    }

    void selectPicPath() {
        try {
            for (String s: picPaths) {
                if (vehicle.getModelName() == s) {
                    image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + s + ".jpg"));
                } else {
                    image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Default.jpg"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public MotorizedVehicle getVehicle() {
        return vehicle;
    }

    public BufferedImage getImage() {
        return image;
    }
}
