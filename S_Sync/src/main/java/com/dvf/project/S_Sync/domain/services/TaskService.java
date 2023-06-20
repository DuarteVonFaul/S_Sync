package com.dvf.project.S_Sync.domain.services;

import com.dvf.project.S_Sync.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends BasicService<Task>{

    public TaskService(JpaRepository<Task, Integer> repository) {
        super(repository);
    }

}
