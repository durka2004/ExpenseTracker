package springboot.project.ExpenseTracker.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.project.ExpenseTracker.Service.ExpenseService;
import springboot.project.ExpenseTracker.dto.ExpenseRequestDto;
import springboot.project.ExpenseTracker.dto.ExpenseResponseDto;
import springboot.project.ExpenseTracker.entity.Category;
import springboot.project.ExpenseTracker.entity.Expense;
import springboot.project.ExpenseTracker.exception.ResourceNotFoundException;
import springboot.project.ExpenseTracker.mapper.ExpenseMapper;
import springboot.project.ExpenseTracker.repository.CategoryRepository;
import springboot.project.ExpenseTracker.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ExpenseResponseDto createExpense(ExpenseRequestDto dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Expense expense = new Expense();
        expense.setTitle(dto.getTitle());
        expense.setDescription(dto.getDescription());
        expense.setAmount(dto.getAmount());
        expense.setCategory(category);

        expenseRepository.save(expense);
        return ExpenseMapper.toDto(expense);
    }

    @Override
    public ExpenseResponseDto getExpense(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
        return ExpenseMapper.toDto(expense);
    }

    @Override
    public List<ExpenseResponseDto> getExpensesByCategory(Long categoryId) {
        return expenseRepository.findByCategoryId(categoryId)
                .stream()
                .map(ExpenseMapper::toDto)
                .toList();
    }

    @Override
    public BigDecimal getMonthlySummary(int year, int month) {
        LocalDateTime start = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime end = start.plusMonths(1);

        return expenseRepository.findMonthlyExpenses(start, end)
                .stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

