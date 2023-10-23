package com.sprintservice.controller;

import com.sprintservice.entity.SprintEntity;
import com.sprintservice.service.Impl.SprintServiceImpl;
import com.sprintservice.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    public SprintService sprintService;

    @PostMapping("/add")
    public SprintEntity addSprint(@RequestBody SprintEntity sprint){
        return sprintService.addSprint(sprint);
    }

    //@PreAuthorize("hasRole('manager')")
    @GetMapping(value = "/all")
    @ResponseBody
    public List<SprintEntity> getAllSprints() {
        return sprintService.getAllSprints();
    }

    @PutMapping("/update")
    @ResponseBody
    public SprintEntity updatesprint(@RequestBody SprintEntity sprintEntity){
        return sprintService.updateSprint(sprintEntity);
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public void deleteSprint (@PathVariable  Integer  id){
        sprintService.deleteSprint(id);
    }

    @GetMapping(path = "sprintsByUser/{userId}")
    public List<SprintEntity> getSprintsByUser(@PathVariable Integer userId){
        return sprintService.getSprintsByUser(userId);
    }

    /*@GetMapping("/state-zero")
    public ResponseEntity<List<SprintEntity>> getSprintsWithEtatZero() {
        List<SprintEntity> sprints = sprintService.getSprintsByEtatSprint(false);
        return new ResponseEntity<>(sprints, HttpStatus.OK);
    }*/
}
