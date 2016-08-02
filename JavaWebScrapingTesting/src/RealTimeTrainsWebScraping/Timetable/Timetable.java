package RealTimeTrainsWebScraping.Timetable;

import RealTimeTrainsWebScraping.Station;
import java.util.ArrayList;
import java.util.Objects;
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
        processRawTimetable(rawTimetable);
        setStation(station);
    }

    public void processRawTimetable(Element rawTimetable) {
        services = new ArrayList<>();

        Elements servicesElements = rawTimetable.getElementsByTag("tr");

        for (Element service : servicesElements) {
            services.add(Service.processRawData(service));
        }
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
        if (services == null) {
            services = new ArrayList<>();
        }

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.station);
        hash = 23 * hash + Objects.hashCode(this.services);
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
        final Timetable other = (Timetable) obj;
        if (!Objects.equals(this.station, other.station)) {
            return false;
        }
        if (!Objects.equals(this.services, other.services)) {
            return false;
        }
        return true;
    }

}
