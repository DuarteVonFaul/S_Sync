package com.dvf.project.S_Sync.api.controller;

import com.dvf.project.S_Sync.api.dto.request.UserRegisterRequest;
import com.dvf.project.S_Sync.domain.model.User;
import com.dvf.project.S_Sync.domain.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper){
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<User>> get_tasks() {
        List<User> userList = userService.get_all();
        if (userList != null) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserRegisterRequest> create_task(@RequestBody UserRegisterRequest user) {
        userService.create(modelMapper.map(user, User.class));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
