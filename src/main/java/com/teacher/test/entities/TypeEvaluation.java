package com.teacher.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="typeevaluation")
@Data
public class TypeEvaluation {

    @Id
    @SequenceGenerator(name="typeevaluation_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="typeevaluation_id_seq")
    private Integer id;

    private String description;
}
