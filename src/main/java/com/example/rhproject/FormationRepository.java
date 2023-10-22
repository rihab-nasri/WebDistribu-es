package com.example.rhproject;

import com.example.rhproject.Formation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface FormationRepository extends JpaRepository<Formation, Integer> {
    @Query("select c from Formation c where c.name like :name")
    public Page<Formation> formationByName(@Param("name") String n, Pageable pageable);

}
