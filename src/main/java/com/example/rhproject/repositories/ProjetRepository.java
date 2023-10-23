package com.example.rhproject.repositories;

import com.example.rhproject.entities.Projet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Integer> {

    @Query("select p from Projet p where p.nom_projet like :name")
    public Page<Projet> projetByNom_projet(@Param("name") String n, Pageable pageable);

}
