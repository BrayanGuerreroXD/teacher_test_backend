package com.teacher.test.controller;

import com.teacher.test.entities.TypeEvaluation;
import com.teacher.test.repository.TypeEvaluationRepository;
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
@RequestMapping("/typeevaluation")
public class TypeEvaluationController {
    @Autowired
    TypeEvaluationRepository typeEvaluationRepo;

    @GetMapping
    public List<TypeEvaluation> getTypeEvaluationAll() {
        return typeEvaluationRepo.findAll();
    }

    @GetMapping("/{id}")
    public TypeEvaluation getTypeEvaluationbyId(@PathVariable Integer id) {
        Optional<TypeEvaluation> typeEvaluation = typeEvaluationRepo.findById(id);

        if (typeEvaluation.isPresent()) {
            return typeEvaluation.get();
        }

        return null;
    }

    @PostMapping
    public TypeEvaluation postTypeEvaluation(@RequestBody TypeEvaluation typeEvaluation) {
        typeEvaluationRepo.save(typeEvaluation);
        return typeEvaluation;
    }


    @PutMapping("/{id}")
    public TypeEvaluation putTypeEvaluationbyId(@PathVariable Integer id, @RequestBody TypeEvaluation typeEvaluation) {
        Optional<TypeEvaluation> typeEvaluationCurrent = typeEvaluationRepo.findById(id);

        if (typeEvaluationCurrent.isPresent()) {
            TypeEvaluation typeEvaluationReturn = typeEvaluationCurrent.get();
            typeEvaluationReturn.setDescription(typeEvaluation.getDescription());
            return typeEvaluationReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public TypeEvaluation deleteTypeEvaluationbyId(@PathVariable Integer id) {
        Optional<TypeEvaluation> typeEvaluation = typeEvaluationRepo.findById(id);

        if (typeEvaluation.isPresent()) {
            TypeEvaluation typeEvaluationReturn = typeEvaluation.get();
            typeEvaluationRepo.deleteById(id);
            return typeEvaluationReturn;
        }

        return null;
    }
}
