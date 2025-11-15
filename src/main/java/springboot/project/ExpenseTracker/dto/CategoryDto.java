package springboot.project.ExpenseTracker.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Getter
@Setter
public class CategoryDto {

    private Long id;

    @NotBlank(message = "Category name is required")
    private String name;
}
