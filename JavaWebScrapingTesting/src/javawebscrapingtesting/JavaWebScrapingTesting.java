package javawebscrapingtesting;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Graham
 */
public class JavaWebScrapingTesting {
    
    public JavaWebScrapingTesting(){
        /*try {
            Document doc = Jsoup.connect("http://www.realtimetrains.co.uk/search/advanced/RNF/2016/07/05/0000-2359?stp=WVS&show=freight&order=wtt").get();
            //System.out.println(doc);
            //Elements tables = doc.getElementsByClass("table table-condensed servicelist advanced");
            Elements tables = doc.getElementsByClass("table");
            
            Element table = tables.first();
            
            //System.out.println(table);
            
            Element tbody = table.getElementsByTag("tbody").first();
            
            Timetable timetable = new Timetable(tbody, new Station("Rainford", "RNF"));
            System.out.println(timetable.toString());
            
            //Elements tr = tbody.first().getElementsByTag("tr");
            
            /*for (Element td : tr){
                Service service = Service.processRawData(td);
                
                System.out.println(service);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
        
        DayTimetable dt = new DayTimetable(new Station("Rainford", "RNF"), Calendar.getInstance());
        System.out.println(dt);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaWebScrapingTesting jwst = new JavaWebScrapingTesting();
    }
    
}
