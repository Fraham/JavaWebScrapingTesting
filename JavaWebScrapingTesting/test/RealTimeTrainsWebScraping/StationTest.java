package RealTimeTrainsWebScraping;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Graham
 */
public class StationTest {

    public StationTest() {
    }

    Station rnf = new Station("Rainford", "RNF");
    Station wgw = new Station("Wigan Wallgate", "WGW");

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Station.getStations().add(rnf);
        Station.getStations().add(wgw);
        Station.getStations().add(new Station("Wigan North Western", "WGN"));
        Station.getStations().add(new Station("Lancaster", "LAN"));
        Station.getStations().add(new Station("Birchwood", "BWD"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findStationFromName method, of class Station.
     */
    @Test
    public void testFindStationFromName() throws Exception {
        System.out.println("Find Station From Name");

        String name = "Rainford";
        Station expResult = rnf;
        Station result = Station.findStationFromName(name);
        assertEquals(expResult, result);

        name = "rainford";
        expResult = rnf;
        result = Station.findStationFromName(name);
        assertEquals(expResult, result);

        name = "Wigan Wallgate";
        expResult = wgw;
        result = Station.findStationFromName(name);
        assertEquals(expResult, result);

        name = "wigan Wallgate";
        expResult = wgw;
        result = Station.findStationFromName(name);
        assertEquals(expResult, result);

        name = "Wigan wallgate";
        expResult = wgw;
        result = Station.findStationFromName(name);
        assertEquals(expResult, result);

        name = "wigan wallgate";
        expResult = wgw;
        result = Station.findStationFromName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of findStationFromID method, of class Station.
     */
    @Test
    public void testFindStationFromID() throws Exception {
        System.out.println("Find Station From ID");

        String id = "RNF";
        Station expResult = rnf;
        Station result = Station.findStationFromID(id);
        assertEquals(expResult, result);

        id = "rnf";
        expResult = rnf;
        result = Station.findStationFromID(id);
        assertEquals(expResult, result);

        id = "Rnf";
        expResult = rnf;
        result = Station.findStationFromID(id);
        assertEquals(expResult, result);

        id = "rNf";
        expResult = rnf;
        result = Station.findStationFromID(id);
        assertEquals(expResult, result);

        id = "rnF";
        expResult = rnf;
        result = Station.findStationFromID(id);
        assertEquals(expResult, result);

        id = "RnF";
        expResult = rnf;
        result = Station.findStationFromID(id);
        assertEquals(expResult, result);

        id = "WGW";
        expResult = wgw;
        result = Station.findStationFromID(id);
        assertEquals(expResult, result);

        id = "wgw";
        expResult = wgw;
        result = Station.findStationFromID(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Station.
     */
    @Test
    public void testGetName() {
        System.out.println("getName Of Station");

        Station instance = rnf;
        String expResult = "Rainford";
        String result = instance.getName();
        assertEquals(expResult, result);

        instance = wgw;
        expResult = "Wigan Wallgate";
        result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Station.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");

        String name = "other";
        Station instance = rnf;
        instance.setName(name);
        String result = instance.getName();
        assertEquals(name, result);
    }

    /**
     * Test of getCodeName method, of class Station.
     */
    @Test
    public void testGetCodeName() {
        System.out.println("getCodeName");
        Station instance = rnf;
        String expResult = "RNF";
        String result = instance.getCodeName();
        assertEquals(expResult, result);

        instance = wgw;
        expResult = "WGW";
        result = instance.getCodeName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCodeName method, of class Station.
     */
    @Test
    public void testSetCodeName() {
        System.out.println("setCodeName");

        String name = "other";
        Station instance = rnf;
        instance.setCodeName(name);
        String result = instance.getCodeName();
        assertEquals(name, result);
    }

    /**
     * Test of toString method, of class Station.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        Station instance = rnf;
        String expResult = "Station{name=Rainford, codeName=RNF}";
        String result = instance.toString();
        assertEquals(expResult, result);

        instance = wgw;
        expResult = "Station{name=Wigan Wallgate, codeName=WGW}";
        result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStations method, of class Station.
     */
    @Test
    public void testGetStations() {
        System.out.println("getStations");
        
        int result = Station.getStations().size();
        assertEquals(5, result);

    }
}
