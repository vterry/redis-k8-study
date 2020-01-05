package com.sample.sampleredis.sampleredis.controller;

import com.sample.sampleredis.sampleredis.util.UtilAuthorization;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @GetMapping("/auhtorization")
    public ResponseEntity<String> getAuthorization() {
        return ResponseEntity.ok().body(UtilAuthorization.requestAuthorization());
    }

}
