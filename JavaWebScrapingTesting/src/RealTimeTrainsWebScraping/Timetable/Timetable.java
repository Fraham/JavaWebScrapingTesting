package RealTimeTrainsWebScraping.Timetable;

import RealTimeTrainsWebScraping.Station;
import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Graham
 */
public class Timetable {

    private Station station;
    private ArrayList<Service> services;

    public Timetable() {

    }

    public Timetable(ArrayList<Service> newTimetable, Station station) {
        setServices(newTimetable);
        setStation(station);
    }

    public Timetable(Station station) {
        setStation(station);
    }

    /**
     *
     * @param rawTimetable
     * @param station
     */
    public Timetable(Element rawTimetable, Station station) {
        this(processRawTimetable(rawTimetable), station);
    }

    public static ArrayList<Service> processRawTimetable(Element rawTimetable) {
        ArrayList<Service> newService = new ArrayList<>();

        Elements services = rawTimetable.getElementsByTag("tr");

        for (Element service : services) {
            newService.add(Service.processRawData(service));
        }

        return newService;
    }

    /**
     * @return the station
     */
    public Station getStation() {
        return station;
    }

    /**
     * @param station the station to set
     */
    public void setStation(Station station) {
        this.station = station;
    }

    /**
     * @return the services
     */
    public ArrayList<Service> getServices() {
        if (services == null)
            services = new ArrayList<>();
        
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Timetable{" + "station=" + station + ", services=" + services + '}';
    }
}
