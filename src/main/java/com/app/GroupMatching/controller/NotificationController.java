package com.app.GroupMatching.controller;

import com.app.GroupMatching.dto.requests.ChangeStatusRequest;
import com.app.GroupMatching.dto.requests.NotificationRequest;
import com.app.GroupMatching.enums.NotificationStatus;
import com.app.GroupMatching.services.classes.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PutMapping("/change-status")
    public ResponseEntity<?> changeNotificationStatus
            (@RequestBody ChangeStatusRequest request){
        return new ResponseEntity<>(
                notificationService.changeNotificationStatus(
                        request.getNotificationId(),request.getNotificationStatus()),
                HttpStatus.OK);
    }

    @PostMapping("/send")
    public ResponseEntity<?> saveNotification(@RequestBody NotificationRequest notificationRequest){
        return new ResponseEntity<>(
                notificationService.saveNotification(
                       notificationRequest
                ),HttpStatus.OK
        );
    }

    @GetMapping()
    public ResponseEntity<?> getAllNotificationByReceipt(
            @RequestParam Long recipientId
    ){
        return new ResponseEntity<>(
                notificationService.getAllNotificationByReceipt(recipientId),
                HttpStatus.OK);
    }

    @GetMapping("/unread")
    public ResponseEntity<?> getUnreadNotifications(@RequestParam Long receiptId){
        return new ResponseEntity<>(notificationService
                .getNotificationsByStatusAndReceipt(
                NotificationStatus.UNREAD,receiptId)
        ,HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<?> getReadNotifications(@RequestParam Long receiptId){
        return new ResponseEntity<>(notificationService
                .getNotificationsByStatusAndReceipt(
                        NotificationStatus.READ,receiptId)
                ,HttpStatus.OK);
    }

}
