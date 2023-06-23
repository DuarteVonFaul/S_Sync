package com.dvf.project.S_Sync.domain.repository;


import com.dvf.project.S_Sync.domain.model.Developer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("developerRepository")
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
}
