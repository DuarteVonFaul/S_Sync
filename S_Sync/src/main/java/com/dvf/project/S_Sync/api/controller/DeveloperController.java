package com.dvf.project.S_Sync.api.controller;

import com.dvf.project.S_Sync.domain.model.Developer;
import com.dvf.project.S_Sync.domain.services.DeveloperService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private DeveloperService developerService;
    private ModelMapper modelMapper;

    public DeveloperController(DeveloperService developerService, ModelMapper modelMapper){
        this.developerService = developerService;
        this.modelMapper      = modelMapper;
    }


    @GetMapping
    public ResponseEntity<List<Developer>> get_developer_list(){
        List<Developer> developerList = developerService.get_all();
        if (developerList != null) {
            return new ResponseEntity<>(developerList, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Developer> create_task(@RequestBody Developer developer) {
        developerService.create(developer);
        return new ResponseEntity<>(developer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> get_task_id(@PathVariable Integer id ){
        Optional<Developer> developer = developerService.find_by_id(id);
        if(developer != null){
            return new ResponseEntity<>(developer.get(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developer> update_task(@PathVariable Integer id, @RequestBody Developer newDeveloper ){
        Developer developer = developerService.update_by_id(newDeveloper, id);
        if(developer != null){
            return new ResponseEntity<>(developer, HttpStatus.ACCEPTED);
        }
        return ResponseEntity.notFound().build();
    }


}
