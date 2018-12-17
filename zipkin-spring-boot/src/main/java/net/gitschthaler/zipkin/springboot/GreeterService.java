package net.gitschthaler.zipkin.springboot;

import net.gitschthaler.zipkin.springboot.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class GreeterService {

    private RestTemplate restTemplate;

    @Autowired
    public GreeterService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final Logger LOG = LoggerFactory.getLogger(GreeterService.class);

    @GetMapping("/greeter")
    @ResponseBody
    public Greeting greetViaOtherService(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        ResponseEntity<Greeting> greeterResponse = restTemplate.getForEntity("http://localhost:9090/api/greeter", Greeting.class);
        return greeterResponse.getBody();
    }
}