package com.example.case_study_3.service.impl;

import com.example.case_study_3.model.Category;
import com.example.case_study_3.repository.CategoryRepository;
import com.example.case_study_3.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }


}
