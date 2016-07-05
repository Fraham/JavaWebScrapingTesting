package javawebscrapingtesting;

import java.io.IOException;
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
public class JavaWebScrapingTesting {
    
    public JavaWebScrapingTesting(){
        try {
            Document doc = Jsoup.connect("http://www.realtimetrains.co.uk/search/advanced/RNF/2016/07/05/0000-2359?stp=WVS&show=freight&order=wtt").get();
            //System.out.println(doc);
            //Elements tables = doc.getElementsByClass("table table-condensed servicelist advanced");
            Elements tables = doc.getElementsByClass("table");
            
            Element table = tables.first();
            
            //System.out.println(table);
            
            Elements tbody = table.getElementsByTag("tbody");
            
            Elements tr = tbody.first().getElementsByTag("tr");
            
            for (Element td : tr){
                Elements times = td.getElementsByClass("time");
                
                for (Element time : times){
                    System.out.println(time.text());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaWebScrapingTesting jwst = new JavaWebScrapingTesting();
    }
    
}
