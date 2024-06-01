package com.app.GroupMatching.entities;

import com.app.GroupMatching.enums.NotificationStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private User recipient;
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;
    private String content;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

}
