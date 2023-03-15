package com.example.case_study_3.controller;

import com.example.case_study_3.model.Plan;
import com.example.case_study_3.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/plan")

public class PlanController {
    @Autowired
    private IPlanService iPlanService;
    @GetMapping
    public ResponseEntity<List<Plan>> findALl(){
        return new ResponseEntity<>(iPlanService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Plan plan){
        iPlanService.save(plan);
        return new ResponseEntity<>(HttpStatus.CONTINUE);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody Plan plan){
        Plan plan1=iPlanService.findOne(id);
        if (plan1!=null){
            iPlanService.save(plan);
            return new ResponseEntity<>(HttpStatus.CONTINUE);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id){
        iPlanService.delete(id);
        return new ResponseEntity<>(HttpStatus.CONTINUE);
    }

}
