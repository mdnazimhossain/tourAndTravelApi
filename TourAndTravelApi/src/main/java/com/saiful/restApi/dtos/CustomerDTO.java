package com.saiful.restApi.dtos;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String mobileNo;
    private String passportNo;
    private String address;

}
