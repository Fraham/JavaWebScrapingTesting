package javawebscrapingtesting;

/**
 *
 * @author Graham
 */
public class Station {
    private String name;
    private String codeName;
    
    public Station(String name, String codeName){
        this.setCodeName(codeName);
        this.setName(name);
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
}
