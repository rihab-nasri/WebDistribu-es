package com.esprit.rhmanager.demandeconge.Repository;

import com.esprit.rhmanager.demandeconge.Entities.DemandeConge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CongeRepository extends JpaRepository<DemandeConge,Integer> {

    @Query("select c from DemandeConge c where c.userName like :userName")
    public Page<DemandeConge> DemandeByName(@Param("userName") String n, Pageable pageable);


}