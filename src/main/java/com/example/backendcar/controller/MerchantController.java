package com.example.backendcar.controller;

import com.example.backendcar.dto.apllication.ApplicationDetailDto;
import com.example.backendcar.dto.merchant.MerchantCreateDto;
import com.example.backendcar.dto.merchant.MerchantDetailDto;
import com.example.backendcar.dto.merchant.MerchantUpdateDto;
import com.example.backendcar.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid MerchantCreateDto dto){
        merchantService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") UUID id){
        MerchantDetailDto response= (MerchantDetailDto) merchantService.get(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable("id") UUID id, @RequestBody @Valid MerchantUpdateDto dto){
        merchantService.update(id,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        merchantService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<MerchantDetailDto> response=merchantService.getAll();
        return ResponseEntity.ok(response);
    }
}
