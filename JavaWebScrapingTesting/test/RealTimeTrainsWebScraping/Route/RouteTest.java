package RealTimeTrainsWebScraping.Route;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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

    String routeString = "<table class=\"table table-condensed train  realtime  advanced\"> \n"
            + " <thead> \n"
            + "  <tr> \n"
            + "   <th class=\"mileage borderright\" colspan=\"2\">Mileage</th> \n"
            + "   <th></th> \n"
            + "   <th class=\"metadata platform\"></th> \n"
            + "   <th class=\"wtt time borderleft\" colspan=\"2\"><abbr title=\"Working Timetable\">WTT</abbr></th> \n"
            + "   <th class=\"gbtt time borderleft\" colspan=\"2\"><abbr title=\"Public Timetable (Great Britain Timetable)\">GBTT</abbr></th> \n"
            + "   <th class=\"realtime time borderleft\" colspan=\"3\">Realtime</th> \n"
            + "   <th class=\"metadata line path borderleft\" colspan=\"2\">Route</th> \n"
            + "   <th class=\"metadata allowances borderleft\" colspan=\"3\">Allowances</th> \n"
            + "  </tr> \n"
            + "  <tr> \n"
            + "   <th class=\"mileage miles span2\">M</th> \n"
            + "   <th class=\"mileage chains span2 borderright\">Ch</th> \n"
            + "   <th>Location</th> \n"
            + "   <th class=\"metadata platform span2\">Pl</th> \n"
            + "   <th class=\"wtt time span3 borderleft\">Arr</th> \n"
            + "   <th class=\"wtt time span3\">Dep</th> \n"
            + "   <th class=\"gbtt time span3 borderleft\">Arr</th> \n"
            + "   <th class=\"gbtt time span3\">Dep</th> \n"
            + "   <th class=\"realtime time span3 borderleft\">Arr</th> \n"
            + "   <th class=\"realtime time span3\">Dep</th> \n"
            + "   <th class=\"realtime delay span2\">Dly</th> \n"
            + "   <th class=\"metadata line span2 borderleft\">Line</th> \n"
            + "   <th class=\"metadata path span2\">Path</th> \n"
            + "   <th class=\"metadata allowances engineering span2 borderleft\"><abbr title=\"Engineering allowance\">Eng</abbr></th> \n"
            + "   <th class=\"metadata allowances pathing span2\"><abbr title=\"Pathing allowance\">Pth</abbr></th> \n"
            + "   <th class=\"metadata allowances performance span2\"><abbr title=\"Performance allowance\">Prf</abbr></th> \n"
            + "  </tr> \n"
            + " </thead> \n"
            + " <tbody> \n"
            + "  <tr class=\"call_public call origin\">\n"
            + "   <td class=\"mileage miles\">0</td>\n"
            + "   <td class=\"mileage chains borderright\">0</td>\n"
            + "   <td class=\"location\"><span class=\"location\"><a href=\"/search/advanced/KIR/2016/08/02/1900\">Kirkby [KIR]</a></span> </td>\n"
            + "   <td class=\"metadata platform\"></td>\n"
            + "   <td class=\"wtt time  borderleft\"></td>\n"
            + "   <td class=\"wtt time \">1900</td>\n"
            + "   <td class=\"gbtt time  borderleft\"></td>\n"
            + "   <td class=\"gbtt time \">1900</td>\n"
            + "   <td class=\"realtime borderleft\"></td>\n"
            + "   <td class=\"realtime time prediction\"><span title=\"Schedule (Timetable)\">1900</span></td>\n"
            + "   <td></td>\n"
            + "   <td class=\"metadata line borderleft\"></td>\n"
            + "   <td class=\"metadata path\"></td>\n"
            + "   <td class=\"metadata allowances engineering borderleft\"></td>\n"
            + "   <td class=\"metadata allowances pathing\"></td>\n"
            + "   <td class=\"metadata allowances performance\"></td>\n"
            + "  </tr>\n"
            + "  <tr class=\"call_public call intermediate\">\n"
            + "   <td class=\"mileage miles\">5</td>\n"
            + "   <td class=\"mileage chains borderright\">10</td>\n"
            + "   <td class=\"location\"><span class=\"location\"><a href=\"/search/advanced/RNF/2016/08/02/1908\">Rainford [RNF]</a></span> </td>\n"
            + "   <td class=\"metadata platform\"></td>\n"
            + "   <td class=\"wtt time  borderleft\">1907½</td>\n"
            + "   <td class=\"wtt time \">1908</td>\n"
            + "   <td class=\"gbtt time  borderleft\">1908</td>\n"
            + "   <td class=\"gbtt time \">1908</td>\n"
            + "   <td class=\"realtime time prediction borderleft\"><span title=\"Schedule (Timetable)\">1907</span></td>\n"
            + "   <td class=\"realtime time prediction\"><span title=\"Schedule (Timetable)\">1908</span></td>\n"
            + "   <td></td>\n"
            + "   <td class=\"metadata line borderleft\"></td>\n"
            + "   <td class=\"metadata path\"></td>\n"
            + "   <td class=\"metadata allowances engineering borderleft\"></td>\n"
            + "   <td class=\"metadata allowances pathing\"></td>\n"
            + "   <td class=\"metadata allowances performance\"></td>\n"
            + "  </tr>\n"
            + "  <tr class=\"call_public call intermediate\">\n"
            + "   <td class=\"mileage miles\">7</td>\n"
            + "   <td class=\"mileage chains borderright\">16</td>\n"
            + "   <td class=\"location\"><span class=\"location\"><a href=\"/search/advanced/UPL/2016/08/02/1912\">Upholland [UPL]</a></span> </td>\n"
            + "   <td class=\"metadata platform\"></td>\n"
            + "   <td class=\"wtt time  borderleft\">1911½</td>\n"
            + "   <td class=\"wtt time \">1912</td>\n"
            + "   <td class=\"gbtt time  borderleft\">1912</td>\n"
            + "   <td class=\"gbtt time \">1912</td>\n"
            + "   <td class=\"realtime time prediction borderleft\"><span title=\"Schedule (Timetable)\">1911</span></td>\n"
            + "   <td class=\"realtime time prediction\"><span title=\"Schedule (Timetable)\">1912</span></td>\n"
            + "   <td></td>\n"
            + "   <td class=\"metadata line borderleft\"></td>\n"
            + "   <td class=\"metadata path\"></td>\n"
            + "   <td class=\"metadata allowances engineering borderleft\"></td>\n"
            + "   <td class=\"metadata allowances pathing\"></td>\n"
            + "   <td class=\"metadata allowances performance\"></td>\n"
            + "  </tr>\n"
            + "  <tr class=\"call_public call intermediate\">\n"
            + "   <td class=\"mileage miles\">8</td>\n"
            + "   <td class=\"mileage chains borderright\">43</td>\n"
            + "   <td class=\"location\"><span class=\"location\"><a href=\"/search/advanced/ORR/2016/08/02/1915\">Orrell [ORR]</a></span> </td>\n"
            + "   <td class=\"metadata platform\"></td>\n"
            + "   <td class=\"wtt time  borderleft\">1915</td>\n"
            + "   <td class=\"wtt time \">1915½</td>\n"
            + "   <td class=\"gbtt time  borderleft\">1915</td>\n"
            + "   <td class=\"gbtt time \">1915</td>\n"
            + "   <td class=\"realtime time prediction borderleft\"><span title=\"Schedule (Timetable)\">1915</span></td>\n"
            + "   <td class=\"realtime time prediction\"><span title=\"Schedule (Timetable)\">1915</span></td>\n"
            + "   <td></td>\n"
            + "   <td class=\"metadata line borderleft\"></td>\n"
            + "   <td class=\"metadata path\"></td>\n"
            + "   <td class=\"metadata allowances engineering borderleft\"></td>\n"
            + "   <td class=\"metadata allowances pathing\"></td>\n"
            + "   <td class=\"metadata allowances performance\"></td>\n"
            + "  </tr>\n"
            + "  <tr class=\"call_public call intermediate\">\n"
            + "   <td class=\"mileage miles\">10</td>\n"
            + "   <td class=\"mileage chains borderright\">17</td>\n"
            + "   <td class=\"location\"><span class=\"location\"><a href=\"/search/advanced/PEM/2016/08/02/1918\">Pemberton [PEM]</a></span> </td>\n"
            + "   <td class=\"metadata platform\"></td>\n"
            + "   <td class=\"wtt time  borderleft\">1918</td>\n"
            + "   <td class=\"wtt time \">1918½</td>\n"
            + "   <td class=\"gbtt time  borderleft\">1918</td>\n"
            + "   <td class=\"gbtt time \">1918</td>\n"
            + "   <td class=\"realtime time prediction borderleft\"><span title=\"Schedule (Timetable)\">1918</span></td>\n"
            + "   <td class=\"realtime time prediction\"><span title=\"Schedule (Timetable)\">1918</span></td>\n"
            + "   <td></td>\n"
            + "   <td class=\"metadata line borderleft\"></td>\n"
            + "   <td class=\"metadata path\"></td>\n"
            + "   <td class=\"metadata allowances engineering borderleft\">1</td>\n"
            + "   <td class=\"metadata allowances pathing\"></td>\n"
            + "   <td class=\"metadata allowances performance\"></td>\n"
            + "  </tr>\n"
            + "  <tr class=\"call_public call destination\">\n"
            + "   <td class=\"mileage miles\">12</td>\n"
            + "   <td class=\"mileage chains borderright\">7</td>\n"
            + "   <td class=\"location\"><span class=\"location\"><a href=\"/search/advanced/WGW/2016/08/02/1924\">Wigan Wallgate [WGW]</a></span> </td>\n"
            + "   <td class=\"metadata platform expected\">3</td>\n"
            + "   <td class=\"wtt time  borderleft\">1924</td>\n"
            + "   <td class=\"wtt time \"></td>\n"
            + "   <td class=\"gbtt time  borderleft\">1924</td>\n"
            + "   <td class=\"gbtt time \"></td>\n"
            + "   <td class=\"realtime time prediction borderleft\"><span title=\"Schedule (Timetable)\">1923</span></td>\n"
            + "   <td class=\"realtime\"></td>\n"
            + "   <td></td>\n"
            + "   <td class=\"metadata line borderleft\"></td>\n"
            + "   <td class=\"metadata path\"></td>\n"
            + "   <td class=\"metadata allowances engineering borderleft\"></td>\n"
            + "   <td class=\"metadata allowances pathing\"></td>\n"
            + "   <td class=\"metadata allowances performance\"></td>\n"
            + "  </tr> \n"
            + " </tbody> \n"
            + "</table>";

    private final ArrayList<Stop> actualStops = new ArrayList<>();
    
    private Route route;

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
        route = new Route("", "", "", "", routeString);
        
        actualStops.add(new Stop("Kirkby [KIR]",          "", "", "1900", "", "1900", "", "", "", "", "", ""));
        actualStops.add(new Stop("Rainford [RNF]",        "", "1907½", "1908", "1907", "1908", "", "", "", "", "", ""));
        actualStops.add(new Stop("Upholland [UPL]",       "", "1911½", "1912", "1911", "1912", "", "", "", "", "", ""));
        actualStops.add(new Stop("Orrell [ORR]",          "", "1915", "1915½", "1915", "1915", "", "", "", "", "", ""));
        actualStops.add(new Stop("Pemberton [PEM]",       "", "1918", "1918½", "1918", "1918", "", "", "", "1", "", ""));
        actualStops.add(new Stop("Wigan Wallgate [WGW]",  "3", "1924", "", "1923", "", "", "", "", "", "", ""));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of processRoute method, of class Route.
     */
    @Test
    public void testProcessRoute() throws Exception {
    }

    /**
     * Test of refresh method, of class Route.
     */
    @Test
    public void testRefresh() {
    }

    /**
     * Test of getStops method, of class Route.
     */
    @Test
    public void testGetStops() {
        System.out.println("getStops");
        Route instance = route;
        int expResult = 6;
        int result = instance.getStops().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScheduleInformation method, of class Route.
     */
    @Test
    public void testGetScheduleInformation() {
        System.out.println("getScheduleInformation");
        Route instance = route;
        String expResult = "";
        String result = instance.getScheduleInformation();
        assertEquals(expResult, result);

    }

    /**
     * Test of setScheduleInformation method, of class Route.
     */
    @Test
    public void testSetScheduleInformation() {
        System.out.println("setScheduleInformation");
        String scheduleInformation = "";
        Route instance = route;
        instance.setScheduleInformation(scheduleInformation);
    }

    /**
     * Test of getOperationalInformation method, of class Route.
     */
    @Test
    public void testGetOperationalInformation() {
        System.out.println("getOperationalInformation");
        Route instance = route;
        String expResult = "";
        String result = instance.getOperationalInformation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOperationalInformation method, of class Route.
     */
    @Test
    public void testSetOperationalInformation() {
        System.out.println("setOperationalInformation");
        String operationalInformation = "";
        Route instance = route;
        instance.setOperationalInformation(operationalInformation);
    }

    /**
     * Test of getRealtimestatus method, of class Route.
     */
    @Test
    public void testGetRealtimestatus() {
        System.out.println("getRealtimestatus");
        Route instance = route;
        String expResult = "";
        String result = instance.getRealtimestatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRealtimestatus method, of class Route.
     */
    @Test
    public void testSetRealtimestatus() {
        System.out.println("setRealtimestatus");
        String realtimestatus = "";
        Route instance = route;
        instance.setRealtimestatus(realtimestatus);
    }

    /**
     * Test of getURL method, of class Route.
     */
    @Test
    public void testGetURL() {
        System.out.println("getURL");
        Route instance = route;
        String expResult = "";
        String result = instance.getURL();
        assertEquals(expResult, result);
    }

    /**
     * Test of setURL method, of class Route.
     */
    @Test
    public void testSetURL() {
        System.out.println("setURL");
        String URL = "";
        Route instance = route;
        instance.setURL(URL);
    }

    /**
     * Test of toString method, of class Route.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Route instance = route;
        String expResult = "";
        String result = instance.toString();
        //assertEquals(expResult, result);
    }

    /**
     * Test of getStopsAsArrays method, of class Route.
     */
    @Test
    public void testGetStopsAsArrays() {
        System.out.println("getStopsAsArrays");
        Route instance = route;
        ArrayList expResult = null;
        ArrayList result = instance.getStopsAsArrays();
        //assertEquals(expResult, result);
    }

    /**
     * Test of processRouteTable method, of class Route.
     */
    @Test
    public void testProcessRouteTable() {
        System.out.println("processRouteTable");
        Document doc = Jsoup.parse(routeString);
        Elements tables = doc.getAllElements();
        Route instance = route;
        instance.processRouteTable(tables);
        assertEquals(actualStops, route.getStops());
    }
}

