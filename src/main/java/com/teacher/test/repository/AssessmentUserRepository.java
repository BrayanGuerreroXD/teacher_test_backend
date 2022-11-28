package com.teacher.test.repository;

import com.teacher.test.entities.AssessmentUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentUserRepository extends JpaRepository<AssessmentUser, Integer> {
}
