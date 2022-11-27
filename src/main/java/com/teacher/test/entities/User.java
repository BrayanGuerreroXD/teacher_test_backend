package com.teacher.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {

    @Id
    @SequenceGenerator(name="user_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_id_seq")
    private Integer id;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_code")
    private int userCode;

    @Column(name="identify_card_number")
    private int identifyCardNumber;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="is_admin")
    private boolean isAdmin;
}
