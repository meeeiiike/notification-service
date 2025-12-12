package ie.atu.notification_service.controller;

//import feign.Response;
//import ie.atu.notification_service.dto.BookDueSoonRequestDTO;
//import ie.atu.notification_service.dto.BookOverdueRequestDTO;
import ie.atu.notification_service.dto.NotificationDTO;
import ie.atu.notification_service.model.NotificationEntity;
import ie.atu.notification_service.repository.NotificationRepository;
import ie.atu.notification_service.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")

public class NotificationController {

    private final EmailService emailService;
    private final NotificationRepository notificationRepository;

    public NotificationController(EmailService emailService, NotificationRepository notificationRepository) {
        this.emailService = emailService;
        this.notificationRepository = notificationRepository;
    }

    @PostMapping
    public ResponseEntity<NotificationEntity> sendNotification(@Valid@RequestBody NotificationDTO dto){
        return ResponseEntity.ok(emailService.sendNotification(dto));
    }

    @GetMapping
    public ResponseEntity<List<NotificationEntity>> getNotifications(){
        return ResponseEntity.ok(emailService.getNotifications());
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<NotificationEntity>> getUserNotification(@PathVariable String userid){
        return ResponseEntity.ok(emailService.getNotificationByUserId(userid));
    }

}


/*
    @PostMapping("/due-soon")
    public ResponseEntity<Void> sendDueSoon(@RequestBody @Valid BookDueSoonRequestDTO request) {
        emailService.sendBookDueSoon(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/overdue")
    public ResponseEntity<Void> sendOverdue(@RequestBody @Valid BookOverdueRequestDTO request) {
        emailService.sendBookOverdue(request);
        return ResponseEntity.ok().build();
    }

     */

// Rethink endpoints needed
//**********************************************************************
/*
     To create basic endpoints for notifications service.
     If a book is DueSoon a notification will be sent out.
     If a book is Overdue a notification will be sent out.

    Loan Service Detects BookDueSoon or BookOverdue and creates an event.

    Notification Service Receives the event loads user info and then emails them.

    User Service Stores user email and Notification Service calls it to get the email address.





    **************************************************************************
    To reserve a book
    BookService and notifications would have to be updated
    and user id referenced to reserve book.






 */