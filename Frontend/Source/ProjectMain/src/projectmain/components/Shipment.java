package projectmain.components;

public class Shipment
{
    private int id;
    private String barcode;
    private String code; 
    private String title;
    
    Shipment(int id, String barcode, String code, String title)
    {
        this.id = id;
        this.barcode = barcode;
        this.code = code;
        this.title = title;
    }

    public int getId()
    {
        return id;
    }
    
    public String getBarcode()
    {
        return barcode;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public String getTitle()
    {
        return title;
    }
}