package springboot.project.ExpenseTracker.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.project.ExpenseTracker.dto.ExpenseRequestDto;
import springboot.project.ExpenseTracker.dto.ExpenseResponseDto;
import springboot.project.ExpenseTracker.Service.ExpenseService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseResponseDto> create(@Valid @RequestBody ExpenseRequestDto dto) {
        return ResponseEntity.ok(expenseService.createExpense(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.getExpense(id));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ExpenseResponseDto>> getByCategory(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.getExpensesByCategory(id));
    }

    @GetMapping("/summary")
    public ResponseEntity<BigDecimal> getMonthlySummary(
            @RequestParam int year,
            @RequestParam int month) {
        return ResponseEntity.ok(expenseService.getMonthlySummary(year, month));
    }
}
