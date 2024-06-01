package com.app.GroupMatching.controller;

import com.app.GroupMatching.dto.requests.AuthenticationRequest;
import com.app.GroupMatching.dto.requests.RegisterRequest;
import com.app.GroupMatching.dto.responses.AuthenticationResponse;
import com.app.GroupMatching.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final IUserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return userService.register(request);
    }

    @PostMapping("/user/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return userService.authenticate(request);
    }
}
