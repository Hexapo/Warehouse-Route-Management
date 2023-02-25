package projectmain.components;

abstract class User
{
    protected int id;
    protected String lastName;
    protected String firstName;

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
