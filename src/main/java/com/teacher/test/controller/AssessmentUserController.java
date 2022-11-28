package com.teacher.test.controller;

import com.teacher.test.entities.AssessmentUser;
import com.teacher.test.repository.AssessmentUserRepository;
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
@RequestMapping("/assessments_users")
public class AssessmentUserController {

    @Autowired
    AssessmentUserRepository assessmentUserRepo;

    @GetMapping
    public List<AssessmentUser> getAssessmentsUsersAll() {
        return assessmentUserRepo.findAll();
    }

    @GetMapping("/{id}")
    public AssessmentUser getAssessmentsUsersbyId(@PathVariable Integer id) {
        Optional<AssessmentUser> assessmentUser = assessmentUserRepo.findById(id);

        if (assessmentUser.isPresent()) {
            return assessmentUser.get();
        }

        return null;
    }

    @PostMapping
    public AssessmentUser postAssessmentsUsers(@RequestBody AssessmentUser assessmentUser) {
        assessmentUserRepo.save(assessmentUser);
        return assessmentUser;
    }


    @PutMapping("/{id}")
    public AssessmentUser putAssessmentsUsersbyId(@PathVariable Integer id, @RequestBody AssessmentUser assessmentUser) {
        Optional<AssessmentUser> assessmentUserCurrent = assessmentUserRepo.findById(id);

        if (assessmentUserCurrent.isPresent()) {
            AssessmentUser assessmentUserReturn = assessmentUserCurrent.get();
            assessmentUserReturn.setAssessment(assessmentUser.getAssessment());
            assessmentUserReturn.setUser(assessmentUser.getUser());
            assessmentUserRepo.save(assessmentUserReturn);
            return assessmentUserReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public AssessmentUser deleteCategoriesbyId(@PathVariable Integer id) {
        Optional<AssessmentUser> assessmentUser = assessmentUserRepo.findById(id);

        if (assessmentUser.isPresent()) {
            AssessmentUser assessmentUserReturn = assessmentUser.get();
            assessmentUserRepo.deleteById(id);
            return assessmentUserReturn;
        }

        return null;
    }
}
