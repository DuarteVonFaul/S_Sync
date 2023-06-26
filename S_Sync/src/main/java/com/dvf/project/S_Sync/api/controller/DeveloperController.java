package com.dvf.project.S_Sync.api.controller;

import com.dvf.project.S_Sync.domain.model.Developer;
import com.dvf.project.S_Sync.domain.model.Task;
import com.dvf.project.S_Sync.domain.services.DeveloperService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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





}
