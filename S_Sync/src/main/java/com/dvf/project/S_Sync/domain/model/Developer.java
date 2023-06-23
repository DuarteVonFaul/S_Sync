package com.dvf.project.S_Sync.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String name;
    private String email;

    @OneToOne(mappedBy = "developer")
    private User user;



}
