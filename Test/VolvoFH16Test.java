import Model.Car;
import Model.Saab95;
import Model.Volvo240;
import Model.VolvoFH16;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VolvoFH16Test {
    VolvoFH16 truckTransporter = new VolvoFH16();

    Car volvo1 = new Volvo240();


    Car saab1 = new Saab95();
    Car saab2 = new Saab95();
    Car saab3 = new Saab95();
    Car saab4 = new Saab95();
    Car saab5 = new Saab95();

    public void resetTruck() {
        for (Car c : truckTransporter.getLoadedTransport()) {
            c.setLoaded(false);
        }

        truckTransporter.closeRamp();
        truckTransporter.setCurrentSpeed(0);
        truckTransporter.getLoadedTransport().clear();
    }

    @Test
    public void openRamp(){
        resetTruck();
        truckTransporter.setCurrentSpeed(50);
        truckTransporter.openRamp();
        assertEquals(false, truckTransporter.isRampOpen());

        resetTruck();
        truckTransporter.openRamp();
        assertEquals(true, truckTransporter.isRampOpen());
    }

    @Test
    public void loadTransport() {
        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(volvo1);
        assertEquals(1, truckTransporter.getLoadedTransport().size());

        resetTruck();
        truckTransporter.closeRamp();
        assertEquals(0, truckTransporter.getLoadedTransport().size());

        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab1);
        truckTransporter.loadTransport(saab2);
        truckTransporter.loadTransport(saab3);
        truckTransporter.loadTransport(saab4);
        truckTransporter.loadTransport(saab5);
        assertEquals(5, truckTransporter.getLoadedTransport().size());
    }

    @Test
    public void dropTransport() {
        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab1);
        assertEquals(1, truckTransporter.getLoadedTransport().size());

        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab2);
        truckTransporter.closeRamp();
        assertEquals(1, truckTransporter.getLoadedTransport().size());
    }

    @Test
    public void move() {
        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.loadTransport(saab3);
        truckTransporter.setX(50);
        truckTransporter.setY(50);
        truckTransporter.move();
        assertEquals(50, saab3.getX());
        assertEquals(50, saab3.getY());
    }

    @Test
    public void gas() {
        resetTruck();
        truckTransporter.startEngine();
        truckTransporter.gas(1);
        assertEquals(1.1, truckTransporter.getCurrentSpeed());

        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.gas(1);
        assertEquals(0, truckTransporter.getCurrentSpeed());
    }

    @Test
    public void setCurrentSpeed() {
        resetTruck();
        truckTransporter.setCurrentSpeed(50);
        assertEquals(50, truckTransporter.getCurrentSpeed());

        resetTruck();
        truckTransporter.openRamp();
        truckTransporter.setCurrentSpeed(50);
        assertEquals(0, truckTransporter.getCurrentSpeed());
    }

    @Test
    public void notFull() {
        resetTruck();
        assertEquals(0, truckTransporter.getLoadedTransport().size());
    }
}
