package com.dvf.project.S_Sync.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
public class task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private LocalDate completionDate;
    private LocalDate subitDate;

    @Enumerated(EnumType.STRING)
    private TypeTask type;

    @Enumerated(EnumType.STRING)
    private StatusTaks status;

    @Enumerated(EnumType.STRING)
    private PriorityTask priority;

}
