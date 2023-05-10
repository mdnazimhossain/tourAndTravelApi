package com.saiful.restApi.controller;

import com.saiful.restApi.dtos.UmrahPackageDTO;
import com.saiful.restApi.entity.UmrahPackage;
import com.saiful.restApi.service.UmrahPackageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UmrahPackageController {
    @Autowired
    UmrahPackageService umrahPackageService;


    @PostConstruct
    public void initUmrahPackageCon(){
        umrahPackageService.initUmrahPackage();
    }
    @PostMapping("/umrahPackage")
    public void save(@RequestBody UmrahPackageDTO umrahPackageDTO){
        if (umrahPackageDTO != null){
            UmrahPackage umrahPackage = new UmrahPackage();
            BeanUtils.copyProperties(umrahPackageDTO, umrahPackage);
            umrahPackageService.save(umrahPackage);
        }
    }
    @PutMapping("/umrahPackage")
    public void update( @RequestBody UmrahPackageDTO umrahPackageDTO){
        if (umrahPackageDTO != null){
            UmrahPackage umrahPackage = new UmrahPackage();
            BeanUtils.copyProperties(umrahPackageDTO, umrahPackage);
            umrahPackageService.save(umrahPackage);
        }
    }
    @GetMapping("/umrahPackage")
    List<UmrahPackageDTO> all() {
        List<UmrahPackage> umrahPackages = umrahPackageService.findAll();
        List<UmrahPackageDTO> umrahPackageDTOList = new ArrayList<>();
        for (UmrahPackage umrahPackage : umrahPackages
        ) {
            UmrahPackageDTO umrahPackageDTO = new UmrahPackageDTO();
            BeanUtils.copyProperties(umrahPackage, umrahPackageDTO);
            umrahPackageDTOList.add(umrahPackageDTO);
        }
        return umrahPackageDTOList;
    }
    @DeleteMapping("/umrahPackage/{id}")
    public void delete(@PathVariable("id") Long id){
        umrahPackageService.delete(id);
    }


    @GetMapping("/umrahPackage/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        UmrahPackage umrahPackage;
        umrahPackage = umrahPackageService.getById(id);
        if (umrahPackage.getId() != null){
            UmrahPackageDTO umrahPackageDTO = new UmrahPackageDTO();
            BeanUtils.copyProperties(umrahPackage, umrahPackageDTO);
            return ResponseEntity.status(HttpStatus.OK).body(umrahPackageDTO);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data Not Found!!");
//        return new ResponseEntity("Hello World", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
