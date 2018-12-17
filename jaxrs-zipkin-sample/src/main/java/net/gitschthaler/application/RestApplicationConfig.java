package net.gitschthaler.application;


//import brave.jaxrs2.SpanCustomizingContainerFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplicationConfig extends Application {
/*
    public Set<Object> getSingletons() {
        return new LinkedHashSet<>(Arrays.asList(
                SpanCustomizingContainerFilter.create(),
                new GreeterService(),
                new HealthService()
        ));
    }
    */
}
