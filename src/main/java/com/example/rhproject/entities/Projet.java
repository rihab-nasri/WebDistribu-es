package com.example.rhproject.entities;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_projet;
    private String nom_projet;
    private String description;
    private String competence;
    private Date date_debut;
    private Date date_fin;
    private double budget;

    public Projet(String nom_projet, String description, String competence, String date_debut, String date_fin, double budget) throws ParseException {
        this.nom_projet = nom_projet;
        this.description = description;
        this.competence = competence;
        this.budget = budget;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.date_debut = dateFormat.parse(date_debut);
        this.date_fin = dateFormat.parse(date_fin);
    }


}
