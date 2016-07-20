package javawebscrapingtesting;

import java.awt.BorderLayout;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Graham
 */
public class JavaWebScrapingTesting {

    public JavaWebScrapingTesting() {
        WeekTimetable wt = new WeekTimetable(new Station("Rainford", "RNF"), Calendar.getInstance());
        wt.getWeekTimetable();
        System.out.println(wt);
    }

    public JFrame makeJFrame() {
        JFrame frame = new JFrame();

        frame.setTitle("Real Time Trains");
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        frame.add(mainPanel);

        //mainPanel.setBorder(border);

        return frame;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaWebScrapingTesting jwst = new JavaWebScrapingTesting();
        jwst.makeJFrame().setVisible(true);
    }

}
