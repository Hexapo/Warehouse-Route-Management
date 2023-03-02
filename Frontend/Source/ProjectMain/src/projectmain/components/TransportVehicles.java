/*
=====List of all the company's transport vehicles
*/

package projectmain.components;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class TransportVehicles
{
    private ArrayList<TransportVehicle> vehicles;

    public TransportVehicles()
    {
        vehicles = new ArrayList<TransportVehicle>();
    }

    public void updateData()
    {
        System.out.println("\nparsing 'Transport Vehicles' xml file");
        File xmlFile = null;
        try
        {
            /* for windows (needs check) */
            //Frontend\\Source\\ProjectMain\\src\\projectmain\\data\\transportVehicles.xml
            xmlFile = new File("C:\\Users\\babis\\Documents\\GitHub-projects\\Java-Projects\\Frontend\\Source\\ProjectMain\\src\\projectmain\\data\\transportVehicles.xml");
            System.out.println("does the file exists(windows path): " + xmlFile.exists());
        }
        catch(NullPointerException  ex1)
        {
            try
            {
                /* for linux */
                xmlFile = new File("./Frontend/Source/ProjectMain/src/projectmain/data/transportVehicles.xml");
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
            
            vehicles.clear();

            
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            /* normilize the xml file */
            document.getDocumentElement().normalize();


            NodeList vehiclesNodeList = document.getElementsByTagName("TransportVehilce");
            
            /* read each route of the xml file */
            for (int temp = 0; temp < vehiclesNodeList.getLength(); temp++)
            {



                Node vehiclesNode = vehiclesNodeList.item(temp);

                if (vehiclesNode.getNodeType() == Node.ELEMENT_NODE)
                {

                        
                    /* driver elements */
                    Element vehiclesElement = (Element) vehiclesNode;

                    /* read the driver of the route */
                    TransportVehicle vehicle = new TransportVehicle(
                        Integer.parseInt(vehiclesElement.getAttribute("id")),
                        vehiclesElement.getElementsByTagName("licencePlate").item(0).getTextContent());
                        

                            
                            
                        /* add route into a list */
                        vehicles.add(vehicle);
                        
                        //System.out.println(vehicle.getId());
                        //System.out.println(vehicle.getLicencePlate());
                    
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
