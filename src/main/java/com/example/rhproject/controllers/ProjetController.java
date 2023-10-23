package com.example.rhproject.controllers;

import com.example.rhproject.Services.ProjetService;
import com.example.rhproject.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("projets")
public class ProjetController {

    @Autowired
    private ProjetService projetService;


    @PostMapping(value = "/addProjet", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Projet> addProjet(@RequestBody Projet projet) {
        return new ResponseEntity<>(projetService.addProjet(projet), HttpStatus.OK);
    }


    @PutMapping(value = "/updateProjet/{id_projet}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Projet> updateProjet(@PathVariable(value = "id_projet") Integer id_projet, @RequestBody Projet projet)
    {
        return new ResponseEntity<>(projetService.updateProjet(id_projet, projet), HttpStatus.OK);
    }


    @DeleteMapping(value = "/deleteProjet/{id_projet}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteProjet(@PathVariable(value = "id_projet") Integer id_projet){
        projetService.deleteProjet(id_projet);
    }

    @GetMapping(value = "/getProjets", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Projet> getProjets() {
        List<Projet> listProjets = projetService.getAllProjets();
        return listProjets ;
    }

    @GetMapping(value = "/getProjetById/{id_projet}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Projet> getProjetById(@PathVariable(value = "id_projet") Integer id_projet) {
        Optional<Projet> projet = projetService.getProjetById(id_projet);
        if (projet.isPresent()) {
            return new ResponseEntity<>(projet.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
