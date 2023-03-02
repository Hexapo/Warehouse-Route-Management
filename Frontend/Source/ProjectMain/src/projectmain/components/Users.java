
package projectmain.components;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.w3c.dom.Document;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Users 
{
    
    ArrayList<UsersObj> myObjectList;
    
    public Users(){
        myObjectList = new ArrayList<UsersObj>();
    }
    
    public ArrayList<UsersObj> getUsers()
    {
        return myObjectList;
    }
    
    //Method that reads data(users) from XML file and prints them
    public void readUsers()
    {        
           
     try 
     {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(new File("C:\\Users\\babis\\Documents\\GitHub-projects\\Java-Projects\\Frontend\\Source\\ProjectMain\\src\\projectmain\\data\\Users.xml"));
      Element root = doc.getDocumentElement();

      // Get a NodeList of all elements in the document
      NodeList nodeList = doc.getElementsByTagName("User");

      // Create a list to hold the data
      //List<UsersObj> myObjectList = new ArrayList<>();

      // Loop through the elements and create objects to add to the list
      for (int i = 0; i < nodeList.getLength(); i++) 
      {
        Element element = (Element) nodeList.item(i);
        int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
        String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
        String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();

        UsersObj myObject = new UsersObj(id, firstname, lastname);
        myObjectList.add(myObject);
      }
      
      JFrame frame = new JFrame("XML Data Table");
      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create the table model
      DefaultTableModel model = new DefaultTableModel();
      model.addColumn("Id");
      model.addColumn("Firstname");
      model.addColumn("Lastname");

      // Add the data to the table model
      for (UsersObj myObject : myObjectList) {
        model.addRow(new Object[]{myObject.getId(), myObject.getFirstname(), myObject.getLastname()});
      }

      // Create the JTable with the table model
      JTable table = new JTable(model);

      // Add the table to a scroll pane
      JScrollPane scrollPane = new JScrollPane(table);

      // Add the scroll pane to the frame
      frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

      // Pack and display the frame
      frame.pack();
      frame.setVisible(true);

      // Print the data in the list
      for (UsersObj myObject : myObjectList) 
      {
        System.out.println("Id: " + myObject.getId());
        System.out.println("FirstName: " + myObject.getFirstname());
        System.out.println("Lastname: " + myObject.getLastname());
        System.out.println();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
            
  }
    
    public Object[] getColumnTitles()
    {
        Object[] columnTitles = {
            "Id",
            "FirstName",
            "LastName",
        };

        return columnTitles;
    }
    
    public Object[][] getRows()
    {
        Object Uobjects[][] = new Object[myObjectList.size()][UsersObj.class.getDeclaredFields().length]; //-1
        
        for (int i = 0; i < myObjectList.size(); i++)
        {
            Uobjects[i][1] = myObjectList.get(i).getId();
            Uobjects[i][2] = myObjectList.get(i).getFirstname();
            Uobjects[i][3] = myObjectList.get(i).getLastname();
        }    
        
        return Uobjects;
    }        

}   
    
    
    

