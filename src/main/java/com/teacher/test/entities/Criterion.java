package com.teacher.test.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="criterion")
@Data
public class Criterion {

    @Id
    @SequenceGenerator(name="criterion_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="criterion_id_seq")
    private Integer id;

    @Column(name = "max_value")
    private int maxValue;

    @Column(name = "min_value")
    private int minValue;

    @Column(name = "value")
    private int value;
}
