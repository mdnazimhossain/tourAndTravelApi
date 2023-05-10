package com.saiful.restApi.controller;

import com.saiful.restApi.dtos.HajjPackageDTO;
import com.saiful.restApi.entity.HajjPackage;
import com.saiful.restApi.service.HajjPackageService;
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
public class HajjPackageController {
    @Autowired
    HajjPackageService hajjPackageService;

    @PostConstruct
    public void initHajjPackageCon(){
        hajjPackageService.initHajjPackage();
    }
    @PostMapping("/hajjPackage")
    public void save(@RequestBody HajjPackageDTO hajjPackageDTO){
        if (hajjPackageDTO != null){
            HajjPackage hajjPackage = new HajjPackage();
            BeanUtils.copyProperties(hajjPackageDTO, hajjPackage);
            hajjPackageService.save(hajjPackage);
        }
    }
    @PutMapping("/hajjPackage")
    public void update( @RequestBody HajjPackageDTO hajjPackageDTO){
        if (hajjPackageDTO != null){
            HajjPackage hajjPackage = new HajjPackage();
            BeanUtils.copyProperties(hajjPackageDTO, hajjPackage);
            hajjPackageService.save(hajjPackage);
        }
    }
    @GetMapping("/hajjPackage")
    List<HajjPackageDTO> all() {
        List<HajjPackage> hajjPackages = hajjPackageService.findAll();
        List<HajjPackageDTO> hajjPackageDTOList = new ArrayList<>();
        for (HajjPackage hajjPackage : hajjPackages
        ) {
            HajjPackageDTO hajjPackageDTO = new HajjPackageDTO();
            BeanUtils.copyProperties(hajjPackage, hajjPackageDTO);
            hajjPackageDTOList.add(hajjPackageDTO);
        }
        return hajjPackageDTOList;
    }
    @DeleteMapping("/hajjPackage/{id}")
    public void delete(@PathVariable("id") Long id){
        hajjPackageService.delete(id);
    }


    @GetMapping("/hajjPackage/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        HajjPackage hajjPackage;
        hajjPackage = hajjPackageService.getById(id);
        if (hajjPackage.getId() != null){
            HajjPackageDTO hajjPackageDTO = new HajjPackageDTO();
            BeanUtils.copyProperties(hajjPackage, hajjPackageDTO);
            return ResponseEntity.status(HttpStatus.OK).body(hajjPackageDTO);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data Not Found!!");
//        return new ResponseEntity("Hello World", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
