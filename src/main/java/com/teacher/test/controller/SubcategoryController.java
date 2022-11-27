package com.teacher.test.controller;

import com.teacher.test.entities.Subcategory;
import com.teacher.test.repository.SubcategoryRepository;
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
@RequestMapping("/subcategories")
public class SubcategoryController {

    @Autowired
    SubcategoryRepository subcategoryRepo;

    @GetMapping
    public List<Subcategory> getSubcategoriesAll() {
        return subcategoryRepo.findAll();
    }

    @GetMapping("/{id}")
    public Subcategory getSubcategoriesbyId(@PathVariable Integer id) {
        Optional<Subcategory> subcategory = subcategoryRepo.findById(id);

        if (subcategory.isPresent()) {
            return subcategory.get();
        }

        return null;
    }

    @PostMapping
    public Subcategory postSubcategories(@RequestBody Subcategory subcategory) {
        subcategoryRepo.save(subcategory);
        return subcategory;
    }


    @PutMapping("/{id}")
    public Subcategory putSubcategoriesbyId(@PathVariable Integer id, @RequestBody Subcategory subcategory) {
        Optional<Subcategory> subcategoryCurrent = subcategoryRepo.findById(id);

        if (subcategoryCurrent.isPresent()) {
            Subcategory subcategoryReturn = subcategoryCurrent.get();
            subcategoryReturn.setCriterion(subcategory.getCriterion());
            subcategoryReturn.setQuestion(subcategory.getQuestion());
            subcategoryRepo.save(subcategory);
            return subcategoryReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Subcategory deleteSubcategoriesbyId(@PathVariable Integer id) {
        Optional<Subcategory> subcategory = subcategoryRepo.findById(id);

        if (subcategory.isPresent()) {
            Subcategory subcategoryReturn = subcategory.get();
            subcategoryRepo.deleteById(id);
            return subcategoryReturn;
        }

        return null;
    }
}
