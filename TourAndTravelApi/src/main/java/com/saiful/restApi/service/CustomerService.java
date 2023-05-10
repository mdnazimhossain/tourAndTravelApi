package com.saiful.restApi.service;


import com.saiful.restApi.entity.Customer;
import com.saiful.restApi.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;
//    public void initCustomer(){
//
////        Customer customer1 = new Customer();
////        customer1.setName("Jahid");
////        customer1.setMobileNo("01677320646");
////        customer1.setPassportNo("01333620000");
////        customer1.setAddress("Dhaka");
////        customerRepo.save(customer1);
//
//    }
    public List<Customer> findAll() {

        return customerRepo.findAll();
    }

    public void save(Customer customerNew) {
        if (customerNew.getId()!= null){
            customerRepo.findById(customerNew.getId())
                    .map(old -> {

//
//                        private String name;
//                        private String mobileNo;
//                        private String passportNo;
//                        private String address;


                        old.setName(customerNew.getName());
                        old.setMobileNo(customerNew.getMobileNo());
                        old.setPassportNo(customerNew.getPassportNo());
                        old.setAddress(customerNew.getAddress());


                        return customerRepo.save(old);
                    })
                    .orElseGet(() -> {
                        return customerRepo.save(customerNew);
                    });
        }else {
            customerRepo.save(customerNew);
        }
    }

    public Customer getById(Long id) {
       return customerRepo.findById(id).orElse(new Customer());
    }

    public void delete(Long id) {
         customerRepo.deleteById(id);
    }

}
