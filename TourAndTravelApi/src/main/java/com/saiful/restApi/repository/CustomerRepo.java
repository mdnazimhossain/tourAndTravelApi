package com.saiful.restApi.repository;

import com.saiful.restApi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {


}
