package projectmain;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

public class RouteMangGui extends JPanel
{
    private Routes routes;    // Route data: comes from backend

    private JTable routeTable;
    private JScrollPane routesScroll;
    private JPanel routePanel;
    private JPanel buttonPanel;

    private JButton addRouteButton;
    private JButton removeRoute;
    private JButton saveRoute;

    RouteForm form;
    
    /* interface for the methods that will execute inside the form */
    public interface HandleForm {
    
        void close();
        
    }

    RouteMangGui()
    {
        super(new GridBagLayout());
 
        /* create route object */
        routes = new Routes();
        
        /* table to display route data */
        routeTable = new JTable(routes.getRoutesAsFullObject(), routes.getAllColumnTitles());
        
        /* initialize scroll */
        routesScroll = new JScrollPane(routeTable);
        
        /* initialize sub-panels */
        routePanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 6));

        buttonPanel.setBackground(new Color(103,7,78));
        
        /* initialize buttons */
        addRouteButton = new JButton("Add");
        removeRoute = new JButton("Remove");
        saveRoute = new JButton("Save changes");

        addRouteButton.addActionListener(event -> showFrom());
        
        /* add buttons to panel */
        buttonPanel.add(addRouteButton);
        buttonPanel.add(removeRoute);
        
        /* add to route table and buttons to panel */
        routePanel.add(routesScroll, BorderLayout.CENTER);
        routePanel.add(buttonPanel, BorderLayout.PAGE_END);
        
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
        constraint.insets = new Insets(0, 0, 0, 0);
        this.add(routePanel, constraint);


 
        constraint.fill = GridBagConstraints.NONE;
        constraint.anchor = GridBagConstraints.LAST_LINE_END;
        constraint.gridy = 1;
        this.add(saveRoute, constraint);
    }

    /* implements the accept behave and cancel behave */
    public class Form implements HandleForm
    {
        @Override
        public void close()
        {
            remove(form);
            routePanel.setVisible(true);
            updateUI();
        }
    }
 

    public void showFrom()
    {
        form = new RouteForm(new Form());
        GridBagConstraints constraint = new GridBagConstraints();

        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.anchor = GridBagConstraints.PAGE_START;
        constraint.gridwidth = 3;
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.weighty = 1;
        constraint.weightx = 0.5;


        routePanel.setVisible(false);

        add(form, constraint);
        updateUI();
    }
}
