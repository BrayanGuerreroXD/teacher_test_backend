package com.teacher.test.controller;

import com.teacher.test.entities.User;
import com.teacher.test.repository.UserRepository;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping
    public List<User> getUserAll() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User getUsersbyId(@PathVariable Integer id) {
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    @PostMapping
    public User postUsers(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }


    @PutMapping("/{id}")
    public User putUsersbyId(@PathVariable Integer id, @RequestBody User user) {
        Optional<User> userCurrent = userRepo.findById(id);

        if (userCurrent.isPresent()) {
            User userReturn = userCurrent.get();
            userReturn.setUserName(user.getUserName());
            userReturn.setEmail(user.getEmail());
            userRepo.save(userReturn);
            return userReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public User deleteUsersbyId(@PathVariable Integer id) {
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) {
            User userReturn = user.get();
            userRepo.deleteById(id);
            return userReturn;
        }

        return null;
    }
}
