package com.app.GroupMatching.dto.requests;

import com.app.GroupMatching.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupMemberRequest {
    private Long userId;
    private Long groupId;
}
