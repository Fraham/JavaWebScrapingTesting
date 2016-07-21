package RealTimeTrainsWebScraping;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Graham
 */
public class WeekTimetable extends DaysTimetable {

    private ArrayList<DayTimetable> days;

    private Calendar startDate;

    private Station station;

    public WeekTimetable(Station station, Calendar startDate) {
        super(station, startDate, 7);
    }

    @Override
    public String toString() {
        return "Week Timetable{" + "Start Date=" + startDate.getTime() + ",\nDays=" + days + '}';
    }
}
