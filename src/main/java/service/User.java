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
      public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    
      public String getPas(){
        return password;
    }
      public String getfirstName(){
        return firstName;
    }
      public String getlastName(){
        return lastName;
    }
      
     public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
      public void setPas(String password){
        this.password=password;
    }
       public void setfirstName(String firstName){
        this.firstName=firstName;
    }
      public void setlastName(String lastName){
        this.lastName=lastName;
    }
    
    
    
}