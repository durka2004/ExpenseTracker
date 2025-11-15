package springboot.project.ExpenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.project.ExpenseTracker.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
