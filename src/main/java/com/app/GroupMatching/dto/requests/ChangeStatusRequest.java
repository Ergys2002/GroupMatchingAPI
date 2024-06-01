package com.app.GroupMatching.dto.requests;

import com.app.GroupMatching.enums.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeStatusRequest {
    private Long notificationId;
    private NotificationStatus notificationStatus;
}
