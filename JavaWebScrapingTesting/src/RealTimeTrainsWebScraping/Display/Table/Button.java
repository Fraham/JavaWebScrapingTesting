package RealTimeTrainsWebScraping.Display.Table;

import RealTimeTrainsWebScraping.Display.RouteDisplay;
import RealTimeTrainsWebScraping.Driver;
import RealTimeTrainsWebScraping.Route.Route;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Graham
 */
public class Button extends JButton implements ActionListener {

    private final String routeURL;

    public Button(String routeURL) {
        super("Route");

        this.routeURL = routeURL;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showRoute();
    }

    public void showRoute() {
        try {
            Route route = new Route(routeURL);
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new RouteDisplay(route).setVisible(true);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
