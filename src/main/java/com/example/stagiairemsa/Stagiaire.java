package com.example.stagiairemsa;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stagiaire implements Serializable {

    @Id
    @GeneratedValue
    int id;
    String name;
    LocalDate dateDebut,dateFin;
    Boolean archivee=false;
    Double noteAttribue;
    @ManyToOne
    private Encadreur encadreur;









}
