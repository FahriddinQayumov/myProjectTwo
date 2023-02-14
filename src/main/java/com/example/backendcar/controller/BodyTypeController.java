package com.example.backendcar.controller;

import com.example.backendcar.dto.bodytype.BodyTypeCreateDto;
import com.example.backendcar.dto.bodytype.BodyTypeDetailDto;
import com.example.backendcar.service.BodyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/body_type")
public class BodyTypeController {
    @Autowired
    private BodyTypeService bodyTypeService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid BodyTypeCreateDto dto){
        bodyTypeService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") UUID id){
        BodyTypeDetailDto response=bodyTypeService.get(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id,@RequestBody @Valid BodyTypeCreateDto dto) {
        bodyTypeService.update(id,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        bodyTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<BodyTypeDetailDto> response=bodyTypeService.getAll();
        return ResponseEntity.ok(response);
    }
}
