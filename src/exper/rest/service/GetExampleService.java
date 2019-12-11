package exper.rest.service;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//@Path here Identifies the URI path that a resource class will serve requests for.
@Path("GetExampleService")
public class GetExampleService {
    //To process HTTP GET requests.
    @GET
    //@Path Identifies the URI path that a resource class will serve requests for.
    @Path("/name/{nm}")
    //@Produces defines the media type(s) that the methods of a resource class can produce.
    @Produces(MediaType.TEXT_HTML)
    //@PathParam injects the value of URI parameter that defined in @Path expression, into the method
    public String userName(@PathParam("nm") String name) {
        return "<html><body>" + "<Name>" + name + "</Name>" + "</body></html>";
    }
    //To process HTTP GET requests.
    @GET
    //@Path Identifies the URI path that a resource class will serve requests for.
    @Path("/address/{ad}")
    //@Produces defines the media type(s) that the methods of a resource class can produce.
    @Produces(MediaType.TEXT_HTML)
    //@PathParam injects the value of URI parameter that defined in @Path expression, into the method
    public String userAge(@PathParam("ad") String address) {
        return "<html><body>" + "<Address>" + address + "</Address>" + "</body></html>";
    }
}