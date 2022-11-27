package com.teacher.test.controller;

import com.teacher.test.entities.Criterion;
import com.teacher.test.repository.CriterionRepository;
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
@RequestMapping("/criteria")
public class CriterionController {

    @Autowired
    CriterionRepository criterionRepo;

    @GetMapping
    public List<Criterion> getCriteriaAll() {
        return criterionRepo.findAll();
    }

    @GetMapping("/{id}")
    public Criterion getCriteriabyId(@PathVariable Integer id) {
        Optional<Criterion> criterion = criterionRepo.findById(id);

        if (criterion.isPresent()) {
            return criterion.get();
        }

        return null;
    }

    @PostMapping
    public Criterion postCriteria(@RequestBody Criterion criterion) {
        criterionRepo.save(criterion);
        return criterion;
    }


    @PutMapping("/{id}")
    public Criterion putCriteriabyId(@PathVariable Integer id, @RequestBody Criterion criterion) {
        Optional<Criterion> criterionCurrent = criterionRepo.findById(id);

        if (criterionCurrent.isPresent()) {
            Criterion criterionReturn = criterionCurrent.get();
            criterionReturn.setMaxValue(criterion.getMaxValue());
            criterionReturn.setMinValue(criterion.getMinValue());
            criterionReturn.setValue(criterion.getValue());
            criterionRepo.save(criterionReturn);
            return criterionReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Criterion deleteCriteriabyId(@PathVariable Integer id) {
        Optional<Criterion> criterion = criterionRepo.findById(id);

        if (criterion.isPresent()) {
            Criterion criterionReturn = criterion.get();
            criterionRepo.deleteById(id);
            return criterionReturn;
        }

        return null;
    }
}
