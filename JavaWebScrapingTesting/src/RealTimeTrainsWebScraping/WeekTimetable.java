package RealTimeTrainsWebScraping;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Graham
 */
public class WeekTimetable {
    private ArrayList<DayTimetable> days;
    
    private Calendar startDate;
    
    private Station station;
    
    public WeekTimetable(Station station, Calendar startDate){
        this.setStartDate(startDate);
        this.setStation(station);
    }
    
    public void getWeekTimetable(){
        days = new ArrayList<>();
        
        Calendar currentDate = (Calendar)this.getStartDate().clone();
        
        currentDate.add(Calendar.DAY_OF_MONTH, -1);
        
        for (int i = 0; i < 7; i++){
            currentDate.add(Calendar.DAY_OF_MONTH, 1);
            DayTimetable day = new DayTimetable(this.getStation(), (Calendar)currentDate.clone());
            day.getDayTimetable();
            days.add(day);
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

    @Override
    public String toString() {
        return "WeekTimetable{" + "Start Date=" + startDate.getTime() + ",\nDays=" + days + '}';
    }
    
    
}
