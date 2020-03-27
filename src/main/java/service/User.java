package service;
import java.io.*;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="user")
public class User{
     private int id;
     private String name;
     private String password;
     private String firstName;
     private String lastName;
    public User(){}
    public User(int id,String name,String password,String firstName,String lastName){
        this.id=id;
        this.name=name;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    
    @Override
    public String toString() {
        return "[ " + this.id + this.name + " ]";
    }
      public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    
      public String getPassword(){
        return password;
    }
      public String getFirstName(){
        return firstName;
    }
      public String getLastName(){
        return lastName;
    }
      
     public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
      public void setPassword(String password){
        this.password=password;
    }
       public void setFirstName(String firstName){
        this.firstName=firstName;
    }
      public void setLastName(String lastName){
        this.lastName=lastName;
    }
    
    
    
}