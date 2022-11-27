package com.teacher.test.repository;

import com.teacher.test.entities.InscriptionUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionUserRepository extends JpaRepository<InscriptionUser, Integer>{
}
