package springboot.project.ExpenseTracker.dto;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class ExpenseResponseDto {
    private Long id;
    private String title;
    private String description;
    private BigDecimal amount;
    private String categoryName;
    private LocalDateTime createdAt;

}
