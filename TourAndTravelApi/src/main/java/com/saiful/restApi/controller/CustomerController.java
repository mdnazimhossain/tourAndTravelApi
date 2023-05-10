package com.saiful.restApi.controller;

import com.saiful.restApi.dtos.CustomerDTO;
import com.saiful.restApi.entity.Customer;
import com.saiful.restApi.service.CustomerService;
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
public class CustomerController {
    @Autowired
    CustomerService customerService;
//    @PostConstruct
////    public void customerServiceCon(){
////        customerService.initCustomer();
////    }
    @PostMapping("/customer")
    public void save(@RequestBody CustomerDTO customerDTO){
        if (customerDTO != null){
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO, customer);
            customerService.save(customer);
        }
    }
    @PutMapping("/customer")
    public void update( @RequestBody CustomerDTO customerDTO){
        if (customerDTO != null){
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO, customer);
            customerService.save(customer);
        }
    }
    @GetMapping("/customer")
    List<CustomerDTO> all() {
        List<Customer> customers = customerService.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : customers
        ) {
            CustomerDTO customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(customer, customerDTO);
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
    @DeleteMapping("/customer/{id}")
    public void delete(@PathVariable("id") Long id){
        customerService.delete(id);
    }


    @GetMapping("/customer/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        Customer customer;
        customer = customerService.getById(id);
        if (customer.getId() != null){
            CustomerDTO customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(customer, customerDTO);
            return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data Not Found!!");
//        return new ResponseEntity("Hello World", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
