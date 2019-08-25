package com.mkyong.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProcessinHuman {
    public String processHuman() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://stackoverflow.com/questions/43225549/dispatcherservlet-and-web-xml-in-spring-boot", String.class);
    }
}
