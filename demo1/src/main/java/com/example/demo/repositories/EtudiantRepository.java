package com.example.demo.repositories;

import com.example.demo.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    // spring data : hériter d'une interface génériwue JpaRepositor<Entité,Type d'id>

}
