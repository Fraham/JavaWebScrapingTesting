package RealTimeTrainsWebScraping.Timetable;

import RealTimeTrainsWebScraping.Exception.NoTrainsExeception;
import RealTimeTrainsWebScraping.Station;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
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

    private boolean passenger;
    private boolean freight;

    public DayTimetable(Station station, Calendar date, boolean passenger, boolean freight) throws IOException, NoTrainsExeception {
        super(station);

        setDate(date);

        setPassenger(passenger);
        setFreight(freight);
        
        getDayTimetable();
    }

    public void getDayTimetable() throws IOException, NoTrainsExeception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        String show = "";

        if (passenger && freight) {
            show = "all";
        } else if (freight) {
            show = "non-passenger";
        } else if (passenger) {
            show = "passenger";
        }

        Document doc = Jsoup.connect(String.format("http://www.realtimetrains.co.uk/search/advanced/%s/%s/0000-2359?stp=WVS&show=%s&order=wtt", getStation().getCodeName(), dateFormat.format(date.getTime()), show)).get();

        Elements tables = doc.getElementsByClass("table");
        Element table = tables.first();
        if (table != null) {
            Element tbody = table.getElementsByTag("tbody").first();
            setServices(Timetable.processRawTimetable(tbody));
        } else {
            throw new NoTrainsExeception("No trains for this station and date.");
        }
    }

    public List<Object[]> getDatedServices() {
        List<Object[]> datedServices = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Service service : getServices()) {
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
