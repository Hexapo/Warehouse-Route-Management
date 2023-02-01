package projectmain;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Route
{
    private int id;
    private String driver;
    private int truckID;
    private ArrayList <String>shippment; 
    private String status;

    Route()
    {
        shippment = new ArrayList<String>();

        id = -1;
        driver = "None";
        truckID = -1;
        shippment.add("None");
        status = "Uknown";
    }
    Route(String driver, int truckID, ArrayList <String>shippment, String status)
    {
        this.id = -1;
        this.driver = driver;
        this.truckID = truckID;
        this.shippment = shippment;
        this.status = status;
    }
    Route(int id, String driver, int truckID, ArrayList <String>shippment, String status)
    {
        this.id = id;
        this.driver = driver;
        this.truckID = truckID;
        this.shippment = shippment;
        this.status = status;
    }
    Route(int id, String driver, int truckID, String shippment, String status)
    {
        this.shippment = new ArrayList<String>();

        this.id = id;
        this.driver = driver;
        this.truckID = truckID;
        this.shippment.add(shippment);
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

    public ArrayList<String> getShippment()
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

    public void setShippment(ArrayList <String>shippment)
    {
        this.shippment = shippment;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
