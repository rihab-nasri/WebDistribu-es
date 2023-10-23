package com.sprintservice.service;

import com.sprintservice.entity.SprintEntity;

import java.util.List;

public interface SprintService {

    public SprintEntity addSprint(SprintEntity sprint);

    public List<SprintEntity> getAllSprints();

    public SprintEntity updateSprint (SprintEntity sprintEntity);

    public void deleteSprint (int id);

    public List<SprintEntity> getSprintsByUser(Integer userId);
}
