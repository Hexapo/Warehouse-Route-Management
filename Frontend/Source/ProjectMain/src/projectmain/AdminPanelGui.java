
package projectmain;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;
import projectmain.components.Users;



public class AdminPanelGui extends JPanel
{
    private Users users;    // Route data: comes from backend
    /* swing components */
    private javax.swing.JTable usersTable;
    private javax.swing.JDialog shipmentDialoge;
    private javax.swing.JTable shipmentTable;
    private javax.swing.JScrollPane routeScrollPane;
    private javax.swing.JScrollPane shipmentscrollPane;
    
    
    public AdminPanelGui()
    {
       super(new BorderLayout());

        users = new Users();

        /* Create route table */
        usersTable = new JTable(new DefaultTableModel(users.getRows(), users.getColumnTitles()));
        usersTable.setEnabled(false); 
        
        routeScrollPane = new JScrollPane(usersTable);
        routeScrollPane.setLayout(new ScrollPaneLayout());
        
         add(routeScrollPane, BorderLayout.CENTER);
        

        this.setBackground(new java.awt.Color(103,7,78));

        revalidate();
        
    }
    
   
    
    
}
