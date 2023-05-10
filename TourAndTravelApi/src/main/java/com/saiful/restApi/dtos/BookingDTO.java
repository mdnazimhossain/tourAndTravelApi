package com.saiful.restApi.dtos;

import com.saiful.restApi.entity.Customer;
import com.saiful.restApi.entity.HajjPackage;
import lombok.Data;

@Data
public class BookingDTO {
    private Long id;
    private String Date;
    private String details;
    private String bookedBy;
    private String billing;
    private String status;
    private Customer customer;
    private HajjPackage hajjPackage;
}
