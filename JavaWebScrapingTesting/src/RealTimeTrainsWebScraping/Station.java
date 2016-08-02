package RealTimeTrainsWebScraping;

import java.util.ArrayList;
import RealTimeTrainsWebScraping.Exception.UnKnownStationException;
import java.util.Objects;

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
    
    public static Station findStationFromName(String name) throws UnKnownStationException{
        for (Station station : stations) {
            if(station.getName().toLowerCase().equals(name.toLowerCase())){
                return station;
            }
        }
        
        throw new UnKnownStationException("Unable to find station with name: " + name);
    }
    
    public static Station findStationFromID(String id) throws UnKnownStationException{
        for (Station station : stations) {
            if(station.getCodeName().toLowerCase().equals(id.toLowerCase())){
                return station;
            }
        }
        
        throw new UnKnownStationException("Unable to find station with ID: " + id);
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.codeName);
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
        final Station other = (Station) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.codeName, other.codeName)) {
            return false;
        }
        return true;
    }
    
    
}
