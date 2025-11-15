package springboot.project.ExpenseTracker.mapper;


import springboot.project.ExpenseTracker.dto.ExpenseResponseDto;
import springboot.project.ExpenseTracker.entity.Expense;

public class ExpenseMapper {

    public static ExpenseResponseDto toDto(Expense expense) {
        ExpenseResponseDto dto = new ExpenseResponseDto();
        dto.setId(expense.getId());
        dto.setTitle(expense.getTitle());
        dto.setDescription(expense.getDescription());
        dto.setAmount(expense.getAmount());
        dto.setCategoryName(expense.getCategory().getName());
        dto.setCreatedAt(expense.getCreatedAt());
        return dto;
    }
}
