package projectmain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



public class Routes
{
    private ArrayList <Route>routeList;



    Routes()
    {
        routeList = new ArrayList<Route>();
        getRoutes();
    }


    public Object[] getColumnTitles()
    {
        Object[] columnTitles = {
            "Driver",
            "Truck ID",
            "Shipping content",
            "Transportation Status"
        };

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
        Object[] allColumnTitles = {
            "id",
            "Driver",
            "Truck ID",
            "Shipping content",
            "Transportation Status"
        };

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

    public void getRoutes()
    {
        try
        {
            System.out.println("parsing xml file");
            routeList.clear();
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

                    /* read a new route */
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
    }

    public void createRoute(Route route)
    {
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.newDocument();

            document.normalize();

            Element routeData = document.createElement("Route");

            Element id = document.createElement("id");
            Element driver = document.createElement("driver");
            Element truckID = document.createElement("truckID");
            Element shippment = document.createElement("shippment");
            Element status = document.createElement("status");

            id.appendChild(document.createTextNode(String.valueOf(route.getId())));
            driver.appendChild(document.createTextNode(route.getDriver()));
            truckID.appendChild(document.createTextNode(String.valueOf(route.getTruckID())));
            shippment.appendChild(document.createTextNode(route.getShippment().get(0)));
            status.appendChild(document.createTextNode(route.getStatus()));

            routeData.appendChild(id);
            routeData.appendChild(driver);
            routeData.appendChild(truckID);
            routeData.appendChild(shippment);
            routeData.appendChild(status);
            
            document.appendChild(routeData);


            TransformerFactory transformerFactory  = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            /* nice look on terminal */
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(document);

            /* console -> create request on api */
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);
        }
        catch (ParserConfigurationException e)
        {
            System.err.println("parser exception");
            e.printStackTrace();
        }
        catch(TransformerException e)
        {
            System.err.println("IO exception");
            e.printStackTrace();
        }
    }

    public void deleteRoutes(ArrayList <Route>routeList)
    {
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.newDocument();

            document.normalize();

            
            Element root = document.createElement("Routes");
            
            for(int i = 0; i < routeList.size(); i++)
            {
                Element route = document.createElement("Route");
                Element id = document.createElement("id");

                id.appendChild(document.createTextNode(String.valueOf(routeList.get(i).getId())));
    
                route.appendChild(id);
                
                root.appendChild(route);
                
            }
            
            document.appendChild(root);


            TransformerFactory transformerFactory  = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            /* nice look on terminal */
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(document);

            /* console -> create request on api */
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);
        }
        catch (ParserConfigurationException e)
        {
            System.err.println("parser exception");
            e.printStackTrace();
        }
        catch(TransformerException e)
        {
            System.err.println("IO exception");
            e.printStackTrace();
        }
    }
}
