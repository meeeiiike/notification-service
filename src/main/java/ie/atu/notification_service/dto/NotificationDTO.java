package ie.atu.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import java.time.LocalDate;

@Data@AllArgsConstructor@NoArgsConstructor
public class NotificationDTO {
    private long userId;
    private String notification;
    //private String userEmail;
    //private String bookTitle;
    //private LocalDate dueDate;
    //private String type;                    // e.g., "DUE_SOON" or "OVERDUE"
}


