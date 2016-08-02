package RealTimeTrainsWebScraping.Timetable;

import RealTimeTrainsWebScraping.Exception.NoTrainsExeception;
import RealTimeTrainsWebScraping.Station;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author Graham
 */
public class WeekTimetable extends DaysTimetable {

    public WeekTimetable(Station station, Calendar startDate, boolean passenger, boolean freight) throws IOException, NoTrainsExeception {
        super(station, startDate, 7, passenger, freight);
    }

    @Override
    public String toString() {
        return "Week Timetable{" + "Start Date=" + getStartDate().getTime() + ",\nDays=" + getDays() + '}';
    }
    
    
}
