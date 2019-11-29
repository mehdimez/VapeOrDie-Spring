package com.vapeordie.vapeordie.service;

import com.vapeordie.vapeordie.model.Category;
import com.vapeordie.vapeordie.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void updateCategory(Category categoryDetails, Long id) {
        Category category = categoryRepository.findById(id).get();
        category.setDescription(categoryDetails.getDescription());
        category.setName(categoryDetails.getName());
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
