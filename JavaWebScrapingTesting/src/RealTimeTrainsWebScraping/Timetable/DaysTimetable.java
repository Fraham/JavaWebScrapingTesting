package RealTimeTrainsWebScraping.Timetable;

import RealTimeTrainsWebScraping.Station;
import java.util.ArrayList;
import java.util.Calendar;

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

    public DaysTimetable(Station station, Calendar startDate, int numberOfDays, boolean passenger, boolean freight) {
        this.setStartDate(startDate);
        this.setStation(station);
        this.setNumberOfDays(numberOfDays);
        
        setPassenger(passenger);
        setFreight(freight);
    }

    public void getTimetable() {
        setDays(new ArrayList<>());

        Calendar currentDate = (Calendar) this.getStartDate().clone();

        for (int i = 0; i < getNumberOfDays(); i++) {
            DayTimetable day = new DayTimetable(this.getStation(), (Calendar) currentDate.clone(), this.isPassenger(), this.isFreight());
            day.getDayTimetable();
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
}
