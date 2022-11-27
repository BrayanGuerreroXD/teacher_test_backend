package com.teacher.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="inscription_user")
@Data
public class InscriptionUser {

    @Id
    @SequenceGenerator(name="inscription_user_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="inscription_user_id_seq")
    private Integer id;

    @ManyToOne
    private Inscription inscription;

    @OneToOne
    private User user;
}
