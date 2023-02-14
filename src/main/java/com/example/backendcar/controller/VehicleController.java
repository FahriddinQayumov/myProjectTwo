package com.example.backendcar.controller;

import com.example.backendcar.dto.vehicle.VehicleCreateDto;
import com.example.backendcar.dto.vehicle.VehicleDetailDto;
import com.example.backendcar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid VehicleCreateDto dto){
        vehicleService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id")UUID id){
        VehicleDetailDto response= vehicleService.get(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id,@RequestBody @Valid VehicleCreateDto dto){
        vehicleService.update(id,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<VehicleDetailDto> response=vehicleService.getAll();
        return ResponseEntity.ok(response);
    }
}
