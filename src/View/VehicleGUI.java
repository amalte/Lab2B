package View;

import Model.MotorizedVehicle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VehicleGUI {

    private final MotorizedVehicle vehicle;
    private BufferedImage image;

    public VehicleGUI(MotorizedVehicle vehicle) {
        this.vehicle = vehicle;
        selectPicPath();
    }

    void selectPicPath() {
        try {
            if(vehicle.getModelName() == "Volvo240") {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            } else if(vehicle.getModelName() == "Saab95") {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            } else if(vehicle.getModelName() == "Scania") {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            }
            // Add more statements when new pictures are added....maybe make this process automatic?
            else {
                image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Default.jpg"));
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
