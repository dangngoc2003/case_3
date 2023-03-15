package com.example.case_study_3.service;

import com.example.case_study_3.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
}
