package com.example.springwebapp.services;

import com.example.springwebapp.models.Category;
import com.example.springwebapp.repo.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getByName(String name) {
        return categoryRepository.findByName(name);
    }

}
