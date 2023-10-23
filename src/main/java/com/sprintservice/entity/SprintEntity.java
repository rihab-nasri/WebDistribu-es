package com.sprintservice.entity;

import com.sprintservice.model.User;
import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SprintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sprintId ;
    private Date startDate;
    private  Date endDate;
    private String sprintName;
    private  boolean sprintState;
    @Enumerated(EnumType.STRING)
    private  SprintEnum status;
    private Long userId;

    @Transient
    User user;
}
