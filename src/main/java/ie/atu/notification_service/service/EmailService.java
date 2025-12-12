package ie.atu.notification_service.service;

import ie.atu.notification_service.dto.BookDueSoonRequestDTO;
import ie.atu.notification_service.dto.BookOverdueRequestDTO;
import ie.atu.notification_service.dto.NotificationDTO;
import ie.atu.notification_service.model.NotificationEntity;
import ie.atu.notification_service.repository.NotificationRepository;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    private final NotificationRepository notificationRepository;
    //private final JavaMailSender mailSender;
    public EmailService(NotificationRepository notificationRepository /*,JavaMailSender mailSender*/) {
        this.notificationRepository = notificationRepository;
        //this.mailSender = mailSender;
    }

    public NotificationEntity sendNotification(NotificationDTO dto){
        NotificationEntity notification = new NotificationEntity();
        notification.setUserId(dto.getUserId());
        notification.setNotification(dto.getNotification());
        return notificationRepository.save(notification);
    }

    public List<NotificationEntity> getNotifications(){
        return notificationRepository.findAll();
    }

    /*
    public void sendBookDueSoon(BookDueSoonRequestDTO request) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(request.getUserEmail());
        msg.setSubject("Book Due Soon: " + request.getBookTitle());
        msg.setText("Your book \"" + request.getBookTitle() + "\" is due on " + request.getDueDate());
        //mailSender.send(msg);                                                                         // error 500 from email settings issue
        System.out.println("EMAIL WOULD SEND: " + msg);                                                  // for testing

    }

    public void sendBookOverdue(BookOverdueRequestDTO request) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(request.getUserEmail());
        msg.setSubject("Book Overdue: " + request.getBookTitle());
        msg.setText("Your book \"" + request.getBookTitle() + "\" was due on " + request.getDueDate());
        //mailSender.send(msg);                                                                         // error 500 from email settings issue
        System.out.println("EMAIL WOULD SEND: " + msg);                                                 // for testing

    }

     */
}

