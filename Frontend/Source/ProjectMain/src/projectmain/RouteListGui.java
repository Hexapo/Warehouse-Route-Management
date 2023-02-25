package projectmain;

import projectmain.components.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;



public class RouteListGui extends JPanel
{
    private Routes routes;    // Route data: comes from backend
    /* swing components */
    private javax.swing.JTable routeTable;
    private javax.swing.JDialog shipmentDialoge;
    private javax.swing.JTable shipmentTable;
    private javax.swing.JScrollPane routeScrollPane;
    private javax.swing.JScrollPane shipmentscrollPane;


    /*
    * @param pass the Dimension of parent in order to fill the space  
     */
    public RouteListGui()
    {
        super(new BorderLayout());

        routes = new Routes();

        /* Create route table */
        routeTable = new JTable(new DefaultTableModel(routes.getRoutesAsObject(), routes.getColumnTitles()));
        routeTable.setEnabled(false);
        
        /* create scrollpane for the table */
        routeScrollPane = new JScrollPane(routeTable);
        routeScrollPane.setLayout(new ScrollPaneLayout());
 


        add(routeScrollPane, BorderLayout.CENTER);
        

        this.setBackground(new java.awt.Color(103,7,78));

        revalidate();

        TransportVehicles vehicles = new TransportVehicles();
        vehicles.updateData();
    }

    public void updateTable()
    {
        routes.updateData();
        routeTable.setModel(new DefaultTableModel(routes.getRoutesAsObject(), routes.getColumnTitles()));
    }
}


