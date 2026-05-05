package kadysoft.kady;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

class ColoredCellRenderer extends DefaultTableCellRenderer {
    
    private final Color backgroundColor;
    private final Color textColor;

    public ColoredCellRenderer(Color backgroundColor, Color textColor) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        setOpaque(true); // ??? ???? ????? ????
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        c.setBackground(backgroundColor);
        c.setForeground(textColor);
        
        return c;
    }
}