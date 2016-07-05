package javawebscrapingtesting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Date;

/**
 *
 * @author Graham
 */
public class DayTimetable extends Timetable {

    private Calendar date;

    public DayTimetable(Station station, Calendar date) {
        super(station);

        setDate(date);
        
        getTimetable();
    }

    public void getTimetable() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            
            Document doc = Jsoup.connect(String.format("http://www.realtimetrains.co.uk/search/advanced/%s/%s/0000-2359?stp=WVS&show=freight&order=wtt", getStation().getCodeName(), dateFormat.format(date.getTime()))).get();
            
            Elements tables = doc.getElementsByClass("table");
            Element table = tables.first();
            Element tbody = table.getElementsByTag("tbody").first();
            setServices(Timetable.processRawTimetable(tbody));
        } catch (IOException ex) {
            Logger.getLogger(DayTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DayTimetable{" + "date=" + date.getTime() + ", " + super.toString() + '}';
    }
    
    
}
