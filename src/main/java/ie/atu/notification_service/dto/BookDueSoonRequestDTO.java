package ie.atu.notification_service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDueSoonRequestDTO {
    private long userId;
    private String userEmail;
    private String bookTitle;
    private LocalDate dueDate;
}

// Dont think this is needed