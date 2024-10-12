package com.pontovirtual.sistemadeponto.controller;

import com.pontovirtual.sistemadeponto.dto.UserRequestDTO;
import com.pontovirtual.sistemadeponto.dto.UserResponseDTO;
import com.pontovirtual.sistemadeponto.model.User;
import com.pontovirtual.sistemadeponto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO data) {
        User userData = new User(data);
        User savedUser = userRepository.save(userData);
        return ResponseEntity.status(201).body(new UserResponseDTO(savedUser));
    }


    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<UserResponseDTO> userList = userRepository.findAll().stream().map(UserResponseDTO::new).toList();
        if (userList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userList);
    }

}
