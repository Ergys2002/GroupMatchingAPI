package com.app.GroupMatching.services.classes;

import com.app.GroupMatching.dto.requests.NotificationRequest;
import com.app.GroupMatching.entities.Notification;
import com.app.GroupMatching.entities.User;
import com.app.GroupMatching.enums.NotificationStatus;
import com.app.GroupMatching.repositories.NotificationRepository;
import com.app.GroupMatching.repositories.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public Notification changeNotificationStatus(Long notificationId,NotificationStatus notificationStatus){
        Notification notification = notificationRepository.getReferenceById(notificationId);
        notification.setStatus(notificationStatus);
        return notificationRepository.save(notification);
    }

    public Notification saveNotification(NotificationRequest notificationRequest){
        User recipient = userRepository
                .getReferenceById(notificationRequest.getRecipientId());

        User sender = userRepository
                .getReferenceById(notificationRequest.getSenderId());

        Notification notification = Notification
                .builder()
                .sender(sender)
                .recipient(recipient)
                .content(notificationRequest.getContent())
                .status(notificationRequest.getStatus())
                .build();

        return notificationRepository.save(notification);
    }

    public Set<Notification> getAllNotificationByReceipt(Long receiptId){
        return notificationRepository.getNotificationsByRecipientId(receiptId);
    }

    public Set<Notification> getNotificationsByStatusAndReceipt(
            NotificationStatus notificationStatus,
            Long receiptId){

        Set<Notification> notifications = getAllNotificationByReceipt(receiptId);

       return notifications.stream().filter(notification -> notification
                .getStatus()
                .equals(notificationStatus))
                .collect(Collectors.toSet());
    }

}
