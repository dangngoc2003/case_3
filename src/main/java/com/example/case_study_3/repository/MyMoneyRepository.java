package com.example.case_study_3.repository;

import com.example.case_study_3.model.MyMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MyMoneyRepository extends JpaRepository<MyMoney,Long> {

}
