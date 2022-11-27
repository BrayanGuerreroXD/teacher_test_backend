package com.teacher.test.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="assessment")
@Data
public class Assessment {

    @Id
    @SequenceGenerator(name="assessment_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="assessment_id_seq")
    private Integer id;

    @OneToOne
    private TypeEvaluation typeEvaluation;

    private Date assessmentDate;

    private String assessmentSemester;
}
