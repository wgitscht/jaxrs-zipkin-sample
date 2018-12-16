package net.gitschthaler.services;


import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.gitschthaler.model.Greeting;

@Path("/greeter")
public class GreeterService {
    private static final Logger logger = Logger.getLogger(GreeterService.class.getName());

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGreet() throws WebApplicationException {
        Greeting greeting = new Greeting("hi");
        return Response.status(Response.Status.CREATED).entity(greeting).build();
    }
}
