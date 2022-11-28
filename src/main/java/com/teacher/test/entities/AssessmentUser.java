package com.teacher.test.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="assessment_user")
@Data
public class AssessmentUser {

    @Id
    @SequenceGenerator(name="assessment_user_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="assessment_user_id_seq")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
