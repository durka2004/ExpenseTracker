package springboot.project.ExpenseTracker.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springboot.project.ExpenseTracker.entity.Expense;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByCategoryId(Long categoryId);

    @Query("SELECT e FROM Expense e WHERE e.createdAt BETWEEN :start AND :end")
    List<Expense> findMonthlyExpenses(LocalDateTime start, LocalDateTime end);
}
