package com.teacher.test.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="criterion")
@Data
public class Criterion {

    @Id
    @SequenceGenerator(name="criterion_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="criterion_id_seq")
    private Integer id;

    private int maxValue;

    private int minValue;

    private int value;
}
