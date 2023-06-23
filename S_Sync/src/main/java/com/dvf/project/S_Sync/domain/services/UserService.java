package com.dvf.project.S_Sync.domain.services;

import com.dvf.project.S_Sync.domain.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userRepository")
public class UserService extends BasicService<User>{

    public UserService(JpaRepository<User, Integer> repository) {
        super(repository);
    }


}
