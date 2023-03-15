package com.example.case_study_3.service.impl;
import com.example.case_study_3.model.Plan;
import com.example.case_study_3.repository.PlanRepository;
import com.example.case_study_3.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PlanService implements IPlanService {
    @Autowired
    private PlanRepository planRepository;
    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }
    @Override
    public Plan findOne(Long id) {
        return planRepository.findById(id).orElse(null);
    }
    @Override
    public void save(Plan plan) {
    planRepository.save(plan);
    }
    @Override
    public void delete(Long id) {
    planRepository.deleteById(id);
    }
}
