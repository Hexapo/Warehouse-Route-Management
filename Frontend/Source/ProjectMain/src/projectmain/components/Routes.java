package projectmain.components;

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
    private ArrayList<Route> routeList;

    public Routes()
    {
        routeList = new ArrayList<Route>();
        updateData();
    }

    public ArrayList<Route> getRoutes()
    {
        return routeList;
    }

    /* simple route columns */
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


    /* simple route data */
    public Object[][] getRoutesAsObject()
    {
        Object object[][] = new Object[routeList.size()][Route.class.getDeclaredFields().length - 1];
        
        for (int i = 0; i < routeList.size(); i++) {
            
            object[i][0] = routeList.get(i).getDriver().getFirstName() + " " + routeList.get(i).getDriver().getLastName(); 
            object[i][1] = routeList.get(i).getVehicle().getLicencePlate(); 
            object[i][2] = routeList.get(i).getShipments(); 
            object[i][3] = routeList.get(i).getStatus();
        }
        
        return object;
    }

    /* all route columns  */
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

    /* all route data */
    public Object[][] getRoutesAsFullObject()
    {
        /* "Route.class.getDeclaredFields().length" -> returns the number of atributes of Route class */
        Object object[][] = new Object[routeList.size()][Route.class.getDeclaredFields().length];


        for (int i = 0; i < routeList.size(); i++) {
            
            object[i][0] = routeList.get(i).getId(); 
            object[i][1] = routeList.get(i).getDriver().getFirstName() + " " + routeList.get(i).getDriver().getLastName(); 
            object[i][2] = routeList.get(i).getVehicle().getLicencePlate(); 
            object[i][3] = routeList.get(i).getShipments(); 
            object[i][4] = routeList.get(i).getStatus();
        }

        return object;
    }

    public void updateData()
    {
        System.out.println("\nparsing 'Routes' xml file");
        /* _________________get data_________________ */
        File xmlFile = null;
        try
        {
            /* for windows (needs check) */
            //Frontend\\Source\\ProjectMain\\src\\projectmain\\data\\routes.xml
            xmlFile = new File("C:\\Users\\babis\\Documents\\GitHub-projects\\Java-Projects\\Frontend\\Source\\ProjectMain\\src\\projectmain\\data\\routes.xml");
            System.out.println("does the file exists(windows path): " + xmlFile.exists());
        }
        catch(NullPointerException  ex1)
        {
            try
            {
                /* for linux */
                xmlFile = new File("./Frontend/Source/ProjectMain/src/projectmain/data/routes.xml");
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
            
            routeList.clear();

        
            
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            /* normilize the xml file */
            document.getDocumentElement().normalize();

            /* ___________________EACH NODES LIST___________________ */
            /* Route node */
            NodeList routeNodeList = document.getElementsByTagName("Route");

            /* Driver node */
            NodeList driverNodeList = document.getElementsByTagName("Driver");
          
            /* TransportingVehicle node */
            NodeList vehicleNodeList = document.getElementsByTagName("TransportVehicle");
            
            /* Shipments node */
            NodeList shipmentsNodeList = document.getElementsByTagName("Shipments");
            
            /* 
             * isolate each route from the list
             * read and store the elements
            */
            for (int nodeIndex = 0; nodeIndex < routeNodeList.getLength(); nodeIndex++)
            {

                /* for route structure */
                Node routeNode = routeNodeList.item(nodeIndex);

                /* for driver object */
                Node driverNode = driverNodeList.item(nodeIndex);

                /* for vehicle object */
                Node vehicleNode = vehicleNodeList.item(nodeIndex);
                
                /* for shipments object */
                Node shipmentsNode = shipmentsNodeList.item(nodeIndex);
                
                if (routeNode.getNodeType() == Node.ELEMENT_NODE)
                {

                    /* route elements */
                    Element routeElement = (Element) routeNode;

                    /* driver elements */
                    Element driverElement = (Element) driverNode;
                    
                    /* vehicle elements */
                    Element vehicleElement = (Element) vehicleNode;
                    
                    
                

                    /* ______________________Parsing data______________________ */

                    /* parse the driver of the route */
                    Driver driver = new Driver(
                        Integer.parseInt(driverElement.getAttribute("id")),
                        driverElement.getElementsByTagName("firstName").item(0).getTextContent(),
                        driverElement.getElementsByTagName("lastName").item(0).getTextContent());

                    


                    /* parse the shipments of the route */
                    Shipments shipments = new Shipments();
                    /*  
                     * isolate each shipment from shipments list
                     * for each shipments node get the shipment childrens
                    */
                    for (int shipNode = 0; shipNode < shipmentsNode.getChildNodes().getLength(); shipNode++)
                    {
                        /* for shipment object */
                        Node shipmentNode = shipmentsNode.getChildNodes().item(shipNode);

                        if (shipmentNode.getNodeType() == Node.ELEMENT_NODE)
                        {
                            /* shipment elements */
                            Element shipmentElement = (Element) shipmentNode;

                            Shipment shipment = new Shipment(
                                Integer.parseInt(shipmentElement.getAttribute("id")),
                                shipmentElement.getElementsByTagName("barcode").item(0).getTextContent(),
                                shipmentElement.getElementsByTagName("code").item(0).getTextContent(),
                                shipmentElement.getElementsByTagName("title").item(0).getTextContent());
                            
                            shipments.getShipmentList().add(shipment);
                        }
                    }



                    /* parse the transportationVehicle of the route */
                    TransportVehicle vehicle = new TransportVehicle(
                        Integer.parseInt(vehicleElement.getAttribute("id")),
                        vehicleElement.getElementsByTagName("licencePlate").item(0).getTextContent()
                        );
                        


                    /* parse the route */
                    Route route = new Route(
                        Integer.parseInt(routeElement.getAttribute("id")),
                        driver,
                        vehicle,
                        shipments,
                        routeElement.getElementsByTagName("status").item(0).getTextContent()
                        );
                        
                        
                    /* add route into a list */
                    routeList.add(route);
                    //displayRoutes();
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

    public void createRoute(Route route)
    {
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.newDocument();

            document.normalize();

            /* route node object */
            Element routeData = document.createElement("Route");
            Element routeId = document.createElement("id");


            /* driver node object */
            Element driverData = document.createElement("driver");

            Element driverId = document.createElement("id");
            Element driverFirstName = document.createElement("firstName");
            Element driverLastName = document.createElement("lastName");


            Element vehicle = document.createElement("TransportVehicle");
            Element shippment = document.createElement("shippment");
            Element status = document.createElement("status");

            routeId.appendChild(document.createTextNode(String.valueOf(route.getId())));
            vehicle.appendChild(document.createTextNode(String.valueOf(route.getVehicle().getId())));
            shippment.appendChild(document.createTextNode(String.valueOf(route.getShipments().getShipmentList().get(0).getId())));
            status.appendChild(document.createTextNode(route.getStatus()));

            /* driver attributes */
            driverId.appendChild(document.createTextNode(String.valueOf(route.getDriver().getId())));
            driverFirstName.appendChild(document.createTextNode(String.valueOf(route.getDriver().getFirstName())));
            driverLastName.appendChild(document.createTextNode(String.valueOf(route.getDriver().getLastName())));

            /* add attributes to driver element */
            driverData.appendChild(driverId);
            driverData.appendChild(driverFirstName);
            driverData.appendChild(driverLastName);

            /* add attributs to route element */
            routeData.appendChild(routeId);
            routeData.appendChild(driverData);
            routeData.appendChild(vehicle);
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



    /* methods for debugging */
    public void displayRoutes()
    {
        for (Route route : routeList) {
            System.out.println(
                "id: " + route.getId() +
                "\ndriver id:" + route.getDriver().getId() +
                "\n\tdriver first name: " + route.getDriver().getFirstName() +
                "\n\tdriver last name: " + route.getDriver().getLastName() +
                "\nvehicle " + route.getVehicle().getLicencePlate() +
                "\nshipments: "
            );
            for (Shipment shipment : route.getShipments().getShipmentList())
            {
                System.out.println(
                    "\nshipment id: " + shipment.getId() +
                    "\n\tbarcode: " + shipment.getBarcode() +
                    "\n\tcode: " + shipment.getCode() +
                    "\n\ttitle: " + shipment.getTitle()
                );
            }
            System.out.println(
                "vehicle: " + route.getVehicle().getLicencePlate() +
                "\nstatus: " + route.getStatus()
            );
        }
    }
}
