package com.esprit.rhmanager.demandeconge.Controller;

import com.esprit.rhmanager.demandeconge.Entities.DemandeConge;
import com.esprit.rhmanager.demandeconge.Services.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class CongeRestAPI {

    @Autowired
  private   CongeService congeService ;


    private String title=" hello , i'm the employer Micro service" ;

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println(title);
        return title ;

    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DemandeConge> createDemande(@RequestBody DemandeConge demandeConge){
        return new ResponseEntity<>(congeService.addDemande(demandeConge),HttpStatus.OK);
    }

    @PutMapping(value = "/{idConge}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DemandeConge> updateDemande(@PathVariable(value = "idConge") int idConge,
                                                      @RequestBody DemandeConge demandeConge){
        return new ResponseEntity<>(congeService.updateDemande(idConge, demandeConge),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{idConge}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteDemande(@PathVariable(value = "idConge") int idConge){
        return new ResponseEntity<>(congeService.deleteDemande(idConge), HttpStatus.OK);
    }



}
