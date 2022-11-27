package com.teacher.test.controller;

import com.teacher.test.entities.Assessment;
import com.teacher.test.repository.AssessmentRepository;
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
@RequestMapping("/assessments")
public class AssessmentController {

    @Autowired
    AssessmentRepository assessmentRepo;

    @GetMapping
    public List<Assessment> getAssessmentsAll() {
        return assessmentRepo.findAll();
    }

    @GetMapping("/{id}")
    public Assessment getAssesstmentsbyId(@PathVariable Integer id) {
        Optional<Assessment> assessment = assessmentRepo.findById(id);

        if (assessment.isPresent()) {
            return assessment.get();
        }

        return null;
    }

    @PostMapping
    public Assessment postAssessments(@RequestBody Assessment assessment) {
        assessmentRepo.save(assessment);
        return assessment;
    }


    @PutMapping("/{id}")
    public Assessment putAssessmentsbyId(@PathVariable Integer id, @RequestBody Assessment assessment) {
        Optional<Assessment> assessmentCurrent = assessmentRepo.findById(id);

        if (assessmentCurrent.isPresent()) {
            Assessment assessmentReturn = assessmentCurrent.get();
            assessmentReturn.setTypeEvaluation(assessment.getTypeEvaluation());
            assessmentReturn.setAssessmentDate(assessment.getAssessmentDate());
            assessmentReturn.setAssessmentSemester(assessment.getAssessmentSemester());
            assessmentRepo.save(assessmentReturn);
            return assessmentReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Assessment deleteAssessmentsbyId(@PathVariable Integer id) {
        Optional<Assessment> assessment = assessmentRepo.findById(id);

        if (assessment.isPresent()) {
            Assessment assessmentReturn = assessment.get();
            assessmentRepo.deleteById(id);
            return assessmentReturn;
        }

        return null;
    }
}
