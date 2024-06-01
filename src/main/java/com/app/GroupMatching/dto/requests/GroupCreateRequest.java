package com.app.GroupMatching.dto.requests;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.List;

@Getter @Setter
public class GroupCreateRequest {
    private Long leaderId;
    private List<Long> groupLanguagesIds;
    private List<Long> groupSkillsIds;
    private List<Long> groupInterestsIds;
    private int capacity;
    private String title;
    private File logo;
}
