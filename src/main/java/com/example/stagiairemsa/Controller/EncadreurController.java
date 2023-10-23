package com.example.stagiairemsa.Controller;


import com.example.stagiairemsa.Encadreur;
import com.example.stagiairemsa.Service.EncadreurService;
import com.example.stagiairemsa.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncadreurController {

    @Autowired
    EncadreurService encadreurService;

    @PostMapping("/addEncadreur")
    public Encadreur addEncadreur (@RequestBody Encadreur s )
    {
        return encadreurService.addEncadreur(s);
    }
}
