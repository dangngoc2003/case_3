package com.example.case_study_3.service;

import com.example.case_study_3.model.MyMoney;

import java.util.List;

public interface IMoneyService {
    List<MyMoney> findAll();
    List<MyMoney> findALlByUser(Long userId);
    MyMoney findById(Long id);
    void save(MyMoney money);
    void delete(Long id);
    Double selectMoneyByUser(Long userId);
}
