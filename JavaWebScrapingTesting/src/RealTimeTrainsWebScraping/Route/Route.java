package RealTimeTrainsWebScraping.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Graham
 */
public class Route {

    private ArrayList<Stop> stops = new ArrayList<>();

    private String scheduleInformation;
    private String operationalInformation;
    private String realtimestatus;

    private String URL;

    public Route(String scheduleInformation, String operationalInformation, String realtimestatus, String URL, ArrayList<Stop> stops) {
        this.scheduleInformation = scheduleInformation;
        this.operationalInformation = operationalInformation;
        this.realtimestatus = realtimestatus;
        this.URL = URL;
        this.stops = stops;
    }

    public Route(String scheduleInformation, String operationalInformation, String realtimestatus, String URL, String stopsString) {
        this.scheduleInformation = scheduleInformation;
        this.operationalInformation = operationalInformation;
        this.realtimestatus = realtimestatus;
        this.URL = URL;
        Document doc = Jsoup.parse(stopsString);
        processRouteTable(doc.getAllElements());
    }

    public Route(String URL) {
        setURL(URL);
    }

    public void processRoute() throws IOException {
        Document doc = Jsoup.connect(String.format(getURL())).get();

        //get the additional data
        Elements tables = doc.getElementsByClass("table");
        processRouteTable(tables);
    }

    public void processRouteTable(Elements tables) {
        stops = new ArrayList();
        Element table = tables.first();
        if (table != null) {
            Element tbody = table.getElementsByTag("tbody").first();

            Elements rawStops = tbody.getElementsByTag("tr");

            for (Element rawStop : rawStops) {
                stops.add(new Stop(rawStop));
            }
        }
    }

    public void refresh() {
        try {
            processRoute();
        } catch (IOException ex) {
            Logger.getLogger(Route.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the stops
     */
    public ArrayList<Stop> getStops() {
        return stops;
    }

    /**
     * @param stops the stops to set
     */
    public void setStops(ArrayList<Stop> stops) {
        this.stops = stops;
    }

    /**
     * @return the scheduleInformation
     */
    public String getScheduleInformation() {
        return scheduleInformation;
    }

    /**
     * @param scheduleInformation the scheduleInformation to set
     */
    public void setScheduleInformation(String scheduleInformation) {
        this.scheduleInformation = scheduleInformation;
    }

    /**
     * @return the operationalInformation
     */
    public String getOperationalInformation() {
        return operationalInformation;
    }

    /**
     * @param operationalInformation the operationalInformation to set
     */
    public void setOperationalInformation(String operationalInformation) {
        this.operationalInformation = operationalInformation;
    }

    /**
     * @return the realtimestatus
     */
    public String getRealtimestatus() {
        return realtimestatus;
    }

    /**
     * @param realtimestatus the realtimestatus to set
     */
    public void setRealtimestatus(String realtimestatus) {
        this.realtimestatus = realtimestatus;
    }

    /**
     * @return the URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @param URL the URL to set
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "Route{" + "stops=" + stops + ", scheduleInformation=" + scheduleInformation + ", operationalInformation=" + operationalInformation + ", realtimestatus=" + realtimestatus + ", URL=" + URL + '}';
    }

    public ArrayList<Object[]> getStopsAsArrays() {
        ArrayList<Object[]> list = new ArrayList<>();

        for (Stop stop : getStops()) {
            list.add(stop.toArray());
        }

        return list;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.stops);
        hash = 41 * hash + Objects.hashCode(this.scheduleInformation);
        hash = 41 * hash + Objects.hashCode(this.operationalInformation);
        hash = 41 * hash + Objects.hashCode(this.realtimestatus);
        hash = 41 * hash + Objects.hashCode(this.URL);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Route other = (Route) obj;
        if (!Objects.equals(this.scheduleInformation, other.scheduleInformation)) {
            return false;
        }
        if (!Objects.equals(this.operationalInformation, other.operationalInformation)) {
            return false;
        }
        if (!Objects.equals(this.realtimestatus, other.realtimestatus)) {
            return false;
        }
        if (!Objects.equals(this.URL, other.URL)) {
            return false;
        }
        if (!Objects.equals(this.stops, other.stops)) {
            return false;
        }
        return true;
    }

}
