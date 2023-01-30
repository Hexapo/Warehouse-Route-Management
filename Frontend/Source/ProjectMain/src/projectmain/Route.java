package projectmain;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Route
{
    private int id;
    private String driver;
    private int truckID;
    private String shippment; 
    private String status;

    Route()
    {
        this.id = -1;
        this.driver = "None";
        this.truckID = -1;
        this.shippment = "None";
        this.status = "Uknown";
    }
    Route(int id, String driver, int truckID, String shippment, String status)
    {
        this.id = id;
        this.driver = driver;
        this.truckID = truckID;
        this.shippment = shippment;
        this.status = status;
    }

    /* getters */
    public int getId()
    {
        return id;
    }

    public String getDriver()
    {
        return driver;
    }

    public int getTruckID()
    {
        return truckID;
    }

    public String getShippment()
    {
        return shippment;
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

    public void setDriver(String driver)
    {
        this.driver = driver;
    }

    public void setTruckID(int truckID)
    {
        this.truckID = truckID;
    }

    public void setShippment(String shippment)
    {
        this.shippment = shippment;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
