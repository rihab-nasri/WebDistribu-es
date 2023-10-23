package com.sprintservice.service.Impl;

import com.sprintservice.entity.SprintEntity;
import com.sprintservice.model.User;
import com.sprintservice.openfeign.UserRestClient;
import com.sprintservice.repository.SprintRepository;
import com.sprintservice.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SprintServiceImpl implements SprintService {

    private SprintRepository sprintRepository;
    private UserRestClient userRestClient;

    public SprintServiceImpl(SprintRepository sprintRepository, UserRestClient userRestClient) {
        this.sprintRepository = sprintRepository;
        this.userRestClient = userRestClient;
    }

    @Override
    public SprintEntity addSprint(SprintEntity sprint) {
        User user = userRestClient.getUserById(sprint.getUserId());
        sprint.setUser(user);
        return sprintRepository.save(sprint);
    }

    @Override
    public List<SprintEntity> getAllSprints() {
        return sprintRepository.findAll();
    }

    @Override
    public SprintEntity updateSprint(SprintEntity sprint) {
        return sprintRepository.save(sprint);
    }

    @Override
    public void deleteSprint(int id) {
        sprintRepository.deleteById(id);
    }

    @Override
    public List<SprintEntity> getSprintsByUser(Integer userId) {

        return null;
    }
}
