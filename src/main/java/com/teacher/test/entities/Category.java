package com.teacher.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="category")
@Data
public class Category {

    @Id
    @SequenceGenerator(name="category_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="category_id_seq")
    private Integer id;

    @OneToOne
    @JoinColumn(name="criterion_id")
    private Criterion criterion;

    @Column(name="category_name")
    private String categoryName;
}
