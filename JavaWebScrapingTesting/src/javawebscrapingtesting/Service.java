package javawebscrapingtesting;

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

    public Service() {

    }

    public Service(String ind, String plannedArrival, String actualArrival, String origin, String platform, String id, String trainOperatorID, String destination, String plannedDeparture, String actualDeparture) {
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
    }
    
    public Service(Service newService){
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
    }

    public Service(Element rawService) {
        this(processRawData(rawService));
    }

    public static Service processRawData(Element rawService) {

        Service newService = new Service();

        Elements rawTDS = rawService.getElementsByTag("td");
System.out.println(rawTDS);
        for (int i = 0; i < rawTDS.size(); i++) {
            
            Element element = rawTDS.get(i);

            if (i == 0) {
                newService.setInd(element.text());
            } else if (i == 1) {
                newService.setPlannedArrival(element.text());
            } else if (i == 2) {
                newService.setActualArrival(element.text());
            } else if (i == 3) {
                newService.setOrigin(element.text());
            } else if (i == 4) {
                newService.setPlatform(element.text());
            } else if (i == 5) {
                newService.setId(element.getElementsByTag("a").first().text());
            } else if (i == 6) {
                newService.setTrainOperatorID(element.text());
            } else if (i == 7) {
                newService.setDestination(element.text());
            } else if (i == 8) {
                newService.setPlannedDeparture(element.text());
            } else if (i == 9) {
                newService.setActualDeparture(element.text());
            }
        }

        return newService;
    }

    @Override
    public String toString() {
        return "Service{" + "ind=" + ind + ", plannedArrival=" + plannedArrival + ", actualArrival=" + actualArrival + ", origin=" + origin + ", platform=" + platform + ", id=" + id + ", trainOperatorID=" + trainOperatorID + ", destination=" + destination + ", plannedDeparture=" + plannedDeparture + ", actualDeparture=" + actualDeparture + '}';
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
        this.actualDeparture = actualDeparture;
    }
}
