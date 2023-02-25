package projectmain.components;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Shipments
{
    private ArrayList<Shipment> shipmentList; 
    
    Shipments()
    {
        shipmentList = new ArrayList<Shipment>();
    }

    public ArrayList<Shipment> getShipmentList()
    {
        return shipmentList;
    }

    public Object[] getShipmentColumns()
    {
        Object[] shipmentColumns = new Object[Shipment.class.getDeclaredFields().length];

        shipmentColumns[0] = "id";
        shipmentColumns[1] = "Barcode";
        shipmentColumns[2] = "Code";
        shipmentColumns[3] = "Title";

        return shipmentColumns;
    }

    /* all route data */
    public Object[][] getShipmentRows()
    {
        /* "Route.class.getDeclaredFields().length" -> returns the number of atributes of Route class */
        Object object[][] = new Object[shipmentList.size()][Shipment.class.getDeclaredFields().length];


        for (int i = 0; i < shipmentList.size(); i++) {
            
            object[i][0] = shipmentList.get(i).getId(); 
            object[i][1] = shipmentList.get(i).getBarcode();
            object[i][2] = shipmentList.get(i).getCode(); 
            object[i][3] = shipmentList.get(i).getTitle(); 
        }

        return object;
    }


    public void UpdateData()
    {
        File xmlFile = null;
        try
        {
            /* for windows (needs check) */
            xmlFile = new File("Frontend\\Source\\ProjectMain\\src\\projectmain\\data\\shipments.xml");
            System.out.println("does the file exists(windows path): " + xmlFile.exists());
        }
        catch(NullPointerException  ex1)
        {
            try
            {
                /* for linux */
                xmlFile = new File("./Frontend/Source/ProjectMain/src/projectmain/data/shipments.xml");
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
            System.out.println("parsing xml file");
            shipmentList.clear();

            
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            /* normilize the xml file */
            document.getDocumentElement().normalize();


            NodeList shippmentNodeList = document.getElementsByTagName("Shippment");
            
            /* read each route of the xml file */
            for (int temp = 0; temp < shippmentNodeList.getLength(); temp++)
            {



                Node shippmentNode = shippmentNodeList.item(temp);

                if (shippmentNode.getNodeType() == Node.ELEMENT_NODE)
                {

                        
                    /* driver elements */
                    Element shippmentElement = (Element) shippmentNode;

                    /* read the driver of the route */
                    Shipment shipment = new Shipment(
                        Integer.parseInt(shippmentElement.getAttribute("id")),
                        shippmentElement.getElementsByTagName("barcode").item(0).getTextContent(),
                        shippmentElement.getElementsByTagName("code").item(0).getTextContent(),
                        shippmentElement.getElementsByTagName("title").item(0).getTextContent());
                        

                            
                            
                        /* add route into a list */
                        shipmentList.add(shipment);
    
                        System.out.println(shipment.getId());
                        System.out.println(shipment.getBarcode());
                        System.out.println(shipment.getCode());
                        System.out.println(shipment.getTitle());
                    
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
