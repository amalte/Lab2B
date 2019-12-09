import Model.Scania;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScaniaTest {
    Scania scania = new Scania();

    @Test
    public void testLowerFlatbed() {
        scania.setFlatbedAngle(70);
        scania.lowerFlatbed();
        assertEquals(69, scania.getFlatbedAngle());

        scania.setFlatbedAngle(0);
        scania.lowerFlatbed();
        assertEquals(0, scania.getFlatbedAngle());
    }

    @Test
    public void testRaiseFlatbed() {
        scania.setFlatbedAngle(0);
        scania.raiseFlatbed();
        assertEquals(1, scania.getFlatbedAngle());

        scania.setFlatbedAngle(70);
        scania.raiseFlatbed();
        assertEquals(70, scania.getFlatbedAngle());

    }

    @Test
    public void testSetFlatbedDegree() {
        scania.setFlatbedAngle(0);
        assertEquals(0, scania.getFlatbedAngle());

        scania.setFlatbedAngle(50);
        assertEquals(50, scania.getFlatbedAngle());

        scania.setFlatbedAngle(-3);
        assertEquals(0, scania.getFlatbedAngle());

        scania.setFlatbedAngle(85);
        assertEquals(70, scania.getFlatbedAngle());
    }

    @Test
    public void testGas() {
        scania.setFlatbedAngle(5);
        scania.gas(1);
        assertEquals(0, scania.getCurrentSpeed(), 0.0001);

        scania.setFlatbedAngle(0);
        scania.startEngine();
        scania.gas(1);
        assertEquals(1.1, scania.getCurrentSpeed(), 0.0001);

    }

    @Test
    public void testSetCurrentSpeed() {
        scania.setCurrentSpeed(0);
        scania.setFlatbedAngle(10);
        scania.setCurrentSpeed(100);
        assertEquals(0, scania.getCurrentSpeed(), 0.0001);

        scania.setFlatbedAngle(0);
        scania.setCurrentSpeed(50);
        scania.setFlatbedAngle(5);
        assertEquals(50, scania.getCurrentSpeed(), 0.0001);
        assertEquals(0, scania.getFlatbedAngle());
    }
}