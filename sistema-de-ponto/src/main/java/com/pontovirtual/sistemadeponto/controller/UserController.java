package com.pontovirtual.sistemadeponto.controller;

import com.pontovirtual.sistemadeponto.dto.UserRequestDTO;
import com.pontovirtual.sistemadeponto.dto.UserResponseDTO;
import com.pontovirtual.sistemadeponto.model.UserModel;
import com.pontovirtual.sistemadeponto.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRequestDTO data) {
        UserModel userModelData = new UserModel();
        BeanUtils.copyProperties(data, userModelData);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModelData));
    }


    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<UserResponseDTO> userList = userRepository.findAll().stream().map(UserResponseDTO::new).toList();
        if (userList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id ) {
        Optional<UserModel> user = userRepository.findById(id);
        if(user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id, @RequestBody @Valid UserRequestDTO data) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        UserModel existingUser = userOptional.get();
        BeanUtils.copyProperties(data, existingUser, "id");
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(existingUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        userRepository.deleteById(userOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    }

}
