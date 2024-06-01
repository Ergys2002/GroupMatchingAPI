package com.app.GroupMatching.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String name;
    private String lastname;
    private String password;
    private LocalDate birthDate;
    private String phoneNumber;
    private String position;
    private int likes;
}
