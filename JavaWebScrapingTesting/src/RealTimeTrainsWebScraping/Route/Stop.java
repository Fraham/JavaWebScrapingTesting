package RealTimeTrainsWebScraping.Route;

import java.util.Objects;
import org.jsoup.nodes.Element;

/**
 *
 * @author Graham
 */
public class Stop {

    private String location;
    private String platform;

    private String workingArrival;
    private String workingDeparture;

    private String realTimeArrival;
    private String realTimeDeparture;
    private String realTimeDelay;

    private String line;
    private String path;

    private String engineeringAllowance;
    private String pathingAllowance;
    private String performanceAllowance;

    public Stop(String location, String platform, String workingArrival, String workingDeparture, String realTimeArrival, String realTimeDeparture, String realTimeDelay, String line, String path, String engineeringAllowance, String pathingAllowance, String performanceAllowance) {
        this.location = location;
        this.platform = platform;
        this.workingArrival = workingArrival;
        this.workingDeparture = workingDeparture;
        this.realTimeArrival = realTimeArrival;
        this.realTimeDeparture = realTimeDeparture;
        this.realTimeDelay = realTimeDelay;
        this.line = line;
        this.path = path;
        this.engineeringAllowance = engineeringAllowance;
        this.pathingAllowance = pathingAllowance;
        this.performanceAllowance = performanceAllowance;
    }    

    public Stop(Element rawStop) {
        processRawStop(rawStop);
    }

