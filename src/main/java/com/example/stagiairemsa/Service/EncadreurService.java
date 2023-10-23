package com.example.stagiairemsa.Service;


import com.example.stagiairemsa.Encadreur;
import com.example.stagiairemsa.Repository.EncadreurRepo;
import com.example.stagiairemsa.Repository.StagiaireRepo;
import com.example.stagiairemsa.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncadreurService {

    @Autowired
    EncadreurRepo encadreurRepo;

    @Autowired
    StagiaireRepo stagiaireRepo;

    public Encadreur addEncadreur (Encadreur encadreur)
    {
        return encadreurRepo.save(encadreur);
    }





}
