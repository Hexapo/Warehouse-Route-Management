package projectmain;

import projectmain.components.*;

import projectmain.RouteMangGui.HandleForm;
import projectmain.components.Driver;
import projectmain.components.Drivers;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class AddRouteForm  extends JPanel
{
	// Components of the Form
	private TitledBorder panelTitle;

    /* driver */
	private JLabel driverLabel;
    private JComboBox driverSelect;

    /* truck */
	private JLabel truckLabel;
    private JComboBox<String> truckIDSelect;

    /* shippment */
    private JLabel shippmentLabel;
    private JList<String> shippmentSelect;

    /* confirm form button */
    private JButton addButton;

    /* cancel form button */
    private JButton cancelButton;

    /* DATA */
    private Drivers drivers;
    
    private String truckID[]
        = {"100", "101", "112", "120", "130"};

    private String shippment[]
        = {"shipmment 1-10", "shippment 11-14", "shippment 15-20", "shippment 21-26", "shippment 27-36"};
            
	AddRouteForm(HandleForm form)
    {

        drivers = new Drivers();

		setLayout(new GridBagLayout());

        /* panel title */
        panelTitle = BorderFactory.createTitledBorder("Add Route");
        this.setBorder(panelTitle);

        GridBagConstraints constraint = new GridBagConstraints();

  
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.weightx = 0.0;
        constraint.weighty = 0.0;
        constraint.ipadx = 0;
        constraint.ipady = 0;
        constraint.gridheight = 1;
        constraint.gridwidth = 2;
        constraint.insets = new Insets(12,0,0,50);


        /* __________DRIVER__________ */
        /* driver label */
		driverLabel  = new JLabel("Assign Driver:");
		driverLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        
        
        constraint.anchor = GridBagConstraints.LINE_START;
        constraint.gridwidth = 2;
        constraint.gridy = 0;
        constraint.gridx = 0;
		add(driverLabel , constraint);

        /* driver selection */









        
        driverSelect = new JComboBox();
        for (int index = 0; index < drivers.getDrivers().size(); index++) {
            
        }
        for (int index=0; index < drivers.getDrivers().size(); index++)
        {
            driverSelect.addItem(drivers.getDrivers().get(index));
            
        }

        driverSelect.setRenderer(new ComboBoxRenderer());

        driverSelect.setFont(new Font("Arial", Font.PLAIN, 15));

        constraint.anchor = GridBagConstraints.CENTER;
        constraint.ipadx = 75;
        constraint.gridy = 0;
        constraint.gridx = 2;
        add(driverSelect, constraint);

        /* ___________TRUCK___________ */
        /* truckID label */
		truckLabel  = new JLabel("Truck ID:");
		truckLabel .setFont(new Font("Dialog", Font.PLAIN, 16));
        
        constraint.anchor = GridBagConstraints.LINE_START;
        constraint.ipadx = 0;
        constraint.gridwidth = 2;
        constraint.gridy = 1;
        constraint.gridx = 0;
		add(truckLabel , constraint);
        
        /* truckID selection */
        truckIDSelect = new JComboBox<String>(truckID);
        truckIDSelect.setFont(new Font("Arial", Font.PLAIN, 15));
        
        constraint.anchor = GridBagConstraints.CENTER;
        constraint.ipadx = 75;
        constraint.gridy = 1;
        constraint.gridx = 2;
        add(truckIDSelect, constraint);
        
        /* _________SHIPPMENT_________ */
		/* shippment label */
        shippmentLabel = new JLabel("Shippment:");
        shippmentLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        constraint.anchor = GridBagConstraints.FIRST_LINE_START;
        constraint.ipadx = 0;
        constraint.gridwidth = 2;
        constraint.gridy = 2;
        constraint.gridx = 0;
        add(shippmentLabel, constraint);

        /* shippment selection */
        shippmentSelect = new JList<String>(shippment);
        shippmentSelect.setLayoutOrientation(JList.VERTICAL);
        shippmentSelect.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        constraint.anchor = GridBagConstraints.CENTER;
        constraint.ipadx = 75;
        constraint.gridy = 2;
        constraint.gridx = 2;
        add(shippmentSelect, constraint);

        /* _________ADD BUTTON_________ */
        addButton = new JButton("Add Route");
        addButton.addActionListener(event -> addRoute(form));

        constraint.anchor = GridBagConstraints.LAST_LINE_START;
        constraint.ipadx = 0;
        constraint.gridy = 3;
        constraint.gridx = 0;
        add(addButton, constraint);

        /* _________CANCEL BUTTON_________ */
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(event -> form.close(this));

        constraint.anchor = GridBagConstraints.PAGE_END;
        constraint.ipadx = 0;
        constraint.gridy = 3;
        constraint.gridx = 4;
        add(cancelButton, constraint);

		setVisible(true);

        updateUI();
	}


	public void addRoute(HandleForm form)
	{
        if(shippmentSelect.isSelectionEmpty())
        {            
            JOptionPane.showMessageDialog(null, "Cannot add route: No shippment specified.");
        }
        else
        {
            try
            {
                // System.out.println("driver select: " + ((Driver)driverSelect.getSelectedItem()).getId());
                /* post */
                // new Routes().createRoute(new Route(
                //     (Driver)driverSelect.getSelectedItem(),                      // cast object to string
                //     Integer.parseInt(truckIDSelect.getSelectedItem().toString()),   // cast object to string -> to int
                //     new ArrayList<String>(shippmentSelect.getSelectedValuesList()), // cast List<String> to ArrayList<String>
                //     "Prepare shippment")
                // );
                
            }
            catch (NumberFormatException e)
            {
                System.err.println("Truck id cannot parsed as integer number");
                e.printStackTrace();
            }

            form.close(this);
        }
	}
}

class ComboBoxRenderer extends DefaultListCellRenderer
{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        if (value instanceof Driver)
        {
            value = ((Driver)value).getFirstName() + " " + ((Driver)value).getLastName();
        }
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        return this;
    }
     
}