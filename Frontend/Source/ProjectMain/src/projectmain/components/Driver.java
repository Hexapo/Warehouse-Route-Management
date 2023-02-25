package projectmain.components;

public class Driver extends User
{
    Driver(String firstName, String lastName)
    {
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Driver(int id, String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    // protected Routes routes;

    // public Routes getRoutes() {
    //     return routes;
    // }

    // public void setRouteStatus(int id, String status)
    // {
    //     routes.getRoute(id).setStatus(status);
    // }
}
