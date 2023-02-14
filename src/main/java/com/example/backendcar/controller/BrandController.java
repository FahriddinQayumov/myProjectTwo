package com.example.backendcar.controller;

import com.example.backendcar.dto.brand.BrandCreateDto;
import com.example.backendcar.dto.brand.BrandDetailDto;
import com.example.backendcar.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id")UUID id){
        BrandDetailDto response=brandService.get(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid BrandCreateDto brand){
        brandService.create(brand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id,@RequestBody @Valid BrandCreateDto dto){
        brandService.update(id,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<BrandDetailDto> response=brandService.getAll();
        return ResponseEntity.ok(response);
    }
}
