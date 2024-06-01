package com.app.GroupMatching.dto.requests;

import com.app.GroupMatching.entities.Interest;
import com.app.GroupMatching.entities.Language;
import com.app.GroupMatching.entities.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


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
}
