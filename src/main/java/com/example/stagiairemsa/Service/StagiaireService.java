package com.example.stagiairemsa.Service;

import com.example.stagiairemsa.Encadreur;
import com.example.stagiairemsa.Repository.EncadreurRepo;
import com.example.stagiairemsa.Repository.StagiaireRepo;
import com.example.stagiairemsa.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class StagiaireService
{

    @Autowired
    StagiaireRepo stagiaireRepo;

    @Autowired
    EncadreurRepo encadreurRepo;

    public Stagiaire addStagiaire (Stagiaire stagiaire)

    {
        return stagiaireRepo.save(stagiaire);
    }

    public Stagiaire AssignStagiaireToEnc (int idStagiaire, int idENc)
    {
        Encadreur encadreur = encadreurRepo.findById(idENc).orElse(null);
        Stagiaire s = stagiaireRepo.findById(idStagiaire).get();
        s.setEncadreur(encadreur);
        stagiaireRepo.save(s);
        return s;

    }

    public List<Stagiaire> FinStage ()
    {
        List<Stagiaire> stagiaireList = stagiaireRepo.findAll();
        for(Stagiaire s : stagiaireList)
        {
            if(s.getDateFin().isBefore(LocalDate.now()))
                s.setArchivee(true);
                stagiaireRepo.save(s);
        }

        return stagiaireList;

    }

    public void BestStagiaire ()
    {
        List<Stagiaire> Stagiaires = stagiaireRepo.findAll();
        Optional<Stagiaire> stagiaireAvecNoteMax = Stagiaires.stream()
                .max(Comparator.comparing(Stagiaire::getNoteAttribue));

        if (stagiaireAvecNoteMax.isPresent()) {
            Stagiaire stagiaireMax = stagiaireAvecNoteMax.get();
            System.out.println("Stagiaire avec la note maximale : " + stagiaireMax.getName() + " - Note : " + stagiaireMax.getNoteAttribue());
        } else {
            System.out.println("Aucun stagiaire trouvé dans la liste.");
        }


    }









}
