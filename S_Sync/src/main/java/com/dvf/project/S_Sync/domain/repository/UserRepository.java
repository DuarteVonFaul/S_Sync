package com.dvf.project.S_Sync.domain.repository;

import com.dvf.project.S_Sync.domain.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
}
