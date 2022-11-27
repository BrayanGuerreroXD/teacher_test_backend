package com.teacher.test.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="inscription")
@Data
public class Inscription {

    @Id
    @SequenceGenerator(name="inscription_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="inscription_id_seq")
    private Integer id;

    @Column(name = "validation_inscription")
    private boolean validationInscription;

    @Column(name = "validation_date")
    private Date validationDate;
}
