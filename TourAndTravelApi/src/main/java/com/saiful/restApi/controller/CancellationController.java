package com.saiful.restApi.controller;

import com.saiful.restApi.dtos.CancellationDTO;
import com.saiful.restApi.entity.Cancellation;
import com.saiful.restApi.service.CancellationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CancellationController {
    @Autowired
    CancellationService cancellationService;
    @PostMapping("/cancellation")
    public void save(@RequestBody CancellationDTO cancellationDTO){
        if (cancellationDTO != null){
            Cancellation Cancellation = new Cancellation();
            BeanUtils.copyProperties(cancellationDTO, Cancellation);
            cancellationService.save(Cancellation);
        }
    }
    @PutMapping("/cancellation")
    public void update( @RequestBody CancellationDTO cancellationDTO){
        if (cancellationDTO != null){
            Cancellation Cancellation = new Cancellation();
            BeanUtils.copyProperties(cancellationDTO, Cancellation);
            cancellationService.save(Cancellation);
        }
    }
    @GetMapping("/cancellation")
    List<CancellationDTO> all() {
        List<Cancellation> cancellations = cancellationService.findAll();
        List<CancellationDTO> cancellationDTOList = new ArrayList<>();
        for (Cancellation Cancellation : cancellations
        ) {
            CancellationDTO cancellationDTO = new CancellationDTO();
            BeanUtils.copyProperties(Cancellation, cancellationDTO);
            cancellationDTOList.add(cancellationDTO);
        }
        return cancellationDTOList;
    }
    @DeleteMapping("/cancellation/{id}")
    public void delete(@PathVariable("id") Long id){
        cancellationService.delete(id);
    }


    @GetMapping("/cancellation/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        Cancellation Cancellation;
        Cancellation = cancellationService.getById(id);
        if (Cancellation.getId() != null){
            CancellationDTO cancellationDTO = new CancellationDTO();
            BeanUtils.copyProperties(Cancellation, cancellationDTO);
            return ResponseEntity.status(HttpStatus.OK).body(cancellationDTO);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data Not Found!!");
//        return new ResponseEntity("Hello World", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
