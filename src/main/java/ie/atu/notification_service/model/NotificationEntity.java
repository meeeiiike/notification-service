package ie.atu.notification_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "notifications")
@Data@Entity@AllArgsConstructor@NoArgsConstructor
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String notification;
    private LocalDate dueDate;
    //private String userEmail;
    //private String bookTitle;
    //private String type;
}
