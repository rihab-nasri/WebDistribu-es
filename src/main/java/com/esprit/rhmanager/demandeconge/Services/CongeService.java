package com.esprit.rhmanager.demandeconge.Services;

import com.esprit.rhmanager.demandeconge.Entities.DemandeConge;
import com.esprit.rhmanager.demandeconge.Repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CongeService {

    @Autowired
    private CongeRepository congeRepository;

    public DemandeConge addDemande(DemandeConge demandeConge) {
        return congeRepository.save(demandeConge);

    }

    public DemandeConge updateDemande(int idConge, DemandeConge newDemande) {
        if (congeRepository.findById(idConge).isPresent()) {
            DemandeConge existingDemande = congeRepository.findById(idConge).get();
            existingDemande.setDuree(newDemande.getDuree());
            existingDemande.setEtat(newDemande.getEtat());

            return congeRepository.save(existingDemande);

        } else
            return null;

    }

    public String deleteDemande(int idConge){
        if (congeRepository.findById(idConge).isPresent()){
            congeRepository.deleteById(idConge);
            return "Demande supprimé" ;

        }else
            return "demande non supprimé " ;
    }



}
