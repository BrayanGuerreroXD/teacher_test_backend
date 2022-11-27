package com.teacher.test.controller;

import com.teacher.test.entities.Category;
import com.teacher.test.repository.CategoryRepository;
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
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepo;

    @GetMapping
    public List<Category> getCategoriesAll() {
        return categoryRepo.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoriesbyId(@PathVariable Integer id) {
        Optional<Category> category = categoryRepo.findById(id);

        if (category.isPresent()) {
            return category.get();
        }

        return null;
    }

    @PostMapping
    public Category postCategories(@RequestBody Category category) {
        categoryRepo.save(category);
        return category;
    }


    @PutMapping("/{id}")
    public Category putCategoriesbyId(@PathVariable Integer id, @RequestBody Category category) {
        Optional<Category> categoryCurrent = categoryRepo.findById(id);

        if (categoryCurrent.isPresent()) {
            Category categoryReturn = categoryCurrent.get();
            categoryRepo.save(categoryReturn);
            categoryReturn.setCriterion(category.getCriterion());
            categoryReturn.setCategoryName(category.getCategoryName());
            return categoryReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Category deleteCategoriesbyId(@PathVariable Integer id) {
        Optional<Category> category = categoryRepo.findById(id);

        if (category.isPresent()) {
            Category categoryReturn = category.get();
            categoryRepo.deleteById(id);
            return categoryReturn;
        }

        return null;
    }
}
