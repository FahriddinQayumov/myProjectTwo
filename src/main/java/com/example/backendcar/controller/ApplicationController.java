package com.example.backendcar.controller;

import com.example.backendcar.dto.apllication.ApplicationCreateDto;
import com.example.backendcar.dto.apllication.ApplicationDetailDto;
import com.example.backendcar.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ApplicationCreateDto applicationCreateDto){
        applicationService.create(applicationCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") UUID id){
        ApplicationDetailDto response= applicationService.get(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id,@RequestBody @Valid ApplicationCreateDto dto){
        applicationService.update(id,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        applicationService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<ApplicationDetailDto> response=applicationService.getAll();
        return ResponseEntity.ok(response);
    }

}
