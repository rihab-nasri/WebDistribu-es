package com.example.stagiairemsa.Controller;

import com.example.stagiairemsa.Service.StagiaireService;
import com.example.stagiairemsa.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StagiaireController {

    @Autowired
    StagiaireService stagiaireService;

    @PostMapping("/addStagiaire")
    public Stagiaire addStagiaire (@RequestBody Stagiaire s )
    {
         return stagiaireService.addStagiaire(s);
    }

    @PostMapping("/AssignStagiaireToEncadreur/{ids}/{idEnc}")
    public Stagiaire Assign (@PathVariable int ids , @PathVariable int idEnc)
    {
        return stagiaireService.AssignStagiaireToEnc(ids,idEnc);
    }


    @GetMapping("/FinStage")
    public List FinStage()
    {
         return stagiaireService.FinStage();
    }

    @GetMapping("/BestStagiare")
    public void BestStagiaire ()
    {
        stagiaireService.BestStagiaire();
    }

}
