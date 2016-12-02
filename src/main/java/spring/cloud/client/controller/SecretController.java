package spring.cloud.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class SecretController {

    @Value("${secret}") String secret;

    @RequestMapping(value = "/secret", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<?,?> getSecret() {

        return new HashMap<String, String>(){
            {
                put("secret", secret + ". Your code: 3498");
            }
        };
    }
}