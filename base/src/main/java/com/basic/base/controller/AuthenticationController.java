package com.basic.base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.base.model.AuthenticationRequest;
import com.basic.base.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register() {
        return ResponseEntity.ok();
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> authenticate() {
        
    }
    
}
