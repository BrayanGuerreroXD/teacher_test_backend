package com.teacher.test.controller;

import com.teacher.test.entities.InscriptionUser;
import com.teacher.test.repository.InscriptionUserRepository;
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
@RequestMapping("/inscriptions_users")
public class InscriptionUserController {

    @Autowired
    InscriptionUserRepository inscriptionUserRepo;

    @GetMapping
    public List<InscriptionUser> getInscriptionsUsersAll() {
        return inscriptionUserRepo.findAll();
    }

    @GetMapping("/{id}")
    public InscriptionUser getInscriptionsUsersbyId(@PathVariable Integer id) {
        Optional<InscriptionUser> inscriptionUser = inscriptionUserRepo.findById(id);

        if (inscriptionUser.isPresent()) {
            return inscriptionUser.get();
        }

        return null;
    }

    @PostMapping
    public InscriptionUser postInscriptionsUsers(@RequestBody InscriptionUser inscriptionUser) {
        inscriptionUserRepo.save(inscriptionUser);
        return inscriptionUser;
    }


    @PutMapping("/{id}")
    public InscriptionUser putInscriptionsUsersbyId(@PathVariable Integer id, @RequestBody InscriptionUser inscriptionUser) {
        Optional<InscriptionUser> inscriptionUserCurrent = inscriptionUserRepo.findById(id);

        if (inscriptionUserCurrent.isPresent()) {
            InscriptionUser inscriptionUserReturn = inscriptionUserCurrent.get();
            inscriptionUserReturn.setInscription(inscriptionUser.getInscription());
            inscriptionUserReturn.setUser(inscriptionUser.getUser());
            inscriptionUserRepo.save(inscriptionUserReturn);
            return inscriptionUserReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public InscriptionUser deleteInscriptionsUsersbyId(@PathVariable Integer id) {
        Optional<InscriptionUser> inscriptionUser = inscriptionUserRepo.findById(id);

        if (inscriptionUser.isPresent()) {
            InscriptionUser inscriptionUserReturn = inscriptionUser.get();
            inscriptionUserRepo.deleteById(id);
            return inscriptionUserReturn;
        }

        return null;
    }
}
