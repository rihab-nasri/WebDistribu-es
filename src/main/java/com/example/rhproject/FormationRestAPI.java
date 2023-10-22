package com.example.rhproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormationRestAPI {

    @Autowired
    private FormationService FormationService;


    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Formation> createFormation(@RequestBody Formation formation) {
        return new ResponseEntity<>(FormationService.addFormation(formation), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Formation> updateFormation(@PathVariable(value = "id") int id, @RequestBody Formation formation)
    {
        return new ResponseEntity<>(FormationService.updateFormation(id, formation), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteFormation(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(FormationService.deleteFormation(id), HttpStatus.OK);
    }

    @GetMapping(value = "/formations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Formation> getFormation() {
        List<Formation> listFormation = FormationService.getAllFormation();
        return listFormation ;
    }



}
