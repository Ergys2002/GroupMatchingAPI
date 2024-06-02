package com.app.GroupMatching.dto.responses;

import com.app.GroupMatching.entities.GroupLanguage;
import com.app.GroupMatching.entities.GroupMember;
import com.app.GroupMatching.entities.GroupSkill;
import com.app.GroupMatching.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponse {
    private User leader;
    private int capacity;
    private String title;
    private String description;
    private String logoURL;
    private Set<GroupMember> groupMembers;
    private Set<GroupLanguage> groupLanguages;
    private Set<GroupSkill> groupSkills;
}
