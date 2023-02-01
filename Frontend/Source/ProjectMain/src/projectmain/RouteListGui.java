package projectmain;


import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;



public class RouteListGui extends JPanel
{
    private Routes routes;    // Route data: comes from backend
    /* swing components */
    private javax.swing.JTable routeTable;
    private javax.swing.JScrollPane scrollPane;


    /*
    * @param pass the Dimension of parent in order to fill the space  
     */
    public RouteListGui()
    {
        super();

        routes = new Routes();

        /* Create table */
        routeTable = new JTable(new DefaultTableModel(routes.getRoutesAsObject(), routes.getColumnTitles()));

        
        routeTable.setVisible(true);
        routeTable.setEnabled(false);
        
        /* create scrollpane for the table */
        scrollPane = new JScrollPane(routeTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        routeTable.setFillsViewportHeight(true);
        // scrollPane = new JScrollPane(routeTable);


        scrollPane.setLayout(new ScrollPaneLayout());



        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);

        this.setBackground(new java.awt.Color(103,7,78));

        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addComponent(scrollPane)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(
            GroupLayout.Alignment.LEADING)
            )));

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(scrollPane));

        this.setLayout(layout);

    }

    public void updateTable()
    {
        routes.getRoutes();
        routeTable.setModel(new DefaultTableModel(routes.getRoutesAsFullObject(), routes.getAllColumnTitles()));
    }
}
