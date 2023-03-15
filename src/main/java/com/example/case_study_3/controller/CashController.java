package com.example.case_study_3.controller;

import com.example.case_study_3.model.Cash;
import com.example.case_study_3.model.Category;
import com.example.case_study_3.service.ICashService;
import com.example.case_study_3.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cash")
public class CashController {
    @Autowired
    public ICashService iCashService;
    @Autowired
    public ICategoryService iCategoryService;
    @GetMapping
    public ResponseEntity<Page<Cash>> findAll(@PageableDefault(value = 3)Pageable pageable){
        return new ResponseEntity<>(iCashService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cash> findOne(@PathVariable Long id){
        Cash cash=iCashService.findOne(id);
        return new ResponseEntity<>(cash,HttpStatus.ACCEPTED);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findALl(){
        return new ResponseEntity<>(iCategoryService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/categories/create")
    public ResponseEntity<Void> createC(@RequestBody Category category){
        iCategoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CONTINUE);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Cash cash){
        iCashService.save(cash);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody Cash cash) {
        Cash cash1 = iCashService.findOne(id);
        if (cash1 != null) {
            iCashService.save(cash);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iCashService.delete(id);
        return new ResponseEntity<>(HttpStatus.CONTINUE);
    }
    @GetMapping("/search/{start}/{end}")
    public ResponseEntity<List<Cash>> searchByDate(@PathVariable String start,@PathVariable String end){
        LocalDateTime starDate=  LocalDateTime.parse(start);
        LocalDateTime endDate=LocalDateTime.parse(end);
        return new ResponseEntity<>(iCashService.searchByDate(starDate,endDate),HttpStatus.OK);
    }
    @GetMapping("/total/{type}")
    public ResponseEntity<Double> getTotalByType(@PathVariable String type){
        return new ResponseEntity<>(iCashService.totalMoneyByType(type),HttpStatus.OK);
    }
    @GetMapping("/total/{name}/{type}/{category_id}/{start}/{end}")
    public ResponseEntity<Double> getTotal(@PathVariable String name,
                                           @PathVariable String type,
                                           @PathVariable String category_id,
                                           @PathVariable  String start,
                                           @PathVariable  String end){
        Long category=Long.valueOf(category_id);
        LocalDateTime starDate=  LocalDateTime.parse(start);
        LocalDateTime endDate=LocalDateTime.parse(end);
        return new ResponseEntity<>(iCashService.totalMoneyByCategoryAndType(name,type,category,starDate,endDate),HttpStatus.OK);
    }
    @GetMapping("/{minMoney}/{maxMoney}")
    public ResponseEntity<List<Cash>> findByMoney(@PathVariable Double minMoney,@PathVariable Double maxMoney){
        return new ResponseEntity<>(iCashService.findCashByMoney(minMoney,maxMoney),HttpStatus.OK);
    }
    @GetMapping("/{type}/{min}/{max}")
    public ResponseEntity<List<Cash>> findTypeAndDate(@PathVariable String type,@PathVariable String min,@PathVariable String max){
        LocalDateTime starDate=  LocalDateTime.parse(min);
        LocalDateTime endDate=LocalDateTime.parse(max);
        return new ResponseEntity<>(iCashService.findByDate(type,starDate,endDate),HttpStatus.OK);
    }
}
