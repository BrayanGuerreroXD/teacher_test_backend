package com.teacher.test.repository;

import com.teacher.test.entities.AssessmentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentCategoryRepository extends JpaRepository<AssessmentCategory, Integer> {
}
