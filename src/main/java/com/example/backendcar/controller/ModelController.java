package com.example.backendcar.controller;

import com.example.backendcar.dto.model.ModelCreateDto;
import com.example.backendcar.dto.model.ModelDetailDto;
import com.example.backendcar.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ModelCreateDto dto){
        modelService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") UUID id){
        ModelDetailDto response=modelService.get(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id,@RequestBody @Valid ModelCreateDto dto){
        modelService.update(id,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        modelService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<ModelDetailDto> response=modelService.getAll();
        return ResponseEntity.ok(response);
    }
}
