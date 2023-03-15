package com.example.case_study_3.repository;

import com.example.case_study_3.model.MyMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MyMoneyRepository extends JpaRepository<MyMoney,Long> {
 List<MyMoney> findAllByUser_Id(@Param("userId") Long userId);
 @Query(value = "select sum (m.money) from MyMoney m where m.user.id = :userId")
 Double selectMoneyByUser(@Param("userId") Long id );
}
