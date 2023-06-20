package com.dvf.project.S_Sync.api.controller;

import com.dvf.project.S_Sync.api.dto.request.TaskUpdateRequest;
import com.dvf.project.S_Sync.domain.model.Task;
import com.dvf.project.S_Sync.domain.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;
    private ModelMapper modelMapper;

    public TaskController(TaskService taskService, ModelMapper modelMapper){
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }


    @GetMapping
    public ResponseEntity<List<Task>> get_tasks() {
        List<Task> taskList = taskService.get_all();
        if (taskList != null) {
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Task> create_task(@RequestBody Task task) {
        taskService.create(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get_task_id(@PathVariable Integer id ){
        Optional<Task> task = taskService.find_by_id(id);
        if(task != null){
            return new ResponseEntity<>(task.get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update_task(@PathVariable Integer id, @RequestBody TaskUpdateRequest newTaks ){
        Task task = modelMapper.map(newTaks, Task.class);
        task = taskService.update_task_by_id(task, id);
        if(task != null){
            return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
        }
        return ResponseEntity.notFound().build();
    }
}
