package com.dvf.project.S_Sync.domain.services;

import com.dvf.project.S_Sync.domain.model.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService extends BasicService<Task>{

    public TaskService(JpaRepository<Task, Integer> repository) {
        super(repository);
    }

    public Task update_task_by_id(Task task, Integer id){
        Optional<Task> optionalEntityDataBse = this.find_by_id(id);

        if (optionalEntityDataBse.isPresent()) {
            Task updateTask = optionalEntityDataBse.get();
            task.setCompletionDate(updateTask.getCompletionDate());
            task.setSubmitDate(updateTask.getSubmitDate());
            BeanUtils.copyProperties(task, updateTask, "id");
            return this.create(updateTask);
        } else {
            throw new IllegalArgumentException("not fould");
        }
    }

}
