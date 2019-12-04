package com.vapeordie.vapeordie.service.Category;

import com.vapeordie.vapeordie.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
    public void updateCategory(Category category, Long id);
    public void deleteCategory(Long id);
    public Category addCategory(Category category);
    public Category getCategoryById(Long id);
}
