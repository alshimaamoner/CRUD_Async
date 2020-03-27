
package service;
import java.util.List; 
import java.util.*;
import org.glassfish.jersey.client.ClientConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import javax.ws.rs.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.ws.rs.core.*;
import javax.ws.rs.client.*;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ws.rs.client.AsyncInvoker;
public class SampleClient {
    private static Client client = ClientBuilder.newClient();
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) {
       try{
              User user=getUser(1);
             user.setFirstName("pp");
              update(user);
             
         
       }catch(JsonProcessingException | InterruptedException|ExecutionException e){
           e.printStackTrace();
           
       }finally{
           client.close();
       }
    }
    private static void getUsers() throws InterruptedException, ExecutionException  {

         WebTarget webresource=client.target("http://localhost:9090/TestRest-1.0-SNAPSHOT/rest/employees");
        final AsyncInvoker asyncInvoker =webresource.request(MediaType.APPLICATION_JSON).async();
		 final Future<Response> responseFuture = asyncInvoker.get();
        final Response response = responseFuture.get();
		if(response.getStatus()!=200){
          throw new RuntimeException("Failed : HTTP error code :"+response.getStatus());

        }
		System.out.println("Response received : " + response);
		List<User> users= response.readEntity(new GenericType<List<User>>() {});
        System.out.println("Response get All uSER from  Server");
        users.forEach((user)->{System.out.println("id : "+user.getId()+",name : "+user.getName()+",pass :"+user.getPassword()+"first name :"+user.getFirstName()+"last name : "+user.getLastName());});
     
        }
     private static User getUser(int id) throws InterruptedException, ExecutionException  {

          WebTarget webresource=client.target("http://localhost:9090/TestRest-1.0-SNAPSHOT/rest/employees/retrieve/").path(String.valueOf(id));
        final AsyncInvoker asyncInvoker =webresource.request(MediaType.APPLICATION_JSON).async();
		 final Future<Response> responseFuture = asyncInvoker.get();
        final Response response = responseFuture.get();
		if(response.getStatus()!=200){
          throw new RuntimeException("Failed : HTTP error code :"+response.getStatus());

        }
		System.out.println("Response received : " + response);
       User employee=response.readEntity(User.class);
		System.out.println("get Specific user From Server : ");
		System.out.println("id : "+employee.getId()+",name : "+employee.getName());
         return employee;
     
        }


 private static void insertUser(User user) throws InterruptedException, ExecutionException,JsonProcessingException   {
    System.out.println(user);
       ObjectMapper objectMapper = new ObjectMapper();
       String reques =objectMapper.writeValueAsString(user);
    Response response= client
      .target("http://localhost:9090/TestRest-1.0-SNAPSHOT/rest").path("employees")
      .request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
      .post(Entity.entity(reques, MediaType.APPLICATION_JSON));
        
		System.out.println("Response received : " +response+ response.readEntity(String.class));

    System.out.println(">>> Done ");
     
	}
     private static void update(User user) throws InterruptedException, ExecutionException,JsonProcessingException  {
         ObjectMapper objectMapper = new ObjectMapper();
       String reques =objectMapper.writeValueAsString(user);
         WebTarget webresource=client.target("http://localhost:9090/TestRest-1.0-SNAPSHOT/rest").path("employees").path("user/").path(""+user.getId());
        final AsyncInvoker asyncInvoker =webresource.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).async();
		 final Future<Response> responseFuture = asyncInvoker.put(Entity.entity(user, MediaType.APPLICATION_JSON));
        final Response response = responseFuture.get();	
		System.out.println("Response received : " +response+ response.readEntity(String.class));      
        
}
}