import Model.Car;
import Model.CarWorkshop;
import Model.Saab95;
import Model.Volvo240;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarWorkshopTest {
    CarWorkshop<Car> carWorkshop = new CarWorkshop<>(5, 3, 3, 3.5, 5, 0, 0);
    CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>(5, 3, 3, 3.5,5,0, 0);
    CarWorkshop<Saab95> saabWorkshop = new CarWorkshop<>(5, 3, 3, 3.5,5,0, 0);

    Volvo240 volvo1 = new Volvo240();
    Volvo240 volvo2 = new Volvo240();
    Volvo240 volvo3 = new Volvo240();
    Volvo240 volvo4 = new Volvo240();
    Volvo240 volvo5 = new Volvo240();

    Saab95 saab1 = new Saab95();
    Saab95 saab2 = new Saab95();
    Saab95 saab3 = new Saab95();
    Saab95 saab4 = new Saab95();
    Saab95 saab5 = new Saab95();

    @Test
    public void loadTransport() {
        carWorkshop.loadTransport(saab1);
        carWorkshop.loadTransport(volvo1);
        assertEquals(2, carWorkshop.getLoadedTransport().size());

        volvoWorkshop.loadTransport(volvo2);
        assertEquals(1, volvoWorkshop.getLoadedTransport().size());
        saabWorkshop.loadTransport(saab2);
        assertEquals(1, saabWorkshop.getLoadedTransport().size());

        carWorkshop.loadTransport(saab3);
        carWorkshop.loadTransport(saab4);
        carWorkshop.loadTransport(saab5);
        assertEquals(5, carWorkshop.getLoadedTransport().size());

        carWorkshop.loadTransport(saab2);
        assertEquals(5, carWorkshop.getLoadedTransport().size());
        carWorkshop.loadTransport(saab3);
        carWorkshop.loadTransport(saab4);
        assertEquals(5, carWorkshop.getLoadedTransport().size());

        // ---These should give compile errors when uncommented--- //
        //volvoWorkshop.loadTransport(saab1);
        //saabWorkshop.loadTransport(volvo1);

    }

    @Test
    public void dropTransport() {
        carWorkshop.getLoadedTransport().clear();
        volvoWorkshop.getLoadedTransport().clear();
        saabWorkshop.getLoadedTransport().clear();

        carWorkshop.loadTransport(saab1);
        carWorkshop.dropTransport();
        assertEquals(0, carWorkshop.getLoadedTransport().size());

        volvoWorkshop.loadTransport(volvo1);
        volvoWorkshop.dropTransport();
        assertEquals(0, volvoWorkshop.getLoadedTransport().size());

        saabWorkshop.loadTransport(saab2);
        saabWorkshop.loadTransport(saab3);
        saabWorkshop.dropTransport();
        saabWorkshop.dropTransport();
        assertEquals(0, saabWorkshop.getLoadedTransport().size());
    }
}
