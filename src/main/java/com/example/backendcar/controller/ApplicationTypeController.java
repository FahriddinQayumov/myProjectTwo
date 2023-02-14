package com.example.backendcar.controller;

import com.example.backendcar.dto.applicationtype.ApplicationTypeCreateDto;
import com.example.backendcar.dto.applicationtype.ApplicationTypeDetailDto;
import com.example.backendcar.service.ApplicationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/application_type")
public class ApplicationTypeController {
    @Autowired
    private ApplicationTypeService applicationTypeService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ApplicationTypeCreateDto applicationTypeCreateDto){
        applicationTypeService.create(applicationTypeCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") UUID id){
        ApplicationTypeDetailDto response= applicationTypeService.get(id);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id,@RequestBody @Valid ApplicationTypeCreateDto dto){
        applicationTypeService.update(id,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        applicationTypeService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<ApplicationTypeDetailDto> response=applicationTypeService.getAll();
        return ResponseEntity.ok(response);
    }



}
