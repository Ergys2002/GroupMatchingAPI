package com.app.GroupMatching.controller;

import com.app.GroupMatching.dto.requests.AuthenticationRequest;
import com.app.GroupMatching.dto.requests.PreferencesRequest;
import com.app.GroupMatching.dto.requests.RegisterRequest;
import com.app.GroupMatching.dto.responses.AuthenticationResponse;
import com.app.GroupMatching.entities.User;
import com.app.GroupMatching.services.classes.LanguageService;
import com.app.GroupMatching.services.classes.UserService;
import com.app.GroupMatching.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save-preferences")
    public ResponseEntity<?> savePreferences(
            @RequestParam Long userId, PreferencesRequest preferencesRequest){
       return new ResponseEntity<>(
              userService.saveUserPreferences(userId,
                      preferencesRequest) , HttpStatus.OK
       );
    }
}
