package spring.cloud.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RefreshScope
public class SecretController {

    @Value("${wordConfig.theLucky}") private String theLucky;
    @Value("${secret}") private String secret;

    @RequestMapping(value = "/secret", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<?,?> getSecret() {

        return new HashMap<String, String>(){
            {
                put("secret", secret + ". Your code: 3498");
            }
        };
    }

    @RequestMapping(value = "/lucky", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<?,?> getLucky() {

        return new HashMap<String, String>(){
            {
                put("lucky", theLucky);
            }
        };
    }
}