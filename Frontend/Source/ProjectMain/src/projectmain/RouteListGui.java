package projectmain;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class RouteListGui extends JPanel
{
    String[] columnTitles = {
        "Driver",
        "Truck ID",
        "Shipping content",
        "Transportation Status"
    };

    Object[][] data = {
        {"Vasilis", new Integer(100), "Barcodes 1-10", "Ready"},
        {"Andreas", new Integer(101), "Barcodes 11-14", "Transporting..."},
        {"Tasos", new Integer(120), "Barcodes 15-20", "Shipped"},
        {"Kostas", new Integer(130), "Barcodes 21-26", "Loading Truck..."},
        {"Vaggelis", new Integer(112), "Barcodes 27-36", "Transporting..."},
    };

    /* swing components */
    private javax.swing.JTable routeTable;
    private javax.swing.JScrollPane scrollPane;



    /**
     * 
     */
    public RouteListGui()
    {
        super();

        routeTable = new JTable(data, columnTitles);
        routeTable.setVisible(true);
        
        scrollPane = new JScrollPane(routeTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        routeTable.setFillsViewportHeight(true);
        // scrollPane = new JScrollPane(routeTable);
        
        this.setBounds(0, 0, 650, 650);
        // this.setLayout(new BorderLayout());


        this.setBackground(new java.awt.Color(45, 45, 80));
        this.add(scrollPane, BorderLayout.CENTER);

        // this.setPreferredSize( new Dimension( 300, 300 ) );

        

    }
}
