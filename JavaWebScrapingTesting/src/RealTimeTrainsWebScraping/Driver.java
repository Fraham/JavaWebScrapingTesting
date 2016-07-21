package RealTimeTrainsWebScraping;

import java.awt.BorderLayout;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Graham
 */
public class Driver {

    public Driver() {
        WeekTimetable wt = new WeekTimetable(new Station("Rainford", "RNF"), Calendar.getInstance());
        wt.getWeekTimetable();
        System.out.println(wt);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Station.getStations().add(new Station("Rainford", "RNF"));
        Station.getStations().add(new Station("Wigan Wallgate", "WGW"));
        Station.getStations().add(new Station("Wigan North Western", "WGN"));
        Station.getStations().add(new Station("Lancaster", "LAN"));
        
    }

}