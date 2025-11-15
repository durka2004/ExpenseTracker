package springboot.project.ExpenseTracker.Service.Impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.project.ExpenseTracker.Service.CategoryService;
import springboot.project.ExpenseTracker.dto.CategoryDto;
import springboot.project.ExpenseTracker.entity.Category;
import springboot.project.ExpenseTracker.exception.ResourceNotFoundException;
import springboot.project.ExpenseTracker.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());

        categoryRepository.save(category);

        // set the auto-generated ID back into the DTO
        dto.setId(category.getId());
        return dto;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));

        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> {
                    CategoryDto dto = new CategoryDto();
                    dto.setId(category.getId());
                    dto.setName(category.getName());
                    return dto;
                })
                .toList();
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));

        category.setName(dto.getName());
        categoryRepository.save(category);

        dto.setId(category.getId());
        return dto;
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));

        categoryRepository.delete(category);
    }
}
