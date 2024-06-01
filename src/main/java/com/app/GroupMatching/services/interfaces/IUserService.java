package com.app.GroupMatching.services.interfaces;

import com.app.GroupMatching.dto.requests.AuthenticationRequest;
import com.app.GroupMatching.dto.requests.PreferencesRequest;
import com.app.GroupMatching.dto.requests.RegisterRequest;
import com.app.GroupMatching.dto.responses.AuthenticationResponse;
import com.app.GroupMatching.entities.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    User getUserById(Long id);
    ResponseEntity<?> getUsersMatchingWithAGroupByGroupId(Long groupId);
    ResponseEntity<AuthenticationResponse> register(RegisterRequest request);
    User saveUserPreferences(Long userId, PreferencesRequest preferencesRequest);
    ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request);

    User getUserById(Long id);
}
