# Zipkin example for JAX Instrumentation
A very simple JAX-RS sample application that implements a service and reports to a zipkin server.
This example is self contained and runs on the embedded tomcat server. To see the actual zipkin messages
start a zipkin server via docker.

Deployment
----

To start simply run:

```mvn clean install tomcat7:run```

to run the zipkin server:
```docker run -p 9411:9411 openzipkin/zipkin``

now go to to
http://localhost:9090/api/health
and
http://localhost:9090/api/greeter
to create some traces.

and check if you see the traces on:
http://localhost:9411/zipkin/