package com.app.GroupMatching.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreferencesRequest {
    private List<Long> interestId;
    private List<Long> languagesId;
    private List<Long> skillsId;
}
