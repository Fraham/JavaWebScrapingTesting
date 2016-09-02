package RealTimeTrainsWebScraping.Display.Table;

import RealTimeTrainsWebScraping.Display.RouteDisplay;
import RealTimeTrainsWebScraping.Route.Route;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
        try {
            showRoute();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable to connect to Real Time Trains.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void showRoute() throws IOException {
        Route route = new Route(routeURL);
        Thread processRouteThread = new Thread() {
            @Override
            public void run() {
                try {
                    route.processRoute();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        };
        processRouteThread.start();

        java.awt.EventQueue.invokeLater(() -> {
            new RouteDisplay(route, processRouteThread).setVisible(true);
        });
    }

}
