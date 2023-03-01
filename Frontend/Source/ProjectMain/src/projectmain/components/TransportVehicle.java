/*
=====Company's transport vehicle
*/

package projectmain.components;


public class TransportVehicle
{
    private int id;
    private String licencePlate;

    public TransportVehicle(int id, String licencePlate)
    {
        this.id = id;
        this.licencePlate = licencePlate;
    }

    public int getId()
    {
        return id;
    }

    public String getLicencePlate()
    {
        return licencePlate;
    }
}