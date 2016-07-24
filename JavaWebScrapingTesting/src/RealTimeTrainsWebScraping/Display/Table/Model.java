package RealTimeTrainsWebScraping.Display.Table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Graham
 */
public class Model extends AbstractTableModel {

    private final List<String> columnNames = new ArrayList();
    private final List<List> data = new ArrayList();

    {
        columnNames.add("IND");
        columnNames.add("Planned Arrival");
        columnNames.add("Actual Arrival");
        columnNames.add("Origin");
        columnNames.add("Platform");
        columnNames.add("ID");
        columnNames.add("Train Operator");
        columnNames.add("Destination");
        columnNames.add("Planned Departure");
        columnNames.add("Actual Departure");
        columnNames.add("Date");
        columnNames.add("Route");
    }

    public void addRow(List rowData) {
        data.add(rowData);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        try {
            return columnNames.get(col);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        try {
            return data.get(row).get(col);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void clear() {
        data.clear();
        //fireTableDataChanged();
    }
}
