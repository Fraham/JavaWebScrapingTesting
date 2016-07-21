package RealTimeTrainsWebScraping;

import java.util.ArrayList;

/**
 *
 * @author Graham
 */
public class Station {
    private String name;
    private String codeName;
    
    private static ArrayList<Station> stations = new ArrayList<>();
    
    public Station(String name, String codeName){
        this.setCodeName(codeName);
        this.setName(name);
    }
    
    public static Station findStationFromName(String name){
        for (Station station : stations) {
            if(station.getName().equals(name)){
                return station;
            }
        }
        
        return null; // change to expection
    }
    
    public static Station findStationFromID(String id){
        for (Station station : stations) {
            if(station.getCodeName().equals(id)){
                return station;
            }
        }
        
        return null; // change to expection
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the codeName
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * @param codeName the codeName to set
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public String toString() {
        return "Station{" + "name=" + name + ", codeName=" + codeName + '}';
    }
    
        /**
     * @return the stations
     */
    public static ArrayList<Station> getStations() {
        return stations;
    }

    /**
     * @param aStations the stations to set
     */
    public static void setStations(ArrayList<Station> aStations) {
        stations = aStations;
    }
}
