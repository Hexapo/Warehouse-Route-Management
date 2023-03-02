
package projectmain.components;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Users")
public class UsersObj 
{
   int id;
   String firstname, lastname;

   //Constructor
   public UsersObj()
   {
       this.id = id;
       this.firstname = firstname;
       this.lastname = lastname;
   }        
   
   public UsersObj(int id, String Firstname, String Lastname) 
   {
       this.id = id;
       this.firstname = Firstname;
       this.lastname = Lastname;
   }

    //Getters
    public int getId() {
        return id;
    }

    
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
   
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String Firstname) {
        this.firstname = Firstname;
    }

    public void setLastname(String Lastname) {
        this.lastname = Lastname;
    }
    
}
