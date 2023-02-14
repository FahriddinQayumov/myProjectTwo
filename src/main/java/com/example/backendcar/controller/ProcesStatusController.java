package com.example.backendcar.controller;

import com.example.backendcar.dto.processtatus.ProcesStatusCreateDto;
import com.example.backendcar.dto.processtatus.ProcesStatusDetailDto;
import com.example.backendcar.service.ProcesStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("proces_status")
public class ProcesStatusController {
    @Autowired
    private ProcesStatusService procesStatusService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProcesStatusCreateDto procesStatusCreateDto) {
        procesStatusService.create(procesStatusCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") UUID id){
        ProcesStatusDetailDto response= procesStatusService.get(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id,@RequestBody @Valid ProcesStatusCreateDto dto){
        procesStatusService.update(id,dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        procesStatusService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<ProcesStatusDetailDto> response=procesStatusService.getAll();
        return ResponseEntity.ok(response);
    }

}
