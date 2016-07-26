package RealTimeTrainsWebScraping.Display;

import RealTimeTrainsWebScraping.Route.Route;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Graham
 */
public class RouteDisplay extends javax.swing.JFrame {

    private Route displayedRoute;

    /**
     * Creates new form RouteDisplay
     * @param route
     */
    public RouteDisplay(Route route) {
        initComponents();
        setDisplayedRoute(route);

        populateTable();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblRoute.getModel();
        
        model.setRowCount(0);

        for (Object[] row : getDisplayedRoute().getStopsAsArrays()) {
            model.addRow(row);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoute = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Route");

        tblRoute.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location", "Platform", "Working Arrival", "Working Depature", "Real Time Arrival", "Real Time Departure", "Real Time Delay", "Line", "Path", "Engineering Allowance", "Pathing Allowance", "Performance Allowance"
            }
        ));
        tblRoute.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane1.setViewportView(tblRoute);

        btnRefresh.setText("Refresh");
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        getDisplayedRoute().refresh();
        
        populateTable();
    }//GEN-LAST:event_btnRefreshMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tblRoute;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the displayedRoute
     */
    public Route getDisplayedRoute() {
        return displayedRoute;
    }

    /**
     * @param displayedRoute the displayedRoute to set
     */
    public void setDisplayedRoute(Route displayedRoute) {
        this.displayedRoute = displayedRoute;
    }
}