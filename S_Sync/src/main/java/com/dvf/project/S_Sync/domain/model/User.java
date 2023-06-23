package com.dvf.project.S_Sync.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "Developer_id")
    private Developer developer;

}
