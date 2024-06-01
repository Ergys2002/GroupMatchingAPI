package com.app.GroupMatching.entities;

import com.app.GroupMatching.enums.NotificationStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notifications")@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends BaseEntity{
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private User recipient;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;
    private String content;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

}
