package RealTimeTrainsWebScraping.Route;

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
public class RouteTest {
    
    public RouteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of processRoute method, of class Route.
     */
    @Test
    public void testProcessRoute() throws Exception {
        System.out.println("processRoute");
        Route instance = null;
        instance.processRoute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of refresh method, of class Route.
     */
    @Test
    public void testRefresh() {
        System.out.println("refresh");
        Route instance = null;
        instance.refresh();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStops method, of class Route.
     */
    @Test
    public void testGetStops() {
        System.out.println("getStops");
        Route instance = null;
        ArrayList<Stop> expResult = null;
        ArrayList<Stop> result = instance.getStops();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStops method, of class Route.
     */
    @Test
    public void testSetStops() {
        System.out.println("setStops");
        ArrayList<Stop> stops = null;
        Route instance = null;
        instance.setStops(stops);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScheduleInformation method, of class Route.
     */
    @Test
    public void testGetScheduleInformation() {
        System.out.println("getScheduleInformation");
        Route instance = null;
        String expResult = "";
        String result = instance.getScheduleInformation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScheduleInformation method, of class Route.
     */
    @Test
    public void testSetScheduleInformation() {
        System.out.println("setScheduleInformation");
        String scheduleInformation = "";
        Route instance = null;
        instance.setScheduleInformation(scheduleInformation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperationalInformation method, of class Route.
     */
    @Test
    public void testGetOperationalInformation() {
        System.out.println("getOperationalInformation");
        Route instance = null;
        String expResult = "";
        String result = instance.getOperationalInformation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOperationalInformation method, of class Route.
     */
    @Test
    public void testSetOperationalInformation() {
        System.out.println("setOperationalInformation");
        String operationalInformation = "";
        Route instance = null;
        instance.setOperationalInformation(operationalInformation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRealtimestatus method, of class Route.
     */
    @Test
    public void testGetRealtimestatus() {
        System.out.println("getRealtimestatus");
        Route instance = null;
        String expResult = "";
        String result = instance.getRealtimestatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRealtimestatus method, of class Route.
     */
    @Test
    public void testSetRealtimestatus() {
        System.out.println("setRealtimestatus");
        String realtimestatus = "";
        Route instance = null;
        instance.setRealtimestatus(realtimestatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getURL method, of class Route.
     */
    @Test
    public void testGetURL() {
        System.out.println("getURL");
        Route instance = null;
        String expResult = "";
        String result = instance.getURL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setURL method, of class Route.
     */
    @Test
    public void testSetURL() {
        System.out.println("setURL");
        String URL = "";
        Route instance = null;
        instance.setURL(URL);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Route.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Route instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStopsAsArrays method, of class Route.
     */
    @Test
    public void testGetStopsAsArrays() {
        System.out.println("getStopsAsArrays");
        Route instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getStopsAsArrays();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
