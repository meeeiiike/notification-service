package ie.atu.notification_service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NotificationDTO {
    private long userId;
    private String userEmail;
    private String bookTitle;
    private LocalDate dueDate;
    private String type;                    // e.g., "DUE_SOON" or "OVERDUE"
}


