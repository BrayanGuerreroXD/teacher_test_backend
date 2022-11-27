package com.teacher.test.repository;

import com.teacher.test.entities.Criterion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriterionRepository extends JpaRepository<Criterion, Integer> {
}
