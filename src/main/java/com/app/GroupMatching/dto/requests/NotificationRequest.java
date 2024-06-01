package com.app.GroupMatching.dto.requests;

import com.app.GroupMatching.entities.User;
import com.app.GroupMatching.enums.NotificationStatus;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private Long recipientId;
    private Long senderId;
    private String content;
    private NotificationStatus status;
}
