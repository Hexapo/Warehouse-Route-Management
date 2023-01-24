package projectmain;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class RouteForm  extends JPanel
{
	// Components of the Form
	private TitledBorder panelTitle;

	private JLabel driverLabel;
    private JComboBox<String> driverSelect;

	private JLabel truckLabel;
    private JComboBox<String> truckIDSelect;

    private JLabel shippmentLabel;
    private JList<String> shippmentSelect;


    /* DATA */
    private String driver[]
        = { "Vasilis", "Andreas", "Tasos", "Kostas",
        "Vaggelis", "Xrhstos"};
    
    private String truckID[]
        = {"100", "101", "112", "120", "130"};

    private String shippment[]
        = {"shipmment 1-10", "shippment 11-14", "shippment 15-20", "shippment 21-26", "shippment 27-36"};
            
	RouteForm()
    {
		setLayout(new GridBagLayout());

        /* panel title */
        panelTitle = BorderFactory.createTitledBorder("Add Route");
        this.setBorder(panelTitle);

        GridBagConstraints constraint = new GridBagConstraints();

  
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.weightx = 1;
        constraint.weighty = 1;
        // constraint.gridwidth = 2;
        constraint.weighty = 0.5;
        constraint.ipady = 8;


        constraint.fill = GridBagConstraints.BOTH;
        constraint.anchor = GridBagConstraints.CENTER;
        constraint.gridwidth = 1;
        
        /* driver label */
		driverLabel  = new JLabel("Assign Driver:");
		driverLabel .setFont(new Font("Dialog", Font.PLAIN, 16));
        
        constraint.gridy = 1;
        constraint.gridx = 0;
		add(driverLabel , constraint);

        /* driver selection */
        driverSelect = new JComboBox<String>(driver);
        driverSelect.setFont(new Font("Arial", Font.PLAIN, 15));

        constraint.gridy = 1;
        constraint.gridx = 1;
        add(driverSelect, constraint);

        /* truckID label */
		truckLabel  = new JLabel("Truck ID:");
		truckLabel .setFont(new Font("Dialog", Font.PLAIN, 16));
        
     
        constraint.gridy = 1;
        constraint.gridx = 2;
		add(truckLabel , constraint);

        /* truckID selection */
        truckIDSelect = new JComboBox<String>(truckID);
        truckIDSelect.setFont(new Font("Arial", Font.PLAIN, 15));

        constraint.gridy = 1;
        constraint.gridx = 3;
        add(truckIDSelect, constraint);

		/* shippment label */
        shippmentLabel = new JLabel("Shippment:");
        shippmentLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        constraint.gridy = 2;
        constraint.gridx = 0;
        add(shippmentLabel, constraint);

        /* shippment selection */
        shippmentSelect = new JList<String>(shippment);
        shippmentSelect.setLayoutOrientation(JList.VERTICAL);
        shippmentSelect.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        constraint.gridheight = 2;
        constraint.gridy = 2;
        constraint.gridx = 1;
        add(shippmentSelect, constraint);

		setVisible(true);
        updateUI();
	}


	public void actionPerformed(ActionEvent e)
	{
		
	}
}

