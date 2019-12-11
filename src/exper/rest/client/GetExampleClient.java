package exper.rest.client;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class GetExampleClient {
    public static final String BASE_URI = "http://localhost:8080/ws-app";
    public static final String PATH_NAME = "/GetExampleService/name/";
    public static final String PATH_ADDRESS = "/GetExampleService/address/";
    public static void main(String[] args) {
        String name = "Arun";
        String address = "Mumbai";
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource resource = client.resource(BASE_URI);
        WebResource nameResource = resource.path("rest").path(PATH_NAME + name);
        System.out.println("Client Response \n" + getClientResponse(nameResource));
        System.out.println("Response \n" + getResponse(nameResource) + "\n\n");
        WebResource ageResource = resource.path("rest").path(PATH_ADDRESS + address);
        System.out.println("Client Response \n" + getClientResponse(ageResource));
        System.out.println("Response \n" + getResponse(ageResource));
    }
    /**
     * Returns client response as:- GET http://localhost:8083/Restful-web-service/rest/GetExampleService/name/Arun
     * @param service
     * @return
     */
    private static String getClientResponse(WebResource resource) {
        return resource.accept(MediaType.TEXT_HTML).get(ClientResponse.class).toString();
    }
    /**
     * Returns the response as HTML
     * @param service
     * @return
     */
    private static String getResponse(WebResource resource) {
        return resource.accept(MediaType.TEXT_HTML).get(String.class);
    }
}