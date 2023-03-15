package com.example.case_study_3.service;

import com.example.case_study_3.model.Plan;

import java.util.List;

public interface IPlanService {
    List<Plan> findAll();
    Plan findOne(Long id);

    void save(Plan plan);

    void delete(Long id);
}
