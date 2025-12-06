package ie.atu.notification_service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookOverdueRequestDTO {
    private long userId;
    private String userEmail;
    private String bookTitle;
    private LocalDate dueDate;
}