package projectmain;

import projectmain.components.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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

    /* table show the data */
    private JTable routeTable;
    private JScrollPane routeScroll;

    private JPanel routePanel;
    private JPanel buttonPanel;

    private JButton addRouteButton;
    private JButton removeRouteButton;
    private JButton saveRouteButton;

    AddRouteForm addRouteForm;
    RemoveRouteFrom removeRouteFrom;
    
    /* interface for the methods that will execute inside the form */
    public interface HandleForm {
    
        void close(JPanel panel);
        
    }

    RouteMangGui()
    {
        super(new GridBagLayout());

        /* create route object */
        routes = new Routes();
        
        /* table to display route data */
        routeTable = new JTable(new DefaultTableModel(routes.getRoutesAsFullObject(), routes.getAllColumnTitles()));
        

        
        /* initialize scroll */
        routeScroll = new JScrollPane(routeTable);
        routeScroll.setLayout(new ScrollPaneLayout());
        
        /* initialize sub-panels */
        routePanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 6));

        buttonPanel.setBackground(new Color(103,7,78));
        
        /* initialize buttons */
        addRouteButton = new JButton("Add");
        removeRouteButton = new JButton("Remove");
        saveRouteButton = new JButton("Save changes");

        /* button action listeners */
        addRouteButton.addActionListener(event -> addRouteFrom());
        removeRouteButton.addActionListener(event -> removeRouteForm());
        
        /* add buttons to panel */
        buttonPanel.add(addRouteButton);
        buttonPanel.add(removeRouteButton);
        buttonPanel.add(saveRouteButton);
        
        /* add to route table and buttons to panel */
        routePanel.add(routeScroll, BorderLayout.CENTER);
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
    }

    public void updateTable()
    {
        routes.updateData();
        routeTable.setModel(new DefaultTableModel(routes.getRoutesAsFullObject(), routes.getAllColumnTitles()));
    }

    /* implements the accept behave and cancel behave */
    public class Form implements HandleForm
    {
        @Override
        public void close(JPanel panel)
        {
            remove(panel);
            updateTable();
            routePanel.setVisible(true);
            updateUI();
        }
    }
 

    public void addRouteFrom()
    {
        addRouteForm = new AddRouteForm(new Form());
        GridBagConstraints constraint = new GridBagConstraints();

        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.anchor = GridBagConstraints.PAGE_START;
        constraint.gridwidth = 3;
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.weighty = 1;
        constraint.weightx = 0.5;


        routePanel.setVisible(false);

        add(addRouteForm, constraint);
        updateUI();
    }

    public void removeRouteForm()
    {
        removeRouteFrom = new RemoveRouteFrom(routes, new Form());

        routePanel.setVisible(false);

        GridBagConstraints constraint = new GridBagConstraints();

        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.anchor = GridBagConstraints.PAGE_START;
        constraint.gridwidth = 3;
        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.weighty = 1;
        constraint.weightx = 0.5;

        add(removeRouteFrom, constraint);
        updateUI();
    }
}
