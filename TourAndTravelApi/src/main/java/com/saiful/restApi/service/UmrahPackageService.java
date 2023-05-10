package com.saiful.restApi.service;


import com.saiful.restApi.entity.HajjPackage;
import com.saiful.restApi.entity.UmrahPackage;
import com.saiful.restApi.repository.UmrahPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class UmrahPackageService {
    @Autowired
    UmrahPackageRepo umrahPackageRepo;
    public void initUmrahPackage(){


//        UmrahPackage UmrahPackage1 = new UmrahPackage();
//        UmrahPackage1.setName("Umrah Package");
//        UmrahPackage1.setType("Economy Umrah Package");
//        UmrahPackage1.setPrice("120000");
//        UmrahPackage1.setStartDate("01-01-2023");
//        UmrahPackage1.setEndDate("31-12-2023");
//        UmrahPackage1.setDescription("Visa with all charges.Meet & assist on arrival at Jeddah airport");
//        UmrahPackage1.setLocation("Makkah & Madinah");
//        UmrahPackage1.setImageLink("https://images.unsplash.com/photo-1540866225557-9e4c58100c67?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aGFqanxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60");
//        umrahPackageRepo.save(UmrahPackage1);
//
//        UmrahPackage UmrahPackage2 = new UmrahPackage();
//        UmrahPackage2.setName("Umrah Package");
//        UmrahPackage2.setType("Premium Umrah Package");
//        UmrahPackage2.setPrice("250000");
//        UmrahPackage2.setStartDate("01-01-2023");
//        UmrahPackage2.setEndDate("31-12-2023");
//        UmrahPackage2.setDescription("Visa with all charges.Meet & assist on arrival at Jeddah airport");
//        UmrahPackage2.setLocation("Makkah & Madinah");
//        UmrahPackage2.setImageLink("https://images.unsplash.com/photo-1540866225557-9e4c58100c67?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aGFqanxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60");
//        umrahPackageRepo.save(UmrahPackage2);
//
//
//        UmrahPackage UmrahPackage3 = new UmrahPackage();
//        UmrahPackage3.setName("Umrah Package");
//        UmrahPackage3.setType("Platinum Umrah Package");
//        UmrahPackage3.setPrice("180000");
//        UmrahPackage3.setStartDate("01-01-2023");
//        UmrahPackage3.setEndDate("31-12-2023");
//        UmrahPackage3.setDescription("Visa with all charges.Meet & assist on arrival at Jeddah airport");
//        UmrahPackage3.setLocation("Makkah & Madinah");
//        UmrahPackage3.setImageLink("https://images.unsplash.com/photo-1540866225557-9e4c58100c67?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aGFqanxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60");
//        umrahPackageRepo.save(UmrahPackage3);
//
//
//        UmrahPackage UmrahPackage4 = new UmrahPackage();
//        UmrahPackage4.setName("Umrah Package");
//        UmrahPackage4.setType("Platinum Umrah Package");
//        UmrahPackage4.setPrice("180000");
//        UmrahPackage4.setStartDate("01-01-2023");
//        UmrahPackage4.setEndDate("31-12-2023");
//        UmrahPackage4.setDescription("Visa with all charges.Meet & assist on arrival at Jeddah airport");
//        UmrahPackage4.setLocation("Makkah & Madinah");
//        UmrahPackage4.setImageLink("https://images.unsplash.com/photo-1540866225557-9e4c58100c67?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aGFqanxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60");
//        umrahPackageRepo.save(UmrahPackage3);
//

    }
    public List<UmrahPackage> findAll() {

        return umrahPackageRepo.findAll();
    }

    public void save(UmrahPackage umrahPackageNew) {
        if (umrahPackageNew.getId()!= null){
            umrahPackageRepo.findById(umrahPackageNew.getId())
                    .map(old -> {

//    private String name;
//    private String type;
//    private String price;
//    private String startDate;
//    private String endDate;
//    private String description;
//    private String location;
//    private String imageLink;

                        old.setName(umrahPackageNew.getName());
                        old.setType(umrahPackageNew.getType());
                        old.setPrice(umrahPackageNew.getPrice());
                        old.setStartDate(umrahPackageNew.getStartDate());
                        old.setEndDate(umrahPackageNew.getEndDate());
                        old.setDescription(umrahPackageNew.getDescription());
                        old.setLocation(umrahPackageNew.getLocation());
                        old.setImageLink(umrahPackageNew.getImageLink());

                        return umrahPackageRepo.save(old);
                    })
                    .orElseGet(() -> {
                        return umrahPackageRepo.save(umrahPackageNew);
                    });
        }else {
            umrahPackageRepo.save(umrahPackageNew);
        }
    }

    public UmrahPackage getById(Long id) {
       return umrahPackageRepo.findById(id).orElse(new UmrahPackage());
    }

    public void delete(Long id) {
         umrahPackageRepo.deleteById(id);
    }

}
