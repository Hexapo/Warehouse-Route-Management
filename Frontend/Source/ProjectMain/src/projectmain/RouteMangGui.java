package projectmain;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout.Constraints;

import javafx.event.ActionEvent;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

public class RouteMangGui extends JPanel
{
    private Route route;    // Route data: comes from backend

    private JTable routeTable;
    private JScrollPane routesScroll;
    private JPanel routesPanel;

    private JButton addRoute;
    private JButton removeRoute;
    private JButton saveRoute;

    RouteMangGui()
    {
        super(new GridBagLayout());
 
        /* create  */
        route = new Route();

        routeTable = new JTable(route.getData(), route.getColumnTitles());

        /* initialize scroll */
        routesScroll = new JScrollPane(routeTable);

        /* initialize panel */
        routesPanel = new JPanel(new BorderLayout());
        routesPanel.add(routesScroll, BorderLayout.PAGE_START);

        /* initialize buttons */
        addRoute = new JButton("Add");
        removeRoute = new JButton("Remove");
        saveRoute = new JButton("Save changes");

        /* set color the entire panel */
        this.setBackground(new Color(103,7,78));

        /* define constraints */
        GridBagConstraints constraint = new GridBagConstraints();

        /* place route panel that holds the table */
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.anchor = GridBagConstraints.PAGE_START;
        constraint.gridwidth = 3;
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.weighty = 1;
        constraint.weightx = 0.5;
        this.add(routesPanel, constraint);

        /* place the add route button */
        constraint.fill = GridBagConstraints.NONE;
        constraint.weightx = 0.9;
        constraint.gridwidth = 1;
        constraint.gridy = 1;
        constraint.gridx = 0;

        addRoute.addActionListener(event -> addRoute());
        this.add(addRoute, constraint);

        /* place the remove route button */
        constraint.gridy = 1;
        constraint.gridx = 1;
        this.add(removeRoute, constraint);
        
        /* place the save changes button */
        constraint.anchor = GridBagConstraints.LAST_LINE_END;
        constraint.gridy = 2;
        this.add(saveRoute, constraint);
    }

    public void addRoute()
    {
        RouteForm form = new RouteForm();
        GridBagConstraints constraint = new GridBagConstraints();

        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.anchor = GridBagConstraints.PAGE_START;
        constraint.gridwidth = 3;
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.weighty = 1;
        constraint.weightx = 0.5;


        routesScroll.setVisible(false);

        this.add(form, constraint);
        this.revalidate();
    }
}