    private void processRawStop(Element rawStop) {

        setLocation(rawStop.getElementsByClass("location").first().getElementsByTag("a").first().text());
        setPlatform(rawStop.getElementsByClass("platform").first().text());

        setWorkingArrival(rawStop.getElementsByClass("wtt").first().text());
        setWorkingDeparture(rawStop.getElementsByClass("wtt").first().nextElementSibling().text());

        if (rawStop.getElementsByClass("realtime").first() != null) {
            setRealTimeArrival(rawStop.getElementsByClass("realtime").first().text());
            setRealTimeDeparture(rawStop.getElementsByClass("realtime").first().nextElementSibling().text());
            setRealTimeDelay(rawStop.getElementsByClass("realtime").first().nextElementSibling().nextElementSibling().text());
        } else if (rawStop.getElementsByClass("time").first() != null) {
            setRealTimeArrival("No Report");
            setRealTimeDeparture("No Report");
            setRealTimeDelay("No Report");
        } else {
            setRealTimeArrival("");
            setRealTimeDeparture("");
            setRealTimeDelay("");
        }

        setLine(rawStop.getElementsByClass("line").first().text());
        setPath(rawStop.getElementsByClass("path").first().text());

        setEngineeringAllowance(rawStop.getElementsByClass("engineering").first().text());
        setPathingAllowance(rawStop.getElementsByClass("pathing").first().text());
        setPerformanceAllowance(rawStop.getElementsByClass("performance").first().text());
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
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
     * @return the line
     */
    public String getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(String line) {
        this.line = line;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the engineeringAllowance
     */
    public String getEngineeringAllowance() {
        return engineeringAllowance;
    }

    /**
     * @param engineeringAllowance the engineeringAllowance to set
     */
    public void setEngineeringAllowance(String engineeringAllowance) {
        this.engineeringAllowance = engineeringAllowance;
    }

    /**
     * @return the pathingAllowance
     */
    public String getPathingAllowance() {
        return pathingAllowance;
    }

    /**
     * @param pathingAllowance the pathingAllowance to set
     */
    public void setPathingAllowance(String pathingAllowance) {
        this.pathingAllowance = pathingAllowance;
    }

    /**
     * @return the performanceAllowance
     */
    public String getPerformanceAllowance() {
        return performanceAllowance;
    }

    /**
     * @param performanceAllowance the performanceAllowance to set
     */
    public void setPerformanceAllowance(String performanceAllowance) {
        this.performanceAllowance = performanceAllowance;
    }

    /**
     * @return the realTimeArrival
     */
    public String getRealTimeArrival() {
        return realTimeArrival;
    }

    /**
     * @param realTimeArrival the realTimeArrival to set
     */
    public void setRealTimeArrival(String realTimeArrival) {
        this.realTimeArrival = realTimeArrival;
    }

    /**
     * @return the realTimeDeparture
     */
    public String getRealTimeDeparture() {
        return realTimeDeparture;
    }

    /**
     * @param realTimeDeparture the realTimeDeparture to set
     */
    public void setRealTimeDeparture(String realTimeDeparture) {
        this.realTimeDeparture = realTimeDeparture;
    }

    /**
     * @return the realTimeDelay
     */
    public String getRealTimeDelay() {
        return realTimeDelay;
    }

    /**
     * @param realTimeDelay the realTimeDelay to set
     */
    public void setRealTimeDelay(String realTimeDelay) {
        this.realTimeDelay = realTimeDelay;
    }

    /**
     * @return the workingArrival
     */
    public String getWorkingArrival() {
        return workingArrival;
    }

    /**
     * @param workingArrival the workingArrival to set
     */
    public void setWorkingArrival(String workingArrival) {
        this.workingArrival = workingArrival;
    }

    /**
     * @return the workingDeparture
     */
    public String getWorkingDeparture() {
        return workingDeparture;
    }

    /**
     * @param workingDeparture the workingDeparture to set
     */
    public void setWorkingDeparture(String workingDeparture) {
        this.workingDeparture = workingDeparture;
    }

    @Override
    public String toString() {
        return "\nStop{" + "location=" + location + ", platform=" + platform + ", workingArrival=" + workingArrival + ", workingDeparture=" + workingDeparture + ", realTimeArrival=" + realTimeArrival + ", realTimeDeparture=" + realTimeDeparture + ", realTimeDelay=" + realTimeDelay + ", line=" + line + ", path=" + path + ", engineeringAllowance=" + engineeringAllowance + ", pathingAllowance=" + pathingAllowance + ", performanceAllowance=" + performanceAllowance + "}";
    }

    public Object[] toArray() {
        return new Object[]{location, platform, workingArrival, workingDeparture, realTimeArrival, realTimeDeparture, realTimeDelay, line, path, engineeringAllowance, pathingAllowance, performanceAllowance};
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.location);
        hash = 53 * hash + Objects.hashCode(this.platform);
        hash = 53 * hash + Objects.hashCode(this.workingArrival);
        hash = 53 * hash + Objects.hashCode(this.workingDeparture);
        hash = 53 * hash + Objects.hashCode(this.realTimeArrival);
        hash = 53 * hash + Objects.hashCode(this.realTimeDeparture);
        hash = 53 * hash + Objects.hashCode(this.realTimeDelay);
        hash = 53 * hash + Objects.hashCode(this.line);
        hash = 53 * hash + Objects.hashCode(this.path);
        hash = 53 * hash + Objects.hashCode(this.engineeringAllowance);
        hash = 53 * hash + Objects.hashCode(this.pathingAllowance);
        hash = 53 * hash + Objects.hashCode(this.performanceAllowance);
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
        final Stop other = (Stop) obj;
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.platform, other.platform)) {
            return false;
        }
        if (!Objects.equals(this.workingArrival, other.workingArrival)) {
            return false;
        }
        if (!Objects.equals(this.workingDeparture, other.workingDeparture)) {
            return false;
        }
        if (!Objects.equals(this.realTimeArrival, other.realTimeArrival)) {
            return false;
        }
        if (!Objects.equals(this.realTimeDeparture, other.realTimeDeparture)) {
            return false;
        }
        if (!Objects.equals(this.realTimeDelay, other.realTimeDelay)) {
            return false;
        }
        if (!Objects.equals(this.line, other.line)) {
            return false;
        }
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.engineeringAllowance, other.engineeringAllowance)) {
            return false;
        }
        if (!Objects.equals(this.pathingAllowance, other.pathingAllowance)) {
            return false;
        }
        if (!Objects.equals(this.performanceAllowance, other.performanceAllowance)) {
            return false;
        }
        return true;
    }
    
}
