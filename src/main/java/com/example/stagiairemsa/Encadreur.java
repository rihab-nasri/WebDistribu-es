package com.example.stagiairemsa;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Encadreur implements Serializable {

    @Id
    @GeneratedValue
    int id;
    String nom;
    String departement;



    @OneToMany (mappedBy = "encadreur")
    private List<Stagiaire> stagiaireList;

}
