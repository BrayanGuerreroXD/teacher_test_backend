package com.teacher.test.controller;

import com.teacher.test.entities.AssessmentCategory;
import com.teacher.test.repository.AssessmentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/assessments_categories")
public class AssessmentCategoryController {

    @Autowired
    AssessmentCategoryRepository assessmentCategoryRepo;

    @GetMapping
    public List<AssessmentCategory> getAssessmentsCategoriesAll() {
        return assessmentCategoryRepo.findAll();
    }

    @GetMapping("/{id}")
    public AssessmentCategory getAssessmentsCategoriesbyId(@PathVariable Integer id) {
        Optional<AssessmentCategory> assessmentCategory = assessmentCategoryRepo.findById(id);

        if (assessmentCategory.isPresent()) {
            return assessmentCategory.get();
        }

        return null;
    }

    @PostMapping
    public AssessmentCategory postAssessmentsCategories(@RequestBody AssessmentCategory assessmentCategory) {
        assessmentCategoryRepo.save(assessmentCategory);
        return assessmentCategory;
    }


    @PutMapping("/{id}")
    public AssessmentCategory putAssessmentsCategoriesbyId(@PathVariable Integer id, @RequestBody AssessmentCategory assessmentCategory) {
        Optional<AssessmentCategory> assessmentCategoryCurrent = assessmentCategoryRepo.findById(id);

        if (assessmentCategoryCurrent.isPresent()) {
            AssessmentCategory assessmentCategoryReturn = assessmentCategoryCurrent.get();
            assessmentCategoryReturn.setAssessment(assessmentCategory.getAssessment());
            assessmentCategoryReturn.setCategory(assessmentCategory.getCategory());
            assessmentCategoryRepo.save(assessmentCategoryReturn);
            return assessmentCategoryReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public AssessmentCategory deleteAssessmentsCategoriesbyId(@PathVariable Integer id) {
        Optional<AssessmentCategory> assessmentCategory = assessmentCategoryRepo.findById(id);

        if (assessmentCategory.isPresent()) {
            AssessmentCategory assessmentCategoryReturn = assessmentCategory.get();
            assessmentCategoryRepo.deleteById(id);
            return assessmentCategoryReturn;
        }

        return null;
    }
}
