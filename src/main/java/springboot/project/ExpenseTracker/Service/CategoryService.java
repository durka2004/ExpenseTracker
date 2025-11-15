package springboot.project.ExpenseTracker.Service;

import springboot.project.ExpenseTracker.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto dto);

    CategoryDto getCategoryById(Long id);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long id, CategoryDto dto);

    void deleteCategory(Long id);
}
