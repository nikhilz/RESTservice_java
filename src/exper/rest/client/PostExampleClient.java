package exper.rest.client;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import exper.rest.service.dataPojo;
public class PostExampleClient {
    private static final String BASE_URI = "http://localhost:8080/ws-app";
    private static final String PATH_NAME = "/PostExampleService/empInfo";
    public static void main(String[] args) throws IOException {
        Map<String, String> formDataMap = new HashMap<String, String>();
        formDataMap.put("name", "Arun");
        formDataMap.put("age", "25");
        
        Gson gsonObj = new Gson();
        String jsonStr = gsonObj.toJson(formDataMap);
      //  dataPojo dp = new dataPojo("Nikhil","25");
        ClientResponse res = post(jsonStr);
       // ClientResponse res = post(formDataMap);
        System.out.println("res status :: "+ res.getStatus());
        System.out.println("res :: "+ getResponse(res));      
    }
    /**
     * Post Method
     * @param formDataMap
     * @return
     */
    private static ClientResponse post(String dp){
  //  private static ClientResponse post( Map<String, String> formDataMap){
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource resource = client.resource(BASE_URI);
        WebResource nameResource = resource.path("rest").path(PATH_NAME);
       /* Form form = new Form();
        Iterator<String> itr = formDataMap.keySet().iterator();
        while(itr.hasNext()){
            String key = itr.next();
           form.add(key, formDataMap.get(key));
        }  */
        ClientResponse res = nameResource
                .type("application/json").post(ClientResponse.class, dp);
       // ClientResponse res = nameResource.post(ClientResponse.class, form);
        System.out.println("Client Response \n" + getClientResponse(nameResource));
        return res;
    }
    /** 
     * Returns client response
     * @param resource
     * @return
     */
    private static String getClientResponse(WebResource resource) {
        return resource.getURI().toString();
    }
    /**
     * Returns the response
     * @param res
     * @return
     * @throws IOException
     */
    private static String getResponse(ClientResponse res) throws IOException {      
        InputStream is = res.getEntityInputStream();
        byte[] b = new byte[20000];
        is.read(b);
        return new String(b);
    }
}