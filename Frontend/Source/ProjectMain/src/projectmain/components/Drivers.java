/*
=====List of all drivers of the company
*/


package projectmain.components;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.*;



public class Drivers
{
    private ArrayList<Driver> drivers;

    public Drivers()
    {
        drivers = new ArrayList<Driver>();
        updateData();
    }
    
    public ArrayList<Driver> getDrivers()
    {
        return drivers;
    }

    public void updateData()
    {
        System.out.println("\nparsing 'Drivers' xml file");
        File xmlFile = null;
        try
        {
            /* for windows (needs check) */
            xmlFile = new File("Frontend\\Source\\ProjectMain\\src\\projectmain\\data\\drivers.xml");
            System.out.println("does the file exists(windows path): " + xmlFile.exists());
        }
        catch(NullPointerException  ex1)
        {
            try
            {
                /* for linux */
                xmlFile = new File("./Frontend/Source/ProjectMain/src/projectmain/data/drivers.xml");
                System.out.println("does the file exists(linux path): " + xmlFile.exists());
            }
            catch(NullPointerException  ex2)
            {
                System.err.println("file not found");
                ex2.printStackTrace();
            }
        }


        try
        {
            
            drivers.clear();

            
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            /* normilize the xml file */
            document.getDocumentElement().normalize();


            NodeList driverNodeList = document.getElementsByTagName("Driver");
            
            /* read each route of the xml file */
            for (int temp = 0; temp < driverNodeList.getLength(); temp++)
            {



                Node driverNode = driverNodeList.item(temp);

                if (driverNode.getNodeType() == Node.ELEMENT_NODE)
                {

                        
                    /* driver elements */
                    Element driverElement = (Element) driverNode;

                    /* read the driver of the route */
                    Driver driver = new Driver(
                        Integer.parseInt(driverElement.getAttribute("id")),
                        driverElement.getElementsByTagName("firstName").item(0).getTextContent(),
                        driverElement.getElementsByTagName("lastName").item(0).getTextContent());
                        

                            
                            
                        /* add route into a list */
                        drivers.add(driver);
                        
                        //System.out.println(driver.getId());
                        //System.out.println(driver.getFirstName());
                        //System.out.println(driver.getLastName());
                    
                }
            }
        }
        catch (ParserConfigurationException e)
        {
            System.err.println("parser exception");
            e.printStackTrace();
        }
        catch(SAXException e)
        {
            System.err.println("SAX exception");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.err.println("IO exception");
            e.printStackTrace();
        }
    }
}


class Item
{
    private int index;
    private String value;

    Item(String value, int index)
    {
        this.value = value;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }
}