package com.app.GroupMatching.services.interfaces;

import com.app.GroupMatching.dto.requests.AuthenticationRequest;
import com.app.GroupMatching.dto.requests.RegisterRequest;
import com.app.GroupMatching.dto.responses.AuthenticationResponse;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<AuthenticationResponse> register(RegisterRequest request);

    ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request);
}
