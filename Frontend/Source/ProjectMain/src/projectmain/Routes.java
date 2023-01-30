package projectmain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;



public class Routes
{
    private ArrayList <Route>routeList;

    /* OLD SOLUTION */
    private Object[] columnTitles;
    private Object[] allColumnTitles;


    Routes()
    {
        try
        {
            routeList = new ArrayList<Route>();
            /* for windows (needs check) */
            // File xmlFile = new File("Frontend\\Source\\ProjectMain\\src\\projectmain\\data.xml");
            
            /* for linux */
            File xmlFile = new File("./Frontend/Source/ProjectMain/src/projectmain/data.xml");
            

            System.out.println("does the file exists: " + xmlFile.exists());
            
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            /* normilize the xml file */
            document.getDocumentElement().normalize();



            NodeList nList = document.getElementsByTagName("Route");
            
            /* read the lines of the xml file */
            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node node = nList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE)
                {

                    Element Element = (Element) node;

                    /* create a new route */
                    Route route = new Route(
                        Integer.parseInt(Element.getElementsByTagName("id").item(0).getTextContent()),
                        Element.getElementsByTagName("driver").item(0).getTextContent(),
                        Integer.parseInt(Element.getElementsByTagName("truckID").item(0).getTextContent()),
                        Element.getElementsByTagName("shippment").item(0).getTextContent(),
                        Element.getElementsByTagName("status").item(0).getTextContent()
                        );

                    /* add route into a list */
                    routeList.add(route);
                }
            }
        }
        catch (ParserConfigurationException e)
        {
            System.err.println("parser exception");
            e.printStackTrace();
        }
        catch(NullPointerException  e)
        {
            System.err.println("file not found");
            e.printStackTrace();
        }
        catch(SAXException e)
        {
            System.err.println("SAX exception");
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.err.println("IO exception");
            e.printStackTrace();
        }

        /* OLD SOLUTION */
        Object[] fetchColumnTitles = {
            "Driver",
            "Truck ID",
            "Shipping content",
            "Transportation Status"
        };

        Object[] fetchAllColumnTitles = {
            "id",
            "Driver",
            "Truck ID",
            "Shipping content",
            "Transportation Status"
        };

        columnTitles = fetchColumnTitles;
        allColumnTitles = fetchAllColumnTitles;
    }
    public Object[] getColumnTitles()
    {
        return columnTitles;
    }

    
    public Object[][] getRoutesAsObject()
    {
        Object object[][] = new Object[routeList.size()][Route.class.getDeclaredFields().length - 1];
        
        for (int i = 0; i < routeList.size(); i++) {
            
            object[i][0] = routeList.get(i).getDriver(); 
            object[i][1] = routeList.get(i).getTruckID(); 
            object[i][2] = routeList.get(i).getShippment(); 
            object[i][3] = routeList.get(i).getStatus();
        }
        
        return object;
    }

    public Object[] getAllColumnTitles()
    {
        return allColumnTitles;
    }

    public Object[][] getRoutesAsFullObject()
    {
        /* "Route.class.getDeclaredFields().length" -> returns the number of atributes of Route class */
        Object object[][] = new Object[routeList.size()][Route.class.getDeclaredFields().length];


        for (int i = 0; i < routeList.size(); i++) {
            
            object[i][0] = routeList.get(i).getId(); 
            object[i][1] = routeList.get(i).getDriver(); 
            object[i][2] = routeList.get(i).getTruckID(); 
            object[i][3] = routeList.get(i).getShippment(); 
            object[i][4] = routeList.get(i).getStatus();
        }

        return object;
    }
}
