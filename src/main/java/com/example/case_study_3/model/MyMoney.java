package com.example.case_study_3.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MyMoney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCard;
    private Double money;
    @OneToOne
    private User user;
}
