package projectmain;

import projectmain.components.*;

import projectmain.RouteMangGui.HandleForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class RemoveRouteFrom extends JPanel
{
    private Routes routes;

    private TitledBorder panelTitle;
    
    /* represent table */
    DefaultTableModel model;
    private JTable routesTable;
    private JScrollPane scrollPane;

    /* panel for buttons */
    private JPanel buttonPanel;

    /* Buttons */
    private JButton removeRouteButton;
    private JButton cancelButton;


    RemoveRouteFrom(Routes routes, HandleForm form)
    {
        super(new BorderLayout());
        this.routes = routes;

        /* panel title */
        panelTitle = BorderFactory.createTitledBorder("Remove Route");
        this.setBorder(panelTitle);
        
        /* set model for the table */
        model = new DefaultTableModel(tableData(), tableColumns()) // set model with boolean type on the first column
        {
            public Class<?> getColumnClass(int column)
            {
                switch(column)
                {
                    case 0:     // first column. recognize boolean and turn first column into check box
                        return Boolean.class;
                    // case 1:     // second column. With this definition is avoided the cast in removeRoute method
                    //     return Integer.class;
                    default:    // other columns
                        return String.class;
                }
            }
        };

        /* set up table */
        routesTable = new JTable(model)
        {	/* disable column from editing except selection column */
            public boolean isCellEditable(int row, int column)
            {
                if (column == 0)
                {
                    return true;
                }
                return false;
            }
        };
        

        /* add table to scrollpane */
        scrollPane = new JScrollPane(routesTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);

        /* panel for the buttons */
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 6));
        buttonPanel.setBackground(new Color(103,7,78));

        /* initialize buttons */
        removeRouteButton = new JButton("Remove selected routes");
        cancelButton = new JButton("Cancel");

        /* button action listeners */
        removeRouteButton.addActionListener((event) -> removeRoute(form));
        cancelButton.addActionListener((event) -> form.close(this));

        /* add buttons in button panel */
        buttonPanel.add(removeRouteButton);
        buttonPanel.add(cancelButton);

        /* add button panel to form */
        add(buttonPanel, BorderLayout.PAGE_END);
    }


    private Object[] tableColumns()
    {
        /* columns with extra field for the checkbox */
        Object[] columns  = new Object[routes.getAllColumnTitles().length+1];

        columns[0] = "Select";      // First column name

        for (int label = 1; label < columns.length; label++)        // The rest labels will be the same
        {
            columns[label] = routes.getAllColumnTitles()[label-1];
        }

        return columns;
    }

    private Object[][] tableData()
    {
        Object [][] data = new Object[routes.getRoutesAsFullObject().length][tableColumns().length];

        for (int row = 0; row < routes.getRoutesAsFullObject().length; row++)
        {
            data[row][0] = false;

            for(int column = 1; column < tableColumns().length; column++)
            {
                data[row][column] = routes.getRoutesAsFullObject()[row][column-1]; 
            }
        }

        return data;
    }


    private void removeRoute(HandleForm form)
    {
        ArrayList <Route>selectedRoutes = new ArrayList<Route>();

        /* Search table for the selected rows */
        for (int index = 0; index < routesTable.getRowCount(); index++)
        {
            if((Boolean)routesTable.getValueAt(index, 0))
            {
                Route route = new Route();
                route.setId((int)routesTable.getValueAt(index, 1));

                selectedRoutes.add(route);


                System.out.println(selectedRoutes.get(selectedRoutes.size()-1).getId());

            }  
        }
        if(selectedRoutes.size() > 0)
        {
            routes.deleteRoutes(selectedRoutes);
            form.close(this);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No Routes Selected.");
        }

    }
}
