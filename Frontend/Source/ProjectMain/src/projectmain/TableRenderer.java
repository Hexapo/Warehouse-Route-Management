package projectmain;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.table.DefaultTableCellRenderer;

import projectmain.components.Driver;

public class TableRenderer extends DefaultTableCellRenderer
{

    public TableRenderer()
    {
        super();
    }

    public void setValue(Driver value)
    {
        setText(value.getFirstName() + " " + value.getLastName());
    }

    public Class<?> getColumnClass(int column)
    {
        switch(column)
        {
            case 0:
                return JPanel.class;

            default:    // other columns
                return String.class;
        }
    }

}