package RealTimeTrainsWebScraping;

/**
 *
 * @author Graham
 */
public class Stop {
    private String location;
    private String platform;
    private String arrival;
    private String departure;
    
    private String line;
    private String path;
    
    private String engineeringAllowance;
    private String pathingAllowance;
    private String performanceAllowance;
    
    public Stop(){
        
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
     * @return the arrival
     */
    public String getArrival() {
        return arrival;
    }

    /**
     * @param arrival the arrival to set
     */
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    /**
     * @return the departure
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * @param departure the departure to set
     */
    public void setDeparture(String departure) {
        this.departure = departure;
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
}
