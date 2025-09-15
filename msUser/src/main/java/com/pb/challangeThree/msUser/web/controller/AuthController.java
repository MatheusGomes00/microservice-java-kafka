package com.pb.challangeThree.msUser.web.controller;

import com.pb.challangeThree.msUser.security.AuthenticationService;
import com.pb.challangeThree.msUser.web.dto.AuthRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/api/auth")
    public String authenticate(@RequestBody AuthRequest authRequest) {
        return authenticationService.authenticate(authRequest.getUsername(), authRequest.getPassword());
    }

}
