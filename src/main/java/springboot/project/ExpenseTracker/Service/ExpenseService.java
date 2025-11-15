package springboot.project.ExpenseTracker.Service;

import springboot.project.ExpenseTracker.dto.ExpenseRequestDto;
import springboot.project.ExpenseTracker.dto.ExpenseResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseService {
    ExpenseResponseDto createExpense(ExpenseRequestDto dto);
    ExpenseResponseDto getExpense(Long id);
    List<ExpenseResponseDto> getExpensesByCategory(Long categoryId);
    BigDecimal getMonthlySummary(int year, int month);
}
