package com.example.rhproject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String monitor;
    private int duration;
    private LocalDate startDate;
    private LocalDate endDate;
    private int applicantsNbr;
    private int capacity;
    private String notice;

    public Formation(String name, String description, String monitor, int duration) {
        this.name = name;
        this.description = description;
        this.monitor = monitor;
        this.duration = duration;
    }
}
