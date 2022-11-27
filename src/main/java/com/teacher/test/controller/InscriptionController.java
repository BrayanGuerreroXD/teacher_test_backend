package com.teacher.test.controller;

import com.teacher.test.entities.Inscription;
import com.teacher.test.repository.InscriptionRepository;
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
@RequestMapping("/inscriptions")
public class InscriptionController {
    @Autowired
    InscriptionRepository inscriptionRepo;

    @GetMapping
    public List<Inscription> getInscriptionAll() {
        return inscriptionRepo.findAll();
    }

    @GetMapping("/{id}")
    public Inscription getInscriptionsbyId(@PathVariable Integer id) {
        Optional<Inscription> inscription = inscriptionRepo.findById(id);

        if (inscription.isPresent()) {
            return inscription.get();
        }

        return null;
    }

    @PostMapping
    public Inscription postInscriptions(@RequestBody Inscription inscription) {
        inscriptionRepo.save(inscription);
        return inscription;
    }


    @PutMapping("/{id}")
    public Inscription putInscriptionsbyId(@PathVariable Integer id, @RequestBody Inscription inscription) {
        Optional<Inscription> inscriptionCurrent = inscriptionRepo.findById(id);

        if (inscriptionCurrent.isPresent()) {
            Inscription inscriptionReturn = inscriptionCurrent.get();
            inscriptionReturn.setValidationInscription(inscription.isValidationInscription());
            inscriptionReturn.setValidationDate(inscription.getValidationDate());
            inscriptionRepo.save(inscriptionReturn);
            return inscriptionReturn;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Inscription deleteInscriptionsbyId(@PathVariable Integer id) {
        Optional<Inscription> inscription = inscriptionRepo.findById(id);

        if (inscription.isPresent()) {
            Inscription inscriptionReturn = inscription.get();
            inscriptionRepo.deleteById(id);
            return inscriptionReturn;
        }

        return null;
    }
}
