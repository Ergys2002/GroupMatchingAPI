package com.app.GroupMatching.repositories;

import com.app.GroupMatching.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
    public Set<Notification> getNotificationsByRecipientId(Long recipientId);

}
