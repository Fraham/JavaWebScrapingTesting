package RealTimeTrainsWebScraping;

import RealTimeTrainsWebScraping.Display.MainDisplay;
import java.io.FileNotFoundException;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author Graham
 */
public class Driver {

    public Driver() {
    }

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        /*Station.getStations().add(new Station("Rainford", "RNF"));
        Station.getStations().add(new Station("Wigan Wallgate", "WGW"));
        Station.getStations().add(new Station("Wigan North Western", "WGN"));
        Station.getStations().add(new Station("Lancaster", "LAN"));
        Station.getStations().add(new Station("Birchwood", "BWD"));
        
        */
        
        Station.loadFromFile();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainDisplay().setVisible(true);
            }
        });
    }

}
