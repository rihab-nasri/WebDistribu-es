package com.example.rhproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService {
    @Autowired
    FormationRepository FormationRepo;

    public Formation addFormation(Formation Formation) {
        return FormationRepo.save(Formation);
    }
    public Formation updateFormation(int id, Formation newFormation) {
        if (FormationRepo.findById(id).isPresent()) {
            Formation existingFormation = FormationRepo.findById(id).get();
            existingFormation.setName(newFormation.getName());
            existingFormation.setDescription(newFormation.getDescription());
            existingFormation.setDuration(newFormation.getDuration());
            existingFormation.setMonitor(newFormation.getMonitor());
            existingFormation.setApplicantsNbr(newFormation.getApplicantsNbr());
            existingFormation.setStartDate(newFormation.getStartDate());
            existingFormation.setEndDate(newFormation.getEndDate());
            existingFormation.setCapacity(newFormation.getCapacity());

            return FormationRepo.save(existingFormation);
        } else
            return null;
    }


    public String deleteFormation(int id) {
        if (FormationRepo.findById(id).isPresent()) {
            FormationRepo.deleteById(id);
            return "Formation deleted";
        } else
            return "Formation not deleted";
    }
    public List<Formation> getAllFormation(){

        return FormationRepo.findAll();
    }

    public Formation getFormationById(int id) {
        Optional<Formation> optionalFormation = FormationRepo.findById(id);

        if (optionalFormation.isPresent()) {
            return optionalFormation.get();
        } else {
            return null; // Ou jetez une exception de livraison introuvable si nécessaire
        }
    }

}
