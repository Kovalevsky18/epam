import entity.ExperimentalPlaneClassification;
import entity.ExperimentalPlaneType;
import entity.MilitaryPlaneType;
import model.airport.Airport;
import model.plane.ExperimentalPlane;
import model.plane.MilitaryPlane;
import model.plane.PassengerPlane;
import model.plane.Plane;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AirportTest {
    private static final Logger logger = LogManager.getLogger(AirportTest.class);
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, ExperimentalPlaneClassification.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, ExperimentalPlaneClassification.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
    private Airport airport;

    @BeforeMethod
    public void initializeParameter(){
        airport = new Airport(planes);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        assertTrue(airport.getTransportMilitaryPlanes()
                .stream()
                .allMatch(militaryPlane -> MilitaryPlaneType.TRANSPORT.equals(militaryPlane.getMilitaryPlaneType())));
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals( planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

   @Test
    public void testSortByMaxLoadCapacity() {
       airport.sortByMaxLoadCapacity();
       List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
       boolean isSorted = true;

       for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
           if (planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() > planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity()) {
               isSorted = false;
               break;
           }
       }
       Assert.assertTrue(isSorted);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
          assertTrue(airport.getBomberMilitaryPlanes()
                .stream()
                .allMatch(militaryPlane -> MilitaryPlaneType.BOMBER.equals(militaryPlane.getMilitaryPlaneType())));
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        assertFalse(airport.getExperimentalPlanes()
                .stream()
                .allMatch(experimentalPlane -> ExperimentalPlaneClassification.UNCLASSIFIED
                        .equals(experimentalPlane.getExperimentalPlaneClassification())));
    }
}
