package RealTimeTrainsWebScraping.Display.Table;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Graham
 */
public class Render implements TableCellRenderer {

    private TableCellRenderer defaultRenderer;

    public Render(TableCellRenderer renderer) {
        defaultRenderer = renderer;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Component) {
            return (Component) value;
        }
        return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

}
