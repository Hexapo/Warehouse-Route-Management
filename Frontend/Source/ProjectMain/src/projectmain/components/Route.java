package projectmain.components;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Route
{
    private int id;
    private Driver driver;
    private TransportVehicle vehicle;
    private Shipments shipments; 
    private String status;

    public Route()
    {
        
        id = -1;
        driver = new Driver("none", "nono");
        vehicle = new TransportVehicle(-1, "not_defined");
        shipments = new Shipments();
        status = "Uknown";
    }
    Route(Driver driver, TransportVehicle vehicle, Shipments shipments, String status)
    {
        this.id = -1;
        this.driver = driver;
        this.vehicle = vehicle;
        this.shipments = shipments;
        this.status = status;
    }
    Route(int id, Driver driver, TransportVehicle vehicle, Shipments shipments, String status)
    {
        this.id = id;
        this.driver = driver;
        this.vehicle = vehicle;
        this.shipments = shipments;
        this.status = status;
    }
    Route(int id, Driver driver, TransportVehicle vehicle, String shipments, String status)
    {
        
        this.id = id;
        this.driver = driver;
        this.vehicle = vehicle;
        this.shipments = new Shipments();
        this.status = status;
    }

    /* getters */
    public int getId()
    {
        return id;
    }

    public Driver getDriver()
    {
        return driver;
    }

    public TransportVehicle getVehicle()
    {
        return vehicle;
    }

    public Shipments getShipments()
    {
        return shipments;
    }

    public String getStatus()
    {
        return status;
    }

    /* setters */
    public void setId(int id)
    {
        this.id = id;
    }

    public void setDriver(Driver driver)
    {
        this.driver = driver;
    }

    public void setTruckID(TransportVehicle vehicle)
    {
        this.vehicle = vehicle;
    }

    public void setShippment(Shipments shipments)
    {
        this.shipments = shipments;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
