package net.gitschthaler.services;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Provides a simple health.
 *
 */
@Path("/health")
public class HealthService {

    @Produces({ MediaType.TEXT_PLAIN })
    @GET
	public Response isAlive() {
		return Response.ok("OK").build();
	}
}