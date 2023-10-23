package com.example.rhproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class QRCodeService {

    @Autowired
    private FormationRepository formationRepository;

    public String generateQRCode(Integer formationyId) {
        // Récupérer la formation en fonction de l'ID
        Formation formation = formationRepository.findById(formationyId).orElse(null);

        if (formation == null) {
            return null;
        }



        StringBuilder builder = new StringBuilder();
        builder.append("Delivery ID: ").append(formation.getId()).append("\n");
        builder.append("Name: ").append(formation.getName()).append("\n");
        builder.append("description: ").append(formation.getDescription()).append("\n");
        builder.append("monitor: ").append(formation.getMonitor()).append("\n");
        builder.append("duration: ").append(formation.getDuration()).append("\n");
        builder.append("startDate : ").append(formation.getStartDate()).append("\n");
        builder.append("endDate: ").append(formation.getEndDate()).append("\n");
        builder.append("applicantsNbr : ").append(formation.getApplicantsNbr()).append("\n");
        builder.append("capacity: ").append(formation.getCapacity()).append("\n");

        return builder.toString();
    }

}
