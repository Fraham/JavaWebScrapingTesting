package RealTimeTrainsWebScraping;

import RealTimeTrainsWebScraping.Route.Route;
import RealTimeTrainsWebScraping.Display.RouteDisplay;
import RealTimeTrainsWebScraping.Display.MainDisplay;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Graham
 */
public class Driver {

    public Driver() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Station.getStations().add(new Station("Rainford", "RNF"));
        Station.getStations().add(new Station("Wigan Wallgate", "WGW"));
        Station.getStations().add(new Station("Wigan North Western", "WGN"));
        Station.getStations().add(new Station("Lancaster", "LAN"));

        try {
            Route route = new Route("http://www.realtimetrains.co.uk/train/H38485/2016/07/20/advanced");
            System.out.println(route.toString());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new RouteDisplay(route).setVisible(true);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDisplay().setVisible(true);
            }
        });

        //MainDisplay display = new MainDisplay();
        //display.setVisible(true);
    }

}
