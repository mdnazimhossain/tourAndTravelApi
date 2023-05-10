package com.saiful.restApi.service;


import com.saiful.restApi.entity.HajjPackage;
import com.saiful.restApi.repository.HajjPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class HajjPackageService {
    @Autowired
    HajjPackageRepo hajjPackageRepo;
public void initHajjPackage(){

//    HajjPackage hajjPackage1 = new HajjPackage();
//    hajjPackage1.setName("Hajj Package");
//    hajjPackage1.setType("Economy Hajj Package");
//    hajjPackage1.setPrice("620000");
//    hajjPackage1.setStartDate("01-01-2024");
//    hajjPackage1.setEndDate("02-03-2024");
//    hajjPackage1.setDescription("Visa with all charges.Health insurance .Meet & assist on arrival at Jeddah airport");
//    hajjPackage1.setLocation("Makkah & Madinah");
//    hajjPackage1.setImageLink("https://images.unsplash.com/photo-1564769625905-50e93615e769?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aGFqanxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60");
//    hajjPackageRepo.save(hajjPackage1);
//
//    HajjPackage hajjPackage2 = new HajjPackage();
//    hajjPackage2.setName("Hajj Package");
//    hajjPackage2.setType("NOn Shifting Hajj Package");
//    hajjPackage2.setPrice("630000");
//    hajjPackage2.setStartDate("01-01-2024");
//    hajjPackage2.setEndDate("02-03-2024");
//    hajjPackage2.setDescription("Visa with all charges.Health insurance .Meet & assist on arrival at Jeddah airport");
//    hajjPackage2.setLocation("Makkah & Madinah");
//    hajjPackage2.setImageLink("https://images.unsplash.com/photo-1564769625905-50e93615e769?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aGFqanxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60");
//    hajjPackageRepo.save(hajjPackage2);
//
//    HajjPackage hajjPackage3 = new HajjPackage();
//    hajjPackage3.setName("Hajj Package");
//    hajjPackage3.setType("Premium Hajj Package");
//    hajjPackage3.setPrice("650000");
//    hajjPackage3.setStartDate("01-01-2024");
//    hajjPackage3.setEndDate("02-03-2024");
//    hajjPackage3.setDescription("Visa with all charges.Health insurance .Meet & assist on arrival at Jeddah airport");
//    hajjPackage3.setLocation("Makkah & Madinah");
//    hajjPackage3.setImageLink("https://images.unsplash.com/photo-1564769625905-50e93615e769?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aGFqanxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60");
//    hajjPackageRepo.save(hajjPackage3);
//
//    HajjPackage hajjPackage4 = new HajjPackage();
//    hajjPackage4.setName("Hajj Package");
//    hajjPackage4.setType("Shifting Hajj Package");
//    hajjPackage4.setPrice("600000");
//    hajjPackage4.setStartDate("01-01-2024");
//    hajjPackage4.setEndDate("02-03-2024");
//    hajjPackage4.setDescription("Visa with all charges.Health insurance .Meet & assist on arrival at Jeddah airport");
//    hajjPackage4.setLocation("Makkah & Madinah");
//    hajjPackage4.setImageLink("https://images.unsplash.com/photo-1564769625905-50e93615e769?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aGFqanxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60");
//    hajjPackageRepo.save(hajjPackage4);


}
    public List<HajjPackage> findAll() {

        return hajjPackageRepo.findAll();
    }

    public void save(HajjPackage hajjPackageNew) {
        if (hajjPackageNew.getId()!= null){
            hajjPackageRepo.findById(hajjPackageNew.getId())
                    .map(old -> {

//    private String name;
//    private String type;
//    private String price;
//    private String startDate;
//    private String endDate;
//    private String description;
//    private String location;
//    private String imageLink;

                        old.setName(hajjPackageNew.getName());
                        old.setType(hajjPackageNew.getType());
                        old.setPrice(hajjPackageNew.getPrice());
                        old.setStartDate(hajjPackageNew.getStartDate());
                        old.setEndDate(hajjPackageNew.getEndDate());
                        old.setDescription(hajjPackageNew.getDescription());
                        old.setLocation(hajjPackageNew.getLocation());
                        old.setImageLink(hajjPackageNew.getImageLink());

                        return hajjPackageRepo.save(old);
                    })
                    .orElseGet(() -> {
                        return hajjPackageRepo.save(hajjPackageNew);
                    });
        }else {
            hajjPackageRepo.save(hajjPackageNew);
        }
    }

    public HajjPackage getById(Long id) {
       return hajjPackageRepo.findById(id).orElse(new HajjPackage());
    }

    public void delete(Long id) {
         hajjPackageRepo.deleteById(id);
    }

}
