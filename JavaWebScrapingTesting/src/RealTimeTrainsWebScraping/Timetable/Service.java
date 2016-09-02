package RealTimeTrainsWebScraping.Timetable;

import RealTimeTrainsWebScraping.Display.Table.Button;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Graham
 */
public class Service {

    private String ind;
    private String plannedArrival;
    private String actualArrival;
    private String origin;
    private String platform;
    private String id;
    private String trainOperatorID;
    private String destination;
    private String plannedDeparture;
    private String actualDeparture;

    private String routeURL;

    public Service() {

    }

    public Service(String ind, String plannedArrival, String actualArrival, String origin, String platform, String id, String trainOperatorID, String destination, String plannedDeparture, String actualDeparture, String routeURL) {
        this.ind = ind;
        this.plannedArrival = plannedArrival;
        this.actualArrival = actualArrival;
        this.origin = origin;
        this.platform = platform;
        this.id = id;
        this.trainOperatorID = trainOperatorID;
        this.destination = destination;
        this.plannedDeparture = plannedDeparture;
        this.actualDeparture = actualDeparture;
        this.routeURL = routeURL;
    }

    public Service(Service newService) {
        this.ind = newService.getInd();
        this.plannedArrival = newService.getPlannedArrival();
        this.actualArrival = newService.getActualArrival();
        this.origin = newService.getOrigin();
        this.platform = newService.getPlatform();
        this.id = newService.getId();
        this.trainOperatorID = newService.getTrainOperatorID();
        this.destination = newService.getDestination();
        this.plannedDeparture = newService.getPlannedDeparture();
        this.actualDeparture = newService.getActualDeparture();
        this.routeURL = newService.getRouteURL();
    }

    public Service(Element rawService) {
        this(processRawData(rawService));
    }

    public static Service processRawData(Element rawService) {

        Service newService = new Service();

        Elements rawTDS = rawService.getElementsByTag("td");

        for (int i = 0; i < rawTDS.size(); i++) {
            Element element = rawTDS.get(i);

            switch (i) {
                case 0:
                    newService.setInd(element.text());
                    break;
                case 1:
                    newService.setPlannedArrival(element.text());
                    break;
                case 2:
                    newService.setActualArrival(element.text());
                    break;
                case 3:
                    newService.setOrigin(element.text());
                    break;
                case 4:
                    newService.setPlatform(element.text());
                    break;
                case 5:
                    newService.setId(element.getElementsByTag("a").first().text());
                    newService.setRouteURL(element.select("a").first().attr("abs:href"));
                    break;
                case 6:
                    newService.setTrainOperatorID(element.text());
                    break;
                case 7:
                    newService.setDestination(element.text());
                    break;
                case 8:
                    newService.setPlannedDeparture(element.text());
                    break;
                case 9:
                    newService.setActualDeparture(element.text());
                    break;
                default:
                    break;
            }
        }

        return newService;
    }

    @Override
    public String toString() {
        return "\n" + "Service{" + "ind=" + ind + ", plannedArrival=" + plannedArrival + ", actualArrival=" + actualArrival + ", origin=" + origin + ", platform=" + platform + ", id=" + id + ", trainOperatorID=" + trainOperatorID + ", destination=" + destination + ", plannedDeparture=" + plannedDeparture + ", actualDeparture=" + actualDeparture + '}';
    }

    public List<Object> toList() {
        List<Object> service = new ArrayList<>();

        service.add(ind);
        service.add(plannedArrival);
        service.add(actualArrival);
        service.add(origin);
        service.add(platform);
        service.add(id);
        service.add(trainOperatorID);
        service.add(destination);
        service.add(plannedDeparture);
        service.add(actualDeparture);
        service.add(new Button(routeURL));

        return service;
    }

    /**
     * @return the ind
     */
    public String getInd() {
        return ind;
    }

    /**
     * @param ind the ind to set
     */
    public void setInd(String ind) {
        this.ind = ind;
    }

    /**
     * @return the plannedArrival
     */
    public String getPlannedArrival() {
        return plannedArrival;
    }

    /**
     * @param plannedArrival the plannedArrival to set
     */
    public void setPlannedArrival(String plannedArrival) {
        this.plannedArrival = plannedArrival;
    }

    /**
     * @return the actualArrival
     */
    public String getActualArrival() {
        return actualArrival;
    }

    /**
     * @param actualArrival the actualArrival to set
     */
    public void setActualArrival(String actualArrival) {
        if (actualArrival.equals("N/R")) {
            actualArrival = "No Report";
        }
        
        this.actualArrival = actualArrival;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform the platform to set
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the trainOperatorID
     */
    public String getTrainOperatorID() {
        return trainOperatorID;
    }

    /**
     * @param trainOperatorID the trainOperatorID to set
     */
    public void setTrainOperatorID(String trainOperatorID) {
        this.trainOperatorID = trainOperatorID;
    }

    /**
     * @return the Destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param Destination the Destination to set
     */
    public void setDestination(String Destination) {
        this.destination = Destination;
    }

    /**
     * @return the plannedDeparture
     */
    public String getPlannedDeparture() {
        return plannedDeparture;
    }

    /**
     * @param plannedDeparture the plannedDeparture to set
     */
    public void setPlannedDeparture(String plannedDeparture) {
        this.plannedDeparture = plannedDeparture;
    }

    /**
     * @return the actualDeparture
     */
    public String getActualDeparture() {
        return actualDeparture;
    }

    /**
     * @param actualDeparture the actualDeparture to set
     */
    public void setActualDeparture(String actualDeparture) {
        if (actualDeparture.equals("N/R")) {
            actualDeparture = "No Report";
        }

        this.actualDeparture = actualDeparture;
    }

    /**
     * @return the routeURL
     */
    public String getRouteURL() {
        return routeURL;
    }

    /**
     * @param routeURL the routeURL to set
     */
    public void setRouteURL(String routeURL) {
        this.routeURL = routeURL;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.ind);
        hash = 17 * hash + Objects.hashCode(this.plannedArrival);
        hash = 17 * hash + Objects.hashCode(this.actualArrival);
        hash = 17 * hash + Objects.hashCode(this.origin);
        hash = 17 * hash + Objects.hashCode(this.platform);
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.trainOperatorID);
        hash = 17 * hash + Objects.hashCode(this.destination);
        hash = 17 * hash + Objects.hashCode(this.plannedDeparture);
        hash = 17 * hash + Objects.hashCode(this.actualDeparture);
        hash = 17 * hash + Objects.hashCode(this.routeURL);
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
        final Service other = (Service) obj;
        if (!Objects.equals(this.ind, other.ind)) {
            return false;
        }
        if (!Objects.equals(this.plannedArrival, other.plannedArrival)) {
            return false;
        }
        if (!Objects.equals(this.actualArrival, other.actualArrival)) {
            return false;
        }
        if (!Objects.equals(this.origin, other.origin)) {
            return false;
        }
        if (!Objects.equals(this.platform, other.platform)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.trainOperatorID, other.trainOperatorID)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        if (!Objects.equals(this.plannedDeparture, other.plannedDeparture)) {
            return false;
        }
        if (!Objects.equals(this.actualDeparture, other.actualDeparture)) {
            return false;
        }
        if (!Objects.equals(this.routeURL, other.routeURL)) {
            return false;
        }
        return true;
    }

}
