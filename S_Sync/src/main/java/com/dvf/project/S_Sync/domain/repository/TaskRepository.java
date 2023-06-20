package com.dvf.project.S_Sync.domain.repository;

import com.dvf.project.S_Sync.domain.model.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Integer> {
    // Você pode adicionar métodos personalizados de consulta, se necessário
}
