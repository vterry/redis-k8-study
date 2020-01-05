package com.sample.client.restclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${sample-server-app.listClientsUrl}")
    private String serviceUrl;

    @Value("${sample-server-app.authorizationUrl}")
    private String authorizationUrl = "http://localhost:8080/auhtorization";

    @GetMapping("/sample")
    public ResponseEntity<String> sampleRequest() {
        HttpHeaders headers = new HttpHeaders();
        String token = restTemplate.getForObject(authorizationUrl, String.class);
        headers.set("token", token);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        return restTemplate.exchange(serviceUrl, HttpMethod.GET, entity, String.class);
    }
}
