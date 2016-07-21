package RealTimeTrainsWebScraping;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Graham
 */
public class DayTimetable extends Timetable {

    private Calendar date;

    public DayTimetable(Station station, Calendar date) {
        super(station);

        setDate(date);
    }

    public void getDayTimetable() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            Document doc = Jsoup.connect(String.format("http://www.realtimetrains.co.uk/search/advanced/%s/%s/0000-2359?stp=WVS&show=freight&order=wtt", getStation().getCodeName(), dateFormat.format(date.getTime()))).get();

            Elements tables = doc.getElementsByClass("table");
            Element table = tables.first();
            if (table != null) {
                Element tbody = table.getElementsByTag("tbody").first();
                setServices(Timetable.processRawTimetable(tbody));
            }
        } catch (IOException ex) {
            Logger.getLogger(DayTimetable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Object []> getDatedServices(){
        List<Object []> datedServices = new ArrayList<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
        for (Service service : getServices()){
            List list = service.toList();
            list.add(sdf.format(date.getTime()));
            datedServices.add(list.toArray());                    
        }
        return datedServices;
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
        return "\nDayTimetable{" + "date=" + date.getTime() + ",\n" + super.toString() + '}';
    }

}
