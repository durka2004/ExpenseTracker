package springboot.project.ExpenseTracker.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExpenseRequestDto
{
    @NotBlank(message="Title is required")
    private String title;
    private String description;

    @NotNull(message="Amount is Required")
    @DecimalMin(value="0.01",message="Amount must be Positive")
    private BigDecimal amount;

    @NotNull(message="Category ID is required ")
    private Long categoryId;
}