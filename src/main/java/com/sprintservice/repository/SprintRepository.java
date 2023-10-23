package com.sprintservice.repository;

import com.sprintservice.entity.SprintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<SprintEntity, Integer> {
    List<SprintEntity> findBySprintState(boolean etatSprint);
    List<SprintEntity> findBySprintName(String nomSprint);
}
