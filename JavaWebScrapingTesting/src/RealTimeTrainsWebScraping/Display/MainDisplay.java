package RealTimeTrainsWebScraping.Display;

import RealTimeTrainsWebScraping.Timetable.DayTimetable;
import RealTimeTrainsWebScraping.Timetable.DaysTimetable;
import RealTimeTrainsWebScraping.Station;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import RealTimeTrainsWebScraping.Display.Table.*;
import RealTimeTrainsWebScraping.Exception.NoTrainsExeception;
import RealTimeTrainsWebScraping.Exception.UnKnownStationException;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Graham
 */
public class MainDisplay extends javax.swing.JFrame {

    /**
     * Creates new form MainDisplay
     */
    public MainDisplay() {
        initComponents();

        Calendar date = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        txtDate.setText(sdf.format(date.getTime()));

        tblTimetable.setFillsViewportHeight(true);

        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbStation.getModel();

        for (Station station : Station.getStations()) {
            model.addElement(station.getName());
        }

        TableCellRenderer defaultRenderer;

        defaultRenderer = tblTimetable.getDefaultRenderer(RealTimeTrainsWebScraping.Display.Table.Button.class);
        tblTimetable.setDefaultRenderer(RealTimeTrainsWebScraping.Display.Table.Button.class, new Render(defaultRenderer));
        tblTimetable.addMouseListener(new ButtonMouseListener(tblTimetable));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        lblStation = new javax.swing.JLabel();
        cmbStation = new javax.swing.JComboBox<>();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnAccept = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTimetable = new javax.swing.JTable();
        lblDays = new javax.swing.JLabel();
        spnDays = new javax.swing.JSpinner();
        chkPassenger = new javax.swing.JCheckBox();
        chkFreight = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fraham's Real Time Trains");

        mainPanel.setName("mainPanel"); // NOI18N

        lblStation.setText("Station:");

        lblDate.setText("Date:");

        btnAccept.setText("Accept");
        btnAccept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAcceptMousePressed(evt);
            }
        });

        jScrollPane1.setMinimumSize(new java.awt.Dimension(100, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 100));

        tblTimetable.setAutoCreateRowSorter(true);
        tblTimetable.setModel(new Model());
        tblTimetable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblTimetable.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane1.setViewportView(tblTimetable);

        lblDays.setText("Days:");

        spnDays.setValue(1);

        chkPassenger.setSelected(true);
        chkPassenger.setText("Passenger");

        chkFreight.setSelected(true);
        chkFreight.setText("Freight");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(lblStation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbStation, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDays)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnDays, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkPassenger)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkFreight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                        .addComponent(btnAccept)
                        .addGap(34, 34, 34))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStation)
                    .addComponent(cmbStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccept)
                    .addComponent(lblDays)
                    .addComponent(spnDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkPassenger)
                    .addComponent(chkFreight))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcceptMousePressed
        try {
            Calendar date = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            date.setTime(sdf.parse(txtDate.getText()));

            Station station = Station.findStationFromName(cmbStation.getSelectedItem().toString());

            boolean passenger = chkPassenger.isSelected();
            boolean freight = chkFreight.isSelected();

            if (!passenger && !freight) {
                JOptionPane.showMessageDialog(null, "Select either passenger or freight trains.", "Error", JOptionPane.WARNING_MESSAGE);
                
                return;
            }

            DaysTimetable timetable = new DaysTimetable(station, date, Integer.parseInt(spnDays.getValue().toString()), passenger, freight);

            Model model = (Model) tblTimetable.getModel();

            model.clear();
            for (DayTimetable day : timetable.getDays()) {
                for (Object[] service : day.getDatedServices()) {
                    model.addRow(Arrays.asList(service));
                }
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Unable to parse the date.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable to connect to Real Time Trains.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (NoTrainsExeception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Information", JOptionPane.WARNING_MESSAGE);
        } catch (UnKnownStationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAcceptMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JCheckBox chkFreight;
    private javax.swing.JCheckBox chkPassenger;
    private javax.swing.JComboBox<String> cmbStation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDays;
    private javax.swing.JLabel lblStation;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JSpinner spnDays;
    private javax.swing.JTable tblTimetable;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables
}
