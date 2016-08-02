package RealTimeTrainsWebScraping.Timetable;

import RealTimeTrainsWebScraping.Exception.NoTrainsExeception;
import RealTimeTrainsWebScraping.Station;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author Graham
 */
public class DaysTimetable {

    private ArrayList<DayTimetable> days;

    private Calendar startDate;

    private Station station;

    private int numberOfDays;
    
    private boolean passenger;
    private boolean freight;

    public DaysTimetable(Station station, Calendar startDate, int numberOfDays, boolean passenger, boolean freight) throws IOException, NoTrainsExeception {
        setStartDate(startDate);
        setStation(station);
        setNumberOfDays(numberOfDays);
        
        setPassenger(passenger);
        setFreight(freight);
        
        getTimetable();
    }

    public void getTimetable() throws IOException, NoTrainsExeception {
        setDays(new ArrayList<>());

        Calendar currentDate = (Calendar) this.getStartDate().clone();

        for (int i = 0; i < getNumberOfDays(); i++) {
            DayTimetable day = new DayTimetable(this.getStation(), (Calendar) currentDate.clone(), this.isPassenger(), this.isFreight());
            getDays().add(day);
            
            currentDate.add(Calendar.DAY_OF_MONTH, 1);
        }
    }

    /**
     * @return the days
     */
    public ArrayList<DayTimetable> getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(ArrayList<DayTimetable> days) {
        this.days = days;
    }

    /**
     * @return the startDate
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
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
     * @return the numberOfDays
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * @param numberOfDays the numberOfDays to set
     */
    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
        return "Days Timetable{" + "Start Date=" + startDate.getTime() + ",\nDays=" + days + '}';
    }

    /**
     * @return the passenger
     */
    public boolean isPassenger() {
        return passenger;
    }

    /**
     * @param passenger the passenger to set
     */
    public void setPassenger(boolean passenger) {
        this.passenger = passenger;
    }

    /**
     * @return the freight
     */
    public boolean isFreight() {
        return freight;
    }

    /**
     * @param freight the freight to set
     */
    public void setFreight(boolean freight) {
        this.freight = freight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.days);
        hash = 71 * hash + Objects.hashCode(this.startDate);
        hash = 71 * hash + Objects.hashCode(this.station);
        hash = 71 * hash + this.numberOfDays;
        hash = 71 * hash + (this.passenger ? 1 : 0);
        hash = 71 * hash + (this.freight ? 1 : 0);
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
        final DaysTimetable other = (DaysTimetable) obj;
        if (this.numberOfDays != other.numberOfDays) {
            return false;
        }
        if (this.passenger != other.passenger) {
            return false;
        }
        if (this.freight != other.freight) {
            return false;
        }
        if (!Objects.equals(this.days, other.days)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.station, other.station)) {
            return false;
        }
        return true;
    }
    
}
