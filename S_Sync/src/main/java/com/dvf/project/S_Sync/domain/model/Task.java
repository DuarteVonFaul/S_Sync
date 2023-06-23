package com.dvf.project.S_Sync.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String title;
    private String description;
    private LocalDate completionDate;
    private LocalDate submitDate;

    @Enumerated(EnumType.STRING)
    private TypeTask type;

    @Enumerated(EnumType.STRING)
    private StatusTaks status;

    @Enumerated(EnumType.STRING)
    private PriorityTask priority;

    @OneToOne
    @JoinColumn(name = "Developer_id")
    private Developer developer;

}
