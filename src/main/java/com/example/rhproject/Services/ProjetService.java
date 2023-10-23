package com.example.rhproject.Services;

import com.example.rhproject.entities.Projet;
import com.example.rhproject.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {

    @Autowired
    ProjetRepository projetRepository;

    /* Get All */
    public List<Projet> getAllProjets(){
        return projetRepository.findAll();
    }

    /* Add */
    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    /* Update */
    public Projet updateProjet(Integer id_projet, Projet newProjet) {
        Projet existingProjet = projetRepository.findById(id_projet).orElse(null);

        existingProjet.setNom_projet(newProjet.getNom_projet());
        existingProjet.setDescription(newProjet.getDescription());
        existingProjet.setCompetence(newProjet.getCompetence());
        existingProjet.setDate_debut(newProjet.getDate_debut());
        existingProjet.setDate_fin(newProjet.getDate_fin());
        existingProjet.setBudget(newProjet.getBudget());

        return projetRepository.save(existingProjet);
    }


    /* Delete */
    public void deleteProjet(Integer id_projet) {
        Projet projet = projetRepository.findById(id_projet).orElse(null);
        projetRepository.delete(projet);
    }

    /* Get Projet */
    public Optional<Projet> getProjetById(Integer id_projet) {
            return projetRepository.findById(id_projet);
    }



}
