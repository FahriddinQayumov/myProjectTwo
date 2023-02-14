package com.example.backendcar.controller;

import com.example.backendcar.dto.user.UserCreateDto;
import com.example.backendcar.dto.user.UserDetailedDto;
import com.example.backendcar.dto.user.UserUpdateDto;
import com.example.backendcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid UserCreateDto dto){
       userService.create(dto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") UUID id){
        return ResponseEntity.ok(userService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable("id") UUID id, @RequestBody @Valid UserUpdateDto dto){
        userService.update(id,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
}
