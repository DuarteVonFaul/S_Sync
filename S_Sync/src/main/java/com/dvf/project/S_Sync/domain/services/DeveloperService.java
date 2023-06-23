package com.dvf.project.S_Sync.domain.services;

import com.dvf.project.S_Sync.domain.model.Developer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@Qualifier("developerRepository")
public class DeveloperService extends BasicService<Developer> {


    public DeveloperService(JpaRepository<Developer, Integer> repository) {
        super(repository);
    }

}
